package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import pageObjects.BillingAddressPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.ConfirmOrderPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.OrderInfomationPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PaymentInformationPageObject;
import pageObjects.PaymentMethodPageObject;
import pageObjects.ProductInfoPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.ShoppingCartPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;

@Listeners(commons.MethodListener.class)
public class User_07_Order extends BaseTest {
	WebDriver driver;
	private String validEmail;
	HomePageObject homePage;
	RegisterPageObject registerPage;
	LoginPageObject loginPage;
	ProductInfoPageObject productInfoPage;
	ShoppingCartPageObject shoppingCartPage;
	BillingAddressPageObject billingAddressPage;
	CheckoutPageObject checkoutPage;
	PaymentMethodPageObject paymentMethodPage;
	PaymentInformationPageObject paymentInformationPage;
	ConfirmOrderPageObject confirmOrderPage;
	MyAccountPageObject myAccountPage;
	OrdersPageObject ordersPage;
	OrderInfomationPageObject orderInfomationPage;

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

		log.info("Pre-Condition - Step 09: Navigate to 'Login' page");
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
		log.info(
				"Order_01 - Step 01: Select '2.5 GHz Intel Pentium Dual-Core E2200 [+$15.00]' in 'Processor' dropdown");
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
		Assert.assertEquals(
				shoppingCartPage.isProductInfoDisplayedInShoppingCart("1", "Product(s)", "Build your own computer"),
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
		Assert.assertEquals(
				shoppingCartPage.isProductInfoDisplayedInShoppingCart("1", "Product(s)", "Build your own computer"),
				UserData.Order.PRODUCT_INFO_AFTER);

		log.info("Order_02 - Step 15: Verify 'Total' is '$2,640.00'");
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
		productInfoPage = homePage.selectProductByProductName("Computers ", "Desktops ",
				"Lenovo IdeaCentre 600 All-in-One PC");

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

		log.info("Order_02 - Step 08: Verify 'Total' is '$2,500.00'");
		Assert.assertEquals(shoppingCartPage.isProductPriceDisplayedInShoppingCart("1", "Total"), "$2,500.00");
		
		log.info("Order_03 - Step 09: Click to 'Remove' button");
		shoppingCartPage.clickToRemoveButtonByRowNumberAndColumnName("1", "Remove");

	}

	@Test
	public void Order_05_Checkout_Order_Pay_By_Cheque() {
		log.info("Order_05 - Step 01: Navigate to Home page");
		homePage = shoppingCartPage.navigateToHomePage();

		log.info("Order_05 - Step 02: Select 'Apple MacBook Pro 13-inch'");
		productInfoPage = homePage.selectProductByProductName("Computers ", "Notebooks ", "Apple MacBook Pro 13-inch");

		log.info("Order_05 - Step 03: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();

		log.info("Order_05 - Step 04: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_05 - Step 05: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();

		log.info("Order_05 - Step 06: Click to 'Estimate shipping'");
		shoppingCartPage.clickToEstimateShipping();

		log.info("Order_05 - Step 07: Verify Shipping Popup is displayed");
		Assert.assertTrue(shoppingCartPage.isShippingPopupDisplayed());

		log.info("Order_05 - Step 08: Select 'Viet Nam' in Shipping Popup dropdown");
		shoppingCartPage.selectItemInShippingPopupDropdown("Viet Nam");

		log.info("Order_05 - Step 09: Enter to 'Zip/ postal code' textbox");
		shoppingCartPage.enterToZipPostCode("550000");

		log.info("Order_05 - Step 10: Check to 'Next Day Air' radio");
		shoppingCartPage.checkToRadionButtonByName("Next Day Air");

		log.info("Order_05 - Step 11: Check to 'Next Day Air' radio");
		shoppingCartPage.clickToApplyButton();

		log.info("Order_05 - Step 12: Verify Shipping Popup is not displayed");
		Assert.assertTrue(shoppingCartPage.isShippingPopupNotDisplayed());

		log.info("Order_05 - Step 13: Check to 'Term of service' checkbox");
		shoppingCartPage.checkToTermOfServiceCheckbox();

		log.info("Order_05 - Step 14: Click to 'Checkout' button");
		billingAddressPage = shoppingCartPage.clickToCheckoutButton();

		log.info("Order_05 - Step 15: Enter to 'Firstname' textbox with value : '" + UserData.Order.FIRST_NAME + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_FirstName", UserData.Order.FIRST_NAME);

		log.info("Order_05 - Step 16: Enter to 'Lastname' textbox with value : '" + UserData.Order.LAST_NAME + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_LastName", UserData.Order.LAST_NAME);

		log.info("Order_05 - Step 17: Enter to 'Email' textbox with value : '" + UserData.Order.EMAIL_ADDRESS + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_Email", UserData.Order.EMAIL_ADDRESS);

		log.info("Order_05 - Step 18: Select '" + UserData.Order.COUNTRY_NAME + "' in Country dropdown");
		billingAddressPage.selectItemByDropdownIDAndTextItem("BillingNewAddress_CountryId",
				UserData.Order.COUNTRY_NAME);

		log.info("Order_05 - Step 19: Enter to 'City' textbox with value : '" + UserData.Order.CITY_NAME + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_City", UserData.Order.CITY_NAME);

		log.info("Order_05 - Step 20: Enter to 'Address 1' textbox with value : '" + UserData.Order.ADDRESS_1 + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_Address1", UserData.Order.ADDRESS_1);

		log.info("Order_05 - Step 21: Enter to 'Zip / postal code' textbox with value : '"
				+ UserData.Order.ZIP_POSTAL_CODE + "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_ZipPostalCode", UserData.Order.ZIP_POSTAL_CODE);

		log.info("Order_05 - Step 22: Enter to 'Phone number' textbox with value : '" + UserData.Order.PHONE_NUMBER
				+ "'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_PhoneNumber", UserData.Order.PHONE_NUMBER);

		log.info("Order_05 - Step 23: Click to 'Continue' button");
		checkoutPage = billingAddressPage.clickToContinueButton();

		log.info("Order_05 - Step 24: Check to '2nd Day Air ($0.00)' radio button");
		checkoutPage.checkToRadioButtonByName("2nd Day Air ($0.00)");

		log.info("Order_05 - Step 25: Click to 'Continue' button");
		paymentMethodPage = checkoutPage.clickToContinueButton();

		log.info("Order_05 - Step 26: Check to 'Check / Money Order' radio button");
		paymentMethodPage.checkToRadioButtonByName("Check / Money Order");

		log.info("Order_05 - Step 27: Click to 'Continue' button");
		paymentInformationPage = paymentMethodPage.clickToContinueButton();

		log.info("Order_05 - Step 28: Verify payment information is displayed");
		Assert.assertTrue(paymentInformationPage.isPaymentInformationDisplayed());

		log.info("Order_05 - Step 29: Click to 'Continue' button");
		confirmOrderPage = paymentInformationPage.clickToContinueButton();

		log.info("Order_05 - Step 30: Verify 'Name' in 'Billing Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("billing-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_05 - Step 31: Verify 'Email' in 'Billing Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_05 - Step 32: Verify 'Phone' in 'Billing Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_05 - Step 33: Verify 'Address' in 'Billing Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.ADDRESS_1));

		log.info("Order_05 - Step 34: Verify 'City Stale Zip' in 'Billing Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_05 - Step 35: Verify 'Country' in 'Billing Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_05 - Step 36: Verify 'Payment' in 'Billing Address' is 'Check / Money Order'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("payment-method", "Check / Money Order"));
		
		log.info("Order_05 - Step 37: Verify 'Name' in 'Shipping Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_05 - Step 38: Verify 'Email' in 'Shipping Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_05 - Step 39: Verify 'Phone' in 'Shipping Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_05 - Step 40: Verify 'Address' in 'Shipping Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.ADDRESS_1));

		log.info("Order_05 - Step 41: Verify 'City Stale Zip' in 'Shipping Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_05 - Step 42: Verify 'Country' in 'Shipping Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_05 - Step 43: Verify 'Shipping' in 'Shipping Address' is '2nd Day Air'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("shipping-method", "2nd Day Air"));
		
		log.info("Order_05 - Step 44: Verify 'SKU' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "AP_MBP_13"));
		
		log.info("Order_05 - Step 45: Verify 'Product name' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Product(s)", "Apple MacBook Pro 13-inch"));
		
		log.info("Order_05 - Step 46: Verify 'Price' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$1,800.00"));
		
		log.info("Order_05 - Step 47: Verify 'Qty.' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Qty.", "2"));
		
		log.info("Order_05 - Step 48: Verify 'Total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$3,600.00"));
		
		log.info("Order_05 - Step 49: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$3,600.00"));
		
		log.info("Order_05 - Step 50: Verify 'Shipping price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_05 - Step 51: Verify 'Tax price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_05 - Step 52: Verify 'Total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Total:", "2", "$3,600.00"));
		
		log.info("Order_05 - Step 53: Click to 'Confirm' button");
		confirmOrderPage.clickToConfirmButton();
		
		log.info("Order_05 - Step 54: Verify success message and order number is displayed");
		Assert.assertTrue(confirmOrderPage.isSuccessMessagePageTitleDisplayed());
		Assert.assertTrue(confirmOrderPage.isSuccessMessageTitleDisplayed());
		Assert.assertTrue(confirmOrderPage.isOrderNumberDisplayed());
		String orderNumberInHomePage = confirmOrderPage.getOrderNumberInHomePage();
		
		
		log.info("Order_05 - Step 55: Navigate to 'My Account' page");
		myAccountPage = confirmOrderPage.clickToMyAccountLink();
		
		log.info("Order_05 - Step 56: Click to 'Orders' link in menu");
		ordersPage = myAccountPage.clickToOrdersLink();
		
		log.info("Order_05 - Step 57: Verify order number is displayed");
		Assert.assertEquals(ordersPage.isOrderNumberDisplayed(), orderNumberInHomePage);
		
		log.info("Order_05 - Step 58: Click to 'Details' button");
		orderInfomationPage = ordersPage.clickToDetailsButton(orderNumberInHomePage);
		
		log.info("Order_05 - Step 59: Verify 'Order Number' is displayed");
		Assert.assertEquals(orderInfomationPage.isOrderNumberDisplayed(), orderNumberInHomePage);
		
		log.info("Order_05 - Step 60: Verify 'Order Date' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-date"));
		
		log.info("Order_05 - Step 61: Verify 'Order Status' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-status"));
		
		log.info("Order_05 - Step 62: Verify 'Order Total' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-total"));
		
		log.info("Order_05 - Step 63: Verify 'Name' in 'Billing Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("billing-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_05 - Step 64: Verify 'Email' in 'Billing Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_05 - Step 65: Verify 'Phone' in 'Billing Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_05 - Step 66: Verify 'Address' in 'Billing Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.ADDRESS_1));

		log.info("Order_05 - Step 67: Verify 'City Stale Zip' in 'Billing Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_05 - Step 68: Verify 'Country' in 'Billing Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_05 - Step 69: Verify 'Payment Method' in 'Billing Address' is 'Check / Money Order'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method", "Check / Money Order"));
		
		log.info("Order_05 - Step 70: Verify 'Payment Statuc' in 'Billing Address' is 'Pending'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method-status", "Pending"));
		
		log.info("Order_05 - Step 71: Verify 'Name' in 'Shipping Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_05 - Step 72: Verify 'Email' in 'Shipping Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_05 - Step 73: Verify 'Phone' in 'Shipping Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_05 - Step 74: Verify 'Address' in 'Shipping Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.ADDRESS_1));

		log.info("Order_05 - Step 75: Verify 'City Stale Zip' in 'Shipping Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_05 - Step 76: Verify 'Country' in 'Shipping Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_05 - Step 77: Verify 'Shipping Method' in 'Shipping Address' is '2nd Day Air'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("shipping-method", "2nd Day Air"));
		
		log.info("Order_05 - Step 78: Verify 'Shipping Status' in 'Shipping Address' is displayed");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("shipping-status", "Not yet shipped"));
		
		log.info("Order_05 - Step 79: Verify 'SKU' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "AP_MBP_13"));
		
		log.info("Order_05 - Step 80: Verify 'Product name' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Name", "Apple MacBook Pro 13-inch"));
		
		log.info("Order_05 - Step 81: Verify 'Price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$1,800.00"));
		
		log.info("Order_05 - Step 82: Verify 'Quantity' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Quantity", "2"));
		
		log.info("Order_05 - Step 83: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$3,600.00"));
		
		log.info("Order_05 - Step 84: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$3,600.00"));
		
		log.info("Order_05 - Step 85: Verify 'Shipping price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_05 - Step 86: Verify 'Tax price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_05 - Step 87: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Order Total:", "2", "$3,600.00"));
	}

	@Test
	public void Order_06_Checkout_Order_Pay_By_Card() {
		log.info("Order_06 - Step 01: Navigate to Home page");
		homePage = orderInfomationPage.navigateToHomePage();
		
		log.info("Order_06 - Step 02: Select 'HP Spectre XT Pro UltraBook'");
		productInfoPage = homePage.selectProductByProductName("Computers ", "Notebooks ", "HP Spectre XT Pro UltraBook");
		
		log.info("Order_06 - Step 03: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();

		log.info("Order_06 - Step 04: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_06 - Step 05: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();

		log.info("Order_06 - Step 06: Click to 'Estimate shipping'");
		shoppingCartPage.clickToEstimateShipping();

		log.info("Order_06 - Step 07: Verify Shipping Popup is displayed");
		Assert.assertTrue(shoppingCartPage.isShippingPopupDisplayed());

		log.info("Order_06 - Step 08: Select 'Viet Nam' in Shipping Popup dropdown");
		shoppingCartPage.selectItemInShippingPopupDropdown("Viet Nam");

		log.info("Order_06 - Step 09: Enter to 'Zip/ postal code' textbox");
		shoppingCartPage.enterToZipPostCode("550000");

		log.info("Order_06 - Step 10: Check to 'Ground' radio");
		shoppingCartPage.checkToRadionButtonByName("Ground");

		log.info("Order_06 - Step 11: Click to Apply button");
		shoppingCartPage.clickToApplyButton();

		log.info("Order_06 - Step 12: Verify Shipping Popup is not displayed");
		Assert.assertTrue(shoppingCartPage.isShippingPopupNotDisplayed());

		log.info("Order_06 - Step 13: Check to 'Term of service' checkbox");
		shoppingCartPage.checkToTermOfServiceCheckbox();

		log.info("Order_06 - Step 14: Click to 'Checkout' button");
		billingAddressPage = shoppingCartPage.clickToCheckoutButton();
		
		log.info("Order_06 - Step 15: Click to 'Continue' button");
		checkoutPage = billingAddressPage.clickToContinueButton();
		
		log.info("Order_06 - Step 16: Check to 'Ground ($0.00)' radio button");
		checkoutPage.checkToRadioButtonByName("Ground ($0.00)");
		
		log.info("Order_06 - Step 17: Click to 'Continue' button");
		paymentMethodPage = checkoutPage.clickToContinueButton();
		
		log.info("Order_06 - Step 18: Check to 'Credit Card' radio button");
		paymentMethodPage.checkToRadioButtonByName("Credit Card");
		
		log.info("Order_06 - Step 19: Click to 'Continue' button");
		paymentInformationPage = paymentMethodPage.clickToContinueButton();
		
		log.info("Order_06 - Step 20: Select 'Master card' in 'Select credit card' dropdown");
		paymentInformationPage.selectItemByDropdownID("CreditCardType", "Master card");
		
		log.info("Order_06 - Step 21: Enter to 'Cardholder name' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardholderName", "MASTERCARD");
		
		log.info("Order_06 - Step 22: Enter to 'Card number' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardNumber", "5207797735209125");
		
		log.info("Order_06 - Step 23: Select 'Date' in 'Expiration date' dropdown");
		paymentInformationPage.selectItemByDropdownID("ExpireMonth", "04");
		
		log.info("Order_06 - Step 24: Select 'Year' in 'Expiration date' dropdown");
		paymentInformationPage.selectItemByDropdownID("ExpireYear", "2023");
		
		log.info("Order_06 - Step 21: Enter to 'Card code' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardCode", "779");

		log.info("Order_06 - Step 22: Click to 'Continue' button");
		confirmOrderPage = paymentInformationPage.clickToContinueButton();
		
		log.info("Order_06 - Step 23: Verify 'Name' in 'Billing Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("billing-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_06 - Step 24: Verify 'Email' in 'Billing Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_06 - Step 25: Verify 'Phone' in 'Billing Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_06 - Step 26: Verify 'Address' in 'Billing Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.ADDRESS_1));

		log.info("Order_06 - Step 27: Verify 'City Stale Zip' in 'Billing Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_06 - Step 28: Verify 'Country' in 'Billing Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_06 - Step 29: Verify 'Payment' in 'Billing Address' is 'Credit Card'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("payment-method", "Credit Card"));
		
		log.info("Order_06 - Step 30: Verify 'Name' in 'Shipping Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_06 - Step 31: Verify 'Email' in 'Shipping Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_06 - Step 32: Verify 'Phone' in 'Shipping Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_06 - Step 33: Verify 'Address' in 'Shipping Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.ADDRESS_1));

		log.info("Order_06 - Step 34: Verify 'City Stale Zip' in 'Shipping Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_06 - Step 35: Verify 'Country' in 'Shipping Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_06 - Step 36: Verify 'Shipping' in 'Shipping Address' is 'Ground'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("shipping-method", "Ground"));
		
		log.info("Order_06 - Step 37: Verify 'SKU' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "HP_SPX_UB"));
		
		log.info("Order_06 - Step 38: Verify 'Product name' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Product(s)", "HP Spectre XT Pro UltraBook"));
		
		log.info("Order_06 - Step 39: Verify 'Price' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$1,350.00"));
		
		log.info("Order_06 - Step 40: Verify 'Qty.' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Qty.", "1"));
		
		log.info("Order_06 - Step 41: Verify 'Total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$1,350.00"));
		
		log.info("Order_06 - Step 42: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$1,350.00"));
		
		log.info("Order_06 - Step 43: Verify 'Shipping price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_06 - Step 44: Verify 'Tax price' is displayed");
		Assert.assertTrue(confirmOrderPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_06 - Step 45: Verify 'Total price' is displayed");
		Assert.assertTrue(confirmOrderPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Total:", "2", "$1,350.00"));
		
		log.info("Order_06 - Step 47: Click to 'Confirm' button");
		confirmOrderPage.clickToConfirmButton();
		
		log.info("Order_06 - Step 48: Verify success message and order number is displayed");
		Assert.assertTrue(confirmOrderPage.isSuccessMessagePageTitleDisplayed());
		Assert.assertTrue(confirmOrderPage.isSuccessMessageTitleDisplayed());
		Assert.assertTrue(confirmOrderPage.isOrderNumberDisplayed());
		String orderNumberInHomePage = confirmOrderPage.getOrderNumberInHomePage();
		
		log.info("Order_06 - Step 49: Navigate to 'My Account' page");
		myAccountPage = confirmOrderPage.clickToMyAccountLink();
		
		log.info("Order_06 - Step 50: Click to 'Orders' link in menu");
		ordersPage = myAccountPage.clickToOrdersLink();
		
		log.info("Order_06 - Step 51: Verify order number is displayed");
		Assert.assertEquals(ordersPage.isOrderNumberDisplayed(), orderNumberInHomePage);
		
		log.info("Order_06 - Step 52: Click to 'Details' button");
		orderInfomationPage = ordersPage.clickToDetailsButton(orderNumberInHomePage);
		
		log.info("Order_06 - Step 53: Verify 'Order Number' is displayed");
		Assert.assertEquals(orderInfomationPage.isOrderNumberDisplayed(), orderNumberInHomePage);
		
		log.info("Order_06 - Step 54: Verify 'Order Date' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-date"));
		
		log.info("Order_06 - Step 55: Verify 'Order Status' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-status"));
		
		log.info("Order_06 - Step 56: Verify 'Order Total' is displayed");
		Assert.assertTrue(orderInfomationPage.isOrderInfoDisplayedByID("order-total"));
		
		log.info("Order_06 - Step 57: Verify 'Name' in 'Billing Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("billing-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_06 - Step 58: Verify 'Email' in 'Billing Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_06 - Step 59: Verify 'Phone' in 'Billing Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_06 - Step 60: Verify 'Address' in 'Billing Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.ADDRESS_1));

		log.info("Order_06 - Step 61: Verify 'City Stale Zip' in 'Billing Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_06 - Step 62: Verify 'Country' in 'Billing Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_06 - Step 63: Verify 'Payment Method' in 'Billing Address' is 'Credit Card '");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method", "Credit Card "));
		
		log.info("Order_06 - Step 64: Verify 'Payment Statuc' in 'Billing Address' is 'Pending'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method-status", "Pending"));
		
		log.info("Order_06 - Step 65: Verify 'Name' in 'Shipping Address' is '" + UserData.Order.FIRST_NAME + " "
				+ UserData.Order.LAST_NAME + "'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info",
				UserData.Order.FIRST_NAME + " " + UserData.Order.LAST_NAME));

		log.info("Order_06 - Step 66: Verify 'Email' in 'Shipping Address' is '" + UserData.Order.EMAIL_ADDRESS + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.EMAIL_ADDRESS));

		log.info("Order_06 - Step 67: Verify 'Phone' in 'Shipping Address' is '" + UserData.Order.PHONE_NUMBER + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.PHONE_NUMBER));

		log.info("Order_06 - Step 68: Verify 'Address' in 'Shipping Address' is '" + UserData.Order.ADDRESS_1 + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.ADDRESS_1));

		log.info("Order_06 - Step 69: Verify 'City Stale Zip' in 'Shipping Address' is '" + UserData.Order.CITY_NAME
				+ "," + UserData.Order.ZIP_POSTAL_CODE + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.CITY_NAME
						+ "," + UserData.Order.ZIP_POSTAL_CODE));
		
		log.info("Order_06 - Step 70: Verify 'Country' in 'Shipping Address' is '" + UserData.Order.COUNTRY_NAME + "'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("shipping-info", UserData.Order.COUNTRY_NAME));
		
		log.info("Order_06 - Step 71: Verify 'Shipping Method' in 'Shipping Address' is 'Ground '");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("shipping-method", "Ground "));
		
		log.info("Order_06 - Step 72: Verify 'Shipping Status' in 'Shipping Address' is displayed");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("shipping-status", "Not yet shipped"));
		
		log.info("Order_06 - Step 72: Verify 'SKU' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "HP_SPX_UB"));
		
		log.info("Order_06 - Step 73: Verify 'Product name' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Name", "HP Spectre XT Pro UltraBook"));
		
		log.info("Order_06 - Step 74: Verify 'Price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$1,350.00"));
		
		log.info("Order_06 - Step 75: Verify 'Quantity' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Quantity", "1"));
		
		log.info("Order_06 - Step 76: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$1,350.00"));
		
		log.info("Order_06 - Step 77: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$1,350.00"));
		
		log.info("Order_06 - Step 78: Verify 'Shipping price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_06 - Step 79: Verify 'Tax price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_06 - Step 80: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Order Total:", "2", "$1,350.00"));
		
	}

	@Test
	public void Order_07_ReOrder() {
		log.info("Order_07 - Step 01: Navigate to Home page");
		homePage = orderInfomationPage.navigateToHomePage();
		
		log.info("Order_07 - Step 02: Select 'Lenovo IdeaCentre 600 All-in-One PC'");
		productInfoPage = homePage.selectProductByProductName("Computers ", "Desktops ", "Lenovo IdeaCentre 600 All-in-One PC");
		
		log.info("Order_07 - Step 03: Click to 'Add to cart' button");
		productInfoPage.clickToAddToCartButton();
		
		log.info("Order_07 - Step 04: Close product added to shopping cart message");
		productInfoPage.closeProductAddedToShoppingCartMessage();

		log.info("Order_07 - Step 05: Click to 'Shopping cart' link");
		shoppingCartPage = productInfoPage.clickToShoppingCartLink();
		
		log.info("Order_07 - Step 06: Click to 'Estimate shipping'");
		shoppingCartPage.clickToEstimateShipping();
		
		log.info("Order_07 - Step 07: Select 'Viet Nam' in Shipping Popup dropdown");
		shoppingCartPage.selectItemInShippingPopupDropdown("Viet Nam");

		log.info("Order_07 - Step 08: Enter to 'Zip/ postal code' textbox");
		shoppingCartPage.enterToZipPostCode("222111");

		log.info("Order_07 - Step 09: Check to 'Ground' radio");
		shoppingCartPage.checkToRadionButtonByName("Ground");
		
		log.info("Order_07 - Step 10: Click to 'Apply' button");
		shoppingCartPage.clickToApplyButton();
		
		log.info("Order_07 - Step 11: Check to 'Term of service' checkbox");
		shoppingCartPage.checkToTermOfServiceCheckbox();
		
		log.info("Order_07 - Step 12: Click to 'Checkout' button");
		billingAddressPage = shoppingCartPage.clickToCheckoutButton();
		
		log.info("Order_07 - Step 13: Click to 'Continue' button");
		checkoutPage = billingAddressPage.clickToContinueButton();
		
		log.info("Order_07 - Step 14: Check to 'Ground ($0.00)' radio button");
		checkoutPage.checkToRadioButtonByName("Ground ($0.00)");
		
		log.info("Order_07 - Step 15: Click to 'Continue' button");
		paymentMethodPage = checkoutPage.clickToContinueButton();
		
		log.info("Order_07 - Step 16: Check to 'Credit Card' radio button");
		paymentMethodPage.checkToRadioButtonByName("Credit Card");
		
		log.info("Order_07 - Step 17: Click to 'Continue' button");
		paymentInformationPage = paymentMethodPage.clickToContinueButton();
		
		log.info("Order_07 - Step 18: Select 'Master card' in 'Select credit card' dropdown");
		paymentInformationPage.selectItemByDropdownID("CreditCardType", "Master card");
		
		log.info("Order_07 - Step 19: Enter to 'Cardholder name' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardholderName", "MASTERCARD");
		
		log.info("Order_07 - Step 20: Enter to 'Card number' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardNumber", "5207797735209125");
		
		log.info("Order_07 - Step 21: Select 'Date' in 'Expiration date' dropdown");
		paymentInformationPage.selectItemByDropdownID("ExpireMonth", "04");
		
		log.info("Order_07 - Step 22: Select 'Year' in 'Expiration date' dropdown");
		paymentInformationPage.selectItemByDropdownID("ExpireYear", "2023");
		
		log.info("Order_07 - Step 23: Enter to 'Card code' name textbox");
		paymentInformationPage.enterToTextboxByTextboxID("CardCode", "779");
		
		log.info("Order_07 - Step 24: Click to 'Continue' button");
		confirmOrderPage = paymentInformationPage.clickToContinueButton();
		
		log.info("Order_07 - Step 25: Click to 'Confirm' button");
		confirmOrderPage.clickToConfirmButton();
		
		log.info("Order_07 - Step 26: Get Order Number");
		String orderNumberInHomePage = confirmOrderPage.getOrderNumberInHomePage();
		
		log.info("Order_07 - Step 27: Click to 'My Account' link");
		myAccountPage = orderInfomationPage.clickToMyAccount();
		
		log.info("Order_07 - Step 28: Click to 'Orders' link");
		ordersPage = myAccountPage.clickToOrdersLink();
		
		log.info("Order_07 - Step 29: Click to 'Detail' button");
		orderInfomationPage = ordersPage.clickToDetailsButton(orderNumberInHomePage);
		
		log.info("Order_07 - Step 30: Click to 'Re-order' button");
		shoppingCartPage = ordersPage.clickToReOrderButton();
		
		log.info("Order_07 - Step 31: Enter to 'Qty.' with value is '10'");
		shoppingCartPage.enterToQtyByRowNumberAndColumnNumber("1", "Qty.", "10");
		
		log.info("Order_07 - Step 32: Click to 'Update shopping cart' button");
		shoppingCartPage.clickToUpdateShoppingCartButton();
		
		log.info("Order_07 - Step 33: Check to 'Term of service' checkbox");
		shoppingCartPage.checkToTermOfServiceCheckbox();
		
		log.info("Order_07 - Step 34: Click to 'Checkout' button");
		billingAddressPage = shoppingCartPage.clickToCheckoutButton();
		
		log.info("Order_07 - Step 35: Click to 'Edit' button");
		billingAddressPage.clickToEditButton();
		
		log.info("Order_07 - Step 36: Select 'New Address' in 'Billing address' dropdown");
		billingAddressPage.selectItemByDropdownIDAndTextItem("billing-address-select", "New Address");
		
		log.info("Order_07 - Step 37: Enter to 'Firstname' textbox with value 'Automation'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_FirstName", "Automation");
		
		log.info("Order_07 - Step 38: Enter to 'Lastname' textbox with value 'FC'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_LastName", "FC");
		
		log.info("Order_07 - Step 39: Enter to 'Email' textbox with value 'automationfc95@gmail.com'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_Email", "automationfc95@gmail.com");
		
		log.info("Order_07 - Step 40: Enter to 'Country' textbox with value 'Viet Nam'");
		billingAddressPage.selectItemByDropdownIDAndTextItem("BillingNewAddress_CountryId", "Viet Nam");
		
		log.info("Order_07 - Step 41: Enter to 'City' textbox with value 'Long An'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_City", "Long An Provice");
		
		log.info("Order_07 - Step 42: Enter to 'Address 1' textbox with value 'FC'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_Address1", "Ben Luc Town");
		
		log.info("Order_07 - Step 43: Enter to 'Zip / postal code' textbox with value '55550000'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_ZipPostalCode", "55550000");
		
		log.info("Order_07 - Step 44: Enter to 'Phone number' textbox with value '0909222111'");
		billingAddressPage.enterToTextboxByTextboxID("BillingNewAddress_PhoneNumber", "0909222111");
		
		log.info("Order_07 - Step 45: Click to 'Continue' button");
		checkoutPage = billingAddressPage.clickToContinueButton();
		
		log.info("Order_07 - Step 46: Check to 'Next Day Air ($0.00)' radio button");
		checkoutPage.checkToRadioButtonByName("Next Day Air ($0.00)");
		
		log.info("Order_07 - Step 47: Click to 'Continue' button");
		paymentMethodPage = checkoutPage.clickToContinueButton();
		
		log.info("Order_07 - Step 48: Check to 'Check / Money Order' radio button");
		paymentMethodPage.checkToRadioButtonByName("Check / Money Order");
		
		log.info("Order_07 - Step 49: Click to 'Continue' button");
		paymentInformationPage = paymentMethodPage.clickToContinueButton();
		
		log.info("Order_07 - Step 50: Click to 'Continue' button");
		confirmOrderPage = paymentInformationPage.clickToContinueButton();
		
		log.info("Order_07 - Step 51: Verify 'Name' in 'Billing Address' is 'Automation FC'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("billing-info","Automation FC"));

		log.info("Order_07 - Step 52: Verify 'Email' in 'Billing Address' is 'automationfc95@gmail.com'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", "automationfc95@gmail.com"));

		log.info("Order_07 - Step 53: Verify 'Phone' in 'Billing Address' is '0909222111'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", "0909222111"));

		log.info("Order_07 - Step 54: Verify 'Address' in 'Billing Address' is 'Ben Luc Town'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", "Ben Luc Town"));

		log.info("Order_07 - Step 55: Verify 'City Stale Zip' in 'Billing Address' is 'Long An Provice'" + "," + "55550000");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", "Long An Provice" + "," + "55550000"));
		
		log.info("Order_07 - Step 56: Verify 'Country' in 'Billing Address' is 'Viet Name'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("billing-info", "Viet Nam"));
		
		log.info("Order_07 - Step 57: Verify 'Payment' in 'Billing Address' is 'Check / Money Order'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("payment-method", "Check / Money Order"));
		
		log.info("Order_07 - Step 58: Verify 'Name' in 'Shipping Address' is 'Automation FC'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Automation FC"));

		log.info("Order_07 - Step 59: Verify 'Email' in 'Shipping Address' is 'automationfc95@gmail.com'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "automationfc95@gmail.com"));

		log.info("Order_07 - Step 60: Verify 'Phone' in 'Shipping Address' is '0909222111'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "0909222111"));

		log.info("Order_07 - Step 61: Verify 'Address' in 'Shipping Address' is 'Ben Luc Town'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Ben Luc Town"));

		log.info("Order_07 - Step 62: Verify 'City Stale Zip' in 'Shipping Address' is 'Long An Provice'" + "," + "55550000");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Long An Provice" + "," + "55550000"));
		
		log.info("Order_07 - Step 63: Verify 'Country' in 'Shipping Address' is 'Viet Nam'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Viet Nam"));
		
		log.info("Order_07 - Step 64: Verify 'Shipping' in 'Shipping Address' is 'Next Day Air '");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("shipping-method", "Next Day Air"));
		
		log.info("Order_07 - Step 65: Verify 'SKU' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "LE_IC_600"));
		
		log.info("Order_07 - Step 66: Verify 'Product name' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Product(s)", "Lenovo IdeaCentre 600 All-in-One PC"));
		
		log.info("Order_07 - Step 67: Verify 'Price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$500.00"));
		
		log.info("Order_07 - Step 68: Verify 'Quantity' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Qty.", "10"));
		
		log.info("Order_07 - Step 69: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$5,000.00"));
		
		log.info("Order_07 - Step 70: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$5,000.00"));
		
		log.info("Order_07 - Step 71: Verify 'Shipping price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_07 - Step 72: Verify 'Tax price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_07 - Step 73: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Total:", "2", "$5,000.00"));	
		
		log.info("Order_07 - Step 74: Click to 'Confirm' button");
		orderInfomationPage.clickToConfirmButton();
		
		log.info("Order_07 - Step 75: Get Order Number");
		String orderNumberInHomePageBefore = confirmOrderPage.getOrderNumberInHomePage();
		
		log.info("Order_07 - Step 76: Click to 'My Account' link");
		myAccountPage = orderInfomationPage.clickToMyAccount();
		
		log.info("Order_07 - Step 77: Click to 'Orders' link");
		ordersPage = myAccountPage.clickToOrdersLink();
		
		log.info("Order_07 - Step 78: Click to 'Detail' button");
		orderInfomationPage = ordersPage.clickToDetailsButton(orderNumberInHomePageBefore);
		
		log.info("Order_07 - Step 79: Verify 'Name' in 'Billing Address' is 'Automation FC'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "Automation FC"));

		log.info("Order_07 - Step 80: Verify 'Email' in 'Billing Address' is 'automationfc95@gmail.com'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "automationfc95@gmail.com"));

		log.info("Order_07 - Step 81: Verify 'Phone' in 'Billing Address' is '0909222111'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "0909222111"));

		log.info("Order_07 - Step 82: Verify 'Address' in 'Billing Address' is 'Ben Luc Town'");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "Ben Luc Town"));

		log.info("Order_07 - Step 83: Verify 'City Stale Zip' in 'Billing Address' is Long An Provice"+ "," + "55550000");
		Assert.assertTrue(orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "Long An Provice"+ "," + "55550000"));
		
		log.info("Order_07 - Step 84: Verify 'Country' in 'Billing Address' is 'Viet Nam'");
		Assert.assertTrue(
				orderInfomationPage.isConfirmOrderInfoDisplay("billing-info", "Viet Nam"));
		
		log.info("Order_07 - Step 85: Verify 'Payment Method' in 'Billing Address' is 'Check / Money Order'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method", "Check / Money Order"));
		
		log.info("Order_07 - Step 86: Verify 'Payment Statuc' in 'Billing Address' is 'Pending'");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("payment-method-status", "Pending"));
		
		log.info("Order_07 - Step 87: Verify 'Name' in 'Shipping Address' is 'Automation FC'");
		Assert.assertTrue(confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Automation FC"));

		log.info("Order_07 - Step 88: Verify 'Email' in 'Shipping Address' is 'automationfc95@gmail.com'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "automationfc95@gmail.com"));

		log.info("Order_07 - Step 89: Verify 'Phone' in 'Shipping Address' is '0909222111'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "0909222111"));

		log.info("Order_07 - Step 90: Verify 'Address' in 'Shipping Address' is 'Ben Luc Town'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Ben Luc Town"));

		log.info("Order_07 - Step 91: Verify 'City Stale Zip' in 'Shipping Address' is 'Long An Provice'" + "," + "55550000");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Long An Provice" + "," + "55550000"));
		
		log.info("Order_07 - Step 92: Verify 'Country' in 'Shipping Address' is 'Viet Nam'");
		Assert.assertTrue(
				confirmOrderPage.isConfirmOrderInfoDisplay("shipping-info", "Viet Nam"));
		
		log.info("Order_07 - Step 93: Verify 'Shipping' in 'Shipping Address' is 'Next Day Air'");
		Assert.assertTrue(confirmOrderPage.isMethodInfoDisplayed("shipping-method", "Next Day Air"));	
		
		log.info("Order_06 - Step 94: Verify 'Shipping Status' in 'Shipping Address' is displayed");
		Assert.assertTrue(orderInfomationPage.isMethodInfoDisplayed("shipping-status", "Not yet shipped"));
		
		log.info("Order_06 - Step 95: Verify 'SKU' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU", "LE_IC_600"));
		
		log.info("Order_06 - Step 96: Verify 'Product name' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductNameDisplayedByRowNumberAndColumnName("1", "Name", "Lenovo IdeaCentre 600 All-in-One PC"));
		
		log.info("Order_06 - Step 97: Verify 'Price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price", "$500.00"));
		
		log.info("Order_06 - Step 98: Verify 'Quantity' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Quantity", "10"));
		
		log.info("Order_06 - Step 99: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Total", "$5,000.00"));
		
		log.info("Order_06 - Step 100: Verify 'Sub-total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Sub-Total:", "2", "$5,000.00"));
		
		log.info("Order_06 - Step 101: Verify 'Shipping price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Shipping:", "2", "$0.00"));
		
		log.info("Order_06 - Step 102: Verify 'Tax price' is displayed");
		Assert.assertTrue(orderInfomationPage.isPriceInfoDisplayedByRowNameAndColumn("Tax:", "2", "$0.00"));
		
		log.info("Order_06 - Step 103: Verify 'Total price' is displayed");
		Assert.assertTrue(orderInfomationPage.isTotalPriceInfoDisplayedByRowNameAndColumn("Order Total:", "2", "$5,000.00"));
		
	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
