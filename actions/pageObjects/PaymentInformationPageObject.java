package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserPaymentInformationPageUIs;

public class PaymentInformationPageObject extends BasePage {
	WebDriver driver;
	public PaymentInformationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public boolean isPaymentInformationDisplayed() {
		waitForAllElementVisiable(UserPaymentInformationPageUIs.CHECKOUT_PAYMENT_INFO);
		return isElementDisplayed(UserPaymentInformationPageUIs.CHECKOUT_PAYMENT_INFO);
	}
	public ConfirmOrderPageObject clickToContinueButton() {
		waitForElementClickable(UserPaymentInformationPageUIs.CONTINUE_BUTTON);
		clickToElement(UserPaymentInformationPageUIs.CONTINUE_BUTTON);
		return PageGeneraterManager.getConfirmOrderPage(driver);
	}
	public void selectItemByDropdownID(String dropdownID, String textValue) {
		waitForElementClickable(UserPaymentInformationPageUIs.DYNAMIC_DROPDOWN_BY_ID, dropdownID);
		selectItemInDefaultDropdown(UserPaymentInformationPageUIs.DYNAMIC_DROPDOWN_BY_ID, textValue, dropdownID);
	}
	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(UserPaymentInformationPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(UserPaymentInformationPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxID);
	}

}
