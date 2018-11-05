package com.parameters;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

public class ParameterTest {
	
	static WebDriver driver;
	
	@Test
	@Parameters({"url", "mobnumber", "password"})
	public void jdloginTest(String mobnumber, String url, String password) {
		driver = new ChromeDriver();
		driver.get(url);
		driver.findElement(By.id("h_sin_up")).click();
		driver.findElement(By.id("mobile_srch")).sendKeys(mobnumber);
		driver.findElement(By.className("js_sbmt")).click();
		driver.findElement(By.className("sbtnbl")).click();
		driver.findElement(By.id("pass")).sendKeys(password);
		driver.findElement(By.className("jbtn")).click();

		
	}

}
