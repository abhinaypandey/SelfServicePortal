package com.amgen.getResponse.Controller;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

import org.apache.xerces.dom.PSVIAttrNSImpl;

public class test {
 
	public static void duplicateString(String inputString)
	{
		 //Splitting inputString into words
		String[] words = inputString.split(" ");
		  //Creating one HashMap with words as key and their count as value
		HashMap<String,Integer> wordCount = new HashMap<String,Integer>();
		//checking each word
		for(String word : words)
		{
			//whether it is present in wordCount
			if(wordCount.containsKey(word.toLowerCase()))
			{	
				//If it is present, incrementing it's count by 1
				wordCount.put(word.toLowerCase(), wordCount.get(word.toLowerCase())+1);
		}
			else{
				//If it is not present, put that word into wordCount with 1 as it's value
				wordCount.put(word.toLowerCase(),1);
			}
			
	}
	Set<String> wordsinString = wordCount.keySet();
	for (String word : wordsinString)
    {
        //if word count is greater than 1

        if(wordCount.get(word) > 1)
        {
            //Printing that word and it's count

            System.out.println(word+" : "+wordCount.get(word));
        }
    }
}

public static void main(String[] args)
{
    duplicateString("Achal amit achal minakshi achal minakshi");

    duplicateString("Java is java again java");

    duplicateString("Super Man Bat Man Spider Man");
}
}
	
	
