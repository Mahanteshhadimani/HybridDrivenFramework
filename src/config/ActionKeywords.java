package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import utility.Log;

import static executionEngine.DriverScript.ObjectRepository;

public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser(String object) {
		Log.info("Opening Browser");
		System.setProperty("webdriver.gecko.driver", "C:\\DEV\\geckodriver\\geckodriver.exe");
		driver = new FirefoxDriver();
	}

	public static void navigate(String object) {
		Log.info("Navigating to URL");
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
		driver.get(Constants.URL);
	}

	public static void enterUserName(String object) {
		Log.info("Entering the text in UserName");
		System.out.println(object);
		driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(Constants.Username);
	}

	public static void enterPassword(String object) {
		Log.info("Entering the text in Password");
		driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(Constants.Password);
	}

	public static void waitFor(String object) throws Exception {
		Log.info("Wait for 5 seconds");
		Thread.sleep(5000);
	}

	public static void clickAccountSettings(String object) {
		Log.info("Click on Account Settings");
		driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
	}

	public static void clickLogout(String object) {
		Log.info("ClickLogout");
		driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
	}

	public static void closeBrowser(String object) {
		Log.info("Closing the browser");
		driver.quit();
	}

	public static void click(String object) {
		Log.info("Clicking on Webelement " + object);
		System.out.println(object);
		driver.findElement(By.xpath(ObjectRepository.getProperty(object))).click();
	}
}