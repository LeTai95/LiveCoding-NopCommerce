package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserShoppingCartPageUIs;

public class ShoppingCartPageObject extends BasePage {
	WebDriver driver;

	public ShoppingCartPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean isProductAddedToCartSuccess(String rowNumber, String columnName, String productName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserShoppingCartPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
		return isElementDisplayed(UserShoppingCartPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
	}

	public WishlistPageObject clickToWishlistLink() {
		waitForElementVisiable(UserShoppingCartPageUIs.WISHLIST_LINK);
		clickToElement(UserShoppingCartPageUIs.WISHLIST_LINK);
		return PageGeneraterManager.getWishlistPage(driver);
	}

	public String isProductInfoDisplayedInShoppingCart(String rowNumber, String columnName, String productName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserShoppingCartPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
		return getElementText(UserShoppingCartPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
	}

	public String isProductPriceDisplayedInShoppingCart(String rowNumber, String columnName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserShoppingCartPageUIs.PRODUCT_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		return getElementText(UserShoppingCartPageUIs.PRODUCT_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}

	public ProductInfoPageObject clickToEditByRowNumberAndColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserShoppingCartPageUIs.EDIT_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		clickToElement(UserShoppingCartPageUIs.EDIT_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		return PageGeneraterManager.getProductInfoPage(driver);
	}

	public void clickToRemoveButtonByRowNumberAndColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(UserShoppingCartPageUIs.REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		clickToElement(UserShoppingCartPageUIs.REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}

	public boolean isProductNotDisplayed(String rowNumber, String columnName, String productName) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementInvisiable(UserShoppingCartPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
		return isElementUndisplayed(UserShoppingCartPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
	}

	public boolean isShoppingCartMessageDisplayed() {
		waitForElementVisiable(UserShoppingCartPageUIs.SHOPPING_CART_MESSAGE);
		return isElementDisplayed(UserShoppingCartPageUIs.SHOPPING_CART_MESSAGE);
	}

	public HomePageObject navigateToHomePage() {
		waitForElementVisiable(UserShoppingCartPageUIs.HEADER_LOGO);
		clickToElement(UserShoppingCartPageUIs.HEADER_LOGO);
		return PageGeneraterManager.getHomePage(driver);
	}

	public void enterToQtyByRowNumberAndColumnNumber(String rowNumber, String columnName, String textValue) {
		int columnIndex = getElementSize(UserShoppingCartPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserShoppingCartPageUIs.QTY_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		sendkeyToElement(UserShoppingCartPageUIs.QTY_BY_ROW_NUMBER_AND_COLUMN_NAME, textValue, rowNumber,
				String.valueOf(columnIndex));
	}

	public void clickToUpdateShoppingCartButton() {
		waitForElementClickable(UserShoppingCartPageUIs.UPDATE_SHOPPING_CART);
		clickToElement(UserShoppingCartPageUIs.UPDATE_SHOPPING_CART);
	}




}
