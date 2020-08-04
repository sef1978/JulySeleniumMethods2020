package com.hubspot.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import com.hubspot.util.Constants;
import com.hubspot.util.ElementUtil;
import com.hubspot.util.JavaScriptUtil;

public class ContactsPage {
	WebDriver driver;
	ElementUtil elementUtil;
	JavaScriptUtil jsUtil;

	By createContactButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=1]");
	By createContactFormButton = By.xpath("(//button[@type='button']//span[text()='Create contact'])[position()=2]");

	By email = By.xpath("//input[@data-field='email']");
	By firstName = By.xpath("//input[@data-field='firstname']");
	By lastName = By.xpath("//input[@data-field='lastname']");
	By jobTitle = By.xpath("//input[@data-field='jobtitle']");

	
	public ContactsPage(WebDriver driver) {
		this.driver = driver;
		elementUtil = new ElementUtil(driver);
//		jsUtil = new JavaScriptUtil(driver);
	}

	
	public String getContactsPageTitle() {
//		elementUtil.waitForTitlePresent("Contacts");
//		return elementUtil.doGetPageTitle();
		return elementUtil.waitForGetPageTitle(Constants.CONTACTS_PAGE_TITLE);
	}

	
	public void createNewContact(String mail, String fn, String ln, String jobT) {
		elementUtil.waitForElementPresent(createContactButton);
		elementUtil.doClick(createContactButton);
		
		elementUtil.waitForElementPresent(email);
		elementUtil.doSendKeys(email, mail);
		
		elementUtil.waitForElementPresent(firstName);
		elementUtil.doSendKeys(firstName,fn);
		
		elementUtil.waitForElementPresent(lastName);
		elementUtil.doSendKeys(lastName, ln);
		
		elementUtil.waitForElementPresent(jobTitle);
		elementUtil.doSendKeys(jobTitle, jobT);
		
		elementUtil.doClick(createContactFormButton); // bu kisim yerine asagidakini yazdik, int yada baska sebeble calismayabilir.
		
//		jsUtil.clickElementByJS(elementUtil.getElement(createContactFormButton));
	}
}
