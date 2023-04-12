package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminProductInfoPageUIs;

public class AdminProductInfoPageObject extends BasePage {
	WebDriver driver;
	public AdminProductInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public String getProductName(String productName) {
		waitForElementVisiable(AdminProductInfoPageUIs.PRODUCT_NAME, productName);
		return getElementAttribute(AdminProductInfoPageUIs.PRODUCT_NAME, "value", productName);
	}
	public String getProductInforDescription1() {
		waitForElementVisiable(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_1);
		return getElementText(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_1);
	}
	public String getProductInforDescription2() {
		waitForElementVisiable(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_2);
		return getElementText(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_2);
	}
	public void clickToCustomersMenu() {
		switchToDefautContent();
		waitForElementClickable(AdminProductInfoPageUIs.CUSTOMERS_MENU);
		clickToElementByJS(AdminProductInfoPageUIs.CUSTOMERS_MENU);
	}
	public AdminCustomersPageObject clickToCustomersPage() {
		waitForElementClickable(AdminProductInfoPageUIs.CUSTOMERS_PAGE);
		clickToElement(AdminProductInfoPageUIs.CUSTOMERS_PAGE);
		sleepInSecond(1);
		return PageGeneraterManager.getCustomersPage(driver);
	}
	public void switchToProductInfoDescriptionIframe() {
		waitForElementVisiable(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_IFRAME);
		switchToFrameIframe(AdminProductInfoPageUIs.PRODUCT_DESCRIPTION_IFRAME);
	}
	public void swithToDefaultContent() {
		switchToDefautContent();
	}

}
