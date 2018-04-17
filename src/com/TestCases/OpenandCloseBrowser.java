package com.TestCases;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

import com.Testbase.TestBase;

public class OpenandCloseBrowser extends TestBase {

	@BeforeSuite
	public void openBrowsertest() throws Throwable {
		OpenBrowser();
	}

	@AfterSuite
	public void closeBrowsertest() {
		CloseBrowser();
	}

}
