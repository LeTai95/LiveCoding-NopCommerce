package pageUI.nopcommerce.user;

public class UserShoppingCartPageUIs {
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[text()='%s']/preceding-sibling::th";
	public static final String PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//a[text()='%s']";
	public static final String WISHLIST_LINK = "xpath=//a[text()='Wishlist']";
}
