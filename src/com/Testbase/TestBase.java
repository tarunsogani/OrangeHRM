package com.Testbase;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import com.relevantcodes.extentreports.ExtentReports;

public class TestBase {
	public static WebDriver driver;
	public static Properties prop;
	public static FileInputStream fip;
	public static Logger l;
	/*
	 * TestBase() {
	 * System.setProperty("webdriver.chrome.driver","chromedriver.exe");
	 * driver=new ChromeDriver(); }
	 */

	//@Test(priority=1)
	public  void OpenBrowser() throws Throwable {
	
				
		l=Logger.getLogger("devpinoyLogger");
		System.setProperty("webdriver.chrome.driver", "chromedriver_2.37.exe");
		driver = new ChromeDriver();
		driver.get("http://opensource.demo.orangehrmlive.com/");
		l.info("Chrome Browser Launched");
		//driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		fip = new FileInputStream(".\\src\\com\\Config\\Or.Properties");
		prop = new Properties();
		prop.load(fip);
		
	}
	//@Test(priority=2)
	public  void CloseBrowser() {
		driver.quit();
		l.info("Chrome Browser Instance Closed");
	}
	
	/*public static void Id_Element(String a)
	{
		driver.findElement(By.id(a));
	}

	
	public static void Xpath_Element(String a)
	{
		driver.findElement(By.xpath(a));
	}*/
}
