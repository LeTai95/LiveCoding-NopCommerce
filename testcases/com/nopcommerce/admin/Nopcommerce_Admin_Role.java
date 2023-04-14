package com.nopcommerce.admin;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Listeners;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.nopcommerce.data.AdminData;

import adminPageObjects.AdminAddNewAddressPageObject;
import adminPageObjects.AdminCustomerInfoPageObject;
import adminPageObjects.AdminCustomersPageObject;
import adminPageObjects.AdminDashboardPageObject;
import adminPageObjects.AdminEditAddressPageObject;
import adminPageObjects.AdminHomePageObject;
import adminPageObjects.AdminProductInfoPageObject;
import adminPageObjects.AdminProductsPageObject;
import commons.BaseTest;
import commons.PageGeneraterManager;

@Listeners(commons.MethodListener.class)
public class Nopcommerce_Admin_Role extends BaseTest {
	WebDriver driver;
	private String email, editEmail;
	AdminHomePageObject adminHomePage;
	AdminDashboardPageObject adminDashboardPage;
	AdminProductsPageObject adminProductsPage;
	AdminProductInfoPageObject adminProductInfoPage;
	AdminCustomersPageObject adminCustomersPage;
	AdminCustomerInfoPageObject adminCustomerInfoPage;
	AdminAddNewAddressPageObject adminAddNewAddressPage;
	AdminEditAddressPageObject adminEditAddressPage;

	@Parameters({ "browser", "enviroment" })
	@BeforeClass
	public void beforeClass(String browserName, String enviromentName) {
		email = AdminData.CustomerInfo.EMAIL + getRandomNumberByDateTime() + "@gmail.com";
		editEmail = AdminData.CustomerInfo.EDIT_EMAIL + getRandomNumberByDateTime() + "@gmail.com";
		log.info("Pre-Conditon - Step_01: Open browser and login to Admin page");
		driver = getBrowserDriver(browserName, enviromentName);
		adminHomePage = PageGeneraterManager.getAdminHomePage(driver);
		adminDashboardPage = adminHomePage.clickToLoginButton();
	}

	@Test
	public void Admin_01_Search_With_Product_Name() {
		log.info("Admin_01 - Step_01: Click to 'Catalog' menu");
		adminDashboardPage.clickToInCatalogMenu();

		log.info("Admin_01 - Step_02: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_01 - Step_03: Enter to 'Product name' textbox");
		adminProductsPage.enterToTextboxByTextboxID("SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_01 - Step_04: Click to 'Search' button");
		adminProductsPage.clickToSearchButton();

		log.info("Admin_01 - Step_05: Verify 'Product name' is equals 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Product name"),
				"Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_01 - Step_06: Verify 'SKU' is equals 'LE_IC_600'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "SKU"), "LE_IC_600");

		log.info("Admin_01 - Step_07: Verify 'Price' is equals '500'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Price"), "500");

		log.info("Admin_01 - Step_08: Verify 'Stock quantity' is equals '10000'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Stock quantity"),
				"10000");

		log.info("Admin_01 - Step_09: Verify 'Published icon' is displayed");
		Assert.assertTrue(adminProductsPage.isPublishedIconDisplayedByRowNumberAndColumnName("1", "Published"));

	}

	@Test
	public void Admin_02_Search_With_Product_Name_And_Parent_Catelory_And_Unchecked() {
		log.info("Admin_02 - Step_01: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_02 - Step_02: Enter to 'Product name' textbox");
		adminProductsPage.enterToTextboxByTextboxID("SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_02 - Step_03: Select 'Computers' in 'Catagory' dropdown");
		adminProductsPage.selectItemInDropdownByDropdownID("SearchCategoryId", "Computers");

		log.info("Admin_02 - Step_04: Click to 'Search' button");
		adminProductsPage.clickToSearchButton();

		log.info("Admin_02 - Step_05: Verify 'No data available in table' message is displayed");
		Assert.assertTrue(adminProductsPage.isNoDataAvailableDisplayed());

	}

	@Test
	public void Admin_03_Search_With_Product_Name_And_Parent_Catelory_And_Checked() {
		log.info("Admin_03 - Step_01: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_03 - Step_02: Enter to 'Product name' textbox");
		adminProductsPage.enterToTextboxByTextboxID("SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_03 - Step_03: Select 'Computers' in 'Catagory' dropdown");
		adminProductsPage.selectItemInDropdownByDropdownID("SearchCategoryId", "Computers");

		log.info("Admin_03 - Step_04: Check to 'Search subcategories' checkbox");
		adminProductsPage.checkToSearchSubcategoriesCheckbox();

		log.info("Admin_03 - Step_05: Click to 'Search' button");
		adminProductsPage.clickToSearchButton();

		log.info("Admin_03 - Step_06: Verify 'Product name' is equals 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Product name"),
				"Lenovo IdeaCentre 600 All-in-One PC");

	}

	@Test
	public void Admin_04_Search_With_Product_Name_And_Child_Catelory() {
		log.info("Admin_04 - Step_01: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_04 - Step_02: Enter to 'Product name' textbox");
		adminProductsPage.enterToTextboxByTextboxID("SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_04 - Step_03: Select 'Computers >> Desktops' in 'Catagory' dropdown");
		adminProductsPage.selectItemInDropdownByDropdownID("SearchCategoryId", "Computers >> Desktops");

		log.info("Admin_04 - Step_04: Click to 'Search' button");
		adminProductsPage.clickToSearchButton();

		log.info("Admin_04 - Step_05: Verify 'Product name' is equals 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertEquals(adminProductsPage.isProductInfoDisplayedByRowNumberAndColumnName("1", "Product name"),
				"Lenovo IdeaCentre 600 All-in-One PC");

	}

	@Test
	public void Admin_05_Search_With_Product_Name_And_Manufacturer() {
		log.info("Admin_05 - Step_01: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_05 - Step_02: Enter to 'Product name' textbox");
		adminProductsPage.enterToTextboxByTextboxID("SearchProductName", "Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_05 - Step_03: Select 'All' in 'Catagory' dropdown");
		adminProductsPage.selectItemInDropdownByDropdownID("SearchCategoryId", "All");

		log.info("Admin_05 - Step_04: Select 'Apple' in 'Manufacturer' dropdown");
		adminProductsPage.selectItemInDropdownByDropdownID("SearchManufacturerId", "Apple");

		log.info("Admin_05 - Step_05: Click to 'Search' button");
		adminProductsPage.clickToSearchButton();

		log.info("Admin_05 - Step_06: Verify 'No data available in table' message is displayed");
		Assert.assertTrue(adminProductsPage.isNoDataAvailableDisplayed());
	}

	@Test
	public void Admin_06_Go_Directly_To_Product_SKU() {
		log.info("Admin_06 - Step_01: Click to 'Products' in 'Catalog' menu");
		adminProductsPage = adminDashboardPage.clickToProductsPage("Products");

		log.info("Admin_06 - Step_02: Enter to 'Go directly to product SKU' textbox");
		adminProductsPage.enterToTextboxByTextboxID("GoDirectlyToSku", "LE_IC_600");

		log.info("Admin_06 - Step_03: Click to 'Go' button");
		adminProductInfoPage = adminProductsPage.clickToGoButton();

		log.info("Admin_06 - Step_04: Verify 'Product name' is 'Lenovo IdeaCentre 600 All-in-One PC'");
		Assert.assertEquals(adminProductInfoPage.getProductName("Lenovo IdeaCentre 600 All-in-One PC"),
				"Lenovo IdeaCentre 600 All-in-One PC");

		log.info("Admin_06 - Step_05: Switch to 'Product Info Description' iframe");
		adminProductInfoPage.switchToProductInfoDescriptionIframe();

		log.info("Admin_06 - Step_06: Verify 'Lenovo IdeaCentre 600 All-in-One PC' infomation");
		Assert.assertEquals(adminProductInfoPage.getProductInforDescription1(),
				AdminData.ProductInfo.COMPUTERS_LENOVO_FULL_DESCRIPTION_1);
		Assert.assertEquals(adminProductInfoPage.getProductInforDescription2(),
				AdminData.ProductInfo.COMPUTERS_LENOVO_FULL_DESCRIPTION_2);

		log.info("Admin_06 - Step_07: Switch to Default content");
		adminProductInfoPage.swithToDefaultContent();
	}

	@Test
	public void Admin_07_Creat_New_Customer() {
		log.info("Admin_07 - Step_01: Click to 'Customers' menu");
		adminProductInfoPage.clickToCustomersMenu();

		log.info("Admin_07 - Step_02: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage = adminProductInfoPage.clickToCustomersPage();

		log.info("Admin_07 - Step_03: Click to 'Add new' button");
		adminCustomerInfoPage = adminCustomersPage.clickToAddNewButton();

		log.info("Admin_07 - Step_04: Enter to 'Email' textbox with value is '" + email + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("Email", email);

		log.info("Admin_07 - Step_05: Enter to 'Password' textbox with value is '" + AdminData.CustomerInfo.PASSWORD
				+ "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("Password", AdminData.CustomerInfo.PASSWORD);

		log.info("Admin_07 - Step_06: Enter to 'First name' textbox with value is '" + AdminData.CustomerInfo.FIRST_NAME
				+ "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("FirstName", AdminData.CustomerInfo.FIRST_NAME);

		log.info("Admin_07 - Step_07: Enter to 'Last name' textbox with value is '" + AdminData.CustomerInfo.LAST_NAME
				+ "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("LastName", AdminData.CustomerInfo.LAST_NAME);

		log.info("Admin_07 - Step_08: Check to 'Male' in Gender radio");
		adminCustomerInfoPage.checkToCheckboxByCheckboxID("Gender_Male");

		log.info("Admin_07 - Step_09: Enter to 'Data of birth' with value is '" + AdminData.CustomerInfo.DATE_OF_BIRTH
				+ "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("DateOfBirth", AdminData.CustomerInfo.DATE_OF_BIRTH);

		log.info("Admin_07 - Step_10: Enter to 'Company name' with value is '" + AdminData.CustomerInfo.COMPANY_NAME
				+ "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("Company", AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_07 - Step_11: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomerInfoPage.deleteItemInDropdown("Registered");

		log.info("Admin_07 - Step_12: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomerInfoPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_07 - Step_13: Check to 'Active' checkbox");
		adminCustomerInfoPage.checkToCheckboxByCheckboxID("Active");

		log.info("Admin_07 - Step_14: Enter to 'Admin comment' textbox with value is '"
				+ AdminData.CustomerInfo.ADMIN_COMMENT + "'");
		adminCustomerInfoPage.enterToTextareaByTextboxID("AdminComment", AdminData.CustomerInfo.ADMIN_COMMENT);

		log.info("Admin_07 - Step_15: Click to 'Save and Continue Edit' button");
		adminCustomerInfoPage.clickToSaveAndContinueButton();

		log.info("Admin_07 - Step_16: Verify 'New customer has been added successfully' message is displayed");
		Assert.assertTrue(adminCustomerInfoPage.isNewCustomerAddSuccessMessageDisplayed());

		log.info("Admin_07 - Step_17: Verify 'Email' value is '" + email + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextboxValueDisplayedByTextboxID("Email"), email);

		log.info("Admin_07 - Step_18: Verify 'First name' value is '" + AdminData.CustomerInfo.FIRST_NAME + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextboxValueDisplayedByTextboxID("FirstName"),
				AdminData.CustomerInfo.FIRST_NAME);

		log.info("Admin_07 - Step_19: Verify 'Last name' value is '" + AdminData.CustomerInfo.LAST_NAME + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextboxValueDisplayedByTextboxID("LastName"),
				AdminData.CustomerInfo.LAST_NAME);

		log.info("Admin_07 - Step_20: Verify 'Male' radio button is checked");
		Assert.assertTrue(adminCustomerInfoPage.isCheckboxCheckedByCheckboxID("Gender_Male"));

		log.info("Admin_07 - Step_21: Verify 'Data of birth' value is '" + AdminData.CustomerInfo.DATE_OF_BIRTH + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextboxValueDisplayedByTextboxID("DateOfBirth"),
				AdminData.CustomerInfo.DATE_OF_BIRTH);

		log.info("Admin_07 - Step_22: Verify 'Company name' value is '" + AdminData.CustomerInfo.COMPANY_NAME + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextboxValueDisplayedByTextboxID("Company"),
				AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_07 - Step_23: Verify 'Guests' is selected in 'Customer roles' dropdown");
		Assert.assertTrue(adminCustomerInfoPage.isItemInDropdownSelected("Guests"));

		log.info("Admin_07 - Step_24: Verify 'Active' checkbox is checked");
		Assert.assertTrue(adminCustomerInfoPage.isCheckboxCheckedByCheckboxID("Active"));

		log.info("Admin_07 - Step_25: Verify 'Admin comment' value is '" + AdminData.CustomerInfo.ADMIN_COMMENT + "'");
		Assert.assertEquals(adminCustomerInfoPage.isTextareaValueDisplayedByTextareaID("AdminComment"),
				AdminData.CustomerInfo.ADMIN_COMMENT);

		log.info("Admin_07 - Step_26: Click to 'back to customer list' link");
		adminCustomersPage = adminCustomerInfoPage.clickToBackToCustomerListLink();

		log.info("Admin_07 - Step_27: Delete 'Registered' in 'Customer role' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_07 - Step_28: Select 'Guests' in 'Customer role' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_07 - Step_29: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_07 - Step_30: Verify Customer Info is displayed");
		Assert.assertTrue(adminCustomersPage
				.isCustomerInfoDisplayed(AdminData.CustomerInfo.FIRST_NAME + " " + AdminData.CustomerInfo.LAST_NAME));

	}

	@Test
	public void Admin_08_Search_Customer_With_Email() {
		log.info("Admin_08 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_08 - Step_02: Enter to 'Email' textbox with value is '" + email + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", email);

		log.info("Admin_08 - Step_03: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_08 - Step_04: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_08 - Step_05: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_09 - Step_06: Verify Customer Info is displayed");
		Assert.assertTrue(adminCustomersPage
				.isCustomerInfoDisplayed(AdminData.CustomerInfo.FIRST_NAME + " " + AdminData.CustomerInfo.LAST_NAME));

	}

	@Test
	public void Admin_09_Search_Customer_With_Firstname_And_Lastname() {
		log.info("Admin_09 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_09 - Step_02: Enter to 'Firstname' textbox with value is '" + AdminData.CustomerInfo.FIRST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.FIRST_NAME);

		log.info("Admin_09 - Step_03: Enter to 'Lastname' textbox with value is '" + AdminData.CustomerInfo.LAST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.LAST_NAME);

		log.info("Admin_09 - Step_04: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_09 - Step_05: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_09 - Step_06: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_10 - Step_07: Verify Customer Info is displayed");
		Assert.assertTrue(adminCustomersPage
				.isCustomerInfoDisplayed(AdminData.CustomerInfo.FIRST_NAME + " " + AdminData.CustomerInfo.LAST_NAME));

	}

	@Test
	public void Admin_10_Search_Customer_With_Company_Name() {
		log.info("Admin_10 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_10 - Step_02: Enter to 'Company' textbox with value is '" + AdminData.CustomerInfo.COMPANY_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_10 - Step_03: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_10 - Step_04: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_10 - Step_05: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_10 - Step_06: Verify Customer Info is displayed");
		Assert.assertTrue(adminCustomersPage
				.isCustomerInfoDisplayed(AdminData.CustomerInfo.FIRST_NAME + " " + AdminData.CustomerInfo.LAST_NAME));
	}

	@Test
	public void Admin_11_Search_Customer_With_Full_Data() {
		log.info("Admin_11 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_11 - Step_02: Enter to 'Email' textbox with value is '" + email + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", email);

		log.info("Admin_11 - Step_03: Enter to 'Firstname' textbox with value is '" + AdminData.CustomerInfo.FIRST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.FIRST_NAME);

		log.info("Admin_11 - Step_04: Enter to 'Lastname' textbox with value is '" + AdminData.CustomerInfo.LAST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.LAST_NAME);

		log.info("Admin_11 - Step_05: Select '1' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "1");

		log.info("Admin_11 - Step_06: Select '1' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "1");

		log.info("Admin_11 - Step_07: Enter to 'Company' textbox with value is '" + AdminData.CustomerInfo.COMPANY_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_11 - Step_08: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_11 - Step_09: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_11 - Step_10: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_11 - Step_11: Verify Customer Info is displayed");
		Assert.assertTrue(adminCustomersPage
				.isCustomerInfoDisplayed(AdminData.CustomerInfo.FIRST_NAME + " " + AdminData.CustomerInfo.LAST_NAME));

	}

	@Test
	public void Admin_12_Edit_Customer() {
		log.info("Admin_12 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_12 - Step_02: Enter to 'Email' textbox with value is '" + email + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", email);

		log.info("Admin_12 - Step_03: Enter to 'Firstname' textbox with value is '" + AdminData.CustomerInfo.FIRST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.FIRST_NAME);

		log.info("Admin_12 - Step_04: Enter to 'Lastname' textbox with value is '" + AdminData.CustomerInfo.LAST_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.LAST_NAME);

		log.info("Admin_12 - Step_05: Select '1' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "1");

		log.info("Admin_12 - Step_06: Select '1' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "1");

		log.info("Admin_12 - Step_07: Enter to 'Company' textbox with value is '" + AdminData.CustomerInfo.COMPANY_NAME
				+ "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_12 - Step_08: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_12 - Step_09: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_12 - Step_10: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_12 - Step_11: Click to 'Edit' button");
		adminCustomerInfoPage = adminCustomersPage.clickToEditButton(AdminData.CustomerInfo.COMPANY_NAME);

		log.info("Admin_12 - Step_12: Enter to 'Email' textbox with value is '" + editEmail + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("Email", editEmail);

		log.info("Admin_12 - Step_13: Enter to 'First name' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_FIRST_NAME + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("FirstName", AdminData.CustomerInfo.EDIT_FIRST_NAME);

		log.info("Admin_12 - Step_14: Enter to 'Last name' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("LastName", AdminData.CustomerInfo.EDIT_LAST_NAME);

		log.info("Admin_12 - Step_15: Enter to 'Date of birth' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_DATE_OF_BIRTH + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("DateOfBirth", AdminData.CustomerInfo.EDIT_DATE_OF_BIRTH);

		log.info("Admin_12 - Step_16: Enter to 'Company name' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_COMPANY_NAME + "'");
		adminCustomerInfoPage.enterToTextboxByTextboxID("Company", AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_12 - Step_17: Enter to 'Admin comment' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_ADMIN_COMMENT + "'");
		adminCustomerInfoPage.enterToTextareaByTextboxID("AdminComment", AdminData.CustomerInfo.EDIT_ADMIN_COMMENT);

		log.info("Admin_12 - Step_18: Click to 'Save' button");
		adminCustomerInfoPage.clickToSaveButton();

		log.info("Admin_12 - Step_19: Verify 'The customer has been updated successfully' message is displayed");
		Assert.assertTrue(adminCustomerInfoPage.isCustomerUpdatedSuccessMessageDisplayed());

		log.info("Admin_12 - Step_20: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage = adminCustomerInfoPage.clickToCutomerPage();

		log.info("Admin_12 - Step_21: Enter to 'Email' textbox with value is '" + editEmail + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", editEmail);

		log.info("Admin_12 - Step_22: Enter to 'Firstname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_FIRST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.EDIT_FIRST_NAME);

		log.info("Admin_12 - Step_23: Enter to 'Lastname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.EDIT_LAST_NAME);

		log.info("Admin_12 - Step_24: Select '2' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "2");

		log.info("Admin_12 - Step_25: Select '2' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "2");

		log.info("Admin_12 - Step_26: Enter to 'Company' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_COMPANY_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_12 - Step_27: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_12 - Step_28: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_12 - Step_29: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_12 - Step_30: Verify '" + AdminData.CustomerInfo.EDIT_FIRST_NAME + " "
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "' is displayed in Customer Info");
		Assert.assertTrue(adminCustomersPage.isCustomerInfoDisplayed(
				AdminData.CustomerInfo.EDIT_FIRST_NAME + " " + AdminData.CustomerInfo.EDIT_LAST_NAME));

		log.info("Admin_12 - Step_31: Verify '" + AdminData.CustomerInfo.EDIT_COMPANY_NAME
				+ "' is displayed in Customer Info");
		Assert.assertTrue(adminCustomersPage.isCustomerInfoDisplayed(AdminData.CustomerInfo.EDIT_COMPANY_NAME));

	}

	@Test
	public void Admin_13_Add_New_Addres_In_Customer_Detail() {
		log.info("Admin_13 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage.clickToCustomersPage();

		log.info("Admin_13 - Step_02: Enter to 'Email' textbox with value is '" + editEmail + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", editEmail);

		log.info("Admin_13 - Step_03: Enter to 'Firstname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_FIRST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.EDIT_FIRST_NAME);

		log.info("Admin_13 - Step_04: Enter to 'Lastname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.EDIT_LAST_NAME);

		log.info("Admin_13 - Step_05: Select '2' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "2");

		log.info("Admin_13 - Step_06: Select '2' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "2");

		log.info("Admin_13 - Step_07: Enter to 'Company' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_COMPANY_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_13 - Step_08: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_13 - Step_09: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_13 - Step_10: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_13 - Step_11: Click to 'Edit' button");
		adminCustomerInfoPage = adminCustomersPage.clickToEditButton(AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_13 - Step_12: Click to 'Add new address' button");
		adminAddNewAddressPage = adminCustomerInfoPage.clickToAddNewAddressButton();

		log.info("Admin_13 - Step_13: Enter to 'First name' textbox with value is'" + AdminData.AddressInfo.FIRST_NAME
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_FirstName", AdminData.AddressInfo.FIRST_NAME);

		log.info("Admin_13 - Step_14: Enter to 'Last name' textbox with value is'" + AdminData.AddressInfo.LAST_NAME
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_LastName", AdminData.AddressInfo.LAST_NAME);

		log.info("Admin_13 - Step_15: Enter to 'Email' textbox with value is'" + AdminData.AddressInfo.EMAIL + "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_Email", AdminData.AddressInfo.EMAIL);

		log.info("Admin_13 - Step_16: Enter to 'Company' textbox with value is'" + AdminData.AddressInfo.COMPANY + "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_Company", AdminData.AddressInfo.COMPANY);

		log.info("Admin_13 - Step_17: Select '" + AdminData.AddressInfo.COUNTRY + "'in 'Country' dropdown");
		adminAddNewAddressPage.selectItemInDropdownByDropdownID("Address_CountryId", AdminData.AddressInfo.COUNTRY);

		log.info("Admin_13 - Step_18: Select '" + AdminData.AddressInfo.STATE_PROVICE
				+ "'in 'State / province' dropdown");
		adminAddNewAddressPage.selectItemInDropdownByDropdownID("Address_StateProvinceId",
				AdminData.AddressInfo.STATE_PROVICE);

		log.info("Admin_13 - Step_19: Enter to 'County / region' textbox with value is'" + AdminData.AddressInfo.COUNTRY
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_County", AdminData.AddressInfo.COUNTRY);

		log.info("Admin_13 - Step_20: Enter to 'City' textbox with value is'" + AdminData.AddressInfo.CITY + "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_City", AdminData.AddressInfo.CITY);

		log.info("Admin_13 - Step_21: Enter to 'Address 1' textbox with value is'" + AdminData.AddressInfo.ADDRESS_1
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_Address1", AdminData.AddressInfo.ADDRESS_1);

		log.info("Admin_13 - Step_22: Enter to 'Address 2' textbox with value is'" + AdminData.AddressInfo.ADDRESS_2
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_Address2", AdminData.AddressInfo.ADDRESS_2);

		log.info("Admin_13 - Step_23: Enter to 'Zip / postal code' textbox with value is'"
				+ AdminData.AddressInfo.ZIP_PORTAL_CODE + "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_ZipPostalCode",
				AdminData.AddressInfo.ZIP_PORTAL_CODE);

		log.info("Admin_13 - Step_24: Enter to 'Phone number' textbox with value is'"
				+ AdminData.AddressInfo.PHONE_NUMBER + "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_PhoneNumber", AdminData.AddressInfo.PHONE_NUMBER);

		log.info("Admin_13 - Step_25: Enter to 'Fax number' textbox with value is'" + AdminData.AddressInfo.FAX_NUMBER
				+ "'");
		adminAddNewAddressPage.enterToTextboxByTextboxID("Address_FaxNumber", AdminData.AddressInfo.FAX_NUMBER);

		log.info("Admin_13 - Step_26: Click to 'Save' button");
		adminAddNewAddressPage.clickToSaveButton();

		log.info("Admin_13 - Step_27: Verify 'The new address has been added successfully' is displayed");
		Assert.assertTrue(adminAddNewAddressPage.isNewAddressAddedSuccessMessageDisplayed());

		log.info("Admin_13 - Step_28: Verify 'First name' textbox value is equals '" + AdminData.AddressInfo.FIRST_NAME
				+ "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_FirstName"),
				AdminData.AddressInfo.FIRST_NAME);

		log.info("Admin_13 - Step_29: Verify 'Last name' textbox value is equals '" + AdminData.AddressInfo.LAST_NAME
				+ "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_LastName"),
				AdminData.AddressInfo.LAST_NAME);

		log.info("Admin_13 - Step_30: Verify 'Email' textbox value is equals '" + AdminData.AddressInfo.EMAIL + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_Email"),
				AdminData.AddressInfo.EMAIL);

		log.info(
				"Admin_13 - Step_31: Verify 'Company' textbox value is equals '" + AdminData.AddressInfo.COMPANY + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_Company"),
				AdminData.AddressInfo.COMPANY);

		log.info("Admin_13 - Step_32: Verify '" + AdminData.AddressInfo.COUNTRY + "'is selected in 'Country' dropdown");
		Assert.assertEquals(adminAddNewAddressPage.isItemSelectedInDropdown("Address_CountryId"),
				AdminData.AddressInfo.COUNTRY);

		log.info("Admin_13 - Step_33: Verify '" + AdminData.AddressInfo.STATE_PROVICE
				+ "'is selected in 'State / province' dropdown");
		Assert.assertEquals(adminAddNewAddressPage.isItemSelectedInDropdown("Address_StateProvinceId"),
				AdminData.AddressInfo.STATE_PROVICE);

		log.info("Admin_13 - Step_34: Verify 'County / region' textbox value is equals '"
				+ AdminData.AddressInfo.COUNTRY + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_County"),
				AdminData.AddressInfo.COUNTRY);

		log.info("Admin_13 - Step_35: Verify 'City' textbox value is equals '" + AdminData.AddressInfo.CITY + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_City"),
				AdminData.AddressInfo.CITY);

		log.info("Admin_13 - Step_36: Verify 'Address 1' textbox value is equals '" + AdminData.AddressInfo.ADDRESS_1
				+ "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_Address1"),
				AdminData.AddressInfo.ADDRESS_1);

		log.info("Admin_13 - Step_37: Verify 'Address 2' textbox value is equals '" + AdminData.AddressInfo.ADDRESS_2
				+ "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_Address2"),
				AdminData.AddressInfo.ADDRESS_2);

		log.info("Admin_13 - Step_38: Verify 'Zip / postal code' textbox value is equals '"
				+ AdminData.AddressInfo.ZIP_PORTAL_CODE + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_ZipPostalCode"),
				AdminData.AddressInfo.ZIP_PORTAL_CODE);

		log.info("Admin_13 - Step_39: Verify 'Phone number' textbox value is equals '"
				+ AdminData.AddressInfo.PHONE_NUMBER + "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_PhoneNumber"),
				AdminData.AddressInfo.PHONE_NUMBER);

		log.info("Admin_13 - Step_40: Verify 'Fax number' textbox value is equals '" + AdminData.AddressInfo.FAX_NUMBER
				+ "'");
		Assert.assertEquals(adminAddNewAddressPage.isTextboxValueDisplayedByTextboxID("Address_FaxNumber"),
				AdminData.AddressInfo.FAX_NUMBER);

		log.info("Admin_13 - Step_41: Click to 'back to customer details' link");
		adminCustomerInfoPage = adminAddNewAddressPage.clickToBackToCustomerDetailsLink();

		log.info("Admin_13 - Step_42: Verify 'First name' value is equals '" + AdminData.AddressInfo.FIRST_NAME + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.FIRST_NAME));

		log.info("Admin_13 - Step_43: Verify 'Last name' value is equals '" + AdminData.AddressInfo.LAST_NAME + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.LAST_NAME));

		log.info("Admin_13 - Step_44: Verify 'Email' value is equals '" + AdminData.AddressInfo.EMAIL + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EMAIL));

		log.info("Admin_13 - Step_45: Verify 'Phone number' value is equals '" + AdminData.AddressInfo.PHONE_NUMBER
				+ "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.PHONE_NUMBER));

		log.info("Admin_13 - Step_46: Verify 'Fax number' value is equals '" + AdminData.AddressInfo.FAX_NUMBER + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.FAX_NUMBER));

		log.info("Admin_13 - Step_47: Verify 'Address' value is equals '" + AdminData.AddressInfo.COMPANY + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInAddressInfoDisplay(AdminData.AddressInfo.COMPANY));

	}

	@Test
	public void Admin_14_Edit_Addres_In_Customer_Detail() {
		log.info("Admin_14 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage = adminProductInfoPage.clickToCustomersPage();

		log.info("Admin_14 - Step_02: Enter to 'Email' textbox with value is '" + editEmail + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", editEmail);

		log.info("Admin_14 - Step_03: Enter to 'Firstname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_FIRST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.EDIT_FIRST_NAME);

		log.info("Admin_14 - Step_04: Enter to 'Lastname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.EDIT_LAST_NAME);

		log.info("Admin_14 - Step_05: Select '2' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "2");

		log.info("Admin_14 - Step_06: Select '2' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "2");

		log.info("Admin_14 - Step_07: Enter to 'Company' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_COMPANY_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_14 - Step_08: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_14 - Step_09: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_14 - Step_10: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_14 - Step_11: Click to 'Edit' button");
		adminCustomerInfoPage = adminCustomersPage.clickToEditButton(AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_14 - Step_12: Click to 'Edit' button in 'Address'");
		adminEditAddressPage = adminCustomerInfoPage.clickToEditButton();

		log.info("Admin_14 - Step_13: Enter to 'First name' textbox with value is '"
				+ AdminData.AddressInfo.EDIT_FIRST_NAME + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_FirstName", AdminData.AddressInfo.EDIT_FIRST_NAME);

		log.info("Admin_14 - Step_14: Enter to 'Last name' textbox with value is '"
				+ AdminData.AddressInfo.EDIT_LAST_NAME + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_LastName", AdminData.AddressInfo.EDIT_LAST_NAME);

		log.info("Admin_14 - Step_15: Enter to 'Email' textbox with value is '" + AdminData.AddressInfo.EDIT_EMAIL
				+ "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_Email", AdminData.AddressInfo.EDIT_EMAIL);

		log.info("Admin_14 - Step_16: Enter to 'Company' textbox with value is '" + AdminData.AddressInfo.EDIT_COMPANY
				+ "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_Company", AdminData.AddressInfo.EDIT_COMPANY);

		log.info("Admin_14 - Step_17: Select '" + AdminData.AddressInfo.EDIT_COUNTRY + "'in 'Country' dropdown");
		adminEditAddressPage.selectItemInDropdownByDropdownID("Address_CountryId", AdminData.AddressInfo.EDIT_COUNTRY);

		log.info("Admin_14 - Step_18: Select '" + AdminData.AddressInfo.EDIT_STATE_PROVICE
				+ "'in 'State / province' dropdown");
		adminEditAddressPage.selectItemInDropdownByDropdownID("Address_StateProvinceId",
				AdminData.AddressInfo.EDIT_STATE_PROVICE);

		log.info("Admin_14 - Step_19: Enter to 'County / region' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_COUNTRY + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_County", AdminData.AddressInfo.EDIT_COUNTRY);

		log.info("Admin_14 - Step_20: Enter to 'City' textbox with value is'" + AdminData.AddressInfo.EDIT_CITY + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_City", AdminData.AddressInfo.EDIT_CITY);

		log.info("Admin_14 - Step_21: Enter to 'Address 1' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_ADDRESS_1 + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_Address1", AdminData.AddressInfo.EDIT_ADDRESS_1);

		log.info("Admin_14 - Step_22: Enter to 'Address 2' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_ADDRESS_2 + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_Address2", AdminData.AddressInfo.EDIT_ADDRESS_2);

		log.info("Admin_14 - Step_23: Enter to 'Zip / postal code' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_ZIP_PORTAL_CODE + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_ZipPostalCode",
				AdminData.AddressInfo.EDIT_ZIP_PORTAL_CODE);

		log.info("Admin_14 - Step_24: Enter to 'Phone number' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_PHONE_NUMBER + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_PhoneNumber", AdminData.AddressInfo.EDIT_PHONE_NUMBER);

		log.info("Admin_14 - Step_25: Enter to 'Fax number' textbox with value is'"
				+ AdminData.AddressInfo.EDIT_FAX_NUMBER + "'");
		adminEditAddressPage.enterToTextboxByTextboxID("Address_FaxNumber", AdminData.AddressInfo.EDIT_FAX_NUMBER);

		log.info("Admin_14 - Step_26: Click to 'Save' button");
		adminEditAddressPage.clickToSaveButton();

		log.info("Admin_14 - Step_27: Verify 'The address has been updated successfully' message is displayed");
		Assert.assertTrue(adminEditAddressPage.isAddressUpdatedSuccessMessageDisplayed());

		log.info("Admin_14 - Step_28: Verify 'First name' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_FIRST_NAME + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_FirstName"),
				AdminData.AddressInfo.EDIT_FIRST_NAME);

		log.info("Admin_14 - Step_29: Verify 'Last name' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_LAST_NAME + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_LastName"),
				AdminData.AddressInfo.EDIT_LAST_NAME);

		log.info("Admin_14 - Step_30: Verify 'Email' textbox value is equals '" + AdminData.AddressInfo.EDIT_EMAIL
				+ "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_Email"),
				AdminData.AddressInfo.EDIT_EMAIL);

		log.info("Admin_14 - Step_31: Verify 'Company' textbox value is equals '" + AdminData.AddressInfo.EDIT_COMPANY
				+ "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_Company"),
				AdminData.AddressInfo.EDIT_COMPANY);

		log.info("Admin_14 - Step_32: Verify '" + AdminData.AddressInfo.EDIT_COUNTRY
				+ "'is selected in 'Country' dropdown");
		Assert.assertEquals(adminEditAddressPage.isItemSelectedInDropdown("Address_CountryId"),
				AdminData.AddressInfo.EDIT_COUNTRY);

		log.info("Admin_14 - Step_33: Verify '" + AdminData.AddressInfo.EDIT_STATE_PROVICE
				+ "'is selected in 'State / province' dropdown");
		Assert.assertEquals(adminEditAddressPage.isItemSelectedInDropdown("Address_StateProvinceId"),
				AdminData.AddressInfo.EDIT_STATE_PROVICE);

		log.info("Admin_14 - Step_34: Verify 'County / region' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_COUNTRY + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_County"),
				AdminData.AddressInfo.EDIT_COUNTRY);

		log.info("Admin_14 - Step_35: Verify 'City' textbox value is equals '" + AdminData.AddressInfo.EDIT_CITY + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_City"),
				AdminData.AddressInfo.EDIT_CITY);

		log.info("Admin_14 - Step_36: Verify 'Address 1' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_ADDRESS_1 + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_Address1"),
				AdminData.AddressInfo.EDIT_ADDRESS_1);

		log.info("Admin_14 - Step_37: Verify 'Address 2' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_ADDRESS_2 + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_Address2"),
				AdminData.AddressInfo.EDIT_ADDRESS_2);

		log.info("Admin_14 - Step_38: Verify 'Zip / postal code' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_ZIP_PORTAL_CODE + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_ZipPostalCode"),
				AdminData.AddressInfo.EDIT_ZIP_PORTAL_CODE);

		log.info("Admin_14 - Step_39: Verify 'Phone number' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_PHONE_NUMBER + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_PhoneNumber"),
				AdminData.AddressInfo.EDIT_PHONE_NUMBER);

		log.info("Admin_14 - Step_40: Verify 'Fax number' textbox value is equals '"
				+ AdminData.AddressInfo.EDIT_FAX_NUMBER + "'");
		Assert.assertEquals(adminEditAddressPage.isTextboxValueDisplayedByTextboxID("Address_FaxNumber"),
				AdminData.AddressInfo.EDIT_FAX_NUMBER);

		log.info("Admin_14 - Step_41: Click to 'back to customer details' link");
		adminCustomerInfoPage = adminEditAddressPage.clickToBackToCustomerDetailsLink();

		log.info("Admin_14 - Step_42: Verify 'First name' value is equals '" + AdminData.AddressInfo.EDIT_FIRST_NAME
				+ "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EDIT_FIRST_NAME));

		log.info("Admin_14 - Step_43: Verify 'Last name' value is equals '" + AdminData.AddressInfo.EDIT_LAST_NAME
				+ "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EDIT_LAST_NAME));

		log.info("Admin_14 - Step_44: Verify 'Email' value is equals '" + AdminData.AddressInfo.EDIT_EMAIL + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EDIT_EMAIL));

		log.info("Admin_14 - Step_45: Verify 'Phone number' value is equals '" + AdminData.AddressInfo.EDIT_PHONE_NUMBER
				+ "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EDIT_PHONE_NUMBER));

		log.info("Admin_14 - Step_46: Verify 'Fax number' value is equals '" + AdminData.AddressInfo.EDIT_FAX_NUMBER
				+ "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInfoDisplay(AdminData.AddressInfo.EDIT_FAX_NUMBER));

		log.info("Admin_14 - Step_47: Verify 'Address' value is equals '" + AdminData.AddressInfo.COMPANY + "'");
		Assert.assertTrue(adminCustomerInfoPage.isAddressInAddressInfoDisplay(AdminData.AddressInfo.COMPANY));

	}

	@Test
	public void Admin_15_Delete_Addres_In_Customer_Detail() {
		log.info("Admin_15 - Step_01: Click to 'Customers' in 'Customers' menu");
		adminCustomersPage = adminCustomerInfoPage.clickToCutomerPage();

		log.info("Admin_15 - Step_02: Enter to 'Email' textbox with value is '" + editEmail + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchEmail", editEmail);

		log.info("Admin_15 - Step_03: Enter to 'Firstname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_FIRST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchFirstName", AdminData.CustomerInfo.EDIT_FIRST_NAME);

		log.info("Admin_15 - Step_04: Enter to 'Lastname' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_LAST_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchLastName", AdminData.CustomerInfo.EDIT_LAST_NAME);

		log.info("Admin_15 - Step_05: Select '2' in 'Month' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchMonthOfBirth", "2");

		log.info("Admin_15 - Step_06: Select '2' in 'Day' dropdown");
		adminCustomersPage.selectItemInDropdownByDropdownID("SearchDayOfBirth", "2");

		log.info("Admin_15 - Step_07: Enter to 'Company' textbox with value is '"
				+ AdminData.CustomerInfo.EDIT_COMPANY_NAME + "'");
		adminCustomersPage.enterToTextboxByTextboxID("SearchCompany", AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_15 - Step_08: Clear item 'Registered' in 'Customer roles' dropdown");
		adminCustomersPage.deleteItemInCustomerRolesDropdown("Registered");

		log.info("Admin_15 - Step_09: Select 'Guests' in 'Customer roles' dropdown");
		adminCustomersPage.selectItemInCustomerRolesDropdown("Guests");

		log.info("Admin_15 - Step_10: Click to 'Search' button");
		adminCustomersPage.clickToSearchButton();

		log.info("Admin_15 - Step_11: Click to 'Edit' button");
		adminCustomerInfoPage = adminCustomersPage.clickToEditButton(AdminData.CustomerInfo.EDIT_COMPANY_NAME);

		log.info("Admin_15 - Step_12: Click to 'Delete' button");
		adminCustomerInfoPage.clickToDeleteButton();

		log.info("Admin_15 - Step_13: Accept to delete address info");
		adminCustomerInfoPage.acceptToDeleteAddressInfo();

		log.info("Admin_15 - Step_14: Verify Address info is deleted");
		Assert.assertTrue(adminCustomerInfoPage.AddressInfoIsDeleted());

	}

	@AfterClass(alwaysRun = true)
	public void afterClass() {
		closeBrowserDriver();
	}
}
