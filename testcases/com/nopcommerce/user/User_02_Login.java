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
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;
@Listeners(commons.MethodListener.class)
public class User_02_Login extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	RegisterPageObject registerPage;
	
	private String validEmail;
	
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		validEmail = UserData.Register.VALID_EMAIL + getRandomNumberByDateTime() + "@gmail.com";
		
		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName,enviromentName);
		homePage = PageGeneraterManager.getHomePage(driver);
		
		log.info("Pre-Condition - Step 02: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();
		
		log.info("Pre-Condition - Step 03: Enter to Firstname textbox with value '" + UserData.Login.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Login.FIRST_NAME);
		
		log.info("Pre-Condition - Step 04: Enter to Lastname textbox with value '" + UserData.Login.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Login.LAST_NAME);
		
		log.info("Pre-Condition - Step 05: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);
		
		log.info("Pre-Condition - Step 06: Enter to Password textbox with value '" + UserData.Login.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Login.PASSWORD);
		
		log.info("Pre-Condition - Step 07: Enter to Confirm Password textbox with value '" + UserData.Login.PASSWORD + "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.Login.PASSWORD);
		
		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();
		
		log.info("Pre-Condition- Step 09: Navigate to Login page");
		loginPage = homePage.clickToLoginLink();
		
	}
	
	@Test
	public void Login_01_Empty_Data() {
		log.info("Login_01 - Step 01: Click to 'Login' button");
		loginPage.clickToLoginButton();
		
		log.info("Login_01 - Step 02: Verify error message is displayed");
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Test
	public void Login_02_Invalid_Email() {
		log.info("Login_02 - Step 01: Enter to  Email textbox with value '" + UserData.Login.INVALID_EMAIL + "'");
		loginPage.enterToEmailTextbox(UserData.Login.INVALID_EMAIL);
		
		log.info("Login_02 - Step 02: Click to 'Login' button");
		loginPage.clickToLoginButton();
		
		log.info("Login_02 - Step 03: Verify error message is displayed");
		Assert.assertTrue(loginPage.isErrorMessageDisplayed());
	}
	
	@Test
	public void Login_03_Login_With_Unregisted_Email() {
		log.info("Login_03 - Step 01: Enter to  Email textbox with value '" + UserData.Login.UNREGISTED_EMAIL + "'");
		loginPage.enterToEmailTextbox(UserData.Login.UNREGISTED_EMAIL);
		
		log.info("Login_03 - Step 02: Enter to  Password textbox with value '" + UserData.Login.PASSWORD + "'");
		loginPage.enterToPasswordTextbox(UserData.Login.PASSWORD);
		
		log.info("Login_03 - Step 03: Click to 'Login' button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_03 - Step 04: Verify error message is displayed");
		Assert.assertTrue(loginPage.isUnregistedEmailErrorMessageDisplayed());
	}
	
	@Test
	public void Login_04_Login_With_Empty_Password() {
		log.info("Login_04 - Step 01: Enter to  Email textbox  with value '" + validEmail + "'");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_04 - Step 02: Click to 'Login' button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_03 - Step 03: Verify error message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	@Test
	public void Login_05_Login_With_Wrong_Password() {
		log.info("Login_05 - Step 01: Enter to  Email textbox with value '" + validEmail + "'");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_05 - Step 02: Enter to  Password textbox with wrong password ");
		loginPage.enterToPasswordTextbox("000000");
		
		log.info("Login_05 - Step 03: Click to 'Login' button ");
		loginPage.clickToLoginButton();
		
		log.info("Login_05 - Step 04: Verify error message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
	}
	
	@Test
	public void Login_06_Success_Login() {
		log.info("Login_05 - Step 01: Enter to  Email textbox with value '" + validEmail + "'");
		loginPage.enterToEmailTextbox(validEmail);
		
		log.info("Login_05 - Step 02: Enter to  Password textbox with value '" + UserData.Login.PASSWORD + "'");
		loginPage.enterToPasswordTextbox(UserData.Login.PASSWORD);
		
		log.info("Login_05 - Step 03: Click to login button ");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Login_05 - Step 04: Verify My Account link is displayed");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
	}
	
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
