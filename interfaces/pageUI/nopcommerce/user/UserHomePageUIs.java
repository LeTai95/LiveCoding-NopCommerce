package pageUI.nopcommerce.user;

public class UserHomePageUIs {
	public static final String REGISTER_LINK = "xpath=//a[@class='ico-register']";
	public static final String LOGIN_LINK = "xpath=//a[@class='ico-login']";
	public static final String MY_ACCOUNT_LINK = "xpath=//a[@class='ico-account']";
	public static final String DYNAMIC_MENU_BY_TEXT = "xpath=//div[@class='header-menu']//ul[contains(@class,'notmobile')]//a[text()='%s']";
	public static final String DYNAMIC_PRODUCT_BY_TEXT = "xpath=//h2//a[text()='%s']";
	public static final String SEARCH_LINK = "xpath=//div[@class='footer']//a[text()='Search']";
	public static final String SORTBY_DROPDOWN = "xpath=//select[@id='products-orderby']";
	public static final String PRODUCT_TEXT_NAME = "xpath=//h2[@class='product-title']/a";
	public static final String PRODUCT_PRICE_TEXT = "xpath=//span[@class='price actual-price']";
	public static final String DISPLAY_DROPDOWN = "xpath=//div/select[@id='products-pagesize']";
	public static final String PRODUCT_NAME_LIST = "xpath=//div[@class='item-box']";
	public static final String NEXT_ICON = "xpath=//li[@class='next-page']";
	public static final String PREVIOUS_ICON = "xpath=//li[@class='previous-page']";
	public static final String DYNAMIC_PAGING_BY_PAGE_NUMBER = "xpath=//a[text()='%s']";
	public static final String PAGING = "xpath=//div[@class='pager']";
	public static final String DYNAMIC_PRODUCT_NAME_BY_NAME = "xpath=//a[text()='%s']";
	public static final String WISHLIST_BUTTON = "xpath=//button[contains(@id,'add-to-wishlist')]";
	public static final String ADDED_TO_WISHLIST_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String WISHLIST_LINK = "xpath=//a[text()='Wishlist']";
	public static final String DYNAMIC_ADD_TO_COMPARE_LIST_BY_PRODUCT_NAME = "xpath=//a[text()='%s']/parent::h2/following-sibling::div[@class='add-info']//div/button[contains(@class,'add-to-compare-list-button')]";
	public static final String ADD_TO_COMPARE_LIST_SUCCESS_MESSAGE = "xpath=//p[@class='content']";
	public static final String COMPARE_PRODUCTS_LIST_LINK = "xpath=//a[text()='Compare products list']";
	public static final String RECENTLY_VIEWED_PRODUCTS_LINK = "xpath=//a[text()='Recently viewed products']";




}
