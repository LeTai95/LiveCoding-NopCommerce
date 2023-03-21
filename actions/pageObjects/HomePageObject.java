package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserHomePageUIs;

public class HomePageObject extends BasePage {
	WebDriver driver;
	public HomePageObject(WebDriver driver) {
		this.driver = driver;
	}
	public RegisterPageObject clickToRegisterLink() {
		waitForElementClickable(driver, UserHomePageUIs.REGISTER_LINK);
		clickToElement(driver, UserHomePageUIs.REGISTER_LINK);
		return PageGeneraterManager.getRegisterPage(driver);
	}
	public LoginPageObject clickToLoginLink() {
		waitForElementVisiable(driver, UserHomePageUIs.LOGIN_LINK);
		clickToElement(driver, UserHomePageUIs.LOGIN_LINK);
		return PageGeneraterManager.getLoginPage(driver);
	}
	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementVisiable(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}
	public boolean isMyAccountLinkDisplayed() {
		waitForElementVisiable(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
		return isElementDisplayed(driver, UserHomePageUIs.MY_ACCOUNT_LINK);
	}
	public void hoverToMenuByText(String value) {
		waitForElementVisiable(driver, UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
		hoverMouseToElement(driver, UserHomePageUIs.DYNAMIC_MENU_BY_TEXT, value);
	}
	public void clickToItemByText(String value) {
		waitForElementVisiable(driver, UserHomePageUIs.DYNAMIC_ITEM_BY_TEXT, value);
		clickToElement(driver, UserHomePageUIs.DYNAMIC_ITEM_BY_TEXT, value);
	}
	public ProductInfoPageObject clickToProductByText(String textValue) {
		waitForElementClickable(driver, UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, textValue);
		clickToElement(driver, UserHomePageUIs.DYNAMIC_PRODUCT_BY_TEXT, textValue);
		return PageGeneraterManager.getProductInfoPage(driver);
	}

}
