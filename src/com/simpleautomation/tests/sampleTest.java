package com.simpleautomation.tests;

import java.io.IOException;
import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import com.simpleautomation.coreframework.FrameworkBase;
import com.simpleautomation.coreframework.Globals;
import com.simpleautomation.coreframework.SeleniumBase;
import com.simpleautomation.utilities.ExcelUtility;
import com.simpleautomation.utilities.GeneralUtility;

public class sampleTest extends FrameworkBase{
	
	ExcelUtility testData = new ExcelUtility(Globals.excelFilePath, "Sheet1", "xls");
	Map<String,String> map;
	
	public sampleTest(){
	super();
	}

	@BeforeClass
    public void launchBrowser() throws IOException, InterruptedException {
	FrameworkBase.initalize();
	}
	
	@Test
	public void FirstTest(){		
		try {
			map= testData.readExcel("TestCase3");
			Assert.assertEquals(map.get("Test"),"Pass");
			//GeneralUtility.validateResult(map.get("Test"),"Pass");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	@AfterClass
	public void closeAll(){
		driver.close();		
	}
		

	
}