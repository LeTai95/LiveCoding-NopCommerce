package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserSearchPageUIs;

public class SearchPageObject extends BasePage {
	WebDriver driver;
	public SearchPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickToSearchButton() {
		waitForElementClickable(UserSearchPageUIs.SEARCH_BUTTON);
		clickToElement(UserSearchPageUIs.SEARCH_BUTTON);
	}
	public String isErrorMessageDisplayed() {
		waitForElementVisiable(UserSearchPageUIs.ERROR_MESSAGE);
		return getElementText(UserSearchPageUIs.ERROR_MESSAGE);
	}
	public void enterToSearchTextbox(String textValue) {
		waitForElementVisiable(UserSearchPageUIs.SEARCH_TEXTBOX);
		sendkeyToElement(UserSearchPageUIs.SEARCH_TEXTBOX, textValue);
		
	}
	public String isProductNotFoundErrorMessageDisplayed() {
		waitForElementVisiable(UserSearchPageUIs.PRODUCT_NOT_ERROR_MESSAGE);
		return getElementText(UserSearchPageUIs.PRODUCT_NOT_ERROR_MESSAGE);
	}
	public boolean isProductDisplayedByText(String productName) {
		waitForElementVisiable(UserSearchPageUIs.DYNAMIC_PRODUCT_BY_NAME, productName);
		return isElementDisplayed(UserSearchPageUIs.DYNAMIC_PRODUCT_BY_NAME, productName);
	}
	public void checkToCheckboxByName(String checkboxName) {
		waitForElementClickable(UserSearchPageUIs.DYNAMIC_CHECKBOX_BY_NAME, checkboxName);
		checkToDefautCheckboxRadio(UserSearchPageUIs.DYNAMIC_CHECKBOX_BY_NAME, checkboxName);
	}
	public void selectItemFromDropdownByName(String dropdownName, String textItem) {
		waitForElementClickable(UserSearchPageUIs.DYNAMIC_DROPDOWN_BY_NAME, dropdownName);
		selectItemInDefaultDropdown(UserSearchPageUIs.DYNAMIC_DROPDOWN_BY_NAME, textItem, dropdownName);
	}

}
