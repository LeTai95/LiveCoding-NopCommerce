package pageUI.nopcommerce.admin;

public class AdminProductInfoPageUIs {
	public static final String PRODUCT_NAME = "xpath=//input[@value='%s']";
	public static final String PRODUCT_DESCRIPTION_1 = "xpath=//body[@id='tinymce']/p[1]";
	public static final String PRODUCT_DESCRIPTION_2 = "xpath=//body[@id='tinymce']/p[2]";
	public static final String PRODUCT_DESCRIPTION_IFRAME = "xpath=//iframe[@id='FullDescription_ifr']";
	public static final String CUSTOMERS_MENU = "xpath=//i[contains(@class,'fa-user')]/following-sibling::p[contains(text(),'Customers')]";
	public static final String CUSTOMERS_PAGE = "xpath=//li[contains(@class,'menu-open')]//i[@class='nav-icon far fa-dot-circle']/following-sibling::p[contains(text(),'Customers')]";


}
