package com.plamenti;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Browser {

	static WebDriver driver;

	static {
		// For Windows
		System.setProperty("webdriver.chrome.driver", "./src/main/resources/drivers/chromedriver.exe");
		// System.setProperty("webdriver.chrome.driver",
		// "./src/main/resources/drivers/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "./src/main/resources/drivers/geckodriver.exe");
		// System.setProperty("webdriver.ie.driver",
		// "./src/test/resources/drivers/iedriverserver.exe");

		// For Linux -
		// !!! Important !!!
		// On Linux and Mac operating systems, the chromdriver file needs to be made
		// executable using the chmod +x command filename
		// or the chmod 775filename command
		// System.setProperty("webdriver.chrome.driver",
		// "./src/test/resources/drivers/chromedriver.exe");
		// System.setProperty("webdriver.gecko.driver",
		// "./src/test/resources/drivers/geckodriver.exe");

		// The path to the drvers can be added in System path (Linux, Windows) so the
		// above code will unnecessary
		// e.g. for Linux export CHROME_DRIVER = path to the driver
		// export PATH = $PATH:$CHROME_DRIVER

		// To use Chrome in headless mode
		// ChromeOptions options = new ChromeOptions();
		// options.setHeadless(true);

		// this.driver = new ChromeDriver(options);
		driver = new ChromeDriver();
		driver.switchTo().defaultContent();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
	}

	public static WebDriver getDriver() {
		return driver;
	}

	public static void navigate(String url) {
		getDriver().get(url);
	}

	public static String title() {
		return getDriver().getTitle();
	}

	public static void close() {
		getDriver().close();
	}
}
