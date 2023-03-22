package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.AddressesPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.ProductInfoPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;

public class PageGeneraterManager {
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
	
	public static HomePageObject getHomePage(WebDriver driver) {
		return new HomePageObject(driver);
	}
	
	public static MyAccountPageObject getMyAccountPage(WebDriver driver) {
		return new MyAccountPageObject(driver);
	}
	
	public static AddressesPageObject getAddressesPage(WebDriver driver) {
		return new AddressesPageObject(driver);
	}
	
	public static ChangePasswordPageObject getChangePasswordPage(WebDriver driver) {
		return new ChangePasswordPageObject(driver);
	}
	
	public static ProductInfoPageObject getProductInfoPage(WebDriver driver) {
		return new ProductInfoPageObject(driver);
	}
	
	public static ProductReviewPageObject getProductReviewPage(WebDriver driver) {
		return new ProductReviewPageObject(driver);
	}
	
	public static MyProductReviewsPageObject getMyProductReviewsPage(WebDriver driver) {
		return new MyProductReviewsPageObject(driver);
	}
	
	public static SearchPageObject getSearchPage(WebDriver driver) {
		return new SearchPageObject(driver);
	}
}
