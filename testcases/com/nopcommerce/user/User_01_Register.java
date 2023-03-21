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
import pageObjects.RegisterPageObject;

public class User_01_Register extends BaseTest {
	WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	public static String validEmail, invalidEmail, password;
	String firstName, lastName;
	
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviroment) {
		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName, enviroment);
		homePage = PageGeneraterManager.getHomePage(driver);
		firstName = "a";
		lastName = "b";
		password = "123456";
		validEmail = "afc" + generateFakeNumber() + "@gmail.com";
		invalidEmail = "afc@@gmail.com";
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		log.info("Register_01 - Step 02: Click to Register button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_01 - Step 03: Verify Firstname error message displayed");
		Assert.assertTrue(registerPage.isFirstnameErrorMessageDisplayed());
		
		log.info("Register_01 - Step 04: Verify Lastname error message displayed");
		Assert.assertTrue(registerPage.isLastnameErrorMessageDisplayed());
		
		log.info("Register_01 - Step 04: Verify Email error message displayed");
		Assert.assertTrue(registerPage.isEmailErrorMessageDisplayed());
		
		log.info("Register_01 - Step 05: Verify Password error message displayed");
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
		
		log.info("Register_01 - Step 06: Verify ConfirmPassword error message displayed");
		Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_02 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox(firstName);
		
		log.info("Register_02 - Step 03: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox(lastName);
		
		log.info("Register_02 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(invalidEmail);
		
		log.info("Register_02 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register_02 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Register_02 - Step 07: Click to Register link");
		registerPage.clickToRegisterButton();
		
		log.info("Register_02 - Step 08: Verify wrong email message displayed");
		Assert.assertTrue(registerPage.isWrongEmailMessageDisplayed());
	}

	@Test
	public void Register_03_Register_Success() {
		log.info("Register_03 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_03 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox(firstName);
		
		log.info("Register_03 - Step 03: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox(lastName);
		
		log.info("Register_03 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_03 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register_03 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Register_03 - Step 07: Click to Register link");
		registerPage.clickToRegisterButton();
		
		log.info("Register_03 - Step 09: Verify register success message is displayed");
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}

	@Test
	public void Register_04_Exsting_Email() {
		log.info("Register_04 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_04 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox(firstName);
		
		log.info("Register_04 - Step 03: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox(lastName);
		
		log.info("Register_04 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_04 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register_04 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox(password);
		
		log.info("Register_04 - Step 07: Click to Register link");
		registerPage.clickToRegisterButton();
		
		log.info("Register_04 - Step 09: Verify exsting email message is displayed");
		Assert.assertTrue(registerPage.isExstingEmailMessageDisplayed());
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_05 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox(firstName);
		
		log.info("Register_05 - Step 03: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox(lastName);
		
		log.info("Register_05 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_05 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox("12345");
		
		log.info("Register_05 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox("12345");
		
		log.info("Register_05 - Step 07: Click to Register link");
		registerPage.clickToRegisterButton();
		
		log.info("Register_05 - Step 07: Verify Password error message eror displayed");
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Register_06 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_06 - Step 02: Enter to Firstname textbox");
		registerPage.enterToFirstnameTextbox(firstName);
		
		log.info("Register_06 - Step 03: Enter to Lastname textbox");
		registerPage.enterToLastnameTextbox(lastName);
		
		log.info("Register_06 - Step 04: Enter to Email textbox");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_06 - Step 05: Enter to Password textbox");
		registerPage.enterToPasswordTextbox(password);
		
		log.info("Register_06 - Step 06: Enter to Confirm Password textbox");
		registerPage.enterToConfirmPasswordTextbox("12345");
		
		log.info("Register_06 - Step 07: Click to Register link");
		registerPage.clickToRegisterButton();
		
		log.info("Register_06 - Step 08: Verify Confirm Password error message eror displayed ");
		Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
