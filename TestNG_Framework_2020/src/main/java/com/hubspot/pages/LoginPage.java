package com.hubspot.pages;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;import net.bytebuddy.dynamic.TypeResolutionStrategy.Passive;
import sun.util.logging.resources.logging;

public class LoginPage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	
	
	By emailId = By.id("username");
	By pw = By.id("password");
	By lgnBtn = By.id("loginBtn");
			
	// Constructor
	public LoginPage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
	}
	
	// Page actions
	public String getPageTitle(){
		//return driver.getTitle();
		return elementUtil.waitForGetPageTitle(Constants.LOGIN_PAGE_TITLE);
	}
	
	
	
	public HomePage doLogin(String username, String pwd){
//		driver.findElement(emailId).sendKeys(username);
//		driver.findElement(pw).sendKeys(pwd);
//		driver.findElement(lgnBtn).click();
//		return new HomePage(driver);
		
		elementUtil.doSendKeys(emailId, username);
		elementUtil.doSendKeys(pw, pwd);
		elementUtil.doClick(lgnBtn);
		
		return new HomePage(driver);
	
	}
	
	
}
