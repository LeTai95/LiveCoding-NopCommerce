package adminPageObjects;

import org.openqa.selenium.WebDriver;

import commons.BasePage;
import commons.PageGeneraterManager;
import pageUI.nopcommerce.admin.AdminProductsPageUIs;

public class AdminProductsPageObject extends BasePage {
	WebDriver driver;

	public AdminProductsPageObject(WebDriver driver) {
		super(driver);
		this.driver = driver;
	}

	public void enterToTextboxByTextboxID(String textboxID, String textValue) {
		waitForElementVisiable(AdminProductsPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textboxID);
		sendkeyToElement(AdminProductsPageUIs.DYNAMIC_TEXTBOX_BY_TEXTBOX_ID, textValue, textboxID);
	}

	public void clickToSearchButton() {
		waitForElementClickable(AdminProductsPageUIs.SEARCH_BUTTON);
		clickToElement(AdminProductsPageUIs.SEARCH_BUTTON);
		sleepInSecond(3);
	}

	public String isProductInfoDisplayedByRowNumberAndColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(AdminProductsPageUIs.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisiable(AdminProductsPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		return getElementText(AdminProductsPageUIs.PRODUCT_INFO_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}

	public boolean isPublishedIconDisplayedByRowNumberAndColumnName(String rowNumber, String columnName) {
		int columnIndex = getElementSize(AdminProductsPageUIs.COLUMN_INDEX_BY_COLUMN_NAME, columnName) + 1;
		waitForElementVisiable(AdminProductsPageUIs.PULISHED_ICON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
		return isElementDisplayed(AdminProductsPageUIs.PULISHED_ICON_BY_ROW_NUMBER_AND_COLUMN_NAME, rowNumber,
				String.valueOf(columnIndex));
	}

	public void selectItemInDropdownByDropdownID(String dropdownID, String textItem) {
		waitForElementVisiable(AdminProductsPageUIs.DYNAMIC_DROPDOWN_BY_DROPDOWN_ID, dropdownID);
		selectItemInDefaultDropdown(AdminProductsPageUIs.DYNAMIC_DROPDOWN_BY_DROPDOWN_ID, textItem, dropdownID);
	}

	public boolean isNoDataAvailableDisplayed() {
		waitForElementVisiable(AdminProductsPageUIs.NO_DATA_AVAILABLE_MESSAGE);
		return isElementDisplayed(AdminProductsPageUIs.NO_DATA_AVAILABLE_MESSAGE);
	}

	public void checkToSearchSubcategoriesCheckbox() {
		waitForElementVisiable(AdminProductsPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
		checkToDefautCheckboxRadio(AdminProductsPageUIs.SEARCH_SUBCATEGORIES_CHECKBOX);
	}

	public AdminProductInfoPageObject clickToGoButton() {
		waitForElementClickable(AdminProductsPageUIs.GO_BUTTON);
		clickToElement(AdminProductsPageUIs.GO_BUTTON);
		return PageGeneraterManager.getAdminProductPage(driver);
	}

}
