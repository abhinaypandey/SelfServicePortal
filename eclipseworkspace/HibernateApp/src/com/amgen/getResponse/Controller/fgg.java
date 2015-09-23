package com.amgen.getResponse.Controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

class fgg
{
	public static void main(String args[])
	{
	System.out.println("enter string");	
	
	Scanner sc= new Scanner(System.in);
	String s = sc.nextLine();
	char c='a';
	int count1 =  s.length() - s.replace("a", "").length();
	int count=1;
	for(int i = 0 ; i < s.length() - 1; i++)
	{
		if(s.charAt(i)== ' ' && s.charAt(i+1)!= ' ')
		{
			count++;
		}
		
	}
	System.out.println("no of words in a string" + count);
	System.out.println("no of words in a string" + count1);
	}
	
	
}
