package pageUI.nopcommerce.admin;

public class AdminCustomerInfoPageUIs {
	public static final String DYNAMIC_TEXTBOX_BY_TEXTBOX_ID = "xpath=//input[@id='%s']";
	public static final String DYNAMIC_CHECKBOX_BY_CHECKBOX_ID = "xpath=//input[@id='%s']";
	public static final String SAVE_AND_CONTINUE_EDIT_BUTTON = "xpath=//button[@name='save-continue']";
	public static final String PARENT_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//div[contains(@class,'input-group-required')]//div[@class='k-multiselect-wrap k-floatwrap']";
	public static final String CHILD_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//ul[@id='SelectedCustomerRoleIds_listbox']/li";
	public static final String INPUT_ITEM_XPATH_CUSTOMER_ROLES_DROPDOWN = "xpath=//label[text()='Customer roles']/parent::div/parent::div/following-sibling::div//input";
	public static final String DYNAMIC_TEXTAREA_BY_TEXTAREA_ID = "xpath=//textarea[@id='%s']";
	public static final String SUCCESS_MESSAGE = "xpath=//div[contains(@class,'alert-success')]";
	public static final String ITEM_SELECTED_IN_DROPDOWN = "xpath=//ul[@id='SelectedCustomerRoleIds_taglist']//li/span[text()='%s']";
	public static final String BACK_TO_CUSTOMER_LIST = "xpath=//a[text()='back to customer list']";
	public static final String DYNAMIC_DELETE_ITEM_ICON_IN_DROPDOWN = "xpath=//span[text()='%s']/following-sibling::span";
	public static final String SAVE_BUTTON = "xpath=//button[@name='save']";
	public static final String ADDRESS_COLLAPSE_BUTTON = "xpath=//div[text()='Addresses']";
	public static final String ADD_NEW_ADDRESS_BUTTON = "xpath=//button[contains(text(),'Add new address')]";
	public static final String DYNAMIC_ADDRESS_INFO = "xpath=//tbody//tr//td[text()='%s']";
	public static final String EDIT_BUTTON = "xpath=//td[@class='  button-column']/a[text()='Edit']";
	public static final String CUSTOMERS_PAGE = "xpath=//li[contains(@class,'menu-open')]//i[@class='nav-icon far fa-dot-circle']/following-sibling::p[contains(text(),'Customers')]";
	public static final String DELETE_BUTTON = "xpath=//td[@class='  button-column']/a[text()='Delete']";
	public static final String NO_DATA_AVAILABLE = "xpath=//div[text()='Addresses']/parent::div/following-sibling::div[@class='card-body']//tbody//td[text()='No data available in table']";
	public static final String DYNAMIC_ADDRESS_IN_ADDRESS_INFO = "xpath=//tbody//tr//td/div[contains(text(),'%s')]";
	public static final String ITEM_TO_SCROLL = "xpath=//label[text()='Last activity']";

}
