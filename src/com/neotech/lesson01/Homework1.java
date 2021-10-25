package com.neotech.lesson01;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

//Homework 1: HRMS Application Negative Login: 
//
//    1. Open chrome browser
//    2. Go to “https://opensource-demo.orangehrmlive.com/”
//    3. Enter valid username
//    4. Leave password field empty
//    5. Verify error message with text “Password cannot be empty” is displayed.
public class Homework1 extends CommonMethods{
	
	@Test
	public void negativeLoginTest() {
		sendText(driver.findElement(By.id("txtUsername")),ConfigsReader.getProperty("username"));
		click(driver.findElement(By.id("btnLogin")));
	
		String expectedText="Password cannot be empty";
		String actualText=driver.findElement(By.id("spanMessage")).getText();
		
		if(actualText.equals(expectedText)) {
			System.out.println("Test passed!");
		}else {
			System.out.println("Test failed!");
		}
	
	}

}
