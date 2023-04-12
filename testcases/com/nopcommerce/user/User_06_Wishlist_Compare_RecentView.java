package com.nopcommerce.user;

import org.junit.Assert;
import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import pageObjects.CompareProductListPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.RecentlyViewedProductsPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishlistPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;

@Listeners(commons.MethodListener.class)
public class User_06_Wishlist_Compare_RecentView extends BaseTest {
	WebDriver driver;
	private String validEmail;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	WishlistPageObject wishlistPage;
	ShoppingCartPageObject shoppingCartPage;
	CompareProductListPageObject compareProductListPage;
	RecentlyViewedProductsPageObject recentlyViewedProductsPage;

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
		homePage.selectProductByProductName("Computers ", "Notebooks ", "HP Spectre XT Pro UltraBook");
	}

	@Test
	public void TC_01_Wishlist_01_Add_To_Wishlist() {
		log.info("Wishlist_01 - Step 01: Click to 'Add to wishlist' button");
		homePage.clickToAddToWishlistButton();

		log.info("Wishlist_01 - Step 02: Verify product added to Wishlist success message is displayed");
		Assert.assertTrue(homePage.isAddedToWishlistSuccessMessageDisplayed());

		log.info("Wishlist_01 - Step 03: Click to 'Wishlist' link");
		wishlistPage = homePage.clickToWishlistLink();

		log.info("Wishlist_01 - Step 04: Verify product is displayed");
		Assert.assertTrue(
				wishlistPage.getProductNameByRowNumberAndColumnName("1", "Product(s)", "HP Spectre XT Pro UltraBook"));

		log.info("Wishlist_01 - Step 05: Verify Wishlist sharing link is displayed");
		Assert.assertTrue(wishlistPage.isWishlistSharingLinkDisplayed());
	}

	@Test
	public void TC_02_Wishlist_02_Add_Product_To_Cart_From_Wishlist_Page() {
		log.info("Wishlist_02 - Step 06: Click to 'Wishlist' link");
		wishlistPage = homePage.clickToWishlistLink();

		log.info("Wishlist_02 - Step 07: Check to checkbox 'Add to cart'");
		wishlistPage.checkToCheckboxByRowNumberAndColumnName("1", "Add to cart");

		log.info("Wishlist_02 - Step 08: Click to 'Add To Cart' button");
		shoppingCartPage = wishlistPage.clickToAddToCartButton();

		log.info("Wishlist_02 - Step 09: Verify product added to Cart success");
		Assert.assertTrue(
				shoppingCartPage.isProductAddedToCartSuccess("1", "Product(s)", "HP Spectre XT Pro UltraBook"));

		log.info("Wishlist_02 - Step 10: Navigate to Wishlist page");
		wishlistPage = shoppingCartPage.clickToWishlistLink();

		log.info("Wishlist_02 - Step 10: Verify product is not displayed");
		verifyTrue(wishlistPage.isProductNotDisplayedByRowNumberAndColumnName("1", "Product(s)",
				"HP Spectre XT Pro UltraBook"));
	}

	@Test
	public void TC_03_Wishlist_03_Remove_Product_In_Wishlist_Page() {
		log.info("Wishlist_03 - Step 01: Navigate to Home page");
		homePage = wishlistPage.navigateToHomePage();

		log.info("Wishlist_03 - Step 02: Select 'Nokia Lumia 1020'");
		homePage.selectProductByProductName("Electronics ", "Cell phones ", "Nokia Lumia 1020");

		log.info("Wishlist_03 - Step 03: Click to 'Add to wishlist' button");
		homePage.clickToAddToWishlistButton();

		log.info("Wishlist_03 - Step 04: Click to 'Add to wishlist' link");
		homePage.clickToWishlistLink();

		log.info("Wishlist_03 - Step 05: Verify product is displayed");
		Assert.assertTrue(wishlistPage.getProductNameByRowNumberAndColumnName("1", "Product(s)", "Nokia Lumia 1020"));

		log.info("Wishlist_03 - Step 06: Click to 'Remove' button");
		wishlistPage.clickToRemoveButton("1", "Remove");

		log.info("Wishlist_02 - Step 10: Verify product is not displayed");
		verifyTrue(wishlistPage.isProductNotDisplayedByRowNumberAndColumnName("1", "Product(s)", "Nokia Lumia 1020"));
	}

	@Test
	public void TC_04_Compare_01_Add_Product_To_Compare() {
		log.info("Wishlist_04 - Step 01: Navigate to Home page");
		homePage = wishlistPage.navigateToHomePage();

		log.info("Wishlist_04 - Step 02: Hover to 'Computers' menu");
		homePage.hoverToMenuByText("Computers ");

		log.info("Wishlist_04 - Step 03: Click to 'Desktops' menu");
		homePage.clickToItemByText("Desktops ");

		log.info("Wishlist_04 - Step 04: Click to 'Add to compare list' button in 'Build your own computer' product");
		homePage.clickToCompareButtonByProductName("Build your own computer");

		log.info("Wishlist_04 - Step 05: Verify add to compare list success message is displayed");
		Assert.assertTrue(homePage.isAddToCompareListSuccessDisplayed());

		log.info(
				"Wishlist_04 - Step 06: Click to 'Add to compare list' button in 'Lenovo IdeaCentre 600 All-in-One PC' product");
		homePage.clickToCompareButtonByProductName("Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Wishlist_04 - Step 07: Verify add to compare list success message is displayed");
		Assert.assertTrue(homePage.isAddToCompareListSuccessDisplayed());

		log.info("Wishlist_04 - Step 08: Click to 'Compare products list' link");
		compareProductListPage = homePage.clickToCompareProductsListLink();

		log.info(
				"Wishlist_04 - Step 09: Verify 'Remove' button in 'Lenovo IdeaCentre 600 All-in-One PC' product details is displayed");
		Assert.assertTrue(compareProductListPage
				.isRemoveButtonDisplayedByProductNameAndRowNumber("Lenovo IdeaCentre 600 All-in-One PC", "2"));

		log.info("Wishlist_04 - Step 10: Verify 'Remove' button in 'Build your own computer' product details is displayed");
		Assert.assertTrue(compareProductListPage
				.isRemoveButtonDisplayedByProductNameAndRowNumber("Build your own computer", "3"));

		log.info("Wishlist_04 - Step 11: Verify 'Name' in 'Lenovo IdeaCentre 600 All-in-One PC' product details is displayed");
		Assert.assertTrue(compareProductListPage.isProductNameDisplay("Lenovo IdeaCentre 600 All-in-One PC"));

		log.info("Wishlist_04 - Step 12: Verify 'Name' in 'Build your own computer' product details is displayed");
		Assert.assertTrue(compareProductListPage.isProductNameDisplay("Build your own computer"));

		log.info("Wishlist_04 - Step 13: Verify 'Price' in 'Lenovo IdeaCentre 600 All-in-One PC' product details is displayed");
		Assert.assertTrue(compareProductListPage.isPriceDisplayedByProductNameAndRowNumber("Lenovo IdeaCentre 600 All-in-One PC","2"));

		log.info("Wishlist_04 - Step 14: Verify 'Price' in 'Build your own computer' product details is displayed");
		Assert.assertTrue(compareProductListPage.isPriceDisplayedByProductNameAndRowNumber("Build your own computer","3"));

		log.info("Wishlist_04 - Step 15: Verify 'Clear List' button is displayed");
		Assert.assertTrue(compareProductListPage.isClearListButtonDisplayed());

		log.info("Wishlist_04 - Step 16: Click to 'Clear List' button");
		compareProductListPage.clickToClearListButton();

		log.info("Wishlist_04 - Step 17: Verify clear message is displayed");
		Assert.assertTrue(compareProductListPage.isClearMessageDisplayed());

		log.info("Wishlist_04 - Step 18: Verify 'Lenovo IdeaCentre 600 All-in-One PC' is not displayed");
		Assert.assertTrue(compareProductListPage.isProductNotDisplayedByProductName("Lenovo IdeaCentre 600 All-in-One PC"));
		
		log.info("Wishlist_04 - Step 19: Verify 'Build your own computer' is not displayed");
		Assert.assertTrue(compareProductListPage.isProductNotDisplayedByProductName("Build your own computer"));
	}

	@Test
	public void TC_05_Recent_View_01_Recent_View_Product() {
		log.info("Wishlist_05 - Step 01: Navigate to Home page");
		homePage = compareProductListPage.navigateToHomePage();
		
		log.info("Wishlist_05 - Step 02: Select 'Nokia Lumia 1020'");
		homePage.selectProductByProductName("Electronics ", "Cell phones ", "Nokia Lumia 1020");
		
		log.info("Wishlist_05 - Step 03: Select 'Build your own computer'");
		homePage.selectProductByProductName("Computers ", "Desktops ", "Build your own computer");
		
		log.info("Wishlist_05 - Step 04: Select 'HTC One Mini Blue'");
		homePage.selectProductByProductName("Electronics ", "Cell phones ", "HTC One Mini Blue");
		
		log.info("Wishlist_05 - Step 05: Select 'Custom T-Shirt'");
		homePage.selectProductByProductName("Apparel ", "Clothing ", "Custom T-Shirt");
		
		log.info("Wishlist_05 - Step 06: Click to 'Recently viewed products' link");
		recentlyViewedProductsPage = homePage.clickTohomeRecentlyViewedProductsLink();
		
		log.info("Wishlist_05 - Step 07: Verify at least 3 products displayed");
		Assert.assertTrue(recentlyViewedProductsPage.isProductsNumberDisplayedTrue("3"));
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
