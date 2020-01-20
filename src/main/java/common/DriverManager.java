package common;

import java.util.concurrent.TimeUnit;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DriverManager {
private static WebDriver driver = null;

public static WebDriver getDriver() {

		if(driver==null){
			String CHROME_DRIVER_PATH=DriverManager.class.getClassLoader().getResource("chromedriver.exe").getPath(); 
			System.setProperty("webdriver.chrome.driver", CHROME_DRIVER_PATH);
			driver = new ChromeDriver();
			driver.manage().timeouts().pageLoadTimeout(30, TimeUnit.SECONDS);
			//driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		}
		return driver;
	}
}


