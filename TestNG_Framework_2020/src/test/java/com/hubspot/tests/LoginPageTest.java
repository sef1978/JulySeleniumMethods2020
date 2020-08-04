package com.hubspot.tests;
import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hubspot.base.BasePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class LoginPageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	
	@BeforeMethod
	public void setUp(){
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
	}
	
	
	@Test(priority=2, description="login test using correct username and correct password")
	public void loginTest1(){
		loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
	}
	
	
	@Test(priority=3, description="login test using incorrect username and correct password")
	public void loginTest2(){
		loginPage.doLogin(prop.getProperty("incorrectuname"), prop.getProperty("password"));
	}
	
	
	@Test(priority=4, description="login test using incorrect username and incorrect password")
	public void loginTest3(){
		loginPage.doLogin(prop.getProperty("incorrectuname"), prop.getProperty("incorrectpword"));
	}
	
	
	@Test(priority=1,enabled=true,description="getting the title from HubSpot Login Page = HubSpot Login")
	public void getTitle(){
		String title = loginPage.getPageTitle();
		System.out.println(title);
		Assert.assertEquals(title, Constants.LOGIN_PAGE_TITLE, "title is incorrect");	
	}
	
	
	@AfterMethod
	public void tearDown(){
	//	driver.quit();
		basePage.quitBrowser();
	}
}

// https://github.com/BobIT37/TestNGNovember2019/blob/master/src/test/java/com/hubspot/tests/LoginPageTest.java