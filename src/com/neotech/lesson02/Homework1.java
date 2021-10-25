package com.neotech.lesson02;

import org.openqa.selenium.By;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class Homework1 extends CommonMethods {

	// I have two test methods in this class
	// openAndNavigate() will be executed before every test methods -> 2 times
	// quitBrowser() will be executed after every test methods -> 2 times

	@Test
	public void negativeLoginTest() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), "");
		click(driver.findElement(By.id("btnLogin")));

		String expectedMsg = "Password cannot be empty";
		String actualMsg = driver.findElement(By.id("spanMessage")).getText();
		if (actualMsg.equals(expectedMsg)) {
			System.out.println("Test passed!!!");
		} else {
			System.out.println("Test failed!!!");
		}
	}

	@Test
	public void loginValidation() {
		sendText(driver.findElement(By.id("txtUsername")), ConfigsReader.getProperty("username"));
		sendText(driver.findElement(By.id("txtPassword")), ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));

		// Continue with the validations
	}

}
