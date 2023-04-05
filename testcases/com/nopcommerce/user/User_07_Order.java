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

		log.info("Order_05 - Step 02: Select 'Lenovo IdeaCentre 600 All-in-One PC'");
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
		orderInfomationPage = ordersPage.clickToDetailsButton();
		
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
		log.info("Order_06 - Step 01: Verify 'Total price' is displayed");
	}

	//@Test
	public void Order_07_Reorder() {

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}

}
