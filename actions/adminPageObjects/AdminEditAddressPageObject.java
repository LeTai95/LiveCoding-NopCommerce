package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminEditAddressPageUIs;

public class AdminEditAddressPageObject extends BasePage {
	WebDriver driver;
	public AdminEditAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(AdminEditAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(AdminEditAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxID);
		sleepInSecond(1);
	}
	public void selectItemInDropdownByDropdownID(String dropdownID, String textItem) {
		waitForElementVisiable(AdminEditAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(AdminEditAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, textItem, dropdownID);
		sleepInSecond(1);
	}
	public void clickToSaveButton() {
		waitForElementClickable(AdminEditAddressPageUIs.SAVE_BUTTON);
		clickToElement(AdminEditAddressPageUIs.SAVE_BUTTON);
	}
	public boolean isAddressUpdatedSuccessMessageDisplayed() {
		waitForElementVisiable(AdminEditAddressPageUIs.ADDRESS_UPDATED_SUCCESS_MESSAGE);
		return isElementDisplayed(AdminEditAddressPageUIs.ADDRESS_UPDATED_SUCCESS_MESSAGE);
	}
	public String isTextboxValueDisplayedByTextboxID(String textboxID) {
		waitForElementVisiable(AdminEditAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		return getElementAttribute(AdminEditAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, "value", textboxID);
	}
	public String isItemSelectedInDropdown(String dropdownID) {
		waitForElementVisiable(AdminEditAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		return getSelectedItemInDefaultDropdown(AdminEditAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
	}
	public AdminCustomerInfoPageObject clickToBackToCustomerDetailsLink() {
		waitForElementVisiable(AdminEditAddressPageUIs.BACK_TO_CUSTOMER_DETAILS_LINK);
		clickToElement(AdminEditAddressPageUIs.BACK_TO_CUSTOMER_DETAILS_LINK);
		return PageGeneraterManager.getCustomerInfoPage(driver);
		
	}
	
	
}
