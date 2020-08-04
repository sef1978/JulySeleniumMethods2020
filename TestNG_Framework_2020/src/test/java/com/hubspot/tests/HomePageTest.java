package com.hubspot.tests;

import java.util.Properties;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.hubspot.base.BasePage;
import com.hubspot.pages.HomePage;
import com.hubspot.pages.LoginPage;
import com.hubspot.util.Constants;

public class HomePageTest {

	WebDriver driver;
	Properties prop;
	BasePage basePage;
	LoginPage loginPage;
	HomePage homePage;
	
	@BeforeMethod
	public void setUp() {
		basePage = new BasePage();
		prop = basePage.initialize_properties();
		driver = basePage.initialize_driver(prop);
		loginPage = new LoginPage(driver);
		homePage = loginPage.doLogin(prop.getProperty("username"), prop.getProperty("password"));
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		homePage = new HomePage(driver);
	}
	
	
	
	@Test(priority=1, description="get home page title")
	public void verifyHomePageTitle(){
		String title = homePage.getHomePageTitle();
		System.out.println("Home Page title : " + title);
		Assert.assertEquals(title, Constants.HOME_PAGE_TITLE);
	}
	
	
	
	@Test(priority=2,description="get home page header")
	public void verifyHomePageHeader(){
		String header = homePage.getHomePageHeader();
		System.out.println("Home Page header : " + header);
		Assert.assertEquals(header, Constants.HOME_PAGE_HEADER);
	}
	
	
	
	@Test(priority=3,description="get account name in home page")
	public void verifyLoggedInUserAccountName(){
		String accountname = homePage.getLoggedInAccountName();
		System.out.println("Account name : " + accountname);
		Assert.assertEquals(accountname, Constants.ACCOUNT_NAME);
	}
	
	

	@AfterMethod
	public void tearDown(){
	//	driver.quit();
		basePage.quitBrowser();
	}
	
}
