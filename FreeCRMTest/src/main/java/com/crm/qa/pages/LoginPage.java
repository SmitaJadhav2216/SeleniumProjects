package com.crm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.crm.qa.base.TestBase;

public class LoginPage extends TestBase{
	
	//Page Factory - Object Rep:
	@FindBy(how = How.XPATH, using = "//input[@name='username']")
	WebElement username;
	
	@FindBy(how = How.XPATH, using = "//input[@name='password']")
	WebElement password;
	
	@FindBy(xpath="//div[@class='login']")
	WebElement loginBtn;
	
	@FindBy(linkText="Register")
	WebElement signupBtn;
	
	@FindBy(xpath="//img[@alt='ParaBank']")
	WebElement parasBanklogo;
	
	@FindBy(xpath="//*[text()='Log Out']")
	WebElement logout;
	
	//Initializing the page objects:
	public LoginPage(){
		PageFactory.initElements(driver, this);// 'this' means current class objects. Can also use LoginPage.class		
	}
	
	//Actions:
	public String validateLoginPageTitle(){
		return driver.getTitle();//always use string for getTitle		
	}
	
	public boolean validateBankImage(){
		TestBase.wait.until(ExpectedConditions.visibilityOf(parasBanklogo));
				return parasBanklogo.isDisplayed();//always use boolean for isDisplayed
	}
	
	public void login(String un, String pwd){
		TestBase.wait.until(ExpectedConditions.elementToBeClickable(username));
		username.sendKeys(un);
		TestBase.wait.until(ExpectedConditions.elementToBeClickable(password));
		password.sendKeys(pwd);
		// METHOD 1 - use .click()
		//loginBtn.click();
		
		// METHOD 2 - use .submit()
		loginBtn.submit();
		
		// METHOD 3 - use javascriptexecutor
		//JavascriptExecutor js = (JavascriptExecutor)driver; 
	    //js.executeScript("arguments[0].click();", loginBtn);		
		//return new HomePage();// login page lands to homepage, so use return method
	}
	
	public void logoutClick() {
		logout.click();
	}
	
	
}
