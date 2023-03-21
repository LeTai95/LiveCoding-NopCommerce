package pageObjects;

import org.openqa.selenium.WebDriver;

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

}
