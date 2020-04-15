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

public class Adminstrator extends BaseClass
{
	
	public Adminstrator(WebDriver driver)
	{
		driver=Adminstrator.driver;
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
	
	@FindBy(how=How.XPATH,using="//div[@class='data-title']")
	private WebElement accesscontrolPanel;
		
	@FindBy(how=How.XPATH,using="//div[@class='userBotm']/a[1]")
	private WebElement SignOut;
	
	@FindBy(how=How.XPATH,using="//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul/li[7]/span/label")
	private WebElement editPermission;
	
	@FindBy(how=How.XPATH,using="//div[@class='modal-dialog']//following::div[@class='modal-content'][2]/div/h4")
	private WebElement fieldLevel;	
	
	@FindBy(how=How.ID,using="save_field_permissions_btn")
	private WebElement fieldLevelAccessSaveButton;	
	
	@FindBy(how=How.XPATH,using="//div[@id='fields_permissions_div']//following::div[1]/label[1]/input")
	private WebElement none;
	
	@FindBy(how=How.ID,using="flashMsg")
	private WebElement flashMsg;
	
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
	
	public void VerifyAccessControl(String searchValue) throws InterruptedException
	{
		//String pageTitle = "Access Control";
		logger.info("Click on setup button");
		setup.click();
		WebDriverWait wait = new WebDriverWait(driver, 10);
		wait.until(ExpectedConditions.visibilityOf(searchBox));
		
		logger.info("Input the search value" + searchValue);
		searchBox.sendKeys(searchValue);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("suggesstion-box")));
		
		logger.info("Click on access control link");
		Thread.sleep(2000);
		accesscontrol.click();				
		wait.until(ExpectedConditions.visibilityOf(accesscontrolPanel));
		logger.info("Verify the user is navigated to Access control Page");
				
		
	}
	
	public void verifySecurityPermissionDropDown(String value) throws InterruptedException
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adminmaintable_formpermission_repeat']/ul/li[7]/span/label")));
				
		logger.info("Verify the security permission drop down");
		WebElement dropdown =driver.findElement(By.id("module_list"));
		Select drpdwnVal = new Select(dropdown);
		List<WebElement> val =drpdwnVal.getOptions();
		
		for (WebElement SecurityPermissiondrpdwnValues : val)
		{
			String valueToBeSelected = SecurityPermissiondrpdwnValues.getText();
			logger.info("Verify that user is selected a value from drop down and it is:" + valueToBeSelected);
			if(value.equalsIgnoreCase(valueToBeSelected))
			{
				logger.info("Verify that user clicked on Job posting value");
				SecurityPermissiondrpdwnValues.click();
				Thread.sleep(2000);
				wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul/li[7]/span/a")));
				
				
			}
			
		}
	}
		
	public void verifyUserRole(String value) throws InterruptedException
		{
			String UserRole_id = null;
			String data_title = null;
			logger.info("Verify that user role is selected from the Access control Page");
			
			List<WebElement> roleIds = driver.findElements(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul/li[7]/span/a"));
			for (int i = 1; i < roleIds.size(); i++)
			{
				UserRole_id = driver.findElement(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul["+i+"]/li[7]/span/a")).getAttribute("role_id");
				data_title = driver.findElement(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul["+i+"]/li[7]/span/a")).getAttribute("data-title");
				if(data_title.equalsIgnoreCase(value))
					break;
			}
			
			List<WebElement> val =driver.findElements(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul/li[1]/span"));
			
			for (WebElement userRoleValues : val)
			{
				
				String valueToBeSelected = userRoleValues.getText();
				logger.info("Verify user role from the Access control table and it is :" + valueToBeSelected);
				if(value.equalsIgnoreCase(valueToBeSelected))
				{
					
					logger.info("Verify user clicks on edit link");
					String data = driver.findElement(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul["+UserRole_id+"]/li[7]/span/a")).getAttribute("data-title");
					System.out.println(data);
					driver.findElement(By.xpath("//div[@class='adminmaintable_formpermission']//following::div[@class='adminmaintable_formpermission_repeat']/ul["+UserRole_id+"]/li[7]/span/a")).click();
					Thread.sleep(3000);
					WebDriverWait wait = new WebDriverWait(driver, 15);
					wait.until(ExpectedConditions.visibilityOf(fieldLevelAccessSaveButton));
					Thread.sleep(2000);
					break;					
					
				}
				
			}
			
			logger.info("Verify that user is navigated to respective Field access control");
			Select fieldaccessDropdown = new Select(driver.findElement(By.id("field_roles_list")));
			WebElement option = fieldaccessDropdown.getFirstSelectedOption();
			String defaultItemSelected = option.getText();
			logger.info("user is navigated to Field access control Page: "+ defaultItemSelected);
			if(value.equalsIgnoreCase(defaultItemSelected))
			{
				Assert.assertTrue(true, "Field Access control is navigated for respective User only");
			}
			
			String fieldaccessvalue = driver.findElement(By.xpath("//*[@id='fields_permissions_div']/div[1]/label[1]")).getText();
			logger.info("Verify user clicks on Client Bill Rate/salary None Button ");
			if(fieldaccessvalue.equalsIgnoreCase("None"))
			{
				if(!none.isSelected())
				{
					none.click();
					fieldLevelAccessSaveButton.click();
					Thread.sleep(1000);
					flashMsg.isDisplayed();					
					String ExpectedFlashMsg = "Field permissions updated successfully.";
					Assert.assertEquals(flashMsg.getText(), ExpectedFlashMsg);
				}
				else
				{
					WebDriverWait wait = new WebDriverWait(driver, 15);
					wait.until(ExpectedConditions.visibilityOf(fieldLevelAccessSaveButton));
					fieldLevelAccessSaveButton.click();
					Thread.sleep(1000);
					flashMsg.isDisplayed();					
					String ExpectedFlashMsg = "Field permissions updated successfully.";
					Assert.assertEquals(flashMsg.getText(), ExpectedFlashMsg);
				}
					
			}
			
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
