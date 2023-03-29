package pageUI.nopcommerce.user;

public class UserProductInfoPageUIs {
	public static final String ADD_YOUR_REVIEW_LINK = "xpath=//a[text()='Add your review']";
	public static final String DYNAMIC_DROPDOWN_BY_TEXT_ITEM = "xpath=//option[text()='%s']/parent::select";
	public static final String DYNAMIC_CHECKBOX_BY_CHECKBOX_NAME = "xpath=//label[text()='%s']/preceding-sibling::input";
	public static final String ADD_TO_CART_BUTTON = "xpath=//button[contains(@class,'add-to-cart-button')]";
	public static final String ADDED_TO_CART_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String CLOSE_MESSAGE_ICON = "xpath=//span[@class='close']";
	public static final String SHOPPING_CART_LINK = "xpath=//a[@class='ico-cart']";
	public static final String PRODUCT_NUMBER = "xpath=//input[@id='product_enteredQuantity_1']";
	public static final String PRODUCT_PRICE = "xpath=//span[text()='%s']";
}
