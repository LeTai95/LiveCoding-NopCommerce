package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserOrdersPageUIs;

public class OrdersPageObject extends BasePage {
	WebDriver driver;
	public OrdersPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public String isOrderNumberDisplayed() {
		waitForElementVisiable(UserOrdersPageUIs.ORDER_NUMBER);
		String[] orderNumberArray = getElementText(UserOrdersPageUIs.ORDER_NUMBER).split(" ");
		String orderNumber = orderNumberArray[2];
		return orderNumber;
	}
	public OrderInfomationPageObject clickToDetailsButton(String orderNumberInHomePage) {
		waitForElementClickable(UserOrdersPageUIs.DETAILS_BUTTON, orderNumberInHomePage);
		clickToElement(UserOrdersPageUIs.DETAILS_BUTTON, orderNumberInHomePage);
		return PageGeneraterManager.getOrderInfomationPage(driver);
	}
	public ShoppingCartPageObject clickToReOrderButton() {
		waitForElementClickable(UserOrdersPageUIs.RE_ORDER_BUTTON);
		clickToElement(UserOrdersPageUIs.RE_ORDER_BUTTON);
		return PageGeneraterManager.getShoppingCartPage(driver);
	}

}
