package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class User_01_Register extends BaseTest {
	WebDriver driver;
	private RegisterPageObject registerPage;
	private LoginPageObject loginPage;
	private HomePageObject homePage;
	
	@Parameters({"browser","url"})
	@BeforeClass
	public void beforeClass(String browserName, String appUrl) {
		driver = getBrowserDriver(browserName, appUrl);
		
		
	}

	@Test
	public void Register_01_Empty_Data() {
	}

	@Test
	public void Register_02_Invalid_Email() {
	}

	@Test
	public void Register_03_Register_Success() {
	}

	@Test
	public void Register_04_Exsting_Email() {
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
