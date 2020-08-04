package com.hubspot.util;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import com.hubspot.base.BasePage;

public class ElementUtil extends BasePage{
	
	WebDriver driver;
	
	public ElementUtil(WebDriver driver){
		this.driver = driver;
	}
	
	
	public WebElement getElement(By locator){
		waitForElementPresent(locator);
		
		WebElement element = null;
		try{
		element = driver.findElement(locator);
		if(flash.equalsIgnoreCase("yes")){
		   JavaScriptUtil.flash(element, driver);
		 }
		}catch (Exception e) {
			System.out.println("Some exception occured while creating webelement " +locator);
		}
		return element;
	}
	
	
	public void waitForElementPresent(By locator){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(locator));
	}
	
	public void doClick(By locator){
		try{
		getElement(locator).click();
		}
		catch(Exception e){
			System.out.println("Some exception occured while click on  webelement " +locator);
		}
	}
	
	
	public void doSendKeys(By locator, String value){
		try{
		getElement(locator).clear();
		getElement(locator).sendKeys(value);
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " + locator);
		}
	}
	
	
	public String doGetText(By locator){
		String text = null;
		try{
		text = getElement(locator).getText();
		}
		catch(Exception e){
			System.out.println("Some exception occured while sending to  webelement " +locator);
		}
		return text;
	}
	
	
	public String waitForGetPageTitle(String title){
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.titleContains(title));
		return driver.getTitle();
	}
	
	
	public boolean isElementDisplayed(By locator){
		try{
		return getElement(locator).isDisplayed();
		}catch(Exception e){
			System.out.println("Some exception occured while checking webelement displayed "+ locator);
			return false;
		}
	}
}
//	//Utilities -- Util -- basePage
//		// common methods (getTitle, click on- submit,alert handling, calling browser, getURL) 
//		
//		/**
//		 * This method is used to get text and handle alert
//		 * @param driver
//		 * @return
//		 */
//		public static String getAlertText(WebDriver driver){
//			Alert alert = driver.switchTo().alert();
//			String text = alert.getText();
//			System.out.println(text);
//			alert.accept();
//			return text;
//		}
//		
//		/**
//		 * Get title
//		 * @param driver
//		 * @return
//		 */
//		public static String getPageTitle(WebDriver driver){
//			return driver.getTitle();
//		}
//		
//		/**
//		 * URL
//		 * @param driver
//		 * @param url
//		 */
//		public static void launchURL(WebDriver driver, String url){
//			driver.get(url);
//		}
//		
//		/**
//		 * Lauch browser
//		 * @param driver
//		 * @param browserName
//		 * @return
//		 */
//		public static WebDriver launchBrowser(WebDriver driver, String browserName){
//			if(browserName.equals("chrome")){
//				System.setProperty("webdriver.chrome.driver", "/usr/local/bin/chromedriver");
//				driver = new ChromeDriver();
//			}
//			else if(browserName.equals("firefox")){
//				System.setProperty("webdriver.gecko.driver", "/Users/bobit/Documents/Drivers/geckodriver");
//				driver = new FirefoxDriver();
//			}
//			else{
//				System.out.println("Browser is not available "+ browserName);
//			}
//			return driver;
//		}
//		
//		/**
//		 * click on element
//		 * @param driver
//		 * @param locator
//		 */
//		public static void clickOn(WebDriver driver, By locator){
//			driver.findElement(locator).click();
//		}
//		
//		/**
//		 * get element
//		 * @param driver
//		 * @param locator
//		 * @return
//		 */
//		public static WebElement getElement(WebDriver driver, By locator){
//			WebElement element = driver.findElement(locator);
//			return element;
//		}
//		
//		/**
//		 * close browser
//		 * @param driver
//		 */
//		public static void closeBrowser(WebDriver driver){
//			driver.close();
//		}
//		
//		/**
//		 * quit browser
//		 * @param driver
//		 */
//		public static void quitBrowser(WebDriver driver){
//			driver.quit();
//		}
//		public static void mouseOver(WebDriver driver, By locator){
//
//	        Actions action = new Actions(driver);
//	        WebElement mouseOverAction = driver.findElement(locator);
//	        action.moveToElement(mouseOverAction).perform();
//	    }
//		

//}
