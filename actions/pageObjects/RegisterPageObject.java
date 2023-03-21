package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserRegisterPageUIs;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		waitForElementClickable(driver, UserRegisterPageUIs.REGISTER_BUTTON);
		clickToElement(driver, UserRegisterPageUIs.REGISTER_BUTTON);
	}
	public boolean isFirstnameErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.FIRSTNAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.FIRSTNAME_ERROR_MESSAGE);
	}
	public boolean isLastnameErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.LASTNAME_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.LASTNAME_ERROR_MESSAGE);
	}
	public boolean isPasswordErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.PASSWORD_ERROR_MESSAGE);
	}
	public boolean isConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	public boolean isEmailErrorMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.EMAIL_ERROR_MESSAGE);
	}
	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisiable(driver, UserRegisterPageUIs.FIRSTNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUIs.FIRSTNAME_TEXTBOX, firstName);
	}
	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisiable(driver, UserRegisterPageUIs.LATNAME_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUIs.LATNAME_TEXTBOX, lastName);
	}
	public void enterToEmailTextbox(String invalidEmail) {
		waitForElementVisiable(driver, UserRegisterPageUIs.EMAIL_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUIs.EMAIL_TEXTBOX, invalidEmail);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisiable(driver, UserRegisterPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUIs.PASSWORD_TEXTBOX, password);
	}
	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisiable(driver, UserRegisterPageUIs.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(driver, UserRegisterPageUIs.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	public boolean isWrongEmailMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.WRONG_EMAIL_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.WRONG_EMAIL_MESSAGE);
	}
	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
	}
	public boolean isExstingEmailMessageDisplayed() {
		waitForElementVisiable(driver, UserRegisterPageUIs.EXSTING_EMAIL_MESSAGE);
		return isElementDisplayed(driver, UserRegisterPageUIs.EXSTING_EMAIL_MESSAGE);
	}
	
}
