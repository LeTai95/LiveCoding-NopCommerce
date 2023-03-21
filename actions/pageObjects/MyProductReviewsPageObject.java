package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserMyAccountPageUIs;
import pageUI.nopcommerce.user.UserMyProductReviewsUIs;

public class MyProductReviewsPageObject extends BasePage {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public String getReviewTitleText() {
		waitForElementVisiable(UserMyProductReviewsUIs.REVIEW_TITLE);
		return getElementText(UserMyProductReviewsUIs.REVIEW_TITLE);
	}

	public String getReviewText() {
		waitForElementVisiable(UserMyProductReviewsUIs.REVIEW_TEXT);
		return getElementText(UserMyProductReviewsUIs.REVIEW_TEXT);
	}

	public String getRatingValue() {
		waitForElementVisiable(UserMyProductReviewsUIs.RATING_VALUE);
		return getElementAttribute(UserMyProductReviewsUIs.RATING_VALUE, "style");
	}
	

}
