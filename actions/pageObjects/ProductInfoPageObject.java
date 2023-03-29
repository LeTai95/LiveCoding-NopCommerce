package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserProductInfoPageUIs;

public class ProductInfoPageObject extends BasePage {
	WebDriver driver;

	public ProductInfoPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public ProductReviewPageObject clickToAddYourReviewLink() {
		waitForElementVisiable(UserProductInfoPageUIs.ADD_YOUR_REVIEW_LINK);
		clickToElement(UserProductInfoPageUIs.ADD_YOUR_REVIEW_LINK);
		return PageGeneraterManager.getProductReviewPage(driver);
	}

	public void selectItemInDropdownByTextItem(String textItem) {
		waitForElementPresence(UserProductInfoPageUIs.DYNAMIC_DROPDOWN_BY_TEXT_ITEM, textItem);
		selectItemInDefaultDropdown(UserProductInfoPageUIs.DYNAMIC_DROPDOWN_BY_TEXT_ITEM, textItem, textItem);
	}

	public void checkToCheckboxByName(String checkboxName) {
		waitForElementClickable(UserProductInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_NAME, checkboxName);
		checkToDefautCheckboxRadio(UserProductInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_NAME, checkboxName);
	}

	public void clickToAddToCartButton() {
		waitForElementClickable(UserProductInfoPageUIs.ADD_TO_CART_BUTTON);
		clickToElement(UserProductInfoPageUIs.ADD_TO_CART_BUTTON);
	}

	public boolean isProductAddedToShoppingCartMessageDisplayed() {
		waitForElementVisiable(UserProductInfoPageUIs.ADDED_TO_CART_SUCCESS_MESSAGE);
		return isElementDisplayed(UserProductInfoPageUIs.ADDED_TO_CART_SUCCESS_MESSAGE);
	}

	public void closeProductAddedToShoppingCartMessage() {
		waitForElementClickable(UserProductInfoPageUIs.CLOSE_MESSAGE_ICON);
		clickToElement(UserProductInfoPageUIs.CLOSE_MESSAGE_ICON);
	
	}

	public ShoppingCartPageObject clickToShoppingCartLink() {
		waitForElementInvisiable(UserProductInfoPageUIs.CLOSE_MESSAGE_ICON);
		clickToElement(UserProductInfoPageUIs.SHOPPING_CART_LINK);
		return PageGeneraterManager.getShoppingCartPage(driver);
	}

	public void uncheckToCheckboxByName(String checkboxName) {
		waitForElementClickable(UserProductInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_NAME, checkboxName);
		unheckToDefautCheckbox(UserProductInfoPageUIs.DYNAMIC_CHECKBOX_BY_CHECKBOX_NAME, checkboxName);
	}

	public void enterToProductNumber(String productNumber) {
		waitForElementVisiable(UserProductInfoPageUIs.PRODUCT_NUMBER);
		sendkeyToElement(UserProductInfoPageUIs.PRODUCT_NUMBER, productNumber);
	}

	public boolean isPriceDisplayTrue(String price) {
		waitForElementVisiable(UserProductInfoPageUIs.PRODUCT_PRICE, price);
		return isElementDisplayed(UserProductInfoPageUIs.PRODUCT_PRICE, price);
	}

	

}
