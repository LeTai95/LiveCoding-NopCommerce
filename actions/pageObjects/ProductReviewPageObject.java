package pageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.user.UserProductReviewPageUIs;

public class ProductReviewPageObject extends BasePage {
	WebDriver driver;

	public ProductReviewPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToReviewTitleTextbox(String textValue) {
		waitForElementVisiable(UserProductReviewPageUIs.REVIEWTITLE_TEXTBOX);
		sendkeyToElement(UserProductReviewPageUIs.REVIEWTITLE_TEXTBOX, textValue);
	}

	public void enterToReviewtextTextarea(String textValue) {
		waitForElementVisiable(UserProductReviewPageUIs.REVIEWTEXT_TEXTAREA);
		sendkeyToElement(UserProductReviewPageUIs.REVIEWTEXT_TEXTAREA, textValue);
	}

	public void clickToRadioByNumber(String radioNumber) {
		waitForElementClickable(UserProductReviewPageUIs.DYNAMIC_RADIO_BY_NUMBER, radioNumber);
		clickToElement(UserProductReviewPageUIs.DYNAMIC_RADIO_BY_NUMBER, radioNumber);
	}

	public void clickToSubmitReviewButton() {
		waitForElementClickable(UserProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
		clickToElement(UserProductReviewPageUIs.SUBMIT_REVIEW_BUTTON);
	}

	public MyAccountPageObject clickToMyAccountLink() {
		waitForElementVisiable(UserProductReviewPageUIs.MY_ACCOUNT_LINK);
		clickToElement(UserProductReviewPageUIs.MY_ACCOUNT_LINK);
		return PageGeneraterManager.getMyAccountPage(driver);
	}

	

}
