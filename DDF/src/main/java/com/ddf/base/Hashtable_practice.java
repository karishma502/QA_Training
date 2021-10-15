package com.ddf.base;
import java.util.*;
import java.io.*;

public class Hashtable_practice {
	public static void main(String args []) {
		
		Hashtable<String, String> h1 =new 	Hashtable<String, String>();
		h1.put("Name", "Karishma");
		h1.put("Last_NM", "Kate");
		
		System.out.println("h1 name is " +h1.get("Name"));
		System.out.println("h1 lastname " +h1.get("Last_NM"));
		System.out.println("h1 full string " +h1);
		
	}

}
