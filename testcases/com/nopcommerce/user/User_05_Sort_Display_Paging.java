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
public class User_05_Sort_Display_Paging extends BaseTest {
	WebDriver driver;
	private String validEmail;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	
	@Parameters({"browser","enviroment"})
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		validEmail = UserData.Search.VALID_EMAIL + getRandomNumberByDateTime() + "@gmail.com";
		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName, enviromentName);
		homePage = PageGeneraterManager.getHomePage(driver);

		log.info("Pre-Condition - Step 02: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 03: Enter to Firstname textbox with value '" + UserData.Search.FIRST_NAME + "'");
		registerPage.enterToFirstnameTextbox(UserData.Search.FIRST_NAME);

		log.info("Pre-Condition - Step 04: Enter to Lastname textbox with value '" + UserData.Search.LAST_NAME + "'");
		registerPage.enterToLastnameTextbox(UserData.Search.LAST_NAME);

		log.info("Pre-Condition - Step 05: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);

		log.info("Pre-Condition - Step 06: Enter to Password textbox with value '" + UserData.Search.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.Search.PASSWORD);

		log.info("Pre-Condition - Step 07: Enter to Confirm Password textbox with value '" + UserData.Search.PASSWORD
				+ "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.Search.PASSWORD);

		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition- Step 09: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 10: Enter to  Email textbox with value '" + validEmail + "' ");
		loginPage.enterToEmailTextbox(validEmail);

		log.info("Pre-Condition - Step 11: Enter to  Password textbox with value '" + UserData.Search.PASSWORD + "'");
		loginPage.enterToPasswordTextbox(UserData.Search.PASSWORD);

		log.info("Pre-Condition - Step 12: Click to 'Login' button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("Pre-Condition - Step 13: Hover To 'Computers'");
		homePage.hoverToMenuByText("Computers ");

		log.info("Pre-Condition - Step 14: Click to 'Notebooks' ; in Computers menu");
		homePage.clickToItemByText("Notebooks ");
	}
	
	@Test
	public void TC_01_User_05_Sort_01_Sort_With_Name_Ascending_A_To_Z() {
		log.info("User_05_Sort_01 - Step 01: Select item 'Name (A to Z)' in dropdown");
		homePage.selectItemFromSortbyDropdown("Name: A to Z");
		
		log.info("User_05_Sort_01 - Step 02: Verify Products Name sort by ascending");
		Assert.assertTrue(homePage.isProductNameSortByAscending());
	}
	
	@Test
	public void TC_02_User_05_Sort_02_Sort_With_Name_Descending_Z_to_A() {
		log.info("User_05_Sort_02 - Step 01: Select item 'Name (Z to A)' in dropdown");
		homePage.selectItemFromSortbyDropdown("Name: Z to A");
		
		log.info("User_05_Sort_02 - Step 02: Verify Products Name sort by descending");
		Assert.assertTrue(homePage.isProductNameSortByDescending());
	}
	
	@Test
	public void TC_03_User_05_Sort_03_Sort_With_Price_Ascending_Low_to_High() {
		log.info("User_05_Sort_03 - Step 01: Select item 'Price: Low to High' in dropdown");
		homePage.selectItemFromSortbyDropdown("Price: Low to High");
		
		log.info("User_05_Sort_03 - Step 02: Verify Products Price sort by ascending");
		Assert.assertTrue(homePage.isProductPriceSortByAscending());
	}
	
	@Test
	public void TC_04_User_05_Sort_04_Sort_With_Price_Descending_High_to_Low() {
		log.info("User_05_Sort_04 - Step 01: Select item 'Price: High to Low' in dropdown");
		homePage.selectItemFromSortbyDropdown("Price: High to Low");
		
		log.info("User_05_Sort_04 - Step 02: Verify Products Price sort by descending");
		Assert.assertTrue(homePage.isProductPriceSortByDescending());
	}
	
	@Test
	public void TC_05_User_05_Display_01_Verify_With_3_Products_Per_Page() {
		log.info("User_05_Display_01 - Step 01: Select item '3' in dropdown");
		homePage.selectItemFromDisplayDropdown("3");
		
		log.info("User_05_Display_01 - Step 02: Verify have at least 3 products displayed");
		Assert.assertTrue(homePage.isProductNumberDisplayedTrue("3"));
		
		log.info("User_05_Display_01 - Step 03: Verify Next icon is displayed");
		Assert.assertTrue(homePage.isNextIconDisplayed());
		
		log.info("User_05_Display_01 - Step 04: Click to page 2");
		homePage.clickToPageByNumber("2");
		
		log.info("User_05_Display_01 - Step 05: Verify Previous	 icon is displayed");
		Assert.assertTrue(homePage.isPreviousIconDisplayed());
	}
	
	@Test
	public void TC_06_User_05_Display_02_Verify_With_6_Products_Per_Page() {
		log.info("User_05_Display_02 - Step 01: Select item '6' in dropdown");
		homePage.selectItemFromDisplayDropdown("6");
		
		log.info("User_05_Display_02 - Step 02: Verify have at least 6 products displayed");
		Assert.assertTrue(homePage.isProductNumberDisplayedTrue("6"));
		
		log.info("User_05_Display_03 - Step 03: Verify paging is not displayed");
		verifyTrue(homePage.isPagingNotDisplayed());
	}
	
	@Test
	public void TC_07_User_05_Display_03_Verify_With_9_Products_Per_Page() {
		log.info("User_05_Display_02 - Step 01: Select item '9' in dropdown");
		homePage.selectItemFromDisplayDropdown("9");
		
		log.info("User_05_Display_02 - Step 02: Verify have at least 9 products displayed");
		Assert.assertTrue(homePage.isProductNumberDisplayedTrue("9"));
		
		log.info("User_05_Display_03 - Step 03: Verify paging is not displayed");
		verifyTrue(homePage.isPagingNotDisplayed());
	}
	
	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
