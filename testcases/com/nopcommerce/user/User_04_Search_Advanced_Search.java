package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;

@Listeners(commons.MethodListener.class)
public class User_04_Search_Advanced_Search extends BaseTest {
	WebDriver driver;
	private String validEmail;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	SearchPageObject searchPage;

	@Parameters({ "browser", "enviroment" })
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

		log.info("Pre-Condition - Step 13: Click to 'Search' link at Footer");
		searchPage = homePage.clickToSearchLink();
	}

	@Test
	public void Search_01_Search_With_Empty_Data() {
		log.info("Search_01 - Step 1: Click to 'Search' button");
		searchPage.clickToSearchButton();

		log.info("Search_01 - Step 2: Verify error message is displayed");
		Assert.assertEquals(searchPage.isErrorMessageDisplayed(), UserData.Search.ERROR_MESSAGE);
	}

	@Test
	public void Search_02_Search_With_Data_Not_Exist() {
		log.info("Search_02 - Step 1: Enter to 'Search keyword' textbox with value 'Macbook Pro 2050'");
		searchPage.enterToSearchTextbox("Macbook Pro 2050");

		log.info("Search_02 - Step 2: Click to 'Search' button");
		searchPage.clickToSearchButton();

		log.info("Search_02 - Step 3: Verify product not found error message is displayed");
		Assert.assertEquals(searchPage.isProductNotFoundErrorMessageDisplayed(),
				UserData.Search.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
	}

	@Test
	public void Search_03_Search_With_Relative_Data() {
		log.info("Search_03 - Step 1: Enter to 'Search keyword' textbox with value 'lenovo'");
		searchPage.enterToSearchTextbox("lenovo");

		log.info("Search_03 - Step 2: Click to 'Search' button");
		searchPage.clickToSearchButton();

		log.info("Search_03 - Step 3: Verify 'Lenovo IdeaCentre 600 All-in-One PC' is displayed");
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo IdeaCentre 600 All-in-One PC"));
		
		log.info("Search_03 - Step 4: Verify 'Lenovo Thinkpad X1 Carbon Laptop' is displayed");
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_04_Search_With_Absolute_Data() {
		log.info("Search_04 - Step 1: Enter to 'Search keyword' textbox with value 'ThinkPad X1 Carbon'");
		searchPage.enterToSearchTextbox("ThinkPad X1 Carbon");

		log.info("Search_04 - Step 2: Click to 'Search' button");
		searchPage.clickToSearchButton();

		log.info("Search_04 - Step 3: Verify 'Lenovo Thinkpad X1 Carbon Laptop' is displayed");
		Assert.assertTrue(searchPage.isProductDisplayedByText("Lenovo Thinkpad X1 Carbon Laptop"));
	}

	@Test
	public void Search_05_Search_With_Parent_Catelogies() {
		log.info("Search_05 - Step 1: Enter to 'Search keyword' textbox with value 'Apple MacBook Pro'");
		searchPage.enterToSearchTextbox("Apple MacBook Pro");
		
		log.info("Search_05 - Step 2: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByName("Advanced search");
		
		log.info("Search_05 - Step 3: Select 'Computers' from 'Category' dropdown");
		searchPage.selectItemFromDropdownByName("Category", "Computers");
		
		log.info("Search_05 - Step 4: Click to 'Search' button");
		searchPage.clickToSearchButton();
		
		log.info("Search_05 - Step 5: Verify product not found error message is displayed");
		Assert.assertEquals(searchPage.isProductNotFoundErrorMessageDisplayed(),
				UserData.Search.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
	}

	@Test
	public void Search_06_Search_With_Sub_Catelogies() {
		
		
		log.info("Search_06 - Step 1: Enter to 'Search keyword' textbox with value 'Apple MacBook Pro'");
		searchPage.enterToSearchTextbox("Apple MacBook Pro");
		
		log.info("Search_06 - Step 2: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByName("Advanced search");
		
		log.info("Search_06 - Step 3: Select 'Computers' from 'Category' dropdown");
		searchPage.selectItemFromDropdownByName("Category", "Computers");
		
		log.info("Search_06 - Step 4: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByName("Automatically search sub categories");
		
		log.info("Search_06 - Step 5: Click to 'Search' button");
		searchPage.clickToSearchButton();
		
		log.info("Search_04 - Step 3: Verify 'Apple MacBook Pro 13-inch' is displayed");
		Assert.assertTrue(searchPage.isProductDisplayedByText("Apple MacBook Pro 13-inch"));
		
	}

	@Test
	public void Search_07_Search_With_Incorrect_Manufacturer() {
		log.info("Search_07 - Step 1: Enter to 'Search keyword' textbox with value 'Apple MacBook Pro'");
		searchPage.enterToSearchTextbox("Apple MacBook Pro");
		
		log.info("Search_07 - Step 2: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByName("Advanced search");
		
		log.info("Search_07 - Step 3: Select 'Computers' from 'Category' dropdown");
		searchPage.selectItemFromDropdownByName("Category", "Computers");
		
		log.info("Search_07 - Step 4: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByName("Automatically search sub categories");
		
		log.info("Search_07 - Step 5: Select 'HP' from 'Manufacturer' dropdown");
		searchPage.selectItemFromDropdownByName("Manufacturer", "HP");
		
		log.info("Search_07 - Step 6: Check to 'Search In product descriptions' checkbox");
		searchPage.checkToCheckboxByName("Search In product descriptions");
		
		log.info("Search_07 - Step 7: Click to 'Search' button");
		searchPage.clickToSearchButton();
		
		log.info("Search_07 - Step 8: Verify product not found error message is displayed");
		Assert.assertEquals(searchPage.isProductNotFoundErrorMessageDisplayed(),
				UserData.Search.PRODUCT_NOT_FOUND_ERROR_MESSAGE);
	}

	@Test
	public void Search_08_Search_With_Correct_Manufacturer() {
		log.info("Search_08 - Step 1: Enter to 'Search keyword' textbox with value 'Apple MacBook Pro'");
		searchPage.enterToSearchTextbox("Apple MacBook Pro");
		
		log.info("Search_08 - Step 2: Check to 'Advanced search' checkbox");
		searchPage.checkToCheckboxByName("Advanced search");
		
		log.info("Search_08 - Step 3: Select 'Computers' from 'Category' dropdown");
		searchPage.selectItemFromDropdownByName("Category", "Computers");
		
		log.info("Search_08 - Step 4: Check to 'Automatically search sub categories' checkbox");
		searchPage.checkToCheckboxByName("Automatically search sub categories");
		
		log.info("Search_08 - Step 5: Select 'Apple' from 'Manufacturer' dropdown");
		searchPage.selectItemFromDropdownByName("Manufacturer", "Apple");
		
		log.info("Search_08 - Step 6: Check to 'Search In product descriptions' checkbox");
		searchPage.checkToCheckboxByName("Search In product descriptions");
		
		log.info("Search_08 - Step 7: Click to 'Search' button");
		searchPage.clickToSearchButton();
		
		log.info("Search_08 - Step 8: Verify 'Apple MacBook Pro 13-inch' is displayed");
		Assert.assertTrue(searchPage.isProductDisplayedByText("Apple MacBook Pro 13-inch"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
