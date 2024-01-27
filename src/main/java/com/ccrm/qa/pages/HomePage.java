package com.ccrm.qa.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ccrm.qa.base.BasePage;

public class HomePage extends BasePage {

	
	@FindBy(xpath="//span[text() = 'Johnny Deep']")
	@CacheLookup
	WebElement userNameLabel;
	
	@FindBy(xpath="//div[@id='main-nav']")
	WebElement mainNav;
	
	@FindBy(xpath="//span[text()='Contacts']")
	WebElement contactsLink;
	
	@FindBy(xpath="//th[text()='Email']")
	WebElement contactPagecusrsormove;
	
	@FindBy(xpath="//a[@href='/contacts']/following-sibling::button//i[@class='plus inverted icon']")
	WebElement newContactLink;
	
	@FindBy(xpath="//input[@name='first_name']")
	WebElement addContactCursormove;
	
	@FindBy(xpath="//span[text()='Deals']")
	WebElement dealsLink;
	
	@FindBy(xpath="//div[@name='company']")
	WebElement addDealsCursormove;
	
	@FindBy(xpath= "//span[text()='Tasks']")
	WebElement tasksLink;
	
	public static Actions a = new Actions(driver);
	
	public HomePage() {
		PageFactory.initElements(driver, this);	
	}
	

	public String homePageTilte()
	{
		return driver.getTitle();
	}
	

	public boolean verifyCorrectUserName()
	{
		return userNameLabel.isDisplayed();
	}
	
     public void contactPageClick()
     {
    	 moveToElement(mainNav);
    	 doClick(contactsLink);
     }
	
	
	
	
	
}
