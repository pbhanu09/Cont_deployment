package com.TestScripts;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.BaseClass.BaseClass;

public class TestScripts extends BaseClass
{
	
	@Test(enabled=true)
	public void Tc1()
	{
		
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		
        String baseUrl = "http://demo.guru99.com/test/newtours/";
        String expectedTitle = "Welcome: Mercury Tours";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();

        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)){
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
       
        //close Fire fox
        driver.close();
       
	}
	
	@Test(enabled=true)
	public void TestCase2() throws InterruptedException
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		// find element by locator-name
		driver.findElement(By.name("firstname")).sendKeys("Bhanu");
		Thread.sleep(2000);
		// find element by locator-Id
		driver.findElement(By.id("u_0_7")).click();
		// find element by locator-link text
		driver.findElement(By.linkText("Sign Up")).click();
		
		driver.close();
		
		
	}

	@Test(enabled=false)
	public void TC3_textbox_radioButton()
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		// text box
		driver.findElement(By.name("firstname")).sendKeys("Bhanu");
		
		//Radio button
		driver.findElement(By.id("u_0_7")).click();
		
		// check box
		
		driver.close();
	}
	
	@Test(enabled=true)
	public void TC4_dropdown()
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		Select selectDropdown = new Select(driver.findElement(By.id("year")));
        List<WebElement> listOptionDropdown = selectDropdown.getOptions();
        
        // Count the item drop down list and assign into integer variable
        int dropdownCount = listOptionDropdown.size();//12
        
        // String month_val = listOptionDropdown.get(3).getText();//Mar
        for(int i = 0; i < dropdownCount ; i++)// 12<12 i=12;12<12=>false;12
        {
        	String optionsValue = listOptionDropdown.get(i).getText();//listOptionDropdown.get(11).getText()->Dec
            System.out.println(optionsValue);//Dec//
        }
        driver.close();   
	}
	
	@Test(enabled=true)
	public void TC5_AllLinks()
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		// Only one link that too 1st link
		WebElement ele = driver.findElement(By.tagName("a"));
		System.out.println(ele);
		
		// fetch all the avaiable links from facebook.com page
		List<WebElement> links = driver.findElements(By.tagName("a"));
		 
		 System.out.println(links.size());
		 
		 for (int i = 0; i<links.size(); i++)
		 
		 {
		 
		 System.out.println(links.get(i).getText());
		 
		 
		 }
		 driver.close();
	}
	
	@Test(enabled=true)
	public void TC6_list()
	{
		//List->Interface,<String>,ArrayList->class
		// Webdriver driver = new chromedriver()
		List<String> vals = new ArrayList<String>();
		vals.add("Bhanu1");
		vals.add("Bhanu2");
		vals.add("Bhanu3");
		vals.add("Bhanu4");
		vals.add("Bhanu5");
		
		for (int i = 0; i < vals.size(); i++) 
		{
			System.out.println(vals.get(i).toString());
		}
		driver.close();
	}
		
	@Test
	public void TC7_multipleWindow()
	{
		 //Launching the site.	
		 
         driver.get("http://demo.guru99.com/popup.php");			
         driver.manage().window().maximize();	
         // implicit wait
         
         driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);       		
         driver.findElement(By.xpath("//*[contains(@href,'popup.php')]")).click();	
         
         WebDriverWait wait = new WebDriverWait(driver, 20);
         wait.until(ExpectedConditions.numberOfwindowsToBe(2));
        		 
        		
         String MainWindow=driver.getWindowHandle();//Parent window-12345ABCDE
        	System.out.println("Main Window ID is: " +MainWindow);	//12345ABCDE
        
        	// To handle all new opened window.				
        Set<String> s1 = driver.getWindowHandles();	//12345ABCDE, 2345XYZ	
        int size = s1.size();
        System.out.println(size); //10
        Iterator<String> i1=s1.iterator();		
        		
        while(i1.hasNext())		//hasnext()--boolean-true/false	
        {		
            String ChildWindow=i1.next(); //	2345XYZ
            System.out.println("Child Window ID is: " +ChildWindow);//12345ABCDE	--next()-String
            		
            if(!MainWindow.equalsIgnoreCase(ChildWindow))		//12345ABCDE not equal to 2345XYZ	->
            {    		
                 
                    // Switching to Child window
                    driver.switchTo().window(ChildWindow);	                                                                                                           
                    driver.findElement(By.name("emailid")).sendKeys("gaurav.3n@gmail.com");                			
                    
                    driver.findElement(By.name("btnLogin")).click();			
                                 
                    // Closing the Child Window.
                    driver.close();		
            }		
        }		
        // Switching to Parent window i.e Main Window.
            driver.switchTo().window(MainWindow);
            driver.close();
            driver.quit();
    }

	@Test
	public void TC8_Alert()
	{
		// Alert Message handling
		
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.get("http://demo.guru99.com/test/delete_customer.php");			
                            		
     	      	
        driver.findElement(By.name("cusid")).sendKeys("53920");					
        driver.findElement(By.name("submit")).submit();			
        		
        // Switching to Alert        
        Alert alert = driver.switchTo().alert();		
        		
        // Capturing alert message.    
        String alertMessage= driver.switchTo().alert().getText();		
        		
        // Displaying alert message		
        System.out.println(alertMessage);	
        
        		
        // Accepting alert		
        alert.accept();		
        //alert.dismiss();
        driver.close();
	}
		
	@Test
	public void TC9_Facebook_MN_EMID()
	{
		driver.manage().window().maximize();
		driver.get("https://www.facebook.com/");
		
		WebElement textBox = driver.findElement(By.id("u_0_r"));
		textBox.sendKeys("pbhanu09@gmail.com");
		//textBox.sendKeys("9966954269");
		
		String text = textBox.getAttribute("value");
		
		if(text.contains("@"))
		{
			 driver.findElement(By.id("u_0_u")).sendKeys("pbhanu09@gmail.com");
		}
		
		System.out.println("The text is :" +text);
		driver.close();
		
	}
	
	@Test
	public void TC10_WebTable()
	{
		driver.manage().window().maximize();
		driver.get("https://www.seleniumeasy.com/test/table-search-filter-demo.html");
		
		WebElement baseTable = driver.findElement(By.xpath("//table[@class='table']"));
		//To find third row of table
		 List<WebElement> tableRow = baseTable.findElements(By.xpath("//*[@class='table']//following::tbody/tr"));
		 
		 for (int i = 1; i <= tableRow.size(); i++)
		 {
			//To find third row of table
			 List<WebElement> tableRow_col = baseTable.findElements(By.xpath("//*[@class='table']//following::tbody/tr[1]/td"));
			 
			 for (int j = 1; j <= tableRow_col.size(); j++)
			 {
				 WebElement col_val = baseTable.findElement(By.xpath("//*[@class='table']//following::tbody/tr["+i+"]/td["+j+"]"));
				 System.out.println(col_val.getText());
			 }
		 }
		 driver.close();
	}

	@Test
	public void TC11_Actions()
	{
		 driver.get("https://www.guru99.com/");			
         driver.manage().window().maximize();
         
         Actions actions = new Actions(driver);
         WebElement mainMenu = driver.findElement(By.xpath("(//span[@class='g-menu-item-title'])[2]"));
         actions.moveToElement(mainMenu);
         
         WebElement subMenu = driver.findElement(By.xpath("( //a//following::span[contains(text(),'Selenium')])[1]"));
         actions.moveToElement(subMenu);
         actions.click().build().perform();
         
         driver.close();
	}

	@Test
	public void TC12_IRCTC_alert()
	{
		driver.get("https://www.irctc.co.in/nget/train-search");			
        driver.manage().window().maximize();
        
        driver.findElement(By.xpath("//*[@class='btn btn-primary']")).click();
        
//        Alert alert = driver.switchTo().alert();	
//        alert.accept();
        
        driver.close();
	}

}

