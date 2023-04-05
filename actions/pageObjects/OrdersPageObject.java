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
	public OrderInfomationPageObject clickToDetailsButton() {
		waitForElementClickable(UserOrdersPageUIs.DETAILS_BUTTON);
		clickToElement(UserOrdersPageUIs.DETAILS_BUTTON);
		return PageGeneraterManager.getOrderInfomationPage(driver);
	}

}
