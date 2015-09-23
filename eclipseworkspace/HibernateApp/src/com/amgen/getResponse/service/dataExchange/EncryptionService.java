package com.amgen.getResponse.service.dataExchange;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.nio.ByteOrder;
import java.security.InvalidKeyException;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.NoSuchProviderException;
import java.security.Security;
import java.security.SignatureException;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.openpgp.PGPException;
import org.bouncycastle.util.encoders.Base64;
import org.bouncycastle.util.encoders.Base64Encoder;
import org.bouncycastle.util.io.BufferingOutputStream;

import com.sun.mail.util.BASE64EncoderStream;



public class EncryptionService {

	private boolean isArmored = false;
	private String id = "getresponse";
	private String passwd = "getresponse";
	private boolean integrityCheck = true;
	private String pubKeyFile;
	private String privKeyFile;
	private String plainTextFile;
	private String cipherTextFile;
	private String cipherTextFile_base64;
	private String decPlainTextFile;
	private String decPlainTextFile_base64;
	private int encryBitLength=1024;
	private String encryptionType="";

	public EncryptionService(File fileToEncrypt,String encryptionType) {
		// TODO Auto-generated constructor stub
		pubKeyFile = "./User_Files/public.dat";
		privKeyFile = "./User_Files/private.dat";
		
		plainTextFile = fileToEncrypt.getAbsolutePath();
		cipherTextFile = "./User_Files/cypher-text.dat";
		decPlainTextFile = "./User_Files/dec-plain-text.txt";
		this.encryptionType=encryptionType;
	}
	
	public void initializeEncryption(){
//		if(encryptionType.equals("RSA")){
			try {
					System.out.println("started encryption: "+encryptionType);
					this.genKeyPair();
					this.encrypt();
					this.decrypt();
				} catch (InvalidKeyException e){
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchProviderException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (SignatureException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (NoSuchAlgorithmException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (PGPException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
//		}
//		else if(encryptionType.equals("BASE64")){
//			System.out.println(encryptionType);
//			this.encode();
//			this.decode();
//		}
	}
	
//	public void encode(){
//		try {
//			String str="";
//			BufferedReader in=new BufferedReader(new FileReader(new File(plainTextFile)));
//			BufferedOutputStream out=new BufferedOutputStream(new FileOutputStream(new File(cipherTextFile_base64)));
//			while(!((str=in.readLine()).equals(""))){
//				byte[] encodedBytes=Base64.encode(str.getBytes());
//				out.write(encodedBytes);
//			}
//		} catch (FileNotFoundException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//	}
//	
//	public void decode(){
//		
//	}
	
	public void genKeyPair() throws InvalidKeyException, NoSuchProviderException, SignatureException, IOException, PGPException, NoSuchAlgorithmException {
		
		RSAKeyPairGenerator rkpg = new RSAKeyPairGenerator();
																											
		Security.addProvider(new BouncyCastleProvider());

		KeyPairGenerator    kpg = KeyPairGenerator.getInstance("RSA", "BC"); 
		kpg.initialize(encryBitLength);

		KeyPair kp = kpg.generateKeyPair();

		FileOutputStream    out1 = new FileOutputStream(privKeyFile);
		FileOutputStream    out2 = new FileOutputStream(pubKeyFile);
		rkpg.exportKeyPair(out1, out2, kp.getPublic(), kp.getPrivate(), id, passwd.toCharArray(), isArmored);


	}

	public void encrypt() throws NoSuchProviderException, IOException, PGPException{
		FileInputStream pubKeyIs = new FileInputStream(pubKeyFile);
		FileOutputStream cipheredFileIs = new FileOutputStream(cipherTextFile);
		PgpHelper.getInstance().encryptFile(cipheredFileIs, plainTextFile, PgpHelper.getInstance().readPublicKey(pubKeyIs), isArmored, integrityCheck);
		cipheredFileIs.close();
		pubKeyIs.close();
	}

	
	public void decrypt() throws Exception{

		FileInputStream cipheredFileIs = new FileInputStream(cipherTextFile);
		FileInputStream privKeyIn = new FileInputStream(privKeyFile);
		FileOutputStream plainTextFileIs = new FileOutputStream(decPlainTextFile);
		PgpHelper.getInstance().decryptFile(cipheredFileIs, plainTextFileIs, privKeyIn, passwd.toCharArray());
		cipheredFileIs.close();
		plainTextFileIs.close();
		privKeyIn.close();
	}
	


}
