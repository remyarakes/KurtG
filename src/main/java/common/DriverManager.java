package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class DriverManager {
private static WebDriver driver = null;
private static WebDriver firefoxDriver = null;

public static synchronized WebDriver getDriver(String browser) {

	if(browser.equals("chrome")){
		if(driver==null){
			String CHROME_DRIVER_PATH=DriverManager.class.getClassLoader().getResource("chromedriver.exe").getPath();
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}

		return driver;
	}else if(browser.equals("firefox")){
		if(firefoxDriver==null){
			String CHROME_DRIVER_PATH=DriverManager.class.getClassLoader().getResource("chromedriver.exe").getPath();
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			firefoxDriver = new FirefoxDriver();
			firefoxDriver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		return firefoxDriver;
	}else{
		throw new RuntimeException("Unsupported driver");
	}

	}
}


