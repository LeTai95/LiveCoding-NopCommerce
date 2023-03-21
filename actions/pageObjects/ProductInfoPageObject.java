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

	

}
