package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminCustomerInfoPageUIs;
import pageUI.nopcommerce.admin.AdminCustomersPageUIs;

public class AdminCustomersPageObject extends BasePage {
	WebDriver driver;

	public AdminCustomersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public AdminCustomerInfoPageObject clickToAddNewButton() {
		waitForElementClickable(AdminCustomersPageUIs.ADD_NEW_BUTTON);
		clickToElementByJS(AdminCustomersPageUIs.ADD_NEW_BUTTON);
		return PageGeneraterManager.getCustomerInfoPage(driver);
	}

	public boolean isCustomerInfoDisplayedByRowNumberAndColumnName(String rowNumber, String customerInfo) {
		waitForElementInvisiable(AdminCustomersPageUIs.LOADING_ICON);
		waitForElementVisiable(AdminCustomersPageUIs.CUSTOMER_INFO_BY_ROW_NUMBER_AND_LOLUMN_INDEX, rowNumber,
				customerInfo);
		return isElementDisplayed(AdminCustomersPageUIs.CUSTOMER_INFO_BY_ROW_NUMBER_AND_LOLUMN_INDEX, rowNumber,
				customerInfo);
	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminCustomersPageUIs.SEARCH_BUTTON);
		clickToElement(AdminCustomersPageUIs.SEARCH_BUTTON);
		sleepInSecond(1);
	}

	public void clickToCustomersPage() {
		waitForElementClickable(AdminCustomersPageUIs.CUSTOMERS_PAGE);
		clickToElement(AdminCustomersPageUIs.CUSTOMERS_PAGE);
		sleepInSecond(1);
	}

	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(AdminCustomersPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textboxID);
		sendkeyToElement(AdminCustomersPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textValue, textboxID);
		sleepInSecond(1);
	}

	public void deleteItemInCustomerRolesDropdown(String textItem) {
		waitForElementClickable(AdminCustomersPageUIs.DELETE_ITEM_ICON_IN_DROPDOWN, textItem);
		clickToElementByJS(AdminCustomersPageUIs.DELETE_ITEM_ICON_IN_DROPDOWN, textItem);
	}

	public void selectItemInDropdownByDropdownID(String dropdownID, String textItem) {
		waitForElementVisiable(AdminCustomersPageUIs.DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME, dropdownID);
		selectItemInDefaultDropdown(AdminCustomersPageUIs.DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME, textItem, dropdownID);
	}

	public AdminCustomerInfoPageObject clickToEditButton(String customerInfo) {
		waitForElementClickable(AdminCustomersPageUIs.DYNAMIC_EDIT_BUTTON_BY_CUSTOMER_INFO, customerInfo);
		clickToElement(AdminCustomersPageUIs.DYNAMIC_EDIT_BUTTON_BY_CUSTOMER_INFO, customerInfo);
		return PageGeneraterManager.getCustomerInfoPage(driver);
	}

	public boolean isCustomerInfoDisplayed(String customerInfo) {
		waitForElementVisiable(AdminCustomersPageUIs.CUSTOMER_INFO, customerInfo);
		return isElementDisplayed(AdminCustomersPageUIs.CUSTOMER_INFO, customerInfo);
	}

	public void selectItemInCustomerRolesDropdown(String textItem) {
		enterAndSelectItemInDropdown(AdminCustomersPageUIs.PARENT_XPATH_CUSTOMER_ROLES_DROPDOWN,
				AdminCustomersPageUIs.CHILD_XPATH_CUSTOMER_ROLES_DROPDOWN,
				AdminCustomersPageUIs.INPUT_ITEM_XPATH_CUSTOMER_ROLES_DROPDOWN, textItem);
	}

}
