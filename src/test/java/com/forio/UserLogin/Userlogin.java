package com.forio.UserLogin;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class Userlogin {

	WebDriver driver;
	String Url = "https://forio.com/epicenter/sign-in";
	LoginDetails login = new LoginDetails();

	@BeforeMethod
	public void beforeMethod() {

		System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
		driver = new FirefoxDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
		driver.get(Url);
	}

	
			
	@Test(priority = 0)
	public void test1(){
		//Test case with valid credentials
		LoginDetails.emailField(driver, "harishyadav.lavrick@gmail.com");
		LoginDetails.passwordField(driver,"Salman@15");
		LoginDetails.signinButton(driver);
		}
				
	
	@Test(priority = 1)
	public void test2() {
		// Test case with wrong password
		LoginDetails.emailField(driver,"harishyadav.lavrick@gmail.com");
		LoginDetails.passwordField(driver,"salman15");
		LoginDetails.signinButton(driver);
		
	}
	
	@Test(priority = 2)
	public void test3() {
		//Test case with empty email field
		LoginDetails.emailField(driver," ");
		LoginDetails.passwordField(driver,"salman15");
		LoginDetails.signinButton(driver);
		
	}
	
	@Test(priority = 3)
	public void test4() {
		//Test case with empty password field
		LoginDetails.emailField(driver,"harishyadav.lavrick@gmail.com ");
		LoginDetails.passwordField(driver,"");
		LoginDetails.signinButton(driver);
		
	}
	
	@Test(priority = 4)
	public void test5() { 
		//Test case with providing password as special characters
		LoginDetails.emailField(driver,"harishyadav.lavrick@gmail.com ");
		LoginDetails.passwordField(driver,"@##%^&*(@");
		LoginDetails.signinButton(driver);
		
	}
	
	@Test(priority = 5)
	public void test6(){
		LoginDetails.emailField(driver, "harishyadav.lavrick@gmail.com");
		LoginDetails.passwordField(driver,"Salman@15");
		LoginDetails.signinButton(driver);
		
		
		//verifying we are in Dashboard page.
		WebElement element = driver.findElement(By.xpath(".//*[@id='personal-panel']//a[text()='Create a New Project']"));
		String text = element.getText();
		System.out.println("text of element is:" + text);
	}
	
	
	
	
	

	@AfterMethod
	public void afterMethod() throws InterruptedException {

		Thread.sleep(1000);

	}

}
