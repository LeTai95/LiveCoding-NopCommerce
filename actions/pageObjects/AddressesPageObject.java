package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserAddressesPageUIs;

public class AddressesPageObject extends BasePage {
	WebDriver driver;

	public AddressesPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void clickToAddNewButton() {
		waitForElementClickable(UserAddressesPageUIs.ADD_NEW_BUTTON);
		clickToElement(UserAddressesPageUIs.ADD_NEW_BUTTON);
	}

	public void enterToTextboxByName(String textboxName, String textValue) {
		waitForElementVisiable(UserAddressesPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxName);
		sendkeyToElement(UserAddressesPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxName);
	}

	public void setlectItemByID(String dropdownName, String itemText) {
		waitForElementVisiable(UserAddressesPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownName);
		selectItemInDefaultDropdown(UserAddressesPageUIs.DYNAMIC_DROPDOWN_BY_ID, itemText, dropdownName);
	}

	public void clickToSaveButton() {
		waitForElementClickable(UserAddressesPageUIs.SAVE_BUTTON);
		clickToElement(UserAddressesPageUIs.SAVE_BUTTON);
	}

	public ChangePasswordPageObject navigateToChangePasswordPage() {
		waitForElementVisiable(UserAddressesPageUIs.CHANGE_PASSWORD_LINK);
		clickToElement(UserAddressesPageUIs.CHANGE_PASSWORD_LINK);
		return PageGeneraterManager.getChangePasswordPage(driver);
	}

	public boolean isAddedAddressesSuccessMessageDisplayed() {
		waitForElementVisiable(UserAddressesPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(UserAddressesPageUIs.SUCCESS_MESSAGE);
	}
}
