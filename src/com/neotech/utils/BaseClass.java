package com.neotech.utils;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseClass {
	public static WebDriver driver;

	/**
	 * This method will create the driver and return it
	 * 
	 * @return WebDriver driver
	 */
	@BeforeMethod(alwaysRun = true)
	public static WebDriver setUp() {
		ConfigsReader.readProperties(Constants.CONFIGURATION_FILEPATH);

		switch (ConfigsReader.getProperty("browser").toLowerCase()) {
		case "chrome":
			System.setProperty("webdriver.chrome.driver", Constants.CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			break;
		case "firefox":
			System.setProperty("webdriver.gecko.driver", Constants.GECKO_DRIVER_PATH);
			driver = new FirefoxDriver();
			break;
		default:
			throw new RuntimeException("Browser is not supported!");
		}

		driver.manage().timeouts().implicitlyWait(Constants.IMPLICIT_WAIT_TIME, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		driver.get(ConfigsReader.getProperty("url"));

		return driver;
	}

	/**
	 * This method will quit the browser
	 */
	@AfterMethod(alwaysRun = true)
	public static void tearDown() {
		if (driver != null) {
			driver.quit();
		}
	}
}

