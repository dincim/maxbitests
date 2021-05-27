package com.maxBi;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LogInTest {
	
	WebDriver driver; 
	String baseUrl = "http://powerbi.amaxinsurance.com/";
	
	@BeforeMethod
	public void setUp() {
		
		System.setProperty("webdriver.chrome.driver", 
				"C:\\SeleniumDrivers\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.manage().deleteAllCookies();
		driver.get(baseUrl);		
	}
	
	@Test
	public void verifyLogInTest() {
		
		driver.findElement(By.xpath("//div[@class='hod-login login-div']")).click();
		driver.findElement(By.xpath("//input[@type='email']")).sendKeys("mdinc@amaxinsurance.com");
		driver.findElement(By.xpath("//input[@type='password']")).sendKeys("mdinc2020!");;
		driver.findElement(By.xpath("//button[@class='login-btn']")).click();	
	}
	
	@Test
	public void verifyPageTitleTest() {
		
		String title =driver.getTitle();
		System.out.println("The page title is: "+ title);
		Assert.assertEquals(title, "AmaxIns.Web");
		
		
	}
	

	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	

}
