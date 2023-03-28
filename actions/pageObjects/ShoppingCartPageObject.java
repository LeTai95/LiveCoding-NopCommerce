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

}
