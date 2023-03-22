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
		waitForElementVisiable(UserHomePageUIs.DYNAMIC_ITEM_BY_TEXT, value);
		clickToElement(UserHomePageUIs.DYNAMIC_ITEM_BY_TEXT, value);
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
		waitForElementVisiable(UserHomePageUIs.SORTBY_DROPDOWN);
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

}
