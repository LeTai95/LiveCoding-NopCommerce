package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserCompareProductListPageUIs;
import pageUI.nopcommerce.user.UserWishlistPageUIs;

public class CompareProductListPageObject extends BasePage {
	WebDriver driver;

	public CompareProductListPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isRemoveButtonDisplayedByProductNameAndRowNumber(String productName, String rowNumber) {
		waitForElementVisiable(UserCompareProductListPageUIs.REMOVE_BUTTON_BY_PRODUCTNAME_AND_ROW_NUMBER, productName,
				rowNumber);
		return isElementDisplayed(UserCompareProductListPageUIs.REMOVE_BUTTON_BY_PRODUCTNAME_AND_ROW_NUMBER,
				productName, rowNumber);
	}

	public boolean isProductNameDisplay(String productName) {
		waitForElementVisiable(UserCompareProductListPageUIs.DYNAMIC_PRODUCT_NAME, productName);
		return isElementDisplayed(UserCompareProductListPageUIs.DYNAMIC_PRODUCT_NAME, productName);
	}

	public boolean isPriceDisplayedByProductNameAndRowNumber(String productName, String rowNumber) {
		waitForElementVisiable(UserCompareProductListPageUIs.PRICE_BY_PRODUCTNAME_AND_ROW_NUMBER, productName, rowNumber);
		return isElementDisplayed(UserCompareProductListPageUIs.PRICE_BY_PRODUCTNAME_AND_ROW_NUMBER, productName, rowNumber);
	}

	public boolean isClearListButtonDisplayed() {
		waitForElementVisiable(UserCompareProductListPageUIs.CLEAR_BUTTON);
		return isElementDisplayed(UserCompareProductListPageUIs.CLEAR_BUTTON);
	}

	public void clickToClearListButton() {
		waitForElementClickable(UserCompareProductListPageUIs.CLEAR_BUTTON);
		clickToElement(UserCompareProductListPageUIs.CLEAR_BUTTON);
	}

	public boolean isClearMessageDisplayed() {
		waitForElementVisiable(UserCompareProductListPageUIs.CLEAR_MESSAGE);
		return isElementDisplayed(UserCompareProductListPageUIs.CLEAR_MESSAGE);
	}

	public boolean isProductNotDisplayedByProductName(String productName) {
		waitForElementInvisiable(UserCompareProductListPageUIs.DYNAMIC_PRODUCT_NAME, productName);
		return isElementUndisplayed(UserCompareProductListPageUIs.DYNAMIC_PRODUCT_NAME, productName);
	}

	public HomePageObject navigateToHomePage() {
		waitForElementClickable(UserCompareProductListPageUIs.HEADER_LOGO);
		clickToElement(UserCompareProductListPageUIs.HEADER_LOGO);
		return PageGeneraterManager.getHomePage(driver);
	}

}
