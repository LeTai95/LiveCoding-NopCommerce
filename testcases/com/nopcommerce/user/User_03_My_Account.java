package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.UserData;

import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.ProductInfoPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;

@Listeners(commons.MethodListener.class)
public class User_03_My_Account extends BaseTest {
	WebDriver driver;
	HomePageObject homePage;
	LoginPageObject loginPage;
	MyAccountPageObject myAccountPage;
	AddressesPageObject addressesPage;
	ChangePasswordPageObject changePasswordPage;
	ProductInfoPageObject productInfoPage;
	ProductReviewPageObject productReviewPage;
	MyProductReviewsPageObject myProductReviewsPage;
	RegisterPageObject registerPage;
	private String validEmail, reviewTitle;

	@Parameters({ "browser", "enviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		validEmail = UserData.MyAccount.VALID_EMAIL + getRandomNumberByDateTime() + "@gmail.com";
		reviewTitle = "This is my review" + getRandomNumberByDateTime();

		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName, enviromentName);
		homePage = PageGeneraterManager.getHomePage(driver);

		log.info("Pre-Condition - Step 02: Click to 'Register' link");
		registerPage = homePage.clickToRegisterLink();

		log.info("Pre-Condition - Step 03: Enter to Firstname textbox with value '"
				+ UserData.MyAccount.FIRST_NAME_REGISTER_PAGE + "'");
		registerPage.enterToFirstnameTextbox(UserData.MyAccount.FIRST_NAME_REGISTER_PAGE);

		log.info("Pre-Condition - Step 04: Enter to Lastname textbox with value '"
				+ UserData.MyAccount.LAST_NAME_REGISTER_PAGE + "'");
		registerPage.enterToLastnameTextbox(UserData.MyAccount.LAST_NAME_REGISTER_PAGE);

		log.info("Pre-Condition - Step 05: Enter to Email textbox with value '" + validEmail + "'");
		registerPage.enterToEmailTextbox(validEmail);

		log.info("Pre-Condition - Step 06: Enter to Password textbox with value '" + UserData.MyAccount.PASSWORD + "'");
		registerPage.enterToPasswordTextbox(UserData.MyAccount.PASSWORD);

		log.info("Pre-Condition - Step 07: Enter to Confirm Password textbox with value '" + UserData.MyAccount.PASSWORD
				+ "'");
		registerPage.enterToConfirmPasswordTextbox(UserData.MyAccount.PASSWORD);

		log.info("Pre-Condition - Step 08: Click to 'Register' button");
		registerPage.clickToRegisterButton();

		log.info("Pre-Condition- Step 09: Navigate to 'Login' page");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition - Step 10: Enter to  Email textbox with value '" + validEmail + "' ");
		loginPage.enterToEmailTextbox(validEmail);

		log.info(
				"Pre-Condition - Step 11: Enter to  Password textbox with value '" + UserData.MyAccount.PASSWORD + "'");
		loginPage.enterToPasswordTextbox(UserData.MyAccount.PASSWORD);

		log.info("Pre-Condition - Step 12: Click to 'Login' button ");
		homePage = loginPage.clickToLoginButton();

	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("My_Account_01- Step 01: Click to 'My Account' link");
		myAccountPage = homePage.clickToMyAccountLink();

		log.info("My_Account_01- Step 02: Check to 'Female' radio");
		myAccountPage.checkToCheckBoxByName("female");

		log.info("My_Account_01- Step 03: Enter to Firstname textbox with value '"
				+ UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE + "'");
		myAccountPage.enterToTextboxByID("FirstName", UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_01- Step 04: Check to Lastname textbox with value '"
				+ UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE + "'");
		myAccountPage.enterToTextboxByID("LastName", UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_01- Step 05: Select day from 'DateOfBirthDay' dropdown with value '"
				+ UserData.MyAccount.DAY + "'");
		myAccountPage.selectItemByName("DateOfBirthDay", UserData.MyAccount.DAY);

		log.info("My_Account_01- Step 06: Select month from 'DateOfBirthMonth' dropdown with value '"
				+ UserData.MyAccount.MONTH + "'");
		myAccountPage.selectItemByName("DateOfBirthMonth", UserData.MyAccount.MONTH);

		log.info("My_Account_01- Step 07: Select year from 'DateOfBirthYear' dropdown with value '"
				+ UserData.MyAccount.YEAR + "'");
		myAccountPage.selectItemByName("DateOfBirthYear", UserData.MyAccount.YEAR);

		log.info("My_Account_01- Step 08: Enter to Company name textbox with value '" + UserData.MyAccount.COMPANY_NAME
				+ "'");
		myAccountPage.enterToTextboxByID("Company", UserData.MyAccount.COMPANY_NAME);

		log.info("My_Account_01- Step 09: Click to 'Save' button");
		myAccountPage.clickToSaveButton();

		log.info("My_Account_01- Step 10: Verify Female radio is checked");
		Assert.assertTrue(myAccountPage.isFemaleRadioIsChecked("female"));

		log.info("My_Account_01- Step 11: Verify Firstname textbox is equals '"
				+ UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE + "'");
		Assert.assertEquals(myAccountPage.getFirstnameValue("FirstName"),
				UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_01- Step 12: Verify Lastname textbox is equals '"
				+ UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE + "'");
		Assert.assertEquals(myAccountPage.getLastnameValue("LastName"), UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_01- Step 13: Verify Company name textbox is equals '" + UserData.MyAccount.COMPANY_NAME
				+ "'");
		Assert.assertEquals(myAccountPage.getCompanyNameValue("Company"), UserData.MyAccount.COMPANY_NAME);

		log.info("My_Account_01- Step 14: Verify '" + UserData.MyAccount.DAY + "' is selected");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthDay", UserData.MyAccount.DAY),
				UserData.MyAccount.DAY);

		log.info("My_Account_01- Step 15: Verify '" + UserData.MyAccount.MONTH + "' is selected");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthMonth", UserData.MyAccount.MONTH),
				UserData.MyAccount.MONTH);

		log.info("My_Account_01- Step 16: Verify '" + UserData.MyAccount.YEAR + "' is selected");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthYear", UserData.MyAccount.YEAR),
				UserData.MyAccount.YEAR);
	}

	@Test
	public void My_Account_02_Address() {
		log.info("My_Account_02- Step 01: Click to 'Address' menu");
		addressesPage = myAccountPage.navigateToAddressPage();

		log.info("My_Account_02- Step 02: Click to 'Add new' button");
		addressesPage.clickToAddNewButton();

		log.info("My_Account_02- Step 03: Enter to Firstname textbox with value '" + UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE + "'");
		addressesPage.enterToTextboxByName("Address_FirstName", UserData.MyAccount.FIRST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_02- Step 04: Enter to Lastname textbox with value '" + UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE + "'");
		addressesPage.enterToTextboxByName("Address_LastName", UserData.MyAccount.LAST_NAME_MY_ACCOUNT_PAGE);

		log.info("My_Account_02- Step 05: Enter to Email textbox with value '" + UserData.MyAccount.EMAIL_ADDRESS_PAGE + "'");
		addressesPage.enterToTextboxByName("Address_Email", UserData.MyAccount.EMAIL_ADDRESS_PAGE);

		log.info("My_Account_02- Step 06: Enter to Company textbox with value '" + UserData.MyAccount.COMPANY_NAME + "'");
		addressesPage.enterToTextboxByName("Address_Company", UserData.MyAccount.COMPANY_NAME);

		log.info("My_Account_02- Step 07: Select '" + UserData.MyAccount.COUNTRY + "' from Country dropdown");
		addressesPage.setlectItemByID("Address_CountryId", UserData.MyAccount.COUNTRY);

		log.info("My_Account_02- Step 08: Select '" + UserData.MyAccount.COUNTRY + "' from State / province dropdown");
		addressesPage.setlectItemByID("Address_StateProvinceId", UserData.MyAccount.STATE);

		log.info("My_Account_02- Step 09: Enter to City textbox with value '" + UserData.MyAccount.CITY_NAME + "'");
		addressesPage.enterToTextboxByName("Address_City", UserData.MyAccount.CITY_NAME);

		log.info("My_Account_02- Step 10: Enter to Address 1 textbox with value '" + UserData.MyAccount.ADDRESS_1 + "'");
		addressesPage.enterToTextboxByName("Address_Address1", UserData.MyAccount.ADDRESS_1);

		log.info("My_Account_02- Step 11: Enter to Address 2 textbox with value '" + UserData.MyAccount.ADDRESS_2 + "'");
		addressesPage.enterToTextboxByName("Address_Address2", UserData.MyAccount.ADDRESS_2);

		log.info("My_Account_02- Step 12: Enter to Zip / postal code textbox with value '" + UserData.MyAccount.ZIP_PORTAL_CODE + "'");
		addressesPage.enterToTextboxByName("Address_ZipPostalCode", UserData.MyAccount.ZIP_PORTAL_CODE);

		log.info("My_Account_02- Step 13: Enter to Phone number textbox with value '" + UserData.MyAccount.PHONE_NUMBER + "'");
		addressesPage.enterToTextboxByName("Address_PhoneNumber", UserData.MyAccount.PHONE_NUMBER);

		log.info("My_Account_02- Step 14: Enter to fax number textbox with value '" + UserData.MyAccount.FAX_NUMBER + "'");
		addressesPage.enterToTextboxByName("Address_FaxNumber", UserData.MyAccount.FAX_NUMBER);

		log.info("My_Account_02- Step 15: Click to 'Save' button");
		addressesPage.clickToSaveButton();

		log.info("My_Account_02- Step 16: Verify address added successfully");
		Assert.assertTrue(addressesPage.isAddedAddressesSuccessMessageDisplayed());

	}

	@Test
	public void My_Account_03_Change_Password() {
		log.info("My_Account_03 - Step 01: Navigate to 'Change Password' link");
		changePasswordPage = addressesPage.navigateToChangePasswordPage();

		log.info("My_Account_03 - Step 02: Enter to Old Password textbox with value '" + UserData.MyAccount.PASSWORD + "'");
		changePasswordPage.enterToTextboxByID("OldPassword", UserData.MyAccount.PASSWORD);

		log.info("My_Account_03 - Step 03: Enter to New Password textbox with value '" + UserData.MyAccount.NEW_PASSWORD + "'");
		changePasswordPage.enterToTextboxByID("NewPassword", UserData.MyAccount.NEW_PASSWORD);

		log.info("My_Account_03 - Step 04: Enter to Confirm Password textbox with value '" + UserData.MyAccount.NEW_PASSWORD + "'");
		changePasswordPage.enterToTextboxByID("ConfirmNewPassword", UserData.MyAccount.NEW_PASSWORD);

		log.info("My_Account_03 - Step 05: Click to 'Change Password' button");
		changePasswordPage.clickToChangePasswordButton();

		log.info("My_Account_03 - Step 06: Verify changed password successfully");
		Assert.assertTrue(changePasswordPage.isChangedPasswordSuccessfullyDisplayed());

		log.info("My_Account_03 - Step 07: Close changed password successfully message");
		changePasswordPage.closeChangedPasswordSuccessfullyMessage();

		log.info("My_Account_03 - Step 08: Click to 'Logout' link");
		homePage = changePasswordPage.clickToLogoutLink();

		log.info("My_Account_03 - Step 09: Click to 'Login' link");
		loginPage = homePage.clickToLoginLink();

		log.info("My_Account_03 - Step 10: Enter to Email textbox with value '" + validEmail + "'");
		loginPage.enterToEmailTextbox(validEmail);

		log.info("My_Account_03 - Step 11: Enter to Password textbox with value '000000'");
		loginPage.enterToPasswordTextbox("000000");

		log.info("My_Account_03 - Step 12: Click To 'Login' Button");
		loginPage.clickToLoginButton();

		log.info("My_Account_03 - Step 13: Verify login failed message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());

		log.info("My_Account_03 - Step 14: Enter to Password textbox with value '" + UserData.MyAccount.NEW_PASSWORD + "'");
		loginPage.enterToPasswordTextbox(UserData.MyAccount.NEW_PASSWORD);

		log.info("My_Account_03 - Step 15: Click To 'Login' Button");
		homePage = loginPage.clickToLoginButton();

		log.info("My_Account_03 - Step 16: Verify login successfully");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());

	}

	@Test
	public void My_Account_04_My_Product_Reviews() {
		log.info("My_Account_04 - Step 01: Hover To Computers");
		homePage.hoverToMenuByText("Computers ");

		log.info("My_Account_04 - Step 02: Click to Desktops in Computers menu");
		homePage.clickToItemByText("Desktops ");

		log.info("My_Account_04 - Step 03: Click to Product");
		productInfoPage = homePage.clickToProductByText("Build your own computer");

		log.info("My_Account_04 - Step 04: Click Add your review link");
		productReviewPage = productInfoPage.clickToAddYourReviewLink();

		log.info("My_Account_04 - Step 05: Enter to Review title textbox with value '" + reviewTitle + "'");
		productReviewPage.enterToReviewTitleTextbox(reviewTitle);

		log.info("My_Account_04 - Step 06: Enter to Review text textbox with value '" + UserData.MyAccount.REVIEW_TEXT + "'");
		productReviewPage.enterToReviewtextTextarea(UserData.MyAccount.REVIEW_TEXT);

		log.info("My_Account_04 - Step 07: Click to Rating radio");
		productReviewPage.clickToRadioByNumber(UserData.MyAccount.RATING_NUMBER);

		log.info("My_Account_04 - Step 08: Click to 'Submit' button");
		productReviewPage.clickToSubmitReviewButton();

		log.info("My_Account_04 - Step 09: Click to 'My Account' link");
		myAccountPage = productReviewPage.clickToMyAccountLink();

		log.info("My_Account_04 - Step 10: Navigate 'My Product Review' link");
		myProductReviewsPage = myAccountPage.navigateToMyProductReviewLink();

		log.info("My_Account_04 - Step 11: Verify Review Title is equals '" + reviewTitle + "'");
		Assert.assertEquals(myProductReviewsPage.getReviewTitleText(), reviewTitle);

		log.info("My_Account_04 - Step 12: Verify Review Text is equals '" + UserData.MyAccount.REVIEW_TEXT + "'");
		Assert.assertEquals(myProductReviewsPage.getReviewText(), UserData.MyAccount.REVIEW_TEXT);

		log.info("My_Account_04 - Step 13: Verify Rating value");
		Assert.assertEquals(myProductReviewsPage.getRatingValue(), "width: 80%;");

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
