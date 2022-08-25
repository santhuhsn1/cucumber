package com.sjm.utilities;

import java.time.Duration;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import io.github.bonigarcia.wdm.WebDriverManager;

public class BaseSuiteSetUp {
	protected WebDriver driver;
	private ConfigProperties config;
	protected String fileName="testdata";

	@BeforeTest

	public void suiteSetUp() {

		config = new ConfigProperties();
		WebDriverManager.chromedriver().setup();

	}

	@BeforeMethod

	public void onBefore() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get(config.getApplicationUrl("url"));
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	//	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
			}

	@AfterMethod
	public void teatDown() {

		driver.quit();
	}




}
