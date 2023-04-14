package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import pageObjects.HomePageObject;
import pageObjects.RegisterPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;
@Listeners(commons.MethodListener.class)
public class User_01_Register extends BaseTest {
	WebDriver driver;
	private RegisterPageObject registerPage;
	private HomePageObject homePage;
	private String validEmail;
	
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviroment) {
		log.info("Pre-Condition - Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName, enviroment);
		homePage = PageGeneraterManager.getHomePage(driver);
		validEmail = UserData.Register.VALID_EMAIL + getRandomNumberByDateTime() + "@gmail.com";
	}

	@Test
	public void Register_01_Empty_Data() {
		log.info("Register_01 - Step 01: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_01 - Step 02: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_01 - Step 03: Verify Firstname error message displayed");
		Assert.assertTrue(registerPage.isFirstnameErrorMessageDisplayed());
		
		log.info("Register_01 - Step 04: Verify Lastname error message displayed");
		Assert.assertTrue(registerPage.isLastnameErrorMessageDisplayed());
		
		log.info("Register_01 - Step 05: Verify Email error message displayed");
		Assert.assertTrue(registerPage.isEmailErrorMessageDisplayed());
		
		log.info("Register_01 - Step 06: Verify Password error message displayed");
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
		
		log.info("Register_01 - Step 07: Verify ConfirmPassword error message displayed");
		Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
	}

	@Test
	public void Register_02_Invalid_Email() {
		log.info("Register_02 - Step 01: Click to Register link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_02 - Step 02: Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Register.FIRST_NAME);
		
		log.info("Register_02 - Step 03: Enter to Lastname textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Register.LAST_NAME);
		
		log.info("Register_02 - Step 04: Enter to Email textbox with value '" + UserData.Register.INVALID_EMAIL + "'");
		registerPage.enterToEmailTextbox(UserData.Register.INVALID_EMAIL);
		
		log.info("Register_02 - Step 05: Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_02 - Step 06: Enter to Confirm Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_02 - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_02 - Step 08: Verify wrong email message displayed");
		Assert.assertTrue(registerPage.isWrongEmailMessageDisplayed());
	}

	@Test
	public void Register_03_Register_Success() {
		log.info("Register_03 - Step 01: Click to 'Register; link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_03 - Step 02: Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Register.FIRST_NAME);
		
		log.info("Register_03 - Step 03: Enter to Lastname textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Register.LAST_NAME);
		
		log.info("Register_03 - Step 04: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_03 - Step 05: Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_03 - Step 06: Enter to Confirm Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_03 - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_03 - Step 08: Verify register success message is displayed");
		Assert.assertTrue(registerPage.isRegisterSuccessMessageDisplayed());
	}

	@Test
	public void Register_04_Exsting_Email() {
		log.info("Register_04 - Step 01: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_04 - Step 02: Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Register.FIRST_NAME);
		
		log.info("Register_04 - Step 03: Enter to Lastname textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Register.LAST_NAME);
		
		log.info("Register_04 - Step 04: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_04 - Step 05: Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_04 - Step 06: Enter to Confirm Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_04 - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_04 - Step 08: Verify exsting email message is displayed");
		Assert.assertTrue(registerPage.isExstingEmailMessageDisplayed());
	}

	@Test
	public void Register_05_Password_Less_Than_6_Chars() {
		log.info("Register_05 - Step 01: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_05 - Step 02: Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Register.FIRST_NAME);
		
		log.info("Register_05 - Step 03: Enter to Lastname textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Register.LAST_NAME);
		
		log.info("Register_05 - Step 04: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_05 - Step 05: Enter to Password textbox with value '12345'");
		registerPage.enterToPasswordTextbox("12345");
		
		log.info("Register_05 - Step 06: Enter to Confirm Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToConfirmPasswordTextbox("12345");
		
		log.info("Register_05 - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_05 - Step 08: Verify Password error message eror displayed");
		Assert.assertTrue(registerPage.isPasswordErrorMessageDisplayed());
	}

	@Test
	public void Register_06_Invalid_Confirm_Password() {
		log.info("Register_06 - Step 01: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Register_06 - Step 02: Enter to Firstname textbox with value '" + UserData.Register.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Register.FIRST_NAME);
		
		log.info("Register_06 - Step 03: Enter to Lastname textbox with value '" + UserData.Register.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Register.LAST_NAME);
		
		log.info("Register_06 - Step 04: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Register_06 - Step 05: Enter to Password textbox with value '" + UserData.Register.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Register.PASSWORD);
		
		log.info("Register_06 - Step 06: Enter to Confirm Password textbox with value '000000'");
		registerPage.enterToConfirmPasswordTextbox("000000");
		
		log.info("Register_06 - Step 07: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Register_06 - Step 08: Verify Confirm Password error message eror displayed ");
		Assert.assertTrue(registerPage.isConfirmPasswordErrorMessageDisplayed());
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
