package pageUI.nopcommerce.admin;

public class AdminProductsPageUIs {
	public static final String DYNAMIC_TEXTBOX_BY_TEXTBOX_ID = "xpath=//input[@id='%s']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-products']";
	public static final String COLUMN_INDEX_BY_COLUMN_NAME = "xpath=//tr/th[text()='%s']/preceding-sibling::th";
	public static final String PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]";
	public static final String PULISHED_ICON_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[1]//td[7]/i";
	public static final String DYNAMIC_DROPDOWN_BY_DROPDOWN_ID = "xpath=//select[@id='%s']";
	public static final String NO_DATA_AVAILABLE_MESSAGE = "xpath=//tbody/tr/td[text()='No data available in table']";
	public static final String SEARCH_SUBCATEGORIES_CHECKBOX = "xpath=//input[@id='SearchIncludeSubCategories']";
	public static final String GO_BUTTON = "xpath=//button[@id='go-to-product-by-sku']";






}
