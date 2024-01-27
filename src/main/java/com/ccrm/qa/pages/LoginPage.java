package com.ccrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ccrm.qa.base.BasePage;


public class LoginPage extends BasePage {
	
	@FindBy(name="email")
    WebElement email;
	@FindBy(name="password")
	WebElement password;
	
	@FindBy(xpath="//div[text()='Login']")
	WebElement loginBtn;
	
	public LoginPage()
	{
		PageFactory.initElements(driver, this);	 
	}  
	
	public String getLoginPageTitle()
	{
		
		 return driver.getTitle();
	}
	
	public HomePage doLogin(String em,String pwd)
	{
		doSendKeys(email,em);
		doSendKeys(password,pwd);
		doClick(loginBtn);
		
		return new HomePage();
	}
	
}
