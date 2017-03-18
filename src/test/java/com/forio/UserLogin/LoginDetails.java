package com.forio.UserLogin;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginDetails {
	
	static WebElement element = null;
	
	public static WebElement emailField(WebDriver driver,String value){
		element = driver.findElement(By.xpath("//input[@name='email']"));
		element.sendKeys(value);
		return element;
	}
	
	public static WebElement passwordField(WebDriver driver,String value){
		element = driver.findElement(By.xpath("//input[@name='password']"));
		element.sendKeys(value);
		return element;
	}
	
	
	public static WebElement signinButton(WebDriver driver){
		element = driver.findElement(By.xpath("//div[@id='register-or-sign-in']//button"));
		element.click();
		return element;
	}
	
	
	
	

}
