package pageUI.nopcommerce.user;

public class UserHomePageUIs {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String DYNAMIC_MENU_BY_TEXT = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//a[text()='%s']";
	public static final String DYNAMIC_ITEM_BY_TEXT = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_BY_TEXT = "xpath=//a[text()='%s']";
	public static final String SEARCH_LINK = "xpath=//div[@class='footer']//a[text()='Search']";
	public static final String SORTBY_DROPDOWN = "xpath=//select[@id='products-orderby']";
	public static final String PRODUCT_TEXT_NAME = "xpath=//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE_TEXT = "xpath=//span[@class='price actual-price']";
}
