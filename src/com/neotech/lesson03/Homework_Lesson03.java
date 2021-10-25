package com.neotech.lesson03;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

/*
 * Open chrome browser Go to "https://opensource-demo.orangehrmlive.com/" 
 * Login into the application 
 * Add 3 different Employees and create login credentials by providing: 
 * First Name Last Name Username Password 
 * Provide Employee First and Last Name 
 * Verify Employee has been added successfully and take screenshot 
 * (you must have 3 different screenshots) 
 * Close the browser 
 * Specify group for this test case, add it into specific suite and execute from xml file.
 */
public class Homework_Lesson03 extends CommonMethods {
	
	@Test(dataProvider = "empData", groups = { "homework", "regression" })
	public void addEmployee(String name, String lastName, String username, String password) {
		WebElement usernameTxt = driver.findElement(By.id("txtUsername"));
		sendText(usernameTxt, ConfigsReader.getProperty("username"));

		WebElement passwordTxt = driver.findElement(By.id("txtPassword"));
		sendText(passwordTxt, ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));
		wait(1);

		click(driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")));
		click(driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")));

		sendText(driver.findElement(By.xpath("//*[@id=\"firstName\"]")), name);
		sendText(driver.findElement(By.xpath("//*[@id=\"lastName\"]")), lastName);

		String empID = driver.findElement(By.id("employeeId")).getAttribute("value");
		click(driver.findElement(By.xpath("//*[@id=\"chkLogin\"]")));

		sendText(driver.findElement(By.xpath("//*[@id=\"user_name\"]")), username);
		sendText(driver.findElement(By.xpath("//*[@id=\"user_password\"]")), password);
		sendText(driver.findElement(By.xpath("//*[@id=\"re_password\"]")), password);
		click(driver.findElement(By.xpath("//*[@id=\"btnSave\"]")));

		waitForVisibility(driver.findElement(By.id("pdMainContainer")));

		String actualId = driver.findElement(By.id("personal_txtEmployeeId")).getAttribute("value");

		
		Assert.assertEquals(actualId, empID,"Emplyee ID's do not matach");

		takeScreenshot(name + "_" + lastName);
		}
		
	@DataProvider(name = "empData")
	public Object[][] getData() {
		Object[][] credentials = {
				{ "Kemal", "Sunal", "KS123", "12345678" },
				{ "Ben", "Stiller", "BS123", "12345678" },
				{ "Baris", "Manco", "BM123", "12345678" } };

		return credentials;
	}

}
