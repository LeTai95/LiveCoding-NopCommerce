package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;

public class User_02_Login extends BaseTest {
	WebDriver driver;
	private HomePageObject homePage;
	private LoginPageObject loginPage;
	String validEmail, invalidEmail, unregistedEmail, password;
	
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName,enviromentName);
		homePage = PageGeneraterManager.getHomePage(driver);
		
		log.info("Pre-Condition- Step 02: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		validEmail = User_01_Register.validEmail;
		invalidEmail = User_01_Register.invalidEmail;
		password = User_01_Register.password;
		unregistedEmail = "abc98765@gmail.com";
	}
	
	@Test
	public void Login_01_Empty_Data() {
		log.info("Login_01 - Step 01: Click to login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_01 - Step 02: Verify error message is displayed");
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login_02 - Step 01: Enter to  Email textbox ");
		loginPage.enterToEmailTextbox(invalidEmail);
		
		log.info("Login_02 - Step 02: Click to login button");
		loginPage.clickToLoginButton();
		
		log.info("Login_02 - Step 03: Verify error message is displayed");
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Test
	public void Login_03_Login_With_Unregisted_Email() {
		log.info("Login_03 - Step 01: Enter to  Email textbox ");
		loginPage.enterToEmailTextbox(unregistedEmail);
		
		log.info("Login_03 - Step 02: Enter to  Email textbox ");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login_03 - Step 03: Click to login button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_03 - Step 04: Verify error message is displayed");
		Assert.assertTrue(loginPage.isUnregistedEmailErrorMessageDisplayed());
	}
	
	@Test
	public void Login_04_Login_With_Empty_Password() {
		log.info("Login_04 - Step 01: Enter to  Email textbox ");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_04 - Step 02: Click to login button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_03 - Step 03: Verify error message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	@Test
	public void Login_05_Login_With_Wrong_Password() {
		log.info("Login_05 - Step 01: Enter to  Email textbox ");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_05 - Step 02: Enter to  Password textbox with wrong password ");
		loginPage.enterToPasswordTextbox("000000");
		
		log.info("Login_05 - Step 03: Click to login button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_05 - Step 04: Verify error message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	@Test
	public void Login_06_Success_Login() {
		log.info("Login_05 - Step 01: Enter to  Email textbox ");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_05 - Step 02: Enter to  Password textbox ");
		loginPage.enterToPasswordTextbox(password);
		
		log.info("Login_05 - Step 03: Click to login button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login_05 - Step 04: Verify My Account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
