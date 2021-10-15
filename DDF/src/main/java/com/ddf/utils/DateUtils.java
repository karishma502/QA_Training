package com.ddf.utils;

import java.util.Date;

import org.testng.annotations.Test;

public class DateUtils {
	
	public static String getTimeStamp(){
		Date date = new Date();
		return date.toString().replaceAll(":", "_").replaceAll(" ", "_");
	}
	
	@Test
	public void chk() {
		String ts=getTimeStamp();
		Date date = new Date();
		System.out.println(date.toString());
		ts=ts+".html";
		System.out.println("File name is : "+ts);
		
	}
}
