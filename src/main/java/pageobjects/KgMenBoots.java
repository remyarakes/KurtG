package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * author: remya
 * Page Objects for the sub-category page, Men/Boots
 */

public class KgMenBoots {
	@FindBy(xpath = "//*[@id='plp-title']/div/h1")
	@CacheLookup
	private WebElement mensBootsText;

	private WebDriver driver;
	
	public KgMenBoots(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public String getMensBootsText() {
		return mensBootsText.getText();
	}

	public boolean verifyCurrentUrl(){
		String url = driver.getCurrentUrl();
		return url.contains("/men/shoes/boots");
	}
}
