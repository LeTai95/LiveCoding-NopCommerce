package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminHomePageUIs;

public class AdminHomePageObject extends BasePage {
	WebDriver driver;
	public AdminHomePageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}
	public AdminDashboardPageObject clickToLoginButton() {
		waitForElementClickable(AdminHomePageUIs.LOGIN_BUTTON);
		clickToElement(AdminHomePageUIs.LOGIN_BUTTON);
		return PageGeneraterManager.getAdminDashboardPage(driver);
	}

}
