package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import com.hubspot.base.BasePage;
import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavaScriptUtil;;

public class HomePage extends BasePage{

	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil javaScriptUtil;
	
	By header = By.xpath("//i18n-string[contains(text(),'Dashboard Library')]");
	By accountname = By.xpath("//div[text()='sefika arslan']"); //div[@class='user-info-name']");
	By accAv = By.xpath("//img[@class=' nav-avatar ']");
	By accMenu = By.xpath("//*[@id='account-menu-container']");
	
	By mainContactsLink = By.id("nav-primary-contacts-branch");
	By childContactsLink = By.id("nav-secondary-contacts");
	
	
	// constructor
	public HomePage(WebDriver driver){
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
//		javaScriptUtil = new JavaScriptUtil(driver);
	}
	
	
	public String getHomePageTitle() {
	//	return driver.getTitle();
		return elementUtil.waitForGetPageTitle(Constants.HOME_PAGE_TITLE);
	}
	
	
	public String getHomePageHeader() {
	//	return driver.findElement(header).getText();
		return elementUtil.doGetText(header);
	}


	public String getLoggedInAccountName() {
//		return driver.findElement(accountname).getText();
//		Actions actions = new Actions(driver);
//		WebElement element = elementUtil.getElement(accAv);
//		actions.moveToElement(element).click().perform();
//		//javaScriptUtil.clickElementByJS(element);
		return elementUtil.doGetText(accountname);
	}

	

	public void clickOnContacts(){
		elementUtil.doClick(mainContactsLink);
		elementUtil.doClick(childContactsLink);
	}
	
	
	public ContactsPage gotoContactsPage() {
		clickOnContacts();
		return new ContactsPage(driver);
	}
	
//	public void clickContacts(){
//		elementUtil.waitForElementPresent(mainContactsLink);
//		elementUtil.doClick(mainContactsLink);
//		elementUtil.waitForElementPresent(childContactsLink);
//		elementUtil.doClick(childContactsLink);
//}
}
