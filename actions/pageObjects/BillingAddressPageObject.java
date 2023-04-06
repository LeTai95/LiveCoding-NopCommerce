package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserBillingAddressPageUIs;

public class BillingAddressPageObject extends BasePage {
	WebDriver driver;
	public BillingAddressPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(UserBillingAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textboxID);
		sendkeyToElement(UserBillingAddressPageUIs.DYNAMIC_TEXTBOX_BY_ID, textValue, textboxID);
	}
	public void selectItemByDropdownIDAndTextItem(String textboxID, String countryName) {
		waitForElementVisiable(UserBillingAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, textboxID);
		selectItemInDefaultDropdown(UserBillingAddressPageUIs.DYNAMIC_DROPDOWN_BY_ID, countryName, textboxID);
	}
	public CheckoutPageObject clickToContinueButton() {
		waitForElementClickable(UserBillingAddressPageUIs.CONTINUE_BUTTON);
		clickToElement(UserBillingAddressPageUIs.CONTINUE_BUTTON);
		return PageGeneraterManager.getCheckoutPage(driver);
	}
	public void clickToEditButton() {
		waitForElementClickable(UserBillingAddressPageUIs.EDIT_BUTTON);
		clickToElement(UserBillingAddressPageUIs.EDIT_BUTTON);
	}

}
