package com.neotech.lesson03;

import java.io.ObjectInputFilter.Config;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;
//-----------TC-2-----------
//Add 3 Employees with using DataProvider
//Open chrome browser and navigate to Orange HRM website
//Login with valid credentials
//Navigate to addEmployee tab
//Add 3 different employees using data Provider
public class AddEmployeeWithDataProvider extends CommonMethods {
	
	@Test(dataProvider = "empData")
	public void addEmployee(String name, String lastName) {
		WebElement usernameTxt = driver.findElement(By.id("txtUsername"));
		sendText(usernameTxt,ConfigsReader.getProperty("username"));
		
		WebElement passwordTxt = driver.findElement(By.id("txtPassword"));
		sendText(passwordTxt,ConfigsReader.getProperty("password"));
		click(driver.findElement(By.id("btnLogin")));
		wait(1);
		
		click(driver.findElement(By.xpath("//*[@id=\"menu_pim_viewPimModule\"]/b")));
		click(driver.findElement(By.xpath("//*[@id=\"menu_pim_addEmployee\"]")));
		
		sendText(driver.findElement(By.xpath("//*[@id=\"firstName\"]")), name);
		sendText(driver.findElement(By.xpath("//*[@id=\"lastName\"]")), lastName);
		
		click(driver.findElement(By.xpath("//*[@id=\"btnSave\"]")));
		wait(1);
	}
	
	@DataProvider(name="empData")
	public Object[] [] getData(){
		Object [] [] credentials= {
				{"Kemal", "Sunal"},
				{"Ben","Stiller"}, 
				{"Baris", "Manco"}
				};
	
		return credentials;
	}
}
