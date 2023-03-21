package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserLoginPageUIs;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(UserLoginPageUIs.LOGIN_BUTTON);
		clickToElement(UserLoginPageUIs.LOGIN_BUTTON);
		return PageGeneraterManager.getHomePage(driver);
	}
	public void enterToEmailTextbox(String value) {
		waitForElementVisiable(UserLoginPageUIs.EMAIL_TEXTBOX);
		sendkeyToElement(UserLoginPageUIs.EMAIL_TEXTBOX, value);
	}
	public void enterToPasswordTextbox(String value) {
		waitForElementVisiable(UserLoginPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(UserLoginPageUIs.PASSWORD_TEXTBOX, value);
	}

	public boolean isErrorMessageDisplayed() {
		waitForElementVisiable(UserLoginPageUIs.ERROR_MESSAGE);
		return isElementDisplayed(UserLoginPageUIs.ERROR_MESSAGE);
	}
	public boolean isInvalidEmailErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isUnregistedEmailErrorMessageDisplayed() {
		waitForElementVisiable(UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
		return isElementDisplayed(UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
	}
	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElementVisiable(UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
		return isElementDisplayed(UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
	}

	
}
