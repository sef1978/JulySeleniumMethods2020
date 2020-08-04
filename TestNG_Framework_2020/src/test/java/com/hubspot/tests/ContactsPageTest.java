package com.hubspot.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import com.hubspot.base.BasePage;
import com.hubspot.pages.ContactsPage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.ExcelUtil;

public class ContactsPageTest {

	WebDriver driver;
	BasePage basePage;
	Properties prop;
	LoginPage loginPage;
	HomePage homePage;
	ContactsPage contactsPage;
//	Credentials userCred;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
//		userCred = new Credentials(prop.getProperty("username"), prop.getProperty("password"));
//		homePage = loginPage.doLogin(userCred);
//		contactsPage = homePage.goToContactsPage();
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		contactsPage = homePage.gotoContactsPage();
		
	}
	
	
	@Test(priority=1, description = "verify contacts page title")
	public void verifyContactsPageTitle() {
		String title = contactsPage.getContactsPageTitle();
		System.out.println("contacts page title is : " + title);
		Assert.assertEquals(title, "Contacts");
	}
	
	
	@DataProvider
	public Object[][] getContactsTestData(){
		Object [][] data = ExcelUtil.getTestData("contacts");
		return data;
	}
	
	
	@Test(priority=2, dataProvider= "getContactsTestData", description="create new contact")
	public void createContactsTest(String email, String firstName, String lastName, String jobTitle) {
		contactsPage.createNewContact(email, firstName, lastName, jobTitle);
	}
	
	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}
