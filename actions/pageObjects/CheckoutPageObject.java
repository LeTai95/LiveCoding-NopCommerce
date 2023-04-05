package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserCheckoutPageUIs;

public class CheckoutPageObject extends BasePage {
	WebDriver driver;
	public CheckoutPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void checkToRadioButtonByName(String radioCheckboxName) {
		waitForElementClickable(UserCheckoutPageUIs.DYNAMIC_RADIO_CHECKBOX_BY_NAME, radioCheckboxName);
		checkToDefautCheckboxRadio(UserCheckoutPageUIs.DYNAMIC_RADIO_CHECKBOX_BY_NAME, radioCheckboxName);
	}
	public PaymentMethodPageObject clickToContinueButton() {
		waitForElementClickable(UserCheckoutPageUIs.CONTINUE_BUTTON);
		clickToElement(UserCheckoutPageUIs.CONTINUE_BUTTON);
		return PageGeneraterManager.getPaymentMethodPage(driver);
	}

}
