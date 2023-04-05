package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserConfirmOrderPageUIs;

public class ConfirmOrderPageObject extends BasePage {
	WebDriver driver;

	public ConfirmOrderPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isConfirmOrderInfoDisplay(String className, String textValue) {
		waitForElementVisiable(UserConfirmOrderPageUIs.DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT, className,
				textValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT, className,
				textValue);
	}

	public boolean isMethodInfoDisplayed(String methodName, String textValue) {
		waitForElementVisiable(UserConfirmOrderPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE, methodName,
				textValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE, methodName,
				textValue);
	}

	public boolean isProductInfoDisplayedByRowNumberAndColumnName(String rowNumber, String columnName,
			String productInfo) {
		int columnIndex = getElementSize(UserConfirmOrderPageUIs.PRODUCT_INFO_COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
		return isElementDisplayed(UserConfirmOrderPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
	}

	public boolean isProductNameDisplayedByRowNumberAndColumnName(String rowNumber, String columnName,
			String productInfo) {
		int columnIndex = getElementSize(UserConfirmOrderPageUIs.PRODUCT_INFO_COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
		return isElementDisplayed(UserConfirmOrderPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productInfo);
	}

	public boolean isPriceInfoDisplayedByRowNameAndColumn(String rowName, String columnNumber, String priceValue) {
		int rowIndex = getElementSize(UserConfirmOrderPageUIs.ROW_INDEX_BY_ROW_NAME, rowName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER,
				String.valueOf(rowIndex), columnNumber, priceValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER,
				String.valueOf(rowIndex), columnNumber, priceValue);
	}

	public void clickToConfirmButton() {
		waitForElementClickable(UserConfirmOrderPageUIs.CONFIRM_BUTTON);
		clickToElement(UserConfirmOrderPageUIs.CONFIRM_BUTTON);
	}

	public boolean isTotalPriceInfoDisplayedByRowNameAndColumn(String rowName, String columnNumber, String priceValue) {
		int rowIndex = getElementSize(UserConfirmOrderPageUIs.ROW_INDEX_BY_ROW_NAME, rowName) + 1;
		waitForElementVisiable(UserConfirmOrderPageUIs.TOTAL_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME,
				String.valueOf(rowIndex), columnNumber, priceValue);
		return isElementDisplayed(UserConfirmOrderPageUIs.TOTAL_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME,
				String.valueOf(rowIndex), columnNumber, priceValue);
	}

	public boolean isSuccessMessagePageTitleDisplayed() {
		waitForElementVisiable(UserConfirmOrderPageUIs.ORDER_SUCCESS_PAGE_TITLE);
		return isElementDisplayed(UserConfirmOrderPageUIs.ORDER_SUCCESS_PAGE_TITLE);
	}
	public boolean isSuccessMessageTitleDisplayed() {
		waitForElementVisiable(UserConfirmOrderPageUIs.ORDER_SUCCESS_TITLE);
		return isElementDisplayed(UserConfirmOrderPageUIs.ORDER_SUCCESS_TITLE);
	}
	
	public String getOrderNumberInHomePage() {
		waitForElementVisiable(UserConfirmOrderPageUIs.ORDER_NUMBER);
		String[] orderNumberText = getElementText(UserConfirmOrderPageUIs.ORDER_NUMBER).split(" ");	
		String orderNumberInHomePage = orderNumberText[2];;
		return orderNumberInHomePage;
	}
	public boolean isOrderNumberDisplayed() {
		waitForElementVisiable(UserConfirmOrderPageUIs.ORDER_NUMBER);
		return isElementDisplayed(UserConfirmOrderPageUIs.ORDER_NUMBER);
	}
	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementClickable(UserConfirmOrderPageUIs.MY_ACCOUNT_LINK);
		clickToElement(UserConfirmOrderPageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}

}
