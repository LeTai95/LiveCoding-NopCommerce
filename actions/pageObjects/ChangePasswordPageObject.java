package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserChangePasswordPageUIs;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToTextboxByID(String textboxName, String textValue) {
		waitForElementVisiable(driver, UserChangePasswordPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxName);
		sendkeyToElement(driver, UserChangePasswordPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxName);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(driver, UserChangePasswordPageUIs.CHANGE_PASSWORD_BUTTON);
		clickToElement(driver, UserChangePasswordPageUIs.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isChangedPasswordSuccessfullyDisplayed() {
		waitForElementVisiable(driver, UserChangePasswordPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserChangePasswordPageUIs.SUCCESS_MESSAGE);
	}

	public void closeChangedPasswordSuccessfullyMessage() {
		waitForElementClickable(driver, UserChangePasswordPageUIs.SUCCESS_MESSAGE_CLOSE_BUTTON);
		clickToElement(driver, UserChangePasswordPageUIs.SUCCESS_MESSAGE_CLOSE_BUTTON);
		sleepInSecond(1);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(driver, UserChangePasswordPageUIs.LOGOUT_LINK);
		clickToElement(driver, UserChangePasswordPageUIs.LOGOUT_LINK);
		return PageGeneraterManager.getHomePage(driver);
	}
	

}
