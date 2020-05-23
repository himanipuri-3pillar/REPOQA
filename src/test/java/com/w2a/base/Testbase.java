package com.w2a.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;


public class Testbase {

	public static WebDriver driver;
	public static Properties config = new Properties();
	public static Properties OR = new Properties();
	public static FileInputStream fis;
	public static Logger log = Logger.getLogger("devpinoyLogger");

	
	@BeforeSuite
	public void Setup() {
		if(driver == null) {
	
			try {
				fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\Config.properties");
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			try {
				config.load(fis);
				log.debug("Config file loaded!!!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			  try 
			  { 
				  fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\test\\resources\\properties\\OR.properties"); 
				  
			  } catch(FileNotFoundException e) { 
				  // TODO Auto-generated catch block
			  e.printStackTrace(); 
			  
			  } try { 
				  OR.load(fis); 
				  log.debug("OR file loaded!!!");
				  } catch (IOException e) { 
					  // TODOAuto-generated catch block
					  
					  e.printStackTrace(); }
			 
			
			if(config.getProperty("browser").equals("chrome")){
				
				System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir")+"\\src\\test\\resources\\executables\\chromedriver.exe");
				driver = new ChromeDriver();
				log.debug("Chrome Launched");
			}
			else {
				
				driver= new FirefoxDriver();
				
			}
			
			driver.get(config.getProperty("testsiteurl"));
			log.debug("Navigated to the URL:" +config.getProperty("testsiteurl"));
			driver.manage().window().maximize();
			driver.manage().timeouts().implicitlyWait(Integer.parseInt(config.getProperty("implicit.wait")), TimeUnit.SECONDS);
		}
	}
	
	public boolean isElementPresent(By by)
	{
		try {
			driver.findElement(by);
			return true;
		}catch(NoSuchElementException e) {
			return false;
		}
	}
	
	@AfterSuite
	public void teardown() {
		
		if(driver!=null) {
		driver.quit();		
	}
	
	
	log.debug("Test Execution completed!!!");
}
}

