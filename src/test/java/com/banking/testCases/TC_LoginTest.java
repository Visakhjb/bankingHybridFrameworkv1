package com.banking.testCases;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import com.banking.pageObjects.LoginPage;

import junit.framework.Assert;


public class TC_LoginTest extends BaseClass{
	
	@Test
	public void loginTest() throws IOException {
		
		logger.info("URL Entered");
		
		LoginPage lp = new LoginPage(driver);
		
		lp.setUserName(username);
		logger.info("username Entered");
		
		lp.setPassword(password);
		logger.info("password Entered");
		
		lp.clickSubmit();
		logger.info("click Submit");
		
		WebDriverWait wait = new WebDriverWait(driver,10);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2")));
		String heading2 = "//h2";
		System.out.println("Heading is"+driver.findElement(By.xpath(heading2)).getText());
		
		if(driver.findElement(By.xpath("//h2")).getText().equals("Guru99 Bank"))
		{
			Assert.assertTrue(true);
			logger.info("Login Test Passed");
		}
		else
		{
			captureScreen(driver, "loginTest");
			Assert.assertTrue(false);
			logger.info("Login Test Failed");
		}
	}

}
