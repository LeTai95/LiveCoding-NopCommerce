package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminCustomerInfoPageUIs;

public class AdminCustomerInfoPageObject extends BasePage {
	WebDriver driver;

	public AdminCustomerInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textboxID);
		sendkeyToElement(AdminCustomerInfoPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textValue, textboxID);
		sleepInSecond(1);
	}

	public void checkToCheckboxByCheckboxID(String checkboxID) {
		waitForElementClickable(AdminCustomerInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_ID, checkboxID);
		checkToDefautCheckboxRadio(AdminCustomerInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_ID, checkboxID);
	}

	public void selectItemInCustomerRolesDropdown(String textItem) {
		enterAndSelectItemInDropdown(AdminCustomerInfoPageUIs.PARENT_XPATH_CUSTOMER_ROLES_DROPDOWN,
				AdminCustomerInfoPageUIs.CHILD_XPATH_CUSTOMER_ROLES_DROPDOWN,
				AdminCustomerInfoPageUIs.INPUT_ITEM_XPATH_CUSTOMER_ROLES_DROPDOWN, textItem);
//		selectItemInCustomDropdown(AdminCustomerInfoPageUIs.PARENT_XPATH_CUSTOMER_ROLES_DROPDOWN,
//				AdminCustomerInfoPageUIs.CHILD_XPATH_CUSTOMER_ROLES_DROPDOWN, textItem);
	}

	public void clickToSaveAndContinueButton() {
		waitForElementClickable(AdminCustomerInfoPageUIs.SAVE_AND_CONTINUE_EDIT_BUTTON);
		clickToElement(AdminCustomerInfoPageUIs.SAVE_AND_CONTINUE_EDIT_BUTTON);
	}

	public void enterToTextareaByTextboxID(String textareaID, String textValue) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_TEXTAREA_BY_TEXTAREA_ID, textareaID);
		sendkeyToElement(AdminCustomerInfoPageUIs.DYNAMIC_TEXTAREA_BY_TEXTAREA_ID, textValue, textareaID);

	}

	public boolean isNewCustomerAddSuccessMessageDisplayed() {
		waitForElementVisiable(AdminCustomerInfoPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(AdminCustomerInfoPageUIs.SUCCESS_MESSAGE);
	}

	public String isTextboxValueDisplayedByTextboxID(String textboxID) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textboxID);
		return getElementAttribute(AdminCustomerInfoPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, "value", textboxID);
	}

	public boolean isCheckboxCheckedByCheckboxID(String checkboxID) {
		waitForAllElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_ID, checkboxID);
		return isElementSelected(AdminCustomerInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_ID, checkboxID);
	}

	public boolean isItemInDropdownSelected(String textItem) {
		waitForAllElementVisiable(AdminCustomerInfoPageUIs.ITEM_SELECTED_IN_DROPDOWN, textItem);
		return isElementDisplayed(AdminCustomerInfoPageUIs.ITEM_SELECTED_IN_DROPDOWN, textItem);
	}

	public String isTextareaValueDisplayedByTextareaID(String textareaID) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_TEXTAREA_BY_TEXTAREA_ID, textareaID);
		return getElementText(AdminCustomerInfoPageUIs.DYNAMIC_TEXTAREA_BY_TEXTAREA_ID, textareaID);
	}

	public AdminCustomersPageObject clickToBackToCustomerListLink() {
		waitForElementClickable(AdminCustomerInfoPageUIs.BACK_TO_CUSTOMER_LIST);
		clickToElement(AdminCustomerInfoPageUIs.BACK_TO_CUSTOMER_LIST);
		return PageGeneraterManager.getCustomersPage(driver);
	}

	public void deleteItemInDropdown(String textItem) {
		waitForElementClickable(AdminCustomerInfoPageUIs.DYNAMIC_DELETE_ITEM_ICON_IN_DROPDOWN, textItem);
		clickToElement(AdminCustomerInfoPageUIs.DYNAMIC_DELETE_ITEM_ICON_IN_DROPDOWN, textItem);
	}

	public void clickToSaveButton() {
		waitForElementClickable(AdminCustomerInfoPageUIs.SAVE_BUTTON);
		clickToElement(AdminCustomerInfoPageUIs.SAVE_BUTTON);
	}

	public boolean isCustomerUpdatedSuccessMessageDisplayed() {
		waitForElementVisiable(AdminCustomerInfoPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(AdminCustomerInfoPageUIs.SUCCESS_MESSAGE);
	}

	public void clickToAddressButton() {
		scrollToElement(AdminCustomerInfoPageUIs.ITEM_TO_SCROLL);
		waitForElementVisiable(AdminCustomerInfoPageUIs.ADDRESS_COLLAPSE_BUTTON);
		clickToElementByJS(AdminCustomerInfoPageUIs.ADDRESS_COLLAPSE_BUTTON);
		sleepInSecond(3);
	}

	public AdminAddNewAddressPageObject clickToAddNewAddressButton() {
		scrollToElement(AdminCustomerInfoPageUIs.ITEM_TO_SCROLL);
		if (isElementDisplayed(AdminCustomerInfoPageUIs.ADD_NEW_ADDRESS_BUTTON)) {
			waitForElementVisiable(AdminCustomerInfoPageUIs.ADD_NEW_ADDRESS_BUTTON);
			clickToElement(AdminCustomerInfoPageUIs.ADD_NEW_ADDRESS_BUTTON);
			sleepInSecond(2);
		} else {
			waitForElementVisiable(AdminCustomerInfoPageUIs.ADDRESS_COLLAPSE_BUTTON);
			clickToElementByJS(AdminCustomerInfoPageUIs.ADDRESS_COLLAPSE_BUTTON);
			sleepInSecond(2);
			waitForElementVisiable(AdminCustomerInfoPageUIs.ADD_NEW_ADDRESS_BUTTON);
			clickToElement(AdminCustomerInfoPageUIs.ADD_NEW_ADDRESS_BUTTON);
		}
		return PageGeneraterManager.getAddNewAddressPage(driver);
	}

	public boolean isAddressInfoDisplay(String addressInfo) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_ADDRESS_INFO, addressInfo);
		return isElementDisplayed(AdminCustomerInfoPageUIs.DYNAMIC_ADDRESS_INFO, addressInfo);
	}

	public AdminEditAddressPageObject clickToEditButton() {
		scrollToElement(AdminCustomerInfoPageUIs.ITEM_TO_SCROLL);
		waitForElementClickable(AdminCustomerInfoPageUIs.EDIT_BUTTON);
		clickToElementByJS(AdminCustomerInfoPageUIs.EDIT_BUTTON);
		return PageGeneraterManager.getEditAddressPage(driver);
	}

	public AdminCustomersPageObject clickToCutomerPage() {
		waitForElementClickable(AdminCustomerInfoPageUIs.CUSTOMERS_PAGE);
		clickToElement(AdminCustomerInfoPageUIs.CUSTOMERS_PAGE);
		sleepInSecond(1);
		return PageGeneraterManager.getCustomersPage(driver);
	}

	public void clickToDeleteButton() {
		waitForElementClickable(AdminCustomerInfoPageUIs.DELETE_BUTTON);
		clickToElementByJS(AdminCustomerInfoPageUIs.DELETE_BUTTON);
		sleepInSecond(3);
	}

	public void acceptToDeleteAddressInfo() {
		acceptAlert();
	}

	public boolean AddressInfoIsDeleted() {
		waitForElementVisiable(AdminCustomerInfoPageUIs.NO_DATA_AVAILABLE);
		return isElementDisplayed(AdminCustomerInfoPageUIs.NO_DATA_AVAILABLE);
	}

	public boolean isAddressInAddressInfoDisplay(String addressInfo) {
		waitForElementVisiable(AdminCustomerInfoPageUIs.DYNAMIC_ADDRESS_IN_ADDRESS_INFO, addressInfo);
		return isElementDisplayed(AdminCustomerInfoPageUIs.DYNAMIC_ADDRESS_IN_ADDRESS_INFO, addressInfo);
	}

}
