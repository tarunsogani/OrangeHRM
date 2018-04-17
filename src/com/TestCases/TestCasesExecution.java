package com.TestCases;

import org.testng.annotations.Test;

import com.Library.Library;

public class TestCasesExecution extends Library {
	
	@Test(priority = 1)
	public void LoginFunctionalityTest() throws Throwable {
		checkLoginFunctionality();
	}

	@Test(priority = 2)
	
	public void Menu_mouseHover_Action() throws InterruptedException
	{
		menu_action_mousehover();
	}
	
	@Test(priority = 3)
	
	public void Add_User_Test() throws Throwable
	{
		Add_User();
	}
	
}
