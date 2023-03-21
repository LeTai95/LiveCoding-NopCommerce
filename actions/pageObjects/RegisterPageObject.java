package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserRegisterPageUIs;

public class RegisterPageObject extends BasePage {
	WebDriver driver;
	public RegisterPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void clickToRegisterButton() {
		waitForElementClickable(UserRegisterPageUIs.REGISTER_BUTTON);
		clickToElement(UserRegisterPageUIs.REGISTER_BUTTON);
	}
	public boolean isFirstnameErrorMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.FIRSTNAME_ERROR_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.FIRSTNAME_ERROR_MESSAGE);
	}
	public boolean isLastnameErrorMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.LASTNAME_ERROR_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.LASTNAME_ERROR_MESSAGE);
	}
	public boolean isPasswordErrorMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.PASSWORD_ERROR_MESSAGE);
	}
	public boolean isConfirmPasswordErrorMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.CONFIRM_PASSWORD_ERROR_MESSAGE);
	}
	public boolean isEmailErrorMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.EMAIL_ERROR_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.EMAIL_ERROR_MESSAGE);
	}
	public void enterToFirstnameTextbox(String firstName) {
		waitForElementVisiable(UserRegisterPageUIs.FIRSTNAME_TEXTBOX);
		sendkeyToElement(UserRegisterPageUIs.FIRSTNAME_TEXTBOX, firstName);
	}
	public void enterToLastnameTextbox(String lastName) {
		waitForElementVisiable(UserRegisterPageUIs.LATNAME_TEXTBOX);
		sendkeyToElement(UserRegisterPageUIs.LATNAME_TEXTBOX, lastName);
	}
	public void enterToEmailTextbox(String invalidEmail) {
		waitForElementVisiable(UserRegisterPageUIs.EMAIL_TEXTBOX);
		sendkeyToElement(UserRegisterPageUIs.EMAIL_TEXTBOX, invalidEmail);
	}
	public void enterToPasswordTextbox(String password) {
		waitForElementVisiable(UserRegisterPageUIs.PASSWORD_TEXTBOX);
		sendkeyToElement(UserRegisterPageUIs.PASSWORD_TEXTBOX, password);
	}
	public void enterToConfirmPasswordTextbox(String password) {
		waitForElementVisiable(UserRegisterPageUIs.CONFIRM_PASSWORD_TEXTBOX);
		sendkeyToElement(UserRegisterPageUIs.CONFIRM_PASSWORD_TEXTBOX, password);
	}
	public boolean isWrongEmailMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.WRONG_EMAIL_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.WRONG_EMAIL_MESSAGE);
	}
	public boolean isRegisterSuccessMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.REGISTER_SUCCESS_MESSAGE);
	}
	public boolean isExstingEmailMessageDisplayed() {
		waitForElementVisiable(UserRegisterPageUIs.EXSTING_EMAIL_MESSAGE);
		return isElementDisplayed(UserRegisterPageUIs.EXSTING_EMAIL_MESSAGE);
	}
	
}
