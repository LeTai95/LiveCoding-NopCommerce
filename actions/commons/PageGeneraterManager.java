package commons;

import org.openqa.selenium.WebDriver;

import pageObjects.LoginPageObject;
import pageObjects.RegisterPageObject;

public class PageGeneraterManager {
	public static RegisterPageObject getRegisterPage(WebDriver driver) {
		return new RegisterPageObject(driver);
	}
	
	public static LoginPageObject getLoginPage(WebDriver driver) {
		return new LoginPageObject(driver);
	}
}
