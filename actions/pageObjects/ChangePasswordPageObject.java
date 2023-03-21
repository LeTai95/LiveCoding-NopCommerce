package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserChangePasswordPageUIs;

public class ChangePasswordPageObject extends BasePage {
	WebDriver driver;

	public ChangePasswordPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToTextboxByID(String textboxName, String textValue) {
		waitForElementVisiable(UserChangePasswordPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxName);
		sendkeyToElement(UserChangePasswordPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxName);
	}

	public void clickToChangePasswordButton() {
		waitForElementClickable(UserChangePasswordPageUIs.CHANGE_PASSWORD_BUTTON);
		clickToElement(UserChangePasswordPageUIs.CHANGE_PASSWORD_BUTTON);
	}

	public boolean isChangedPasswordSuccessfullyDisplayed() {
		waitForElementVisiable(UserChangePasswordPageUIs.SUCCESS_MESSAGE);
		return isElementDisplayed(UserChangePasswordPageUIs.SUCCESS_MESSAGE);
	}

	public void closeChangedPasswordSuccessfullyMessage() {
		waitForElementClickable(UserChangePasswordPageUIs.SUCCESS_MESSAGE_CLOSE_BUTTON);
		clickToElement(UserChangePasswordPageUIs.SUCCESS_MESSAGE_CLOSE_BUTTON);
		sleepInSecond(1);
	}

	public HomePageObject clickToLogoutLink() {
		waitForElementClickable(UserChangePasswordPageUIs.LOGOUT_LINK);
		clickToElement(UserChangePasswordPageUIs.LOGOUT_LINK);
		return PageGeneraterManager.getHomePage(driver);
	}
	

}
