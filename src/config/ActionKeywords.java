package config;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import executionEngine.DriverScript;
import utility.Log;

import static executionEngine.DriverScript.ObjectRepository;

public class ActionKeywords {

	public static WebDriver driver;

	public static void openBrowser(String object) {
		try {
			Log.info("Opening Browser");
			System.setProperty("webdriver.gecko.driver", "C:\\DEV\\geckodriver\\geckodriver.exe");
			driver = new FirefoxDriver();
		} catch (Exception e) {
			Log.info("Not able to open Browser --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void navigate(String object) {
		try {
			Log.info("Navigating to URL");
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.get(Constants.URL);
		} catch (Exception e) {
			Log.info("Not able to navigate to URL --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void enterUserName(String object) {
		try {
			Log.info("Entering the text in UserName");
			System.out.println(object);
			driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(Constants.Username);
		} catch (Exception e) {
			Log.info("Not able to enter Username --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void enterPassword(String object) {
		try {
			Log.info("Entering the text in Password");
			driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(Constants.Password);
		} catch (Exception e) {
			Log.info("Not able to enter Password --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void waitFor(String object) throws Exception {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.info("Not able to wait --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void clickAccountSettings(String object) {
		try {
			Log.info("Click on Account Settings");
			driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
		} catch (Exception e) {
			Log.info("Not able to click Account Settings --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void clickLogout(String object) {
		try {
			Log.info("ClickLogout");
			driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
		} catch (Exception e) {
			Log.info("Not able to click logout --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void closeBrowser(String object) {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.info("Not able to close the browser --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void click(String object) {
		try {
			Log.info("Clicking on Webelement " + object);
			System.out.println(object);
			driver.findElement(By.xpath(ObjectRepository.getProperty(object))).click();
		} catch (Exception e) {
			Log.info("Not able to click " + object + " --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}
}