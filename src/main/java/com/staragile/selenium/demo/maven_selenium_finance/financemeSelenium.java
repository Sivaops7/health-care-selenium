package com.staragile.selenium.demo.maven_selenium_finance;


import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;


public class financemeSelenium
{
    public static void main( String[] args ) throws InterruptedException, IOException
    {
    	System.setProperty("webdriver.chrome.driver", "/home/sivaops7/Devops/selenium/chrome/chromedriver");
		ChromeOptions chromeOptions = new ChromeOptions();
		WebDriver driver = new ChromeDriver(chromeOptions);
		driver.get("http://3.144.20.109:8086//contact.html");
		driver.manage().timeouts().implicitlyWait(5,TimeUnit.SECONDS);
		driver.findElement(By.name("Name")).sendKeys("sivabalan");
		driver.findElement(By.name("Phone Number")).sendKeys("8903780909");
		driver.findElement(By.name("Email")).sendKeys("sivabalana91@gmail.com");
		driver.findElement(By.name("Message")).sendKeys("Hello siva, Welcome to finance");
		driver.findElement(By.className("send_bt")).click();
		
		String message = driver.findElement(By.id("message")).getText();
		if(message.equals("Email Sent")){
			System.out.println("Script executed sucessfully");
		}else {
			System.out.println("Automation script failed");
		}
		TakesScreenshot scrShot = ((TakesScreenshot)driver);
		File screenShot = scrShot.getScreenshotAs(OutputType.FILE);
		File destFile = new File("/home/sivaops7/Devops/staragile/finace.png");
		FileUtils.copyFile(screenShot, destFile);
		
		Thread.sleep(3000);
		driver.close();
    }
}

