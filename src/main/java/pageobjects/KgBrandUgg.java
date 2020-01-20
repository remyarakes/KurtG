package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * 
 * author: remya
 * Page objects for the sub-category page Brand/UGG
 */

public class KgBrandUgg {
	@FindBy(xpath = "//*[@id='plp-title']/div/h1")
	@CacheLookup
	private WebElement brandUggText;

	private WebDriver driver;
	
	public KgBrandUgg(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public String getBrandUggText() {
		return brandUggText.getText();
	}

	public boolean verifyCurrentUrl(){
		String url = driver.getCurrentUrl();
		return url.contains("/brands/ugg");
	}
}
