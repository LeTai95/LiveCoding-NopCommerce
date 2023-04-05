package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserMyAccountPageUIs;

public class MyAccountPageObject extends BasePage {
	WebDriver driver;

	public MyAccountPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void checkToCheckBoxByName(String radioName) {
		waitForElementClickable(UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
		checkToDefautCheckboxRadio(UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
	}

	public void enterToTextboxByID(String textboxID, String textValue) {
		waitForElementVisiable(UserMyAccountPageUIs.TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(UserMyAccountPageUIs.TEXTBOX_BY_ID, textValue, textboxID);
	}

	public void selectItemByName(String dropdownName, String itemValue) {
		waitForElementVisiable(UserMyAccountPageUIs.DROPDOWN_ITEM_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(UserMyAccountPageUIs.DROPDOWN_ITEM_BY_NAME, itemValue, dropdownName);
	}

	public void clickToSaveButton() {
		waitForElementVisiable(UserMyAccountPageUIs.SAVE_BUTTON);
		clickToElement(UserMyAccountPageUIs.SAVE_BUTTON);
	}

	public boolean isFemaleRadioIsChecked(String radioName) {
		waitForElementVisiable(UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
		return isElementSelected(UserMyAccountPageUIs.CHECK_BOX_BY_NAME, radioName);
	}

	public String getFirstnameValue(String firstName) {
		waitForElementVisiable(UserMyAccountPageUIs.TEXTBOX_BY_ID, firstName);
		return getElementAttribute(UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", firstName);
	}

	public String getLastnameValue(String lastName) {
		waitForElementVisiable(UserMyAccountPageUIs.TEXTBOX_BY_ID, lastName);
		return getElementAttribute(UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", lastName);
	}

	public String getCompanyNameValue(String companyName) {
		waitForElementVisiable(UserMyAccountPageUIs.TEXTBOX_BY_ID, companyName);
		return getElementAttribute(UserMyAccountPageUIs.TEXTBOX_BY_ID, "value", companyName);
	}

	public String getTextFromDropdownByName(String dropdownName, String textValue) {
		waitForElementVisiable(UserMyAccountPageUIs.DROPDOWN_SELECTED_ITEM_BY_NAME, dropdownName, textValue);
		return getElementText(UserMyAccountPageUIs.DROPDOWN_SELECTED_ITEM_BY_NAME, dropdownName, textValue);
	}

	public AddressesPageObject navigateToAddressPage() {
		waitForElementClickable(UserMyAccountPageUIs.ADDRESSES_LINK);
		clickToElement(UserMyAccountPageUIs.ADDRESSES_LINK);
		return PageGeneraterManager.getAddressesPage(driver);
	}

	public MyProductReviewsPageObject navigateToMyProductReviewLink() {
		waitForElementClickable(UserMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		clickToElement(UserMyAccountPageUIs.MY_PRODUCT_REVIEWS_LINK);
		return PageGeneraterManager.getMyProductReviewsPage(driver);
	}

	public OrdersPageObject clickToOrdersLink() {
		waitForElementClickable(UserMyAccountPageUIs.ORDERS_LINK);
		clickToElement(UserMyAccountPageUIs.ORDERS_LINK);
		return PageGeneraterManager.getOrdersPage(driver);
	}
}
