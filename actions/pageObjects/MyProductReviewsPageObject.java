package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import pageUI.nopcommerce.user.UserMyAccountPageUIs;
import pageUI.nopcommerce.user.UserMyProductReviewsUIs;

public class MyProductReviewsPageObject extends BasePage {
	WebDriver driver;

	public MyProductReviewsPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public String getReviewTitleText() {
		waitForElementVisiable(driver, UserMyProductReviewsUIs.REVIEW_TITLE);
		return getElementText(driver, UserMyProductReviewsUIs.REVIEW_TITLE);
	}

	public String getReviewText() {
		waitForElementVisiable(driver, UserMyProductReviewsUIs.REVIEW_TEXT);
		return getElementText(driver, UserMyProductReviewsUIs.REVIEW_TEXT);
	}

	public String getRatingValue() {
		waitForElementVisiable(driver, UserMyProductReviewsUIs.RATING_VALUE);
		return getElementAttribute(driver, UserMyProductReviewsUIs.RATING_VALUE, "style");
	}
	

}
