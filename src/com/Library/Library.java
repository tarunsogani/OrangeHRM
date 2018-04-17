package com.Library;

import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.File;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.Testbase.TestBase;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.LogStatus;

import xls.ShineXlsReader;

public class Library extends TestBase {

	
	public void checkLoginFunctionality() throws Throwable {
		ExtentReports logger = new ExtentReports();
		logger.init("C:\\Users\\TAN\\Desktop\\Selenium Data\\TAN\\Tarun_Extent.html", true);
		logger.startTest("checkLoginFunctionality", "Tarun This Test is to Check the Login Functionality");
				
		driver.findElement(By.id(prop.getProperty("lgn_username_id"))).sendKeys("Admin");
		l.info("Username Entered successfully");
		logger.log(LogStatus.INFO, "Username Entered Successfully");
		//Id_Element(prop.getProperty("lgn_username_id"));
		//Id_Element("abc");
		
		driver.findElement(By.id(prop.getProperty("lgn_password_id"))).sendKeys("admin");
		l.info("Password Entered successfully");
		logger.log(LogStatus.INFO, "Password Entered Successfully");
		//driver.findElement(By.id(prop.getProperty("lgn_password_id"))).sendKeys("admin");
		driver.findElement(By.id(prop.getProperty("login_button_id"))).click();
		l.info("Login button clicked successfully");
		logger.log(LogStatus.INFO,"Login Button Clicked Successfully on Login Page");
		
		String path = new Exception().getStackTrace()[0].getMethodName();
		
       File src_File= ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(src_File, new File(".\\src\\com\\Screenshots\\"+path+"TestCasePass.png"));
		logger.attachScreenshot(".\\src\\com\\Screenshots\\"+path+"TestCasePass.png");
		logger.endTest();
	}
	
/*	@Test(priority=1,dataProvider = "getdata")
	public void checkloginfunctionality(String row, String col) throws Throwable
	{
		driver.findElement(By.xpath(prop.getProperty("Username"))).sendKeys(row);
		l.info("Entered Username");
		driver.findElement(By.xpath(prop.getProperty("password"))).sendKeys(col);
		l.info("Entered Password");
		driver.findElement(By.xpath(prop.getProperty("LoginButton"))).click();
		l.info("Clicked on Login");
		//File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		//FileUtils.copyFile(srcFile, new File(".\\src\\com\\ScreenShots\\OrangeHRM_Test_Pass.png"), true);
		l.info("ScreenShot Captured");
	}*/
	
	/*@Test(priority=1,dataProvider = "getdata")
	public void checkloginfunctionalityusingdatapool(String cn, String cp) {
		System.out.println("The values are: " + cn + cp);
	}*/

	/*@DataProvider
	public Object[][] getdata() {
		ShineXlsReader xls = new ShineXlsReader(".\\src\\com\\Datapool\\DataPool.xlsx");
		int rowCount = xls.getRowCount("Test1");
		int colCount = xls.getColumnCount("Test1");

		System.out.println("The row count is: " + rowCount + " The Column cunt is: " + colCount);
		Object obj[][] = new Object[rowCount - 1][colCount];

		for (int i = 2; i <= rowCount; i++) {
			for (int j = 0; j < colCount; j++) {
				obj[i - 2][j] = xls.getCellData("Test1", j, i);
			}
		}
		return obj;
	}*/
	
	
	public void menu_action_mousehover() throws InterruptedException
	{
		Actions action = new Actions(driver);
		WebElement admin = driver.findElement(By.xpath(prop.getProperty("admin_menu_x")));
		WebElement userMgmt = driver.findElement(By.xpath(prop.getProperty("userMgmt_menu_x")));
		WebElement users = driver.findElement(By.id(prop.getProperty("users_menu_id")));
		
		action.moveToElement(admin).perform();
		Thread.sleep(2000);
		l.info("Move to Admin Menu link successfully");
		action.moveToElement(userMgmt).perform();
		Thread.sleep(2000);
		l.info("Move to User_Management Menu link successfully");
		action.moveToElement(users).click().build().perform();	
		l.info("Move to Users sub Menu link and click successfully");
	}
	
	public void Add_User() throws Throwable
	{
	driver.findElement(By.id("btnAdd")).click();
	l.info("Click on Add Button successfully done");
	Select usr_role = new Select(driver.findElement(By.id(prop.getProperty("usr_role_id"))));
	usr_role.selectByVisibleText("Admin");
	l.info("Select Item from Role dropdown successfully");
	driver.findElement(By.id(prop.getProperty("emp_name_id"))).sendKeys("Linda");
	Thread.sleep(3000);
	Robot rb= new Robot();
	rb.keyPress(KeyEvent.VK_TAB);
	rb.keyRelease(KeyEvent.VK_TAB);
	l.info("Successfully Entered Employee Name");
	driver.findElement(By.id(prop.getProperty("usr_name_id"))).sendKeys("tan12124");
	l.info("Successfully Entered UserName");
	Select usr_status = new Select(driver.findElement(By.id(prop.getProperty("usr_status_id"))));
	l.info("successfully entered User Status");
	usr_status.selectByVisibleText("Enabled");
	driver.findElement(By.id(prop.getProperty("password_id"))).sendKeys("Syne@123*");
	l.info("Password entered successfully");
	driver.findElement(By.id(prop.getProperty("confirm_passwrd_id"))).sendKeys("Syne@123*");
	l.info("Confirm Password successfully Entered");
	
	Thread.sleep(3000);
	driver.findElement(By.id(prop.getProperty("Add_User_Save_btn"))).click();
	l.info("Record Save successfully");
	
	Thread.sleep(5000);
	
			
	}
	
}
