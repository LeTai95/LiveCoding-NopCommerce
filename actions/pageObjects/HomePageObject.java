package pageObjects;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserHomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(UserHomePageUIs.REGISTER_LINK);
		clickToElement(UserHomePageUIs.REGISTER_LINK);
		return PageGeneraterManager.getRegisterPage(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitForElementVisiable(UserHomePageUIs.LOGIN_LINK);
		clickToElement(UserHomePageUIs.LOGIN_LINK);
		return PageGeneraterManager.getLoginPage(driver);
	}
	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementVisiable(UserHomePageUIs.MY_ACCOUNT_LINK);
		clickToElement(UserHomePageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisiable(UserHomePageUIs.MY_ACCOUNT_LINK);
		return isElementDisplayed(UserHomePageUIs.MY_ACCOUNT_LINK);
	}
	public void hoverToMenuByText(String value) {
		waitForElementVisiable(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
		hoverMouseToElement(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
	}
	public void clickToItemByText(String value) {
		waitForElementPresence(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
		clickToElement(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
	}
	public ProductInfoPageObject clickToProductByText(String textValue) {
		waitForElementClickable(UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, textValue);
		clickToElement(UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, textValue);
		return PageGeneraterManager.getProductInfoPage(driver);
	}
	public SearchPageObject clickToSearchLink() {
		waitForElementVisiable(UserHomePageUIs.SEARCH_LINK);
		clickToElement(UserHomePageUIs.SEARCH_LINK);
		return PageGeneraterManager.getSearchPage(driver);
	}
	public void selectItemFromSortbyDropdown(String textItem) {
		waitForElementClickable(UserHomePageUIs.SORTBY_DROPDOWN);
		selectItemInDefaultDropdown(UserHomePageUIs.SORTBY_DROPDOWN, textItem);
		sleepInSecond(2);
	}
	public boolean isProductNameSortByAscending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameText = getListWebElement(UserHomePageUIs.PRODUCT_TEXT_NAME);
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		ArrayList<String> productSortList = new ArrayList<String>();
		for (String product : productUIList) {
			productSortList.add(product);
		}
		Collections.sort(productSortList);
		return productSortList.equals(productUIList);
	}
	public boolean isProductNameSortByDescending() {
		ArrayList<String> productUIList = new ArrayList<String>();
		List<WebElement> productNameText = getListWebElement(UserHomePageUIs.PRODUCT_TEXT_NAME);
		for (WebElement productName : productNameText) {
			productUIList.add(productName.getText());
		}
		ArrayList<String> productSortName = new ArrayList<String>();
		for (String product : productUIList) {
			productSortName.add(product);
		}
		Collections.sort(productSortName);
		Collections.reverse(productSortName);
		return productSortName.equals(productUIList);
	}
	public boolean isProductPriceSortByAscending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(UserHomePageUIs.PRODUCT_PRICE_TEXT);
		for (WebElement productName : productPriceText) {
			productUIList.add(Float.parseFloat(productName.getText().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productSortPrice = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortPrice.add(product);
		}
		Collections.sort(productSortPrice);
		return productSortPrice.equals(productUIList);
	}
	public boolean isProductPriceSortByDescending() {
		ArrayList<Float> productUIList = new ArrayList<Float>();
		List<WebElement> productPriceText = getListWebElement(UserHomePageUIs.PRODUCT_PRICE_TEXT);
		for (WebElement productName : productPriceText) {
			productUIList.add(Float.parseFloat(productName.getText().replace("$", "").replace(",", "")));
		}
		ArrayList<Float> productSortPrice = new ArrayList<Float>();
		for (Float product : productUIList) {
			productSortPrice.add(product);
		}
		Collections.sort(productSortPrice);
		Collections.reverse(productSortPrice);
		return productSortPrice.equals(productUIList);
	}
	public void selectItemFromDisplayDropdown(String textItem) {
		waitForElementClickable(UserHomePageUIs.DISPLAY_DROPDOWN);
		selectItemInDefaultDropdown(UserHomePageUIs.DISPLAY_DROPDOWN, textItem);
		sleepInSecond(2);
	}
	public boolean isProductNumberDisplayedTrue(String productNumber) {
		waitForAllElementVisiable(UserHomePageUIs.PRODUCT_NAME_LIST);
		return getElementSize(UserHomePageUIs.PRODUCT_NAME_LIST) <= Integer.valueOf(productNumber);
	}
	public boolean isNextIconDisplayed() {
		waitForElementVisiable(UserHomePageUIs.NEXT_ICON);
		return isElementDisplayed(UserHomePageUIs.NEXT_ICON);
	}
	public void clickToPageByNumber(String pageNumber) {
		waitForElementClickable(UserHomePageUIs.DYNAMIC_PAGING_BY_PAGE_NUMBER, pageNumber);
		clickToElement(UserHomePageUIs.DYNAMIC_PAGING_BY_PAGE_NUMBER, pageNumber);
	}
	public boolean isPreviousIconDisplayed() {
		waitForElementVisiable(UserHomePageUIs.PREVIOUS_ICON);
		return isElementDisplayed(UserHomePageUIs.PREVIOUS_ICON);
	}
	public boolean isPagingNotDisplayed() {
		waitForElementInvisiable(UserHomePageUIs.PAGING);
		return isElementUndisplayed(UserHomePageUIs.PAGING);
	}
	public void clickToProductByName(String productName) {
		waitForElementClickable(UserHomePageUIs.DYNAMIC_PRODUCT_NAME_BY_NAME, productName);
		clickToElement(UserHomePageUIs.DYNAMIC_PRODUCT_NAME_BY_NAME, productName);
	}
	public void clickToAddToWishlistButton() {
		waitForElementClickable(UserHomePageUIs.WISHLIST_BUTTON);
		clickToElement(UserHomePageUIs.WISHLIST_BUTTON);
	}
	public boolean isAddedToWishlistSuccessMessageDisplayed() {
		waitForElementVisiable(UserHomePageUIs.ADDED_TO_WISHLIST_SUCCESS_MESSAGE);
		return isElementDisplayed(UserHomePageUIs.ADDED_TO_WISHLIST_SUCCESS_MESSAGE);
	}
	public WishlistPageObject clickToWishlistLink() {
		waitForElementClickable(UserHomePageUIs.WISHLIST_LINK);
		clickToElement(UserHomePageUIs.WISHLIST_LINK);
		return PageGeneraterManager.getWishlistPage(driver);
	}
	public ProductInfoPageObject selectProductByProductName(String menu, String submenu, String productName) {
		waitForElementVisiable(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, menu);
		hoverMouseToElement(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, menu);
		
		waitForElementPresence(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, submenu);
		clickToElement(UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, submenu);
		
		waitForElementVisiable(UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, productName);
		clickToElement(UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, productName);
		
		return PageGeneraterManager.getProductInfoPage(driver);
	}
	public void clickToCompareButtonByProductName(String productName) {
		waitForElementClickable(UserHomePageUIs.DYNAMIC_ADD_TO_COMPARE_LIST_BY_PRODUCT_NAME, productName);
		clickToElement(UserHomePageUIs.DYNAMIC_ADD_TO_COMPARE_LIST_BY_PRODUCT_NAME, productName);
	}
	public boolean isAddToCompareListSuccessDisplayed() {
		waitForElementVisiable(UserHomePageUIs.ADD_TO_COMPARE_LIST_SUCCESS_MESSAGE);
		return isElementDisplayed(UserHomePageUIs.ADD_TO_COMPARE_LIST_SUCCESS_MESSAGE);
	}
	public CompareProductListPageObject clickToCompareProductsListLink() {
		waitForElementClickable(UserHomePageUIs.COMPARE_PRODUCTS_LIST_LINK);
		clickToElement(UserHomePageUIs.COMPARE_PRODUCTS_LIST_LINK);
		return PageGeneraterManager.getCompareProductListPage(driver);
	}
	public RecentlyViewedProductsPageObject clickTohomeRecentlyViewedProductsLink() {
		waitForElementClickable(UserHomePageUIs.RECENTLY_VIEWED_PRODUCTS_LINK);
		clickToElement(UserHomePageUIs.RECENTLY_VIEWED_PRODUCTS_LINK);
		return PageGeneraterManager.getRecentlyViewedProductPage(driver);
	}

}
