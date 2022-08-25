package com.sjm.utilities;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class CoustomLibrary {
	static WebDriver driver;

	public static void datepicker( WebDriver driver) throws InterruptedException {
		String month="September 2022";
		String day="1";
		driver.findElement(By.xpath("//input[@id=\"txtJourneyDate\"]")).click();
		Thread.sleep(3000);
		while (true)		
		{
			String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

			if(text.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			}

		}

		driver.findElement(By.xpath("//a[normalize-space()="+day+"]")).click();

	}
	public static void datepickertn( WebDriver driver) throws InterruptedException {
		String month="September 2022";
		String day="2";
		driver.findElement(By.xpath("//input[@id='txtReturnJourneyDate']")).click();
		Thread.sleep(3000);
		while (true)		
		{
			String text = driver.findElement(By.xpath("//div[@class='ui-datepicker-title']")).getText();

			if(text.equals(month))
			{
				break;
			}
			else
			{
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();

			}

		}

		driver.findElement(By.xpath("//a[normalize-space()="+day+"]")).click();

	}

}
