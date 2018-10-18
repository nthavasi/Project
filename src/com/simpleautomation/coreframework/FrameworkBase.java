package com.simpleautomation.coreframework;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FrameworkBase {

	public static WebDriver driver= null;
	public static String browserName= null; 
	public static String url = null;
	
	public FrameworkBase() {

	}

	public static void initalize() throws IOException, InterruptedException{
		//Read Properties File
		Properties prop=new Properties();
		FileInputStream fileData= new FileInputStream(Globals.ConfigFilePath);
		prop.load(fileData);

		//Parameters from Properties File
		browserName = prop.getProperty("browserName");
		url = prop.getProperty("url");

		//Load Driver with Selected Browser
		switch (browserName){
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Globals.chromeDriverPath);
			driver = new ChromeDriver();
			driver.get(url);
			driverProperties();
			break;
		case "IE":
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Globals.ieDriverPath);
			driver = new FirefoxDriver();
			driver.get(url);
			driverProperties();
			break;
		default:
			System.setProperty("webdriver.gecko.driver", Globals.ieDriverPath);
			driver = new FirefoxDriver();
			driver.get(url);
			driverProperties();
			break;
		}
	}

	//Set default properties for Driver
	public static void driverProperties(){
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.manage().timeouts().pageLoadTimeout(2,TimeUnit.SECONDS);
	}
	
	


}