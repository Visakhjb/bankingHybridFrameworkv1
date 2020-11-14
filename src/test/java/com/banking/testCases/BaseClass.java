package com.banking.testCases;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Parameters;

import com.banking.utilities.ReadConfig;


public class BaseClass {
	
	ReadConfig readconfig = new ReadConfig();
	public String baseURL = readconfig.getApplicationURL();
	public String username= readconfig.getUsername();
	public String password= readconfig.getPassword();
	public static WebDriver driver;
	
	public static Logger logger; 
	
	@Parameters("browser")
	@BeforeClass
	public void setup(String browser)
	{
		SimpleDateFormat dateformat = new SimpleDateFormat("yyyy-MM-dd hhmmss");
		String a = new SimpleDateFormat("yyyy-MM-dd hhmmss").format(new Date());
		System.setProperty("current.date", dateformat.format(new Date()));
		
		logger = Logger.getLogger("bankingproject");
		PropertyConfigurator.configure("log4j.properties");
		
		if(browser.equals("Chrome"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--allowed-ips");
//			DesiredCapabilities caps = DesiredCapabilities.chrome();
//					caps.setCapability(ChromeOptions.CAPABILITY, options);
//					caps.setCapability("acceptInsecureCerts", true);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("Edge"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--allowed-ips");
//			DesiredCapabilities caps = DesiredCapabilities.chrome();
//					caps.setCapability(ChromeOptions.CAPABILITY, options);
//					caps.setCapability("acceptInsecureCerts", true);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		else if(browser.equals("InternetExplorer"))
		{
			System.setProperty("webdriver.chrome.driver",readconfig.getChromePath());
//			ChromeOptions options = new ChromeOptions();
//			options.addArguments("--allowed-ips");
//			DesiredCapabilities caps = DesiredCapabilities.chrome();
//					caps.setCapability(ChromeOptions.CAPABILITY, options);
//					caps.setCapability("acceptInsecureCerts", true);
			driver=new ChromeDriver();
			driver.manage().window().maximize();
		}
		
		driver.get(baseURL);
		}

		

	@AfterClass
	public void teardown()
	{
		driver.quit();
	}
	
	public void captureScreen(WebDriver driver, String tname) throws IOException {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File source = ts.getScreenshotAs(OutputType.FILE);
		File target = new File(System.getProperty("user.dir") + "/Screenshots/" + tname + ".png");
		FileUtils.copyFile(source, target);
		System.out.println("Screenshot taken");
	}
	
	public String randomestring()
	{
		String generatedstring=RandomStringUtils.randomAlphabetic(8);
		return(generatedstring);
	}
	
	public static String randomeNum() {
		String generatedString2 = RandomStringUtils.randomNumeric(4);
		return (generatedString2);
	}
	
}
