package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserHomePageUIs;
import pageUI.nopcommerce.user.UserWishlistPageUIs;

public class WishlistPageObject extends BasePage {
	WebDriver driver;

	public WishlistPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public boolean getProductNameByRowNumberAndColumnName(String rowNumber, String columnName, String productName) {
		int columnIndex = getElementSize(UserWishlistPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementVisiable(UserWishlistPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
		return isElementDisplayed(UserWishlistPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
	}

	public void checkToCheckboxByRowNumberAndColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(UserWishlistPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(UserWishlistPageUIs.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		clickToElement(UserWishlistPageUIs.CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}

	public ShoppingCartPageObject clickToAddToCartButton() {
		waitForElementClickable(UserWishlistPageUIs.ADD_TO_CART_BUTTON);
		clickToElement(UserWishlistPageUIs.ADD_TO_CART_BUTTON);
		return PageGeneraterManager.getShoppingCartPage(driver);
	}

	public HomePageObject navigateToHomePage() {
		waitForElementClickable(UserWishlistPageUIs.HEADER_LOGO);
		clickToElement(UserWishlistPageUIs.HEADER_LOGO);
		return PageGeneraterManager.getHomePage(driver);
	}

	public boolean isWishlistSharingLinkDisplayed() {
		waitForElementVisiable(UserWishlistPageUIs.SHARING_LINK);
		return isElementDisplayed(UserWishlistPageUIs.SHARING_LINK);
	}

	public boolean isProductNotDisplayedByRowNumberAndColumnName(String rowNumber, String columnName,
			String productName) {
		int columnIndex = getElementSize(UserWishlistPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementInvisiable(UserWishlistPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
		return isElementUndisplayed(UserWishlistPageUIs.PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex), productName);
	}

	public void clickToRemoveButton(String rowNumber, String columnName) {
		int columnIndex = getElementSize(UserWishlistPageUIs.COLUMN_INDEX_BY_NAME, columnName) + 1;
		waitForElementClickable(UserWishlistPageUIs.REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		clickToElement(UserWishlistPageUIs.REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}
}
