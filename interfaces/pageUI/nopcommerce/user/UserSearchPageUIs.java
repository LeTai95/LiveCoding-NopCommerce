package pageUI.nopcommerce.user;

public class UserSearchPageUIs {
	public static final String SEARCH_BUTTON = "xpath=//button[@class='button-1 search-button']";
	public static final String ERROR_MESSAGE = "xpath=//div[@class='warning']";
	public static final String PRODUCT_NOT_ERROR_MESSAGE = "xpath=//div[@class='no-result']";
	public static final String SEARCH_TEXTBOX = "xpath=//input[@class='search-text']";
	public static final String DYNAMIC_PRODUCT_BY_NAME = "xpath=//a[text()='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_NAME = "xpath=//input[contains(@data-val-required,'%s')]";
	public static final String DYNAMIC_DROPDOWN_BY_NAME = "xpath=//select[contains(@data-val-required,'%s')]";
}
