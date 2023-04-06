package pageUI.nopcommerce.user;

public class UserConfirmOrderPageUIs {
	public static final String DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT = "xpath=//div[@class='%s']//ul//li[contains(string(),'%s')]";
	public static final String DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE = "xpath=//li[@class='%s']//span[contains(text(),'%s')]";
	public static final String PRODUCT_INFO_COLUMN_INDEX_BY_NAME = "xpath=//tr//th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//table[@class='cart']//tbody/tr[%s]//td[%s]//span[text()='%s']";
	public static final String PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//table[@class='cart']//tbody/tr[%s]//td[%s]//a[text()='%s']";
	public static final String ROW_INDEX_BY_ROW_NAME = "xpath=//label[text()='%s']/parent::td/parent::tr/preceding-sibling::tr";
	public static final String PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER = "xpath=//table[@class='cart-total']//tr[%s]//td[%s]//span[text()='%s']";
	public static final String CONFIRM_BUTTON = "xpath=//button[@class='button-1 confirm-order-next-step-button']";
	public static final String TOTAL_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//table[@class='cart-total']//tr[%s]//td[%s]//strong[text()='%s']";
	public static final String ORDER_SUCCESS_PAGE_TITLE = "xpath=//div[@class='page-title']/h1[text()='Thank you']";
	public static final String ORDER_SUCCESS_TITLE = "xpath=//div[@class='title']/strong[text()='Your order has been successfully processed!']";
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String TOTAL_ORDER_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//table[@class='cart-total']//tr[%s]//td[%s]//span//strong[text()='%s']";
	public static final String HEADER_LOGO = "xpath=//div[@class='header-logo']";

}
