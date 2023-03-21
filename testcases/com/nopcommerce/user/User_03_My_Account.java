package com.nopcommerce.user;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import commons.BaseTest;
import commons.PageGeneraterManager;
import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.ProductInfoPageObject;
import pageObjects.ProductReviewPageObject;

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
	String firstName, lastName, companyName, day, month, year, email, password, Email, country, state, address1,
			address2, phoneNumber, faxNumber, cityName, zipPostalCode, newPassword, reviewTitle, reviewText;

	@Parameters({ "browser", "enviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		log.info("Pre-Condition- Step 01: Open browser and navigate to website");
		driver = getBrowserDriver(browserName, enviromentName);
		homePage = PageGeneraterManager.getHomePage(driver);
		firstName = "Automation";
		lastName = "FC";
		companyName = "Automation FC";
		Email = "automationfc.vn@gmail.com";
		country = "Viet Nam";
		state = "Other";
		zipPostalCode = "550000";
		cityName = "Da Nang";
		phoneNumber = "0123456789";
		faxNumber = "0987654321";
		address1 = "123/04 Le Lai";
		address2 = "234/05 Hai Phong";
		day = "1";
		month = "January";
		year = "1999";
		newPassword = "654321";
		reviewTitle = "This is my review";
		reviewText = "This product is great !!!";
		email = User_01_Register.validEmail;
		password = User_01_Register.password;

		log.info("Pre-Condition- Step 02: Click to Login link");
		loginPage = homePage.clickToLoginLink();

		log.info("Pre-Condition- Step 02: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);

		log.info("Pre-Condition- Step 02: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(password);

		log.info("Pre-Condition- Step 02: Click to Login button");
		homePage = loginPage.clickToLoginButton();

		log.info("Pre-Condition- Step 03: Click to My Account link");
		myAccountPage = homePage.clickToMyAccountLink();

	}

	@Test
	public void My_Account_01_Customer_Info() {
		log.info("My_Account_01- Step 01: Check to Female radio");
		myAccountPage.checkToCheckBoxByName("female");

		log.info("My_Account_01- Step 02: Enter to Firstname textbox");
		myAccountPage.enterToTextboxByID("FirstName", firstName);

		log.info("My_Account_01- Step 03: Check to Lastname textbox");
		myAccountPage.enterToTextboxByID("LastName", lastName);

		log.info("My_Account_01- Step 04: Select day from dropdown");
		myAccountPage.selectItemByName("DateOfBirthDay", day);

		log.info("My_Account_01- Step 05: Select month from dropdown");
		myAccountPage.selectItemByName("DateOfBirthMonth", month);

		log.info("My_Account_01- Step 06: Select year from dropdown");
		myAccountPage.selectItemByName("DateOfBirthYear", year);

		log.info("My_Account_01- Step 07: Enter to Company name textbox");
		myAccountPage.enterToTextboxByID("Company", companyName);

		log.info("My_Account_01- Step 08: Click to save button");
		myAccountPage.clickToSaveButton();

		log.info("My_Account_01- Step 09: Verify Female radio is checked");
		Assert.assertTrue(myAccountPage.isFemaleRadioIsChecked("female"));

		log.info("My_Account_01- Step 10: Verify Firstname textbox");
		Assert.assertEquals(myAccountPage.getFirstnameValue("FirstName"), firstName);

		log.info("My_Account_01- Step 11: Verify Lastname textbox");
		Assert.assertEquals(myAccountPage.getLastnameValue("LastName"), lastName);

		log.info("My_Account_01- Step 12: Verify Company name textbox");
		Assert.assertEquals(myAccountPage.getCompanyNameValue("Company"), companyName);

		log.info("My_Account_01- Step 13: Verify DateOfBirth");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthDay", day), day);

		log.info("My_Account_01- Step 14: Verify DateOfMonth");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthMonth", month), month);

		log.info("My_Account_01- Step 15: Verify DateOfYear");
		Assert.assertEquals(myAccountPage.getTextFromDropdownByName("DateOfBirthYear", year), year);
	}

	@Test
	public void My_Account_02_Address() {
		log.info("My_Account_02- Step 01: Click to Address menu");
		addressesPage = myAccountPage.navigateToAddressPage();

		log.info("My_Account_02- Step 02: Click to Add new button");
		addressesPage.clickToAddNewButton();

		log.info("My_Account_02- Step 03: Enter to Firstname textbox");
		addressesPage.enterToTextboxByName("Address_FirstName", firstName);

		log.info("My_Account_02- Step 04: Enter to Lastname textbox");
		addressesPage.enterToTextboxByName("Address_LastName", lastName);

		log.info("My_Account_02- Step 05: Enter to Email textbox");
		addressesPage.enterToTextboxByName("Address_Email", Email);

		log.info("My_Account_02- Step 06: Enter to Company textbox");
		addressesPage.enterToTextboxByName("Address_Company", companyName);

		log.info("My_Account_02- Step 07: Select item from Country dropdown");
		addressesPage.setlectItemByID("Address_CountryId", country);

		log.info("My_Account_02- Step 08: Select item from State / province dropdown");
		addressesPage.setlectItemByID("Address_StateProvinceId", state);
		
		log.info("My_Account_02- Step 09: Enter to City textbox");
		addressesPage.enterToTextboxByName("Address_City", cityName);

		log.info("My_Account_02- Step 10: Enter to Address 1 textbox");
		addressesPage.enterToTextboxByName("Address_Address1", address1);

		log.info("My_Account_02- Step 11: Enter to Address 2 textbox");
		addressesPage.enterToTextboxByName("Address_Address2", address2);

		log.info("My_Account_02- Step 12: Enter to Zip / postal code textbox");
		addressesPage.enterToTextboxByName("Address_ZipPostalCode", zipPostalCode);

		log.info("My_Account_02- Step 13: Enter to Phone number textbox");
		addressesPage.enterToTextboxByName("Address_PhoneNumber", phoneNumber);

		log.info("My_Account_02- Step 15: Enter to fax number textbox");
		addressesPage.enterToTextboxByName("Address_FaxNumber", faxNumber);
		
		log.info("My_Account_02- Step 16: Click to Save button");
		addressesPage.clickToSaveButton();
		
		log.info("My_Account_02- Step 17: Verify address added successfully");
		Assert.assertTrue(addressesPage.isAddedAddressesSuccessMessageDisplayed());

	}

	@Test
	public void My_Account_03_Change_Password() {
		log.info("My_Account_03 - Step 01: Navigate to Change Password link");
		changePasswordPage = addressesPage.navigateToChangePasswordPage();
		
		log.info("My_Account_03 - Step 02: Enter to Old Password textbox");
		changePasswordPage.enterToTextboxByID("OldPassword", password);
		
		log.info("My_Account_03 - Step 03: Enter to New Password textbox");
		changePasswordPage.enterToTextboxByID("NewPassword", newPassword);
		
		log.info("My_Account_03 - Step 04: Enter to Confirm Password textbox");
		changePasswordPage.enterToTextboxByID("ConfirmNewPassword", newPassword);
		
		log.info("My_Account_03 - Step 05: Click to Change Password button");
		changePasswordPage.clickToChangePasswordButton();
		
		log.info("My_Account_03 - Step 06: Verify changed password successfully");
		Assert.assertTrue(changePasswordPage.isChangedPasswordSuccessfullyDisplayed());
		
		log.info("My_Account_03 - Step 07: Close changed password successfully message");
		changePasswordPage.closeChangedPasswordSuccessfullyMessage();
		
		log.info("My_Account_03 - Step 08: Click to Logout link");
		homePage = changePasswordPage.clickToLogoutLink();
		
		log.info("My_Account_03 - Step 09: Click to Login link");
		loginPage = homePage.clickToLoginLink();
		
		log.info("My_Account_03 - Step 10: Enter to Email textbox");
		loginPage.enterToEmailTextbox(email);
		
		log.info("My_Account_03 - Step 11: Enter to Password textbox");
		loginPage.enterToPasswordTextbox("000000");
		
		log.info("My_Account_03 - Step 12: Click To Login Button");
		loginPage.clickToLoginButton();
		
		log.info("My_Account_03 - Step 13: Verify login failed message is displayed");
		Assert.assertTrue(loginPage.isEmptyPasswordErrorMessageDisplayed());
		
		log.info("My_Account_03 - Step 14: Enter to Password textbox");
		loginPage.enterToPasswordTextbox(newPassword);
		
		log.info("My_Account_03 - Step 15: Click To Login Button");
		homePage = loginPage.clickToLoginButton();
		
		log.info("My_Account_03 - Step 16: Verify login successfully");
		Assert.assertTrue(homePage.isMyAccountLinkDisplayed());
		
	
	}
	
	@Test
	public void My_Account_04_My_Product_Reviews() {
		log.info("My_Account_04 - Step 1: Hover To Computers");
		homePage.hoverToMenuByText("Computers ");
		
		log.info("My_Account_04 - Step 2: Click to Desktops in Computers menu");
		homePage.clickToItemByText("Desktops ");
		
		log.info("My_Account_04 - Step 3: Click to Product");
		productInfoPage = homePage.clickToProductByText("Build your own computer");
		
		log.info("My_Account_04 - Step 4: Click Add your review link");
		productReviewPage = productInfoPage.clickToAddYourReviewLink();
		
		log.info("My_Account_04 - Step 5: Enter to Review title textbox");
		productReviewPage.enterToReviewTitleTextbox(reviewTitle);
		
		log.info("My_Account_04 - Step 6: Enter to Review text textbox");
		productReviewPage.enterToReviewtextTextarea(reviewText);
		
		log.info("My_Account_04 - Step 7: Click to Rating radio");
		productReviewPage.clickToRadioByNumber("4");
		
		log.info("My_Account_04 - Step 8: Click to Submit button");
		productReviewPage.clickToSubmitReviewButton();
		
		log.info("My_Account_04 - Step 9: Click to My Account link");
		myAccountPage = productReviewPage.clickToMyAccountLink();
		
		log.info("My_Account_04 - Step 10: Navigate My Product Review link");
		myProductReviewsPage = myAccountPage.navigateToMyProductReviewLink();
		
		log.info("My_Account_04 - Step 11: Verify Review Title");
		Assert.assertEquals(myProductReviewsPage.getReviewTitleText(), reviewTitle);
		
		log.info("My_Account_04 - Step 12: Verify Review Text");
		Assert.assertEquals(myProductReviewsPage.getReviewText(), reviewText);
		
		log.info("My_Account_04 - Step 13: Verify Rating value");
		Assert.assertEquals(myProductReviewsPage.getRatingValue(), "width: 80%;");
		
		
	}
	@AfterClass
	public void afterClass() {
		closeBrowserDriver();
	}
}
