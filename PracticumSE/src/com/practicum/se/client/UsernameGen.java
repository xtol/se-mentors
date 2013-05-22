package com.practicum.se.client;

import java.io.*;
import java.lang.*;
import java.util.*;

public class UsernameGen 
{

	/**
	 * @param args
	 * 
	 */
	static ArrayList<String>  strings = new ArrayList<String>();
	public  void pass_name(String firstname, String lastname) 
	{
		UsernameGen n=new UsernameGen();
		
		for(int i=0;i<25;i++)
		{
			String s= n.generate_name( firstname,  lastname);
			strings.add(s);
		}
		HashSet h = new HashSet(strings);
		strings.clear();
		strings.addAll(h);
		//for(int i = 0; i < strings.size() ; i++)
		//System.out.println( strings.get( i ) );


	}
	public String generate_name(String firstname, String lastname)
	{
		//ArrayList<String> strings=new ArrayList<String>;
		int length_fname=firstname.length();
		Random rand = new Random();
	    int min_len=rand.nextInt(length_fname/2);
		int max_len=rand.nextInt(length_fname - min_len + 1) + min_len;
		String part1=firstname.substring(min_len, max_len);

		int length_lname=lastname.length();
	    int min_len1 =rand.nextInt(length_lname/2);
		int max_len1=rand.nextInt(length_lname - min_len1 + 1) +min_len1;
		String part2=lastname.substring(min_len1, max_len1);

		int random1=rand.nextInt(10);
		int random2=rand.nextInt(10);
		int random3=rand.nextInt(10);

		String rand1=random1+"";
		String rand2=random2+"";
		String rand3=random3+"";
		
	    String SPL_CHARS   = "!@#$%&*_";

		char s = SPL_CHARS.charAt(rand.nextInt(SPL_CHARS.length()));
        
		String username= firstname.charAt(0)+part1+part2+s+rand1+rand2+rand3;
		return username;
		

	}
	public String code_generate()
	{
		final String AB = "0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		 Random rnd = new Random();
		   StringBuilder sb = new StringBuilder( 5 );
		   for( int i = 0; i < 5; i++ ) 
			  sb.append( AB.charAt( rnd.nextInt(AB.length()) ) );
		 // System.out.println("Hello World!------->"+sb.toString());
		return sb.toString();
	}
	
}
