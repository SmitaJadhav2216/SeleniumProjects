package com.crm.qa.testcases;

import java.util.concurrent.TimeUnit;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.crm.qa.base.TestBase;
import com.crm.qa.pages.FundTransfer;
import com.crm.qa.pages.LoginPage;
import com.crm.qa.util.TestUtil;

public class FundTransferTest extends TestBase{
	LoginPage loginPage;
	TestUtil testUtil;
	FundTransfer FundTransfer;
	
	String sheetName = "fundTransfer";
	
	public FundTransferTest(){
		super();//using this it will not throw null pointer exception
	}
	
	@BeforeMethod
	public void setUp(){
		initialization();
		testUtil = new TestUtil();
		loginPage = new LoginPage();
		FundTransfer = new FundTransfer();
		loginPage.login(prop.getProperty("username"), prop.getProperty("password"));
		driver.manage().timeouts().pageLoadTimeout(TestUtil.PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS);
		//testUtil.switchToFrame();
		FundTransfer.clickFundTransfer();
	}
	
	@Test(priority=1)
	public void verifyContactsPageLabel(){
		Assert.assertTrue(FundTransfer.verifytransferFundLabel(),"contacts label is missing on the page");		
	}
	
	
	
	
	@DataProvider // use this for Data driven framework
	public Object[][] getfundTransfer(){
		Object data[][] = TestUtil.getTestData(sheetName); //this will store the complete data in data[][]
		return data; // always use return in case of using data and use object[][]
	}
	
	@Test(priority=4, dataProvider="getfundTransfer")//to use the excel sheet in test case use this line
	public void validatefundTransfer(String Amount, String fromacct, String Toacct){ //use same column names which are in excel sheet
		//homePage.clickOnNewContactLink();		
		// use below line only when there are minimum records and not using excel sheet
		//contactsPage.createNewContact("Mr.", "Tom", "Peter", "Google");
		FundTransfer.fundTransfer(Amount,fromacct.substring(0, 4),Toacct.substring(0, 4));		
	}
		
	@AfterMethod(enabled=true)
	public void tearDown(){
		//loginPage.logoutClick();
		driver.quit();
		driver=null;
	}

}
