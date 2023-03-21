package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserAddressesPageUIs;

public class AddressesPageObject extends BasePage {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(driver, UserAddressesPageUIs.ADD_NEW_BUTTON);
		clickToElement(driver, UserAddressesPageUIs.ADD_NEW_BUTTON);
	}

	public void enterToTextboxByName(String textboxName, String textValue) {
		waitForElementVisiable(driver, UserAddressesPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxName);
		sendkeyToElement(driver, UserAddressesPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxName);
	}

	public void setlectItemByID(String dropdownName, String itemText) {
		waitForElementVisiable(driver, UserAddressesPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownName);
		selectItemInDefaultDropdown(driver, UserAddressesPageUIs.DYNAMIC_DROPDOWN_BY_ID, itemText, dropdownName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(driver, UserAddressesPageUIs.SAVE_BUTTON);
		clickToElement(driver, UserAddressesPageUIs.SAVE_BUTTON);
	}

	public ChangePasswordPageObject navigateToChangePasswordPage() {
		waitForElementVisiable(driver, UserAddressesPageUIs.CHANGE_PASSWORD_LINK);
		clickToElement(driver, UserAddressesPageUIs.CHANGE_PASSWORD_LINK);
		return PageGeneraterManager.getChangePasswordPage(driver);
	}

	public boolean isAddedAddressesSuccessMessageDisplayed() {
		waitForElementVisiable(driver, UserAddressesPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserAddressesPageUIs.SUCCESS_MESSAGE);
	}
}
