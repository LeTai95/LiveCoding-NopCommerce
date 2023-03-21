package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserMyAccountPageUIs;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void checkToCheckBoxByName(String radioName) {
		waitForElementClickable(driver, UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
		checkToDefautCheckboxRadio(driver, UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
	}

	public void enterToTextboxByID(String textboxID, String textValue) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, textValue, textboxID);
	}

	public void selectItemByName(String dropdownName, String itemValue) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.DROPDOWN_ITEM_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(driver, UserMyAccountPageUIs.DROPDOWN_ITEM_BY_NAME, itemValue, dropdownName);
	}

	public void clickToSaveButton() {
		waitForElementVisiable(driver, UserMyAccountPageUIs.SAVE_BUTTON);
		clickToElement(driver, UserMyAccountPageUIs.SAVE_BUTTON);
	}

	public boolean isFemaleRadioIsChecked(String radioName) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
		return isElementSelected(driver, UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
	}

	public String getFirstnameValue(String firstName) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, firstName);
		return getElementAttribute(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", firstName);
	}

	public String getLastnameValue(String lastName) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, lastName);
		return getElementAttribute(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", lastName);
	}

	public String getCompanyNameValue(String companyName) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, companyName);
		return getElementAttribute(driver, UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", companyName);
	}

	public String getTextFromDropdownByName(String dropdownName, String textValue) {
		waitForElementVisiable(driver, UserMyAccountPageUIs.DROPDOWN_SELECTED_ITEM_BY_NAME, dropdownName, textValue);
		return getElementText(driver, UserMyAccountPageUIs.DROPDOWN_SELECTED_ITEM_BY_NAME, dropdownName, textValue);
	}

	public AddressesPageObject navigateToAddressPage() {
		waitForElementClickable(driver, UserMyAccountPageUIs.ADDRESSES_LINK);
		clickToElement(driver, UserMyAccountPageUIs.ADDRESSES_LINK);
		return PageGeneraterManager.getAddressesPage(driver);
	}

	public MyProductReviewsPageObject navigateToMyProductReviewLink() {
		waitForElementClickable(driver, UserMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(driver, UserMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneraterManager.getMyProductReviewsPage(driver);
	}
}
