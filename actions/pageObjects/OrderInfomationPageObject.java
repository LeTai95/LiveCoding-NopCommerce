package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserConfirmOrderPageUIs;
import pageUI.nopcommerce.user.UserOrderInfomationPageUIs;

public class OrderInfomationPageObject extends BasePage {
	WebDriver driver;

	public OrderInfomationPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String isOrderNumberDisplayed() {
		waitForElementVisiable(UserOrderInfomationPageUIs.ORDER_NUMBER);
		String[] orderNumberArray = getElementText(UserOrderInfomationPageUIs.ORDER_NUMBER).split(" ");
		String orderNumber = orderNumberArray[1].replace("#", "");
		return orderNumber;
	}

	public boolean isOrderInfoDisplayedByID(String orderInfo) {
		waitForElementVisiable(UserOrderInfomationPageUIs.DYNAMIC_ORDER_INFO, orderInfo);
		return isElementDisplayed(UserOrderInfomationPageUIs.DYNAMIC_ORDER_INFO, orderInfo);
	}

	public boolean isConfirmOrderInfoDisplay(String className, String textValue) {
		waitForElementVisiable(UserOrderInfomationPageUIs.DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT, className,
				textValue);
		return isElementDisplayed(UserOrderInfomationPageUIs.DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT, className,
				textValue);
	}

	public boolean isMethodInfoDisplayed(String methodName, String textValue) {
		waitForElementVisiable(UserOrderInfomationPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE, methodName,
				textValue);
		return isElementDisplayed(UserOrderInfomationPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE,
				methodName, textValue);
	}

	public boolean isPaymentInfoDisplayed(String shippingName, String textValue) {
		waitForElementVisiable(UserOrderInfomationPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE,
				shippingName, textValue);
		return isElementDisplayed(UserOrderInfomationPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE,
				shippingName, textValue);
	}

	public boolean isProductInfoDisplayedByRowNumberAndColumnName(String rowNumber, String columnName,
			String productInfo) {
		int columnIndex = getElementSize(UserOrderInfomationPageUIs.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisiable(UserOrderInfomationPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
		return isElementDisplayed(UserOrderInfomationPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
	}

	public boolean isProductNameDisplayedByRowNumberAndColumnName(String rowNumber, String columnName,
			String productInfo) {
		int columnIndex = getElementSize(UserOrderInfomationPageUIs.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisiable(UserOrderInfomationPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
		return isElementDisplayed(UserOrderInfomationPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
	}

	public boolean isPriceInfoDisplayedByRowNameAndColumn(String rowName, String columnNumber, String priceValue) {
		int rowIndex = getElementSize(UserConfirmOrderPageUIs.ROW_INDEX_BY_ROW_NAME, rowName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER,
				String.valueOf(rowIndex), columnNumber, priceValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER,
				String.valueOf(rowIndex), columnNumber, priceValue);
	}

	public boolean isTotalPriceInfoDisplayedByRowNameAndColumn(String rowName, String columnNumber, String priceValue) {
		int rowIndex = getElementSize(UserConfirmOrderPageUIs.ROW_INDEX_BY_ROW_NAME, rowName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.TOTAL_ORDER_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME,
				String.valueOf(rowIndex), columnNumber, priceValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.TOTAL_ORDER_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME,
				String.valueOf(rowIndex), columnNumber, priceValue);
	}

	public HomePageObject navigateToHomePage() {
		waitForElementVisiable(UserConfirmOrderPageUIs.HEADER_LOGO);
		clickToElement(UserConfirmOrderPageUIs.HEADER_LOGO);
		return PageGeneraterManager.getHomePage(driver);
	}

	public MyAccountPageObject clickToMyAccount() {
		waitForElementVisiable(UserConfirmOrderPageUIs.MY_ACCOUNT_LINK);
		clickToElement(UserConfirmOrderPageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(UserConfirmOrderPageUIs.CONFIRM_BUTTON);
		clickToElement(UserConfirmOrderPageUIs.CONFIRM_BUTTON);
	}

}
