/**
 *
 * This comment is NOT a class level javadoc comment. 
 * 
 * @description: This class fetches data and calls encryption service 
 * @author: abhinay
 * @version: 
 *
 */
package com.amgen.getResponse.service.dataExchange;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.SignatureException;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.*;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileChannel.MapMode;
import java.nio.charset.StandardCharsets;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

import javassist.bytecode.Descriptor.Iterator;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.print.attribute.standard.Severity;

import org.bouncycastle.openpgp.PGPException;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.lob.ReaderInputStream;

import com.amgen.getResponse.entity.campaign.Channel;
import com.amgen.getResponse.entity.campaign.UserSubscription;
import com.amgen.getResponse.entity.userProfileManagement.User;
import com.amgen.getResponse.utility.HibernateRepository;
import com.amgen.getResponse.utility.HibernateUtil;
import com.amgen.getResponse.service.dataExchange.EncryptionService;
import com.amgen.getResponse.utility.*;

public class DataExchangeServiceImpl {

	private static PrintWriter pw;
	
	private File getLatestFile(File dir){
		File[] filelist=dir.listFiles();
		if(filelist==null || filelist.length==0){
			return null;
		}
		
		File lastModified=filelist[0];
		for(int i=0;i<filelist.length;i++){
			if(lastModified.lastModified() < filelist[i].lastModified()){
				lastModified=filelist[i];
			}
		}
		return lastModified;
		
	}
	
	private boolean getDelimiterStatus(File latestFile,String currentDelimiter){
		boolean delimiterStatus=false;
		try {
			Scanner scan=new Scanner(latestFile);
			String currentLine;
			while(scan.hasNextLine()){
				currentLine=scan.nextLine();
				if(currentLine.contains(currentDelimiter)){
					delimiterStatus=false;
					continue;
				}
				else
					delimiterStatus=true;
			}
			scan.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return delimiterStatus;
	}
	
	private static void fetchData(File file,String filePath,String delimiter) throws SQLException{
		try {

			pw = new PrintWriter(new BufferedWriter(new FileWriter(file,true)),true);
			Repository rep=new HibernateRepository();
			@SuppressWarnings("unchecked")
//			List<User> users=(List<User>)rep.retrieve(User.class);
//			
//			if(!users.isEmpty()){
//				java.util.Iterator<User> iterator=users.iterator(); 
//				
//				while(iterator.hasNext()){
//					User user=(User)iterator.next();
//					String record=user.getId()+delimiter+user.getUserName()+delimiter+user.getFirstName()+delimiter+user.getLastName()+delimiter+user.getEmail();
//					Path path=Paths.get(file.getAbsolutePath());
//					if(searchFor(record,path)==0){
//						pw.println(record);
//						pw.flush();
//					}
//					
//				}
			
			List<UserSubscription> userdata=rep.fetchUserData();
			
			if(!userdata.isEmpty()){
				java.util.Iterator<UserSubscription> iterator=userdata.iterator(); 
				
				while(iterator.hasNext()){
					UserSubscription data=(UserSubscription)iterator.next();

					String record=data.getId()+delimiter+data.getUserName()+delimiter+data.getProductname()+delimiter+data.getChannelname();
					Path path=Paths.get(file.getAbsolutePath());
					if(searchFor(record,path)==0){
						pw.println(record);
						pw.flush();
					}
					
					
				}
				
				/* Calling EncryptionService to handle data encryption and Decryption */
				ResourceBundle rc=ResourceBundle.getBundle("properties.encryption");
				String encryptionType=rc.getString("encryptionType");
				
				EncryptionService encrypt=new EncryptionService(file,encryptionType);
				encrypt.initializeEncryption();
				System.out.println("Data encrypted successfully");
					
			}
			else{
				System.out.println("No registered users found ");
			}
			
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally{
			pw.close();
		}
	}
	
	// This function checks for delimeter status and performs actions accordingly 
	public void DataTransfer() throws Exception{
		    System.out.println("Data transfer has been called ");
			DataExchangeServiceImpl dimpl=new DataExchangeServiceImpl();
			ResourceBundle rc=ResourceBundle.getBundle("properties.delimiter");
			String delimiter=rc.getString("delimiter");
			File dir=new File("User_Files/User_records");
			File lastModified=dimpl.getLatestFile(dir);		
			System.out.println("latest file"+ lastModified.getName());
			boolean delimiterStatus = dimpl.getDelimiterStatus(lastModified,delimiter);
			
			if(delimiterStatus){
				long timestamp=new Date().getTime();
				String filePath="./User_Files/User_records/userData_"+timestamp+".txt";
				File headerFile=new File("./User_Files/User_records/userDataTemplate.txt");
				InputStreamReader ir=new InputStreamReader(new FileInputStream(headerFile));
				BufferedReader bf=new BufferedReader(ir);
				File file=new File(filePath);
				PrintWriter pw=new PrintWriter(new BufferedWriter(new FileWriter(file)),true);
				String header=bf.readLine();
				pw.println(header);
				pw.close();
				fetchData(file,filePath,delimiter);
					
				
			}
			else{
				fetchData(lastModified,lastModified.getAbsolutePath(),delimiter);
			}
			
	}
	
	// This function checks for duplicate entries and inserts only new record 
	 private static final int MAPSIZE = 4 * 1024 ;

	    private static int searchFor(String grepfor, Path path) throws IOException {
	        final byte[] tosearch = grepfor.getBytes(StandardCharsets.UTF_8);
	        StringBuilder report = new StringBuilder();
	        int padding = 1; // need to scan 1 character ahead in case it is a word boundary.
	        int linecount = 0;
	        int matches = 0;
	        boolean inword = false;
	        boolean scantolineend = false;
	        try (FileChannel channel = FileChannel.open(path, StandardOpenOption.READ)) {
	            final long length = channel.size();
	            int pos = 0;
	            while (pos < length) {
	                long remaining = length - pos;
	                int trymap = MAPSIZE + tosearch.length + padding;
	                int tomap = (int)Math.min(trymap, remaining);
	                int limit = trymap == tomap ? MAPSIZE : (tomap - tosearch.length);
	                MappedByteBuffer buffer = channel.map(MapMode.READ_ONLY, pos, tomap);
	                pos += (trymap == tomap) ? MAPSIZE : tomap;
	                for (int i = 0; i < limit; i++) {
	                    final byte b = buffer.get(i);
	                    if (scantolineend) {
	                        if (b == '\n') {
	                            scantolineend = false;
	                            inword = false;
	                            linecount ++;
	                        }
	                    } else if (b == '\n') {
	                        linecount++;
	                        inword = false;
	                    } else if (b == '\r' || b == ' ') {
	                        inword = false;
	                    } else if (!inword) {
	                        if (wordMatch(buffer, i, tomap, tosearch)) {
	                            matches++;
	                            i += tosearch.length - 1;
	                            if (report.length() > 0) {
	                                report.append(", ");
	                            }
	                            report.append(linecount);
	                            scantolineend = true;
	                        } else {
	                            inword = true;
	                        }
	                    }
	                }
	            }
	        }
	        return matches;
	    }

	    private static boolean wordMatch(MappedByteBuffer buffer, int pos, int tomap, byte[] tosearch) {
	        for (int i = 0; i < tosearch.length; i++) {
	            if (tosearch[i] != buffer.get(pos + i)) {
	                return false;
	            }
	        }
	        byte nxt = (pos + tosearch.length) == tomap ? (byte)' ' : buffer.get(pos + tosearch.length); 
	        return nxt == ' ' || nxt == '\n' || nxt == '\r';
	    }

}
