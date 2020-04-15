package com.Pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.BaseClass.BaseClass;

public class TechnicalRecruiter extends BaseClass
{
	
	public TechnicalRecruiter(WebDriver driver)
	{
		driver=TechnicalRecruiter.driver;
		PageFactory.initElements(driver,this);
		
	}
	
	@FindBy(how=How.ID,using="UserLoginUsername")
	private WebElement UserName;
	
	@FindBy(how=How.ID,using="UserLoginPassword")
	private WebElement Password;
	
	@FindBy(how=How.ID,using="signin_submit")
	private WebElement SignIn;
	
	@FindBy(how=How.ID,using="dropdown05")
	private WebElement UserAccount;
	
	@FindBy(how=How.XPATH,using="//div[@class='mgQL-right fadeIn']")
	private WebElement UserAccessContext;
	
	@FindBy(how=How.XPATH,using="//div[@class='mgQL-right fadeIn']//following::div[@class='userDG']")
	private WebElement UserAccessType;
	
	@FindBy(how=How.LINK_TEXT,using="Setup")
	private WebElement setup;
	
	@FindBy(how=How.ID,using="search-box")
	private WebElement searchBox;
	
	@FindBy(how=How.XPATH,using="//div[@id='suggesstion-box']//following-sibling::li[1]")
	private WebElement accesscontrol;
	
	@FindBy(how=How.XPATH,using="//div[@class='userBotm']/a[1]")
	private WebElement SignOut;
	
	@FindBy(how=How.XPATH,using="//div[@class='collapse navbar-collapse']/ul/li[2]/a")
	private WebElement jobposting;
	
	@FindBy(how=How.XPATH,using="//div[@class='listview-action-panel']/div/ul/li[5]/a")
	private WebElement newbutton;
	
	@FindBy(how=How.ID,using="manual")
	private WebElement createManually;
	
	@FindBy(how=How.XPATH,using="//div[@id='main_div']//following::label[1]")
	private WebElement jobCode;
	
	@FindBy(how=How.XPATH,using="//div[@id='main_div']//following::label[3]")
	private WebElement PayRateSalary;
	
	public void VerifyloginCredentails(String username, String password)
	{
		logger.info("input Username :" + username);
		UserName.sendKeys(username);
		logger.info("click on Next Button");
		SignIn.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(Password));
		logger.info("input Password :" + password);
		Password.sendKeys(password);
		logger.info("click on Sigin Button");
		SignIn.click();
		wait.until(ExpectedConditions.visibilityOf(UserAccount));
		logger.info("Verify that User is logged in successfully to Home Page");
		
	}
	
	public String VerifyUserAccess()
	{
		logger.info("Click on User Account");
		UserAccount.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(UserAccessContext));
		logger.info("Verify the User Context");
		String UserTypeIs = UserAccessType.getText();
		logger.info("User Type is:"+ UserTypeIs);
		return UserTypeIs;
		
	}
	
	public void jobPosting()
	{
		logger.info("Click on Job Posting");
		jobposting.click();
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(newbutton));
		logger.info("Click on New Button");
		newbutton.click();
		wait.until(ExpectedConditions.visibilityOf(createManually));
		logger.info("Click on Create Manually");
		createManually.click();
		wait.until(ExpectedConditions.visibilityOf(jobCode));
		
		logger.info("Verify the Label");
		String expectedLabel ="Pay Rate/Salary";
		String actualLabelIs = PayRateSalary.getText();
		logger.info("Verify the Label and the label is :" + actualLabelIs);
		Assert.assertEquals(actualLabelIs.trim(), expectedLabel.trim());
		
		
	}
	
	
	
	
	
	public void verfyAdminUserSignOuts() throws InterruptedException
	{
		logger.info("Click on User Account");
		Thread.sleep(2000);
		UserAccount.click();		
		WebDriverWait wait = new WebDriverWait(driver, 15);
		wait.until(ExpectedConditions.visibilityOf(SignOut));
		
		logger.info("Click on SignOut button");
		SignOut.click();
	}
}
