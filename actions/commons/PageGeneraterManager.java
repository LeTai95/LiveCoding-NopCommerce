package commons;

import org.openqa.selenium.WebDriver;

import adminPageObjects.AdminAddNewAddressPageObject;
import adminPageObjects.AdminCustomerInfoPageObject;
import adminPageObjects.AdminCustomersPageObject;
import adminPageObjects.AdminDashboardPageObject;
import adminPageObjects.AdminEditAddressPageObject;
import adminPageObjects.AdminHomePageObject;
import adminPageObjects.AdminProductInfoPageObject;
import adminPageObjects.AdminProductsPageObject;
import pageObjects.AddressesPageObject;
import pageObjects.BillingAddressPageObject;
import pageObjects.ChangePasswordPageObject;
import pageObjects.CheckoutPageObject;
import pageObjects.CompareProductListPageObject;
import pageObjects.ConfirmOrderPageObject;
import pageObjects.HomePageObject;
import pageObjects.LoginPageObject;
import pageObjects.MyAccountPageObject;
import pageObjects.MyProductReviewsPageObject;
import pageObjects.OrderInfomationPageObject;
import pageObjects.OrdersPageObject;
import pageObjects.PaymentInformationPageObject;
import pageObjects.PaymentMethodPageObject;
import pageObjects.ProductInfoPageObject;
import pageObjects.ProductReviewPageObject;
import pageObjects.RecentlyViewedProductsPageObject;
import pageObjects.RegisterPageObject;
import pageObjects.SearchPageObject;
import pageObjects.ShoppingCartPageObject;
import pageObjects.WishlistPageObject;

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
	
	public static WishlistPageObject getWishlistPage(WebDriver driver) {
		return new WishlistPageObject(driver);
	}
	
	public static ShoppingCartPageObject getShoppingCartPage(WebDriver driver) {
		return new ShoppingCartPageObject(driver);
	}
	
	public static CompareProductListPageObject getCompareProductListPage(WebDriver driver) {
		return new CompareProductListPageObject(driver);
	}
	
	public static RecentlyViewedProductsPageObject getRecentlyViewedProductPage(WebDriver driver) {
		return new RecentlyViewedProductsPageObject(driver);
	}
	
	public static BillingAddressPageObject getBillingAddressPage(WebDriver driver) {
		return new BillingAddressPageObject(driver);
	}
	
	public static CheckoutPageObject getCheckoutPage(WebDriver driver) {
		return new CheckoutPageObject(driver);
	}
	
	public static PaymentMethodPageObject getPaymentMethodPage(WebDriver driver) {
		return new PaymentMethodPageObject(driver);
	}
	
	public static PaymentInformationPageObject getPaymentInformationPage(WebDriver driver) {
		return new PaymentInformationPageObject(driver);
	}
	
	public static ConfirmOrderPageObject getConfirmOrderPage(WebDriver driver) {
		return new ConfirmOrderPageObject(driver);
	}
	
	public static OrdersPageObject getOrdersPage(WebDriver driver) {
		return new OrdersPageObject(driver);
	}
	
	public static OrderInfomationPageObject getOrderInfomationPage(WebDriver driver) {
		return new OrderInfomationPageObject(driver);
	}
	
	public static AdminHomePageObject getAdminHomePage(WebDriver driver) {
		return new AdminHomePageObject(driver);
	}
	
	public static AdminDashboardPageObject getAdminDashboardPage(WebDriver driver) {
		return new AdminDashboardPageObject(driver);
	}
	
	public static AdminProductsPageObject getAdminProductsPage(WebDriver driver) {
		return new AdminProductsPageObject(driver);
	}
	
	public static AdminProductInfoPageObject getAdminProductPage(WebDriver driver) {
		return new AdminProductInfoPageObject(driver);
	}
	
	public static AdminCustomersPageObject getCustomersPage(WebDriver driver) {
		return new AdminCustomersPageObject(driver);
	}
	
	public static AdminCustomerInfoPageObject getCustomerInfoPage(WebDriver driver) {
		return new AdminCustomerInfoPageObject(driver);
	}
	
	public static AdminAddNewAddressPageObject getAddNewAddressPage(WebDriver driver) {
		return new AdminAddNewAddressPageObject(driver);
	}
	
	public static AdminEditAddressPageObject getEditAddressPage(WebDriver driver) {
		return new AdminEditAddressPageObject(driver);
	}
	
	
	
	
	
}
