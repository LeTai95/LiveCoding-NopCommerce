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

		log.info("Pre-Condition - Step 13: Select 'Build your own computer'");
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

		log.info("Order_01 - Step 04: Check to 'Vista Premium [+$60.00]'");
		productInfoPage.checkToCheckboxByName("Vista Premium [+$60.00]");

		log.info("Order_01 - Step 05: Check all 'Software ' checkbox");
		productInfoPage.checkToCheckboxByName("Microsoft Office [+$50.00]");
		productInfoPage.checkToCheckboxByName("Acrobat Reader [+$10.00]");
		productInfoPage.checkToCheckboxByName("Total Commander [+$5.00]");
		
		log.info("Order_01 - Step 06: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();

		log.info("Order_01 - Step 07: Verify product added to shopping cart message is displayed");
		Assert.assertTrue(productInfoPage.isProductAddedToShoppingCartMessageDisplayed());
		
		log.info("Order_01 - Step 08: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_01 - Step 09: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();
		
		log.info("Order_01 - Step 10: Verify product is displayed in shopping cart");
		Assert.assertTrue(shoppingCartPage.isProductAddedToCartSuccess("1", "Product(s)", "Build your own computer"));
		
		log.info("Order_01 - Step 11: Verify product Info is displayed in shopping cart");
		Assert.assertEquals(shoppingCartPage.isProductInfoDisplayedInShoppingCart("1", "Product(s)", "Build your own computer"), 
				UserData.Order.PRODUCT_INFO_BEFORE);
		
		log.info("Order_01 - Step 12: Verify product Price is displayed in shopping cart");
		Assert.assertEquals(shoppingCartPage.isProductPriceDisplayedInShoppingCart("1", "Price"), "$1,500.00");
	}

	@Test
	public void Order_02_Edit_Product_In_Shopping_Cart() {
		log.info("Order_02 - Step 01: Click to 'Edit'");
		productInfoPage = shoppingCartPage.clickToEditByRowNumberAndColumnName("1", "Product(s)");
		
		log.info("Order_01 - Step 02: Select '2.2 GHz Intel Pentium Dual-Core E2200' in 'Processor' dropdown");
		productInfoPage.selectItemInDropdownByTextItem("2.2 GHz Intel Pentium Dual-Core E2200");
		
		log.info("Order_02 - Step 03: Select '4GB [+$20.00]' in 'RAM' dropdown");
		productInfoPage.selectItemInDropdownByTextItem("4GB [+$20.00]");
		
		log.info("Order_02 - Step 04: Check to '320 GB'");
		productInfoPage.checkToCheckboxByName("320 GB");
		
		log.info("Order_02 - Step 05: Check to 'Vista Home [+$50.00]'");
		productInfoPage.checkToCheckboxByName("Vista Home [+$50.00]");
		
		log.info("Order_02 - Step 06: Uncheck 'Acrobat Reader [+$10.00]' and 'Total Commander [+$5.00]' checkbox");
		productInfoPage.uncheckToCheckboxByName("Acrobat Reader [+$10.00]");
		productInfoPage.uncheckToCheckboxByName("Total Commander [+$5.00]");
		
		log.info("Order_02 - Step 07: Enter product number is '2'");
		productInfoPage.enterToProductNumber("2");
		
		log.info("Order_02 - Step 08: Verify price is '$1,320.00'");
		Assert.assertTrue(productInfoPage.isPriceDisplayTrue("$1,320.00"));
		
		log.info("Order_02 - Step 09: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();

		log.info("Order_02 - Step 10: Verify product added to shopping cart message is displayed");
		Assert.assertTrue(productInfoPage.isProductAddedToShoppingCartMessageDisplayed());
		
		log.info("Order_02 - Step 11: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_02 - Step 12: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();
		
		log.info("Order_02 - Step 13: Verify product is displayed in shopping cart");
		Assert.assertTrue(shoppingCartPage.isProductAddedToCartSuccess("1", "Product(s)", "Build your own computer"));
		
		log.info("Order_02 - Step 14: Verify product Info is displayed in shopping cart");
		Assert.assertEquals(shoppingCartPage.isProductInfoDisplayedInShoppingCart("1", "Product(s)", "Build your own computer"), 
				UserData.Order.PRODUCT_INFO_AFTER);
		
		log.info("Order_02 - Step 14: Verify 'Total' is '$2,640.00'");
		Assert.assertEquals(shoppingCartPage.isProductPriceDisplayedInShoppingCart("1", "Total"), "$2,640.00");
	}

	@Test
	public void Order_03_Remove_From_Cart() {
		log.info("Order_03 - Step 01: Click to 'Remove' button");
		shoppingCartPage.clickToRemoveButtonByRowNumberAndColumnName("1", "Remove");
		
		log.info("Order_03 - Step 02: Verify message is displayed");
		Assert.assertTrue(shoppingCartPage.isShoppingCartMessageDisplayed());
		
		log.info("Order_03 - Step 03: Verify product is not displayed");
		Assert.assertTrue(shoppingCartPage.isProductNotDisplayed("1", "Product(s)", "Build your own computer"));
		
	}

	@Test
	public void Order_04_Update_Shopping_Cart() {
		log.info("Order_04 - Step 01: Navigate to Home page");
		homePage = shoppingCartPage.navigateToHomePage();
		
		log.info("Order_04 - Step 02: Select 'Lenovo IdeaCentre 600 All-in-One PC'");
		productInfoPage = homePage.selectProductByProductName("Computers ", "Desktops ", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Order_04 - Step 03: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();
		
		log.info("Order_04 - Step 04: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_04 - Step 05: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();
		
		log.info("Order_04 - Step 06: Enter to 'Qty.'");
		shoppingCartPage.enterToQtyByRowNumberAndColumnNumber("1", "Qty.", "5");
		
		log.info("Order_04 - Step 07: Click to 'Update shopping cart'");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("Order_02 - Step 14: Verify 'Total' is '$2,500.00'");
		Assert.assertEquals(shoppingCartPage.isProductPriceDisplayedInShoppingCart("1", "Total"), "$2,500.00");
		
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
