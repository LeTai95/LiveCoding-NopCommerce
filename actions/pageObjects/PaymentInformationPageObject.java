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

}
