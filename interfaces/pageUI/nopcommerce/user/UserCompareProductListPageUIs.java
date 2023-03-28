package pageUI.nopcommerce.user;

public class UserCompareProductListPageUIs {
	public static final String REMOVE_BUTTON_BY_PRODUCTNAME_AND_ROW_NUMBER = "xpath=//a[text()='%s']/ancestor::tbody/tr[@class='remove-product']/td[%s]";
	public static final String DYNAMIC_PRODUCT_NAME = "xpath=//tbody//a[text()='%s']";
	public static final String PRICE_BY_PRODUCTNAME_AND_ROW_NUMBER = "xpath=//a[text()='%s']/ancestor::tbody//tr[@class='product-price']/td[%s]";
	public static final String CLEAR_BUTTON = "xpath=//a[@class='clear-list']";
	public static final String CLEAR_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String HEADER_LOGO = "xpath=//div[@class='header-logo']";
}
