package commons;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.Cookie;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;



public class BasePage {
	
	public static BasePage getBasePageObject() {
		
		return new BasePage();
	}
	
	public void openPageUrl(WebDriver driver, String pageUrl) {
		
		driver.get(pageUrl);
	}
	
	public String getPageTitle(WebDriver driver) {
		
		return driver.getTitle();	
	}
	
	public String getPageUrl(WebDriver driver) {
		
		return driver.getCurrentUrl();
	}
	
	public String getPageSource(WebDriver driver) {
		
		return driver.getPageSource();
	}
	
	public void backToPage(WebDriver driver) {
		
		driver.navigate().back();
	}
	
	public void forwardToPage(WebDriver driver) {
		
		driver.navigate().forward();
	}
	
	public void refreshToPage(WebDriver driver) {
		
		driver.navigate().refresh();
	}
	
	public Set<Cookie> getAllCookie(WebDriver driver) {
		return driver.manage().getCookies();
	}
	
	public void setCookie(WebDriver driver, Set<Cookie> cookies) {
		for (Cookie cookie : cookies) {
			driver.manage().addCookie(cookie);
		}
		sleepInSecond(3);
	}
	
	public Alert waitForAlertPresence(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		return explicitWait.until(ExpectedConditions.alertIsPresent());
	}
	
	public void acceptAlert(WebDriver driver) {
		
		waitForAlertPresence(driver).accept();
		
	}
	
	public void cancelAlert(WebDriver driver) {
		
		waitForAlertPresence(driver).dismiss();
	}
	
	public String getAlertText(WebDriver driver) {
		
		return waitForAlertPresence(driver).getText();
	}
	
	public void sendkeyToAlert(WebDriver driver, String textValue) {
		
		waitForAlertPresence(driver).sendKeys(textValue);
	}
	
 	public void switchToWindowByID (WebDriver driver, String windowID) {
 		
		Set<String> allWindowIDs = driver.getWindowHandles();
			for (String id : allWindowIDs) {
			if (!id.equals(windowID)) {
				driver.switchTo().window(id);
				break;
			}
		}
 	}
 	
 	public void switchToWindowByPageTitle (WebDriver driver,String tabTitle) {
 		
 		Set<String> allWindowIDs = driver.getWindowHandles();
 		for (String id : allWindowIDs) {
 			driver.switchTo().window(id);
 			String actualTitle = driver.getTitle();
 			if (actualTitle.equals(tabTitle)) {
 				break;
			}
 		}	
 	}
 	
 	public void closeAllTabWithoutParent(WebDriver driver, String parentID) {
 		
 		Set<String> allWindowIDs = driver.getWindowHandles();
		for (String id : allWindowIDs) {
		if (!id.equals(parentID)) {
			driver.switchTo().window(id);
			driver.close();
			}
			driver.switchTo().window(parentID);
		}
 	}
	
 	public By getByLocator(String locatorType) {
 		By by = null;
 		if (locatorType.startsWith("id=") || locatorType.startsWith("ID=") || locatorType.startsWith("Id=")) {
 			by = By.id(locatorType.substring(3));
		} else if (locatorType.startsWith("class=") || locatorType.startsWith("CLASS=") || locatorType.startsWith("Class=")) {
			by = By.className(locatorType.substring(6));
		} else if (locatorType.startsWith("name=") || locatorType.startsWith("Name=") || locatorType.startsWith("Name=")) {
			by = By.name(locatorType.substring(5));
		} else if (locatorType.startsWith("css=") || locatorType.startsWith("CSS=") || locatorType.startsWith("Css=")) {
			by = By.cssSelector(locatorType.substring(4));
		} else if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=") || locatorType.startsWith("Xpath=")) {
			by = By.xpath(locatorType.substring(6));
		} else {
			throw new RuntimeException("Locator type is not support !");
		}
 		return by;
 	}
 	
 	public String getDynamicXpath(String locatorType, String... dynamicValues) {
 		if (locatorType.startsWith("xpath=") || locatorType.startsWith("XPATH=")
 				|| locatorType.startsWith("Xpath=")) {
 			locatorType = String.format(locatorType,(Object[])dynamicValues) ;
		}
 		return locatorType;
 	}
 	
 	public WebElement getWebElement(WebDriver driver, String locatorType) {
 		return driver.findElement(getByLocator(locatorType));
 	}
 	
 	public List<WebElement> getListWebElement(WebDriver driver, String locatorType) {
 		
 		return driver.findElements(getByLocator(locatorType));
 	}
 	
 	public void clickToElement(WebDriver driver, String locatorType) {
 		
 		getWebElement(driver, locatorType).click();
 	}
 	
	public void clickToElement(WebDriver driver,String locatorType, String... dynamicValues) {
 		
 		getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).click();
 	}
	
	public void clearText(WebDriver driver, String locatorType) {
		
		getWebElement(driver, locatorType).clear();
	}
	
	public void clearText(WebDriver driver, String locatorType, String... dynamicValues) {
		
		getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).clear();
	}
 	
 	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue) {
 		WebElement element = getWebElement(driver, locatorType);
 		element.clear();
 		element.sendKeys(textValue);
 	}
 	
	public void sendkeyToElement(WebDriver driver, String locatorType, String textValue, String... dynamicValues) {
 		WebElement element = getWebElement(driver, getDynamicXpath(locatorType,dynamicValues));
 		element.clear();
 		element.sendKeys(textValue);
 	}
 	
 	public String getElementText(WebDriver driver, String locatorType) {
 		
 		return getWebElement(driver, locatorType).getText();
 	}
 	
 	public String getElementText(WebDriver driver, String locatorType, String... dynamicValues) {
 		
 		return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).getText();
 	}

 	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem) {
 		
 		Select select = new Select(getWebElement(driver, locatorType));
 		select.selectByVisibleText(textItem);
 	}
 	
 	public void selectItemInDefaultDropdown(WebDriver driver, String locatorType, String textItem, String... dynamicValues) {
 		
 		Select select = new Select(getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)));
 		select.selectByVisibleText(textItem);
 	}
 	
 	public String getSelectedItemInDefaultDropdown(WebDriver driver, String locatorType) {
 		
 		Select select = new Select(getWebElement(driver, locatorType));
 		return select.getFirstSelectedOption().getText();
 	}
 	
 	public boolean isDropdownMultiple(WebDriver driver, String locatorType) {
 		
 		Select select = new Select(getWebElement(driver, locatorType));
 		return select.isMultiple();
 	}
 	
	public void selectItemInCustomDropdown (WebDriver driver, String parentXpath, String childXpath, String extTextItem) {
		getWebElement(driver, parentXpath).click();
		sleepInSecond(1);
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);	
		List<WebElement> allDropdownItems = explicitWait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(getByLocator(childXpath)));	
		for (WebElement item : allDropdownItems) {
			if (item.getText().trim().equals(extTextItem)) {
				JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
				jsExecutor.executeScript("arguments[0].scrollIntoView(true);", item);
				sleepInSecond(1);
				item.click();
				break;
				}
			}
		}

	public void sleepInSecond(long timeInSecond) {
		try {
		Thread.sleep(timeInSecond * 1000);}
		catch (InterruptedException e) {
		e.printStackTrace();}
		}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName) {
		
		return getWebElement(driver, locatorType).getAttribute(attributeName);
	}
	
	public String getElementAttribute(WebDriver driver, String locatorType, String attributeName, String... dynamicValues) {
		
		return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).getAttribute(attributeName);
	}
	
	public String getElementCssValue(WebDriver driver, String locatorType, String propertyeName) {
		
		return getWebElement(driver, locatorType).getCssValue(propertyeName);
	}
	
	public String getHexaColorFromRGBA(String rgbaValue) {
		return Color.fromString(rgbaValue).asHex();
	}
	
	public int getElementSize(WebDriver driver, String locatorType) {
		
		return getListWebElement(driver, locatorType).size();
	}
	
	public int getElementSize(WebDriver driver, String locatorType, String... dynamicValues) {
		
		return getListWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).size();
	}

	public void checkToDefautCheckboxRadio(WebDriver driver, String locatorType) {
		
		WebElement element = getWebElement(driver, locatorType);
		if (!element.isSelected()) {
			element.click();
		}
	}
	public void checkToDefautCheckboxRadio(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType,dynamicValues));
		if (!element.isSelected()) {
			element.click();
		}
	}
	
	public void unheckToDefautCheckbox(WebDriver driver, String locatorType) {
		
		WebElement element = getWebElement(driver, locatorType);
		if (element.isSelected()) {
			element.click();
		}
	}
	public void unheckToDefautCheckbox(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebElement element = getWebElement(driver, getDynamicXpath(locatorType,dynamicValues));
		if (element.isSelected()) {
			element.click();
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType) {
		try {
			return getWebElement(driver, locatorType).isDisplayed();
		} catch (NoSuchElementException e) {
			return false;
		}
	}
	
	public boolean isElementDisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		
		return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).isDisplayed();
	}
	
	public void overrideGlobalTimeout(WebDriver driver, long timeOut) {
		driver.manage().timeouts().implicitlyWait(timeOut, TimeUnit.SECONDS);
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, locatorType);
		overrideGlobalTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			System.out.println("Element not in DOM.");
			return true;
		} else if(elements.size() >0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visiable/displayed.");
			return true;
		} else
		{
			System.out.println("Element in DOM and visiable.");
			return false;
		}
		
	}
	
	public boolean isElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		overrideGlobalTimeout(driver, shortTimeout);
		List<WebElement> elements = getListWebElement(driver, getDynamicXpath(locatorType,dynamicValues));
		overrideGlobalTimeout(driver, longTimeout);
		
		if (elements.size() == 0) {
			System.out.println("Element not in DOM.");
			return true;
		} else if(elements.size() >0 && !elements.get(0).isDisplayed()) {
			System.out.println("Element in DOM but not visiable/displayed.");
			return true;
		} else
		{
			System.out.println("Element in DOM and visiable.");
			return false;
		}
		
	}
	
	public boolean isElementEnable(WebDriver driver, String locatorType) {
		
		return getWebElement(driver, locatorType).isEnabled();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType) {
		
		return getWebElement(driver, locatorType).isSelected();
	}
	
	public boolean isElementSelected(WebDriver driver, String locatorType, String... dynamicValues) {
		
		return getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)).isSelected();
	}
	
	public void switchToFrameIframe(WebDriver driver, String locatorType) {
		
		driver.switchTo().frame(getWebElement(driver, locatorType));
	}
	
	public void switchToDefautContent(WebDriver driver, String locatorType) {
		
		driver.switchTo().defaultContent();
	}
	
	public void hoverMouseToElement(WebDriver driver, String locatorType) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, locatorType)).perform();
		sleepInSecond(2);
	}	
	
	public void hoverMouseToElement(WebDriver driver, String locatorType, String... dynamicValues) {
		
		Actions action = new Actions(driver);
		action.moveToElement(getWebElement(driver, getDynamicXpath(locatorType,dynamicValues))).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key) {
		
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, locatorType), key).perform();
	}
	
	public void pressKeyToElement(WebDriver driver, String locatorType, Keys key, String... dynamicValues) {
		
		Actions action = new Actions(driver);
		action.sendKeys(getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)), key).perform();
	}

	public void clearValueInElementByDeleteKey(WebDriver driver, String locatorType) {
 		WebElement element = getWebElement(driver, locatorType);
 		element.clear();
 		element.sendKeys(Keys.chord(Keys.CONTROL, "a", Keys.DELETE));
	}
	
	public void scrollToBottomPage(WebDriver driver) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("window.scrollBy(0,document.body.scrollHeight)");
	}
	
	public void hightlightElement(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		WebElement element = getWebElement(driver, locatorType);
		String originalStyle = element.getAttribute("style");
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, "border: 2px solid red; border-style: dashed;");
		sleepInSecond(1);
		jsExecutor.executeScript("arguments[0].setAttribute('style', arguments[1])", element, originalStyle);
	}
	
	public void clickToElementByJS(WebDriver driver,String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].click();", getWebElement(driver, locatorType));
	}
	
	public void scrollToElement(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].scrollIntoView(true);", getWebElement(driver, locatorType));
	}
	
	public String getElementValueByJSXpath(WebDriver driver, String xpathLocator) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		xpathLocator = xpathLocator.replace("xpath", "");
		return (String) jsExecutor.executeScript("return $(document.evaluate(\"" + xpathLocator + "\", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue).val()");
	}

	public void removeAttributeInDOM(WebDriver driver, String locatorType, String attributeRemove) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		jsExecutor.executeScript("arguments[0].removeAttribute('" + attributeRemove + "');", getWebElement(driver, locatorType));
	}
	
	public boolean areJQueryAndJSLoadedSuccess(WebDriver driver) {
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		ExpectedCondition<Boolean> jQueryLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				try {
					return ((Long) jsExecutor.executeScript("return jQuery.active") == 0);
				} catch (Exception e) {
					return true;
				}
			}
		};

		ExpectedCondition<Boolean> jsLoad = new ExpectedCondition<Boolean>() {
			@Override
			public Boolean apply(WebDriver driver) {
				return jsExecutor.executeScript("return document.readyState").toString().equals("complete");
			}
		};

		return explicitWait.until(jQueryLoad) && explicitWait.until(jsLoad);
	}

	public String getElementValidationMessage(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		return (String) jsExecutor.executeScript("return arguments[0].validationMessage;", getWebElement(driver, locatorType));
	}

	public boolean isImageLoaded(WebDriver driver, String locatorType) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (Boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, locatorType));
		return status;
	}
	
	public boolean isImageLoaded(WebDriver driver, String locatorType, String...dynamicValues) {
		JavascriptExecutor jsExecutor = (JavascriptExecutor) driver;
		boolean status = (Boolean) jsExecutor.executeScript(
				"return arguments[0].complete && typeof arguments[0].naturalWidth != 'undefined' && arguments[0].naturalWidth > 0",
				getWebElement(driver, getDynamicXpath(locatorType,dynamicValues)));
		if (status) {
			return true;
		} else {
			return false;
		}
	}

	public void waitForElementVisiable(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	public void waitForElementVisiable(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
	}
	
	public void waitForAllElementVisiable(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(locatorType)));
	}
	
	public void waitForAllElementVisiable(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
	}
	
	public void waitForElementInvisiable(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
	}
	
	
	/*
	 *Wait for element undisplayed in DOM or not in DOM and override implicit wait
	 */
	public void waitForElementUndisplayed(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideGlobalTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(locatorType)));
		overrideGlobalTimeout(driver, longTimeout);
	}
	
	public void waitForElementUndisplayed(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, shortTimeout);
		overrideGlobalTimeout(driver, shortTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
		overrideGlobalTimeout(driver, longTimeout);
	}
	
	public void waitForElementInvisiable(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfElementLocated(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
	}
	
	public void waitForAllElementinVisiable(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, locatorType)));
	}
	
	public void waitForAllElementinVisiable(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.invisibilityOfAllElements(getListWebElement(driver, getDynamicXpath(locatorType,dynamicValues))));
	}
	
	
	public void waitForElementClickable(WebDriver driver, String locatorType) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(locatorType)));
	}
	
	public void waitForElementClickable(WebDriver driver, String locatorType, String... dynamicValues) {
		
		WebDriverWait explicitWait = new WebDriverWait(driver, longTimeout);
		explicitWait.until(ExpectedConditions.elementToBeClickable(getByLocator(getDynamicXpath(locatorType,dynamicValues))));
	}

	public void uploatMultipleFiles(WebDriver driver, String...fileNames) {
		
		String filePath = GlobalConstants.UPLOAD_FILE;
		String fullFileName = "";
		for (String file : fileNames) {
			fullFileName = fullFileName + filePath + file + "\n";
		}
		fullFileName = fullFileName.trim();
		getWebElement(driver, BasePageUIs.UPLOAD_FILE).sendKeys(fullFileName);
	}
	
	private long longTimeout = GlobalConstants.LONG_TIME_OUT;
	private long shortTimeout = GlobalConstants.SHORT_TIME_OUT;
}



