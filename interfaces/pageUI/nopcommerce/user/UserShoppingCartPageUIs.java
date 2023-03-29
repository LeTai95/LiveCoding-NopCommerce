package pageUI.nopcommerce.user;

public class UserShoppingCartPageUIs {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//a[text()='%s']";
	public static final String WISHLIST_LINK = "xpath=//a[text()='Wishlist']";
	public static final String PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//a[text()='%s']/parent::td//div[@class='attributes']";
	public static final String PRODUCT_PRICE_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]/span";
	public static final String EDIT_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]/div[@class='edit-item']/a";
	public static final String REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]/button";
	public static final String SHOPPING_CART_MESSAGE = "xpath=//div[@class='no-data']";
	public static final String HEADER_LOGO = "xpath=//div[@class='header-logo']";
	public static final String QTY_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]/input";
	public static final String UPDATE_SHOPPING_CART = "xpath=//button[@id='updatecart']";
	
	
}
