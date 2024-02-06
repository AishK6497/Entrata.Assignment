package com.base;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Base 
{

	protected WebDriver driver;

    @BeforeMethod
    public void setUp() {
    	WebDriverManager.firefoxdriver().setup();
    	driver = new FirefoxDriver();
        driver.manage().window().maximize();
        driver.get("https://www.entrata.com/");
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(30));

    }

    @AfterMethod
    public void tearDown() {
        if (driver != null) {
            driver.quit();
        }
    }
}
