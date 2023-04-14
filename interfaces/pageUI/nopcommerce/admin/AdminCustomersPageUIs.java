package pageUI.nopcommerce.admin;

public class AdminCustomersPageUIs {
	public static final String ADD_NEW_BUTTON = "xpath=//a[@class='btn btn-primary']";
	public static final String SEARCH_BUTTON = "xpath=//button[@id='search-customers']";
	public static final String LOADING_ICON = "xpath=//div[@id='ajaxBusy']";
	public static final String CUSTOMER_INFO_BY_ROW_NUMBER_AND_LOLUMN_INDEX = "xpath=//tbody//tr[%s]//td[text()='%s']";
	public static final String CUSTOMERS_PAGE = "xpath=//li[contains(@class,'menu-open')]//i[@class='nav-icon far fa-dot-circle']/following-sibling::p[contains(text(),'Customers')]"; 
	public static final String DYNAMIC_TEXTBOX_BY_TEXTBOX_ID = "xpath=//input[@id='%s']";
	public static final String DELETE_ITEM_ICON_IN_DROPDOWN = "xpath=//span[text()='%s']/following-sibling::span[@class='k-select']";
	public static final String DYNAMIC_DROPDOWN_BY_DROPDOWN_NAME = "xpath=//select[@id='%s']";
	public static final String DYNAMIC_EDIT_BUTTON_BY_CUSTOMER_INFO = "xpath=//tbody//td[text()='%s']/following-sibling::td[@class='  button-column']/a";
	public static final String CUSTOMER_INFO = "xpath=//tbody//tr//td[text()='%s']";
	public static final String PARENT_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String CHILD_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String INPUT_ITEM_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div//input";
}
