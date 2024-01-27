package com.ccrm.qa.base;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import com.ccrm.qa.util.TestUtil;

import io.github.bonigarcia.wdm.WebDriverManager;


public class BasePage {

	public static WebDriver driver; 
	public static Properties prop;
	
	public BasePage()
	{
		 prop = new Properties();
			try {
				FileInputStream fis = new FileInputStream(System.getProperty("user.dir")+"\\src\\main\\java\\com\\ccrm\\qa\\config\\config.properties");			
				prop.load(fis);
			}
			catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
	}
	
	public static void initialization()
	{
		String browserName = prop.getProperty("browser"); //Read property
		
		if(browserName.equals("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}
		
		 driver.manage().window().maximize();
		 driver.manage().deleteAllCookies();
		 driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(TestUtil.PAGE_LOAD_TIMEOUT));
		 driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(TestUtil.IMPLICIT_WAIT));
		 driver.get(prop.getProperty("url"));
	}
	
	public void doClick(WebElement element)
	{
		
		element.click();
	}
	
	public void doSendKeys(WebElement element , String text)
	{
		element.click();
		element.sendKeys(text);
	}
	
	public String doGetText(WebElement element)
	{
		return element.getText();
	}
	
	public void moveToElement(WebElement element)
	{
		Actions a = new Actions(driver);
		a.moveToElement(element).build().perform();
	}
	

}
