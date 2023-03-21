package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserProductReviewPageUIs;

public class ProductReviewPageObject extends BasePage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		this.driver = driver;
	}

	public void enterToReviewTitleTextbox(String textValue) {
		waitForElementVisiable(driver, UserProductReviewPageUIs.REVIEWTITLE_TEXTBOX);
		sendkeyToElement(driver, UserProductReviewPageUIs.REVIEWTITLE_TEXTBOX, textValue);
	}

	public void enterToReviewtextTextarea(String textValue) {
		waitForElementVisiable(driver, UserProductReviewPageUIs.REVIEWTEXT_TEXTAREA);
		sendkeyToElement(driver, UserProductReviewPageUIs.REVIEWTEXT_TEXTAREA, textValue);
	}

	public void clickToRadioByNumber(String radioNumber) {
		waitForElementClickable(driver, UserProductReviewPageUIs.DYNAMIC_RADIO_BY_NUMBER, radioNumber);
		clickToElement(driver, UserProductReviewPageUIs.DYNAMIC_RADIO_BY_NUMBER, radioNumber);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(driver, UserProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
		clickToElement(driver, UserProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementVisiable(driver, UserProductReviewPageUIs.MY_ACCOUNT_LINK);
		clickToElement(driver, UserProductReviewPageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}

	

}
