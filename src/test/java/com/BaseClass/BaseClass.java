package com.BaseClass;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.DataProvider;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;
import com.utility.PropertyReader;
import java.io.IOException;
public class BaseClass
{
	public static WebDriver driver;
	private static final int timeValue = 10;
	public static ExtentTest test;
	private static ExtentReports report;

	public static final Logger logger = Logger.getLogger(BaseClass.class.getName());
	static String configFilename = System.getProperty("user.dir") + "//log4j.properties";
	
	@BeforeTest
	public static void getLogger()
	{
		PropertyConfigurator.configure(configFilename);
		logger.info("*****************Start of Test case**********************");
	}
	
	@BeforeClass
	public static void startReport()
	{
		report = new ExtentReports(System.getProperty("user.dir")+"//Reports/ExtentReportResults.html");
		test = report.startTest("ExtentDemo");
	}


	@BeforeMethod
	public void initializer() throws IOException
	{
		
		System.setProperty("webdriver.chrome.driver",System.getProperty("user.dir")+"\\ExtLibs\\chromedriver.exe");
		logger.info("Launch the chrome Browser");
		driver = new ChromeDriver();
		logger.info("Maximize the browser");
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(timeValue, TimeUnit.SECONDS);
//		String URI = PropertyReader.propertyFileReader("URL");
//		logger.info("Input the URL"+ URI);
//		driver.get(URI);
//		String expectedTitle = "Sign In - CEIPAL Talenthire";
//		logger.info("compare the result:"+ driver.getTitle() + ":" +expectedTitle);
//		if(driver.getTitle().equals(expectedTitle))
//		{
//			test.log(LogStatus.PASS, "Navigated to CEIPAL Talenthire Signin Page");
//		}
//		else
//		{
//			test.log(LogStatus.FAIL, "Test initalization Failed");
//		}
//		Assert.assertEquals(driver.getTitle(), expectedTitle, "The Page is not navigated to respective Page");
				
	}
	
//	@AfterMethod
//	public void TearDown()
//	{
//		logger.info("Close the browser");
//		driver.close();
//		logger.info("**************End of Test Case****************");
//	}
		
	@AfterClass
	public static void endReport()
	{
		report.endTest(test);
		report.flush();

	}
	
	@DataProvider(name = "readTestData")
	public Object[] readTestData()
	{
		Object[] obj = new Object[1];
		
		obj[0]= "Bhanu";
		
		return obj;
	}
	
}
