package com.simpleautomation.utilities;

import java.text.DateFormat;
import java.util.Date;

import org.testng.Assert;

public class GeneralUtility {

	
	//** Select Current Timestamp  */
		public static String getTimeStamp(){
			DateFormat DF=DateFormat.getDateTimeInstance();
			Date dte=new Date();
			String DateValue=DF.format(dte);
			DateValue=DateValue.replaceAll(":", "_");
			DateValue=DateValue.replaceAll(",", "");
			return DateValue;
		}

	public static void validateResult(String ExpectedResult, String ActualResult){
		Assert.assertEquals(ExpectedResult, ActualResult);				
	}
	
	
}
