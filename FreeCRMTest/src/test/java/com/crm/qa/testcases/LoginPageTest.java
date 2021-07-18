package com.crm.qa.testcases;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.LoginPage;

public class LoginPageTest extends TestBase{
	LoginPage loginPage;
	//HomePage homePage;
	
	public LoginPageTest(){
		super();//using this it will not throw null pointer exception
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		loginPage = new LoginPage();
	}
	
	@Test//(priority=1)
	public void loginPageTitleTest(){
		String title = loginPage.validateLoginPageTitle();
		Assert.assertEquals(title, "ParaBank | Welcome | Online Banking");
	}
	
	@Test//(priority=2)
	public void crmLogoImageTest(){
		boolean flag = loginPage.validateBankImage();
		Assert.assertTrue(flag);		
	}
	
	@Test//(priority=3)
	public void loginTest(){
		loginPage.login(TestBase.prop.getProperty("username"), TestBase.prop.getProperty("password"));//login method returns homepage class object
	}
	
	@AfterMethod
	public void tearDown(){
		//loginPage.logoutClick();
		driver.quit();
		driver = null;
	}
	
}
