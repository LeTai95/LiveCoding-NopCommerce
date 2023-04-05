package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserPaymentMethodPageUIs;

public class PaymentMethodPageObject extends BasePage {
	WebDriver driver;
	public PaymentMethodPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void checkToRadioButtonByName(String radioCheckboxName) {
		waitForElementClickable(UserPaymentMethodPageUIs.DYNAMIC_RADIO_CHECKBOX_BY_NAME, radioCheckboxName);
		checkToDefautCheckboxRadio(UserPaymentMethodPageUIs.DYNAMIC_RADIO_CHECKBOX_BY_NAME, radioCheckboxName);
	}
	public PaymentInformationPageObject clickToContinueButton() {
		waitForElementClickable(UserPaymentMethodPageUIs.CONTINUE_BUTTON);
		clickToElement(UserPaymentMethodPageUIs.CONTINUE_BUTTON);
		return PageGeneraterManager.getPaymentInformationPage(driver);
	}

}
