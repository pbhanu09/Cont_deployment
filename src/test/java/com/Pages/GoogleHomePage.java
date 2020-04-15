package com.Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.BaseClass.BaseClass;


public class GoogleHomePage extends BaseClass
{
	public WebDriver driver;
	
	public GoogleHomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this);
	}
	
	
	@FindBy(how=How.XPATH,using="//input[@class='gLFyf gsfi']")
	private WebElement serachBox;
	
	@FindBy(how=How.XPATH,using="//input[@name='btnK']")
	private WebElement serachButton;
	
	@FindBy(how=How.XPATH,using="//input[@name='btnI']")
	private WebElement FeelingLuckyButton;
	
	
	public void Search(String searchValue)
	{
		logger.info("Search for search box and input the value:" + searchValue);
		serachBox.sendKeys(searchValue);
		WebDriverWait wait = new WebDriverWait(driver, 15);
		//wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@name='btnK']")));
		wait.until(ExpectedConditions.visibilityOf(serachButton));
		logger.info("Click on search button");
		serachButton.click();
	}
	
	
	
	

}
