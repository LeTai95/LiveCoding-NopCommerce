package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminDashboardPageUIs;
import pageUI.nopcommerce.admin.AdminProductsPageUIs;

public class AdminDashboardPageObject extends BasePage {
	WebDriver driver;
	public AdminDashboardPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
 
	public void clickToInCatalogMenu() {
		waitForElementVisiable(AdminDashboardPageUIs.CATALOG_MENU_IN_DASHBOARD);
		clickToElementByJS(AdminDashboardPageUIs.CATALOG_MENU_IN_DASHBOARD);
		//clickToElement(AdminDashboardPageUIs.CATALOG_MENU_IN_DASHBOARD);
	}

	public AdminProductsPageObject clickToProductsPage(String pageName) {
		waitForElementVisiable(AdminDashboardPageUIs.PRODUCTS_PAGE_IN_CATALOG_MENU, pageName);
		clickToElement(AdminDashboardPageUIs.PRODUCTS_PAGE_IN_CATALOG_MENU, pageName);
		return PageGeneraterManager.getAdminProductsPage(driver);
	}

}
