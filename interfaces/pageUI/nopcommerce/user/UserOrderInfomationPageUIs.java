package pageUI.nopcommerce.user;

public class UserOrderInfomationPageUIs {
	public static final String ORDER_NUMBER = "xpath=//div[@class='order-number']/strong";
	public static final String DYNAMIC_ORDER_INFO = "xpath=//li[@class='%s']";
	public static final String DYNAMIC_CONFIRM_ORDER_INFO_BY_CLASS_AND_TEXT = "xpath=//div[@class='%s']//ul//li[contains(string(),'%s')]";
	public static final String DYNAMIC_METHOD_INFO_BY_METHOD_NAME_AND_TEXT_VALUE = "xpath=//li[@class='%s']//span[contains(text(),'%s')]";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//tr/th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody/tr[%s]//td[%s]//span[text()='%s']";
	public static final String PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody/tr[%s]//td[%s]//a[text()='%s']"; 
	public static final String ROW_INDEX_BY_ROW_NAME = "xpath=//label[text()='%s']/parent::td/parent::tr/preceding-sibling::tr";
	public static final String PRICE_VALUE_BY_ROW_NAME_AND_COLUMN_NUMBER = "xpath=//tr[%s]//td[%s]//span[text()='%s']";
}
