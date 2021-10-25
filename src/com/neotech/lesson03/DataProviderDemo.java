package com.neotech.lesson03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import com.neotech.utils.CommonMethods;
import com.neotech.utils.ConfigsReader;

public class DataProviderDemo extends CommonMethods {
	
	//This is called Data driven Test,, running the same test multiple times with different data provided 
	//by Data Provider annotation which helps us have a 2D Array, so we can use them as different parameters in our test method
	
	@Test(dataProvider = "getData")
	public void LoginFunctionality(String username, String password) {
		WebElement usernameTxt = driver.findElement(By.id("txtUsername"));
		sendText(usernameTxt,username);
		
		WebElement passwordTxt = driver.findElement(By.id("txtPassword"));
		sendText(passwordTxt,password);
		
		wait(1);
		click(driver.findElement(By.id("btnLogin")));
		
	}
	
	@DataProvider
	public Object[] [] getData(){
		//The number of rows tells how many times the test will run!!!!
		Object [] [] credentials= {
				{"Admin", "admin123"},
				{"Flori","Reis123"}, 
				{"Komron", "horosho123"}
				};
	
		return credentials;
	}

}
