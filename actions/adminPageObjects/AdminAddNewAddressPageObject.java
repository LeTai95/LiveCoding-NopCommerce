package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminAddNewAddressPageUIs;

public class AdminAddNewAddressPageObject extends BasePage {
	WebDriver driver;
	public AdminAddNewAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(AdminAddNewAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(AdminAddNewAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxID);
		sleepInSecond(1);
	}
	public void selectItemInDropdownByDropdownID(String dropdownID, String textItem) {
		waitForElementVisiable(AdminAddNewAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(AdminAddNewAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, textItem, dropdownID);
	}
	public void clickToSaveButton() {
		waitForElementClickable(AdminAddNewAddressPageUIs.SAVE_BUTTON);
		clickToElement(AdminAddNewAddressPageUIs.SAVE_BUTTON);
	}
	public boolean isNewAddressAddedSuccessMessageDisplayed() {
		waitForElementVisiable(AdminAddNewAddressPageUIs.NEW_ADDRESS_ADDED_SUCCESS_MESSAGE);
		return isElementDisplayed(AdminAddNewAddressPageUIs.NEW_ADDRESS_ADDED_SUCCESS_MESSAGE);
	}
	public String isTextboxValueDisplayedByTextboxID(String textboxID) {
		waitForElementVisiable(AdminAddNewAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(AdminAddNewAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	public String isItemSelectedInDropdown(String dropdownID) {
		waitForElementVisiable(AdminAddNewAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemInDefaultDropdown(AdminAddNewAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}
	public AdminCustomerInfoPageObject clickToBackToCustomerDetailsLink() {
		waitForElementClickable(AdminAddNewAddressPageUIs.BACK_TO_CUSTOMER_DETAILS_LINK);
		clickToElement(AdminAddNewAddressPageUIs.BACK_TO_CUSTOMER_DETAILS_LINK);
		return PageGeneraterManager.getCustomerInfoPage(driver);
	}

}
