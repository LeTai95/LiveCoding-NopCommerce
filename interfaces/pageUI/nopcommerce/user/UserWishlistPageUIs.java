package pageUI.nopcommerce.user;

public class UserWishlistPageUIs {
	public static final String SHARING_LINK = "xpath=//a[@class='share-link']";
	
	public static final String COLUMN_INDEX_BY_NAME = "xpath=//tr//th[contains(text(),'%s')]/preceding-sibling::th";
	public static final String CHECKBOX_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//input";
	public static final String PRODUCT_NAME_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//a[text()='%s']";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[text()='Add to cart']";
	public static final String HEADER_LOGO = "xpath=//div[@class='header-logo']";
	public static final String REMOVE_BUTTON_BY_ROW_NUMBER_AND_COLUMN_NAME = "xpath=//tbody//tr[%s]//td[%s]//button";
}
