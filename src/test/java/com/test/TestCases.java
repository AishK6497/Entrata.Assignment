package com.test;
import java.time.Duration;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import com.base.Base;

public class TestCases extends Base
{ 
	
	//private static final WebElement WebElememt = null;

	TestCases()
	{
		super();
	}
	
	@Test (priority=0)
    public void navigateToProductsPage() {
		//load residentportal page
        driver.get("https://www.entrata.com/products/residentportal");
        
        String pageTitle = driver.getTitle();
        
        //verification logic for the residentportal page
        Assert.assertEquals(pageTitle, "ResidentPortal by Entrata | Property Manager Tools");
    }
	@Test (priority=1)
    public void testInteractWithForm() {
        
  	  WebElement watchDemo = driver.findElement(By.xpath("(//a[text()='Watch Demo'])[4]"));
  	   	 JavascriptExecutor js = (JavascriptExecutor)driver; 
  			js.executeScript("arguments[0].click();", watchDemo);

        // Fill in form fields
        WebElement firstName = driver.findElement(By.id("FirstName"));
        WebElement lastName = driver.findElement(By.id("LastName"));

        firstName.sendKeys("Aishwarya");
        lastName.sendKeys("Kale");

        // verification logic for filled form fields
        Assert.assertEquals(firstName.getAttribute("value"), "Aishwarya");
        Assert.assertEquals(lastName.getAttribute("value"), "Kale");

       
    }
	@Test(priority=2)
	public void dynamicElement()
	{
		// get sale value
		WebElement saleValue = driver.findElement(By.xpath("(//div[text()='Sales: 814.747.5807'])[2]"));
		String Value = saleValue.getText();
	
	     System.out.println(Value);
		if(Value.equalsIgnoreCase("814.747.5807"))
		{
			
			System.out.println("saleValue has been changed"+saleValue.getText());
		    
		}
		else
		{
			System.out.println("saleValue has not been changed");
		}
	
	}
	
	@Test(priority=3)
	public void getAllLinksFromProductPage() 
	{
		//Click on product page 
		driver.findElement(By.xpath("//div[text()='Products']")).click();
		//wait 10 seconds to load data
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
	// get all links stored in WebElement list
	  List<WebElement> Links = driver.findElements(By.xpath("//a[@class='fat-nav-links']"));
	  System.out.println(Links.size());
	  
	  for(WebElement link:Links)
	  {
		  System.out.println(link.getAttribute("href"));
	  }
	  
	  
	}
	
	}
