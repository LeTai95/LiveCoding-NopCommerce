package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserRecentlyViewedProductsPageUIs;

public class RecentlyViewedProductsPageObject extends BasePage {
	WebDriver driver;
	public RecentlyViewedProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public boolean isProductsNumberDisplayedTrue(String productNumber) {
		waitForAllElementVisiable(UserRecentlyViewedProductsPageUIs.PRODUCT_NUMBER);
		return getElementSize(UserRecentlyViewedProductsPageUIs.PRODUCT_NUMBER) <= Integer.valueOf(productNumber);
	}

}
