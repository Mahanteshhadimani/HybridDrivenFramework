package config;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;

import executionEngine.DriverScript;
import utility.Log;

import static executionEngine.DriverScript.ObjectRepository;

public class ActionKeywords {

	public static WebDriver driver;

	@SuppressWarnings("deprecation")
	public static void openBrowser(String object, String data) {
		Log.info("Opening Browser");
		try {
			if (data.equals("Mozilla")) {
				System.setProperty("webdriver.gecko.driver", "C:\\DEV\\geckodriver\\geckodriver.exe");
				driver = new FirefoxDriver();
				Log.info("Mozilla browser started");
			} else if (data.equals("Edge")) {
			    File file = new File("C:\\DEV\\edgedriver\\MicrosoftWebDriver.exe");

			    System.setProperty("webdriver.edge.driver", file.getAbsolutePath());
			    DesiredCapabilities capabilities = DesiredCapabilities.edge();
			    driver = new EdgeDriver(capabilities);
				
				Log.info("IE browser started");
			} else if (data.equals("Chrome")) {
				System.setProperty("webdriver.chrome.driver", "C:\\DEV\\chromedriver\\chromedriver.exe");
				driver = new ChromeDriver();
				Log.info("Chrome browser started");
			}

			int implicitWaitTime = (10);
			driver.manage().timeouts().implicitlyWait(implicitWaitTime, TimeUnit.SECONDS);
		} catch (Exception e) {
			Log.info("Not able to open the Browser --- " + e.getMessage());
			DriverScript.bResult = false;
		}
	}

	public static void navigate(String object, String data) {
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

	public static void enterUserName(String object, String data) {
		try {
			Log.info("Entering the text in UserName");
			System.out.println(object);
			driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			Log.info("Not able to enter Username --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void enterPassword(String object, String data) {
		try {
			Log.info("Entering the text in Password");
			driver.findElement(By.xpath(ObjectRepository.getProperty(object))).sendKeys(data);
		} catch (Exception e) {
			Log.info("Not able to enter Password --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void waitFor(String object, String data) throws Exception {
		try {
			Log.info("Wait for 5 seconds");
			Thread.sleep(5000);
		} catch (Exception e) {
			Log.info("Not able to wait --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void clickAccountSettings(String object, String data) {
		try {
			Log.info("Click on Account Settings");
			driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
		} catch (Exception e) {
			Log.info("Not able to click Account Settings --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void clickLogout(String object, String data) {
		try {
			Log.info("ClickLogout");
			driver.findElement(By.linkText(ObjectRepository.getProperty(object))).click();
		} catch (Exception e) {
			Log.info("Not able to click logout --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void closeBrowser(String object, String data) {
		try {
			Log.info("Closing the browser");
			driver.quit();
		} catch (Exception e) {
			Log.info("Not able to close the browser --- " + e.getMessage());
			DriverScript.bResult = false;
			e.printStackTrace();
		}
	}

	public static void click(String object, String data) {
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