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
import pageObjects.ProductInfoPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ShoppingCartPageObject;

@Listeners(commons.MethodListener.class)
public class User_07_Order extends BaseTest {
	WebDriver driver;
	private String validEmail;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ProductInfoPageObject productInfoPage;
	ShoppingCartPageObject shoppingCartPage;

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

		log.info("Pre-Condition - Step 13: Select 'HP Spectre XT Pro UltraBook'");
		productInfoPage = homePage.selectProductByProductName("Computers ", "Desktops ", "Build your own computer");
	}

	@Test
	public void Order_01_Add_Product_To_Cart() {
		log.info("Order_01 - Step 01: Select '2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]' in 'Processor' dropdown");
		productInfoPage.selectItemInDropdownByTextItem("2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]");

		log.info("Order_01 - Step 02: Select '8GB [+$60.00]' in 'RAM' dropdown");
		productInfoPage.selectItemInDropdownByTextItem("8GB [+$60.00]");

		log.info("Order_01 - Step 03: Check to '400 GB [+$100.00]'");
		productInfoPage.checkToCheckboxByName("400 GB [+$100.00]");

		log.info("Order_01 - Step 05: Check to 'Vista Premium [+$60.00]'");
		productInfoPage.checkToCheckboxByName("Vista Premium [+$60.00]");

		log.info("Order_01 - Step 06: Check all 'Software ' checkbox");
		productInfoPage.checkToCheckboxByName("Microsoft Office [+$50.00]");
		productInfoPage.checkToCheckboxByName("Acrobat Reader [+$10.00]");
		productInfoPage.checkToCheckboxByName("Total Commander [+$5.00]");
		
		log.info("Order_01 - Step 06: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();

		log.info("Order_01 - Step 07: Verify product added to shopping cart message is displayed");
		Assert.assertTrue(productInfoPage.isProductAddedToShoppingCartMessageDisplayed());
		
		log.info("Order_01 - Step 07: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_01 - Step 07: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();
		
		log.info("Order_01 - Step 07: Verify product is displayed in shopping cart");
		Assert.assertTrue(shoppingCartPage.isProductAddedToCartSuccess("1", "Product(s)", "Build your own computer"));
	}

	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		
	}

	@Test
	public void Order_03_Remove_From_Cart() {

	}

	@Test
	public void Order_04_Update_Shopping_Cart() {

	}

	@Test
	public void Order_05_Checkout_Order_Pay_By_Cheque() {

	}

	@Test
	public void Order_06_Checkout_Order_Pay_By_Card() {

	}

	@Test
	public void Order_07_Reorder() {

	}

	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}

}
