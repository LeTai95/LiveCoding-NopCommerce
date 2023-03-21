package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserLoginPageUIs;

public class LoginPageObject extends BasePage {
	WebDriver driver;
	public LoginPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public HomePageObject clickToLoginButton() {
		waitForElementClickable(driver, UserLoginPageUIs.LOGIN_BUTTON);
		clickToElement(driver, UserLoginPageUIs.LOGIN_BUTTON);
		return PageGeneraterManager.getHomePage(driver);
	}
	public void enterToEmailTextbox(String value) {
		waitForElementVisiable(driver, UserLoginPageUIs.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUIs.EMAIL_TEXTBOX, value);
	}
	public void enterToPasswordTextbox(String value) {
		waitForElementVisiable(driver, UserLoginPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserLoginPageUIs.PASSWORD_TEXTBOX, value);
	}

	public boolean isErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserLoginPageUIs.ERROR_MESSAGE);
		return isElementDisplayed(driver, UserLoginPageUIs.ERROR_MESSAGE);
	}
	public boolean isInvalidEmailErrorMessageDisplayed() {
		// TODO Auto-generated method stub
		return false;
	}
	public boolean isUnregistedEmailErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
		return isElementDisplayed(driver, UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
	}
	public boolean isEmptyPasswordErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
		return isElementDisplayed(driver, UserLoginPageUIs.ERROR_EMAIL_MESSAGE);
	}

	
}
