package com.crm.qa.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import com.crm.qa.base.TestBase;

public class FundTransfer extends TestBase{
  
	@FindBy(xpath="//h1[text()='Transfer Funds']")
	WebElement transferFundLabel;
	
	@FindBy(id="amount")
	WebElement amount;
	
	@FindBy(xpath="//*[@value='Transfer']")
	WebElement trnasferBtn;
	
	@FindBy(xpath="//*[text()='Transfer Funds']")
	WebElement fundTransferLink;
	

	
	public FundTransfer(){
		PageFactory.initElements(driver, this);
	}
	
	public boolean verifytransferFundLabel(){
		return transferFundLabel.isDisplayed();
	}
	
	public void clickFundTransfer() {
		fundTransferLink.click();
	}
	// use when Data driven is not added to project
	public void fundTransfer(String amounts, String toacct, String fromacct){
		amount.sendKeys(amounts);
		Select select = new Select(driver.findElement(By.id("fromAccountId")));
		select.selectByVisibleText(fromacct);
		
		 select = new Select(driver.findElement(By.id("toAccountId")));
		select.selectByVisibleText(toacct);
		
		trnasferBtn.click();
		
		
		
	}
	
	

}
