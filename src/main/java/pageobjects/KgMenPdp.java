package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * author: remya
 * Page objects for the Men product description page - pdp
 */

public class KgMenPdp {
	private WebDriver driver;
	
	@FindBy(xpath = "//*[@id='plp-title']/div/h1")
	@CacheLookup
	private WebElement menShoesText;
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div[1]/div/div/div[2]/div[2]/div/ol/li[5]/button")
	@CacheLookup
	private WebElement shoeSize;
	
	@FindBy(xpath = "//*[@id='root']/div/div/div[3]/div[1]/div/div/div[2]/div[3]/div/ol/li[1]/button")
	@CacheLookup
	private WebElement shoeColour;
	
	public KgMenPdp(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver = driver;
	}
	
	public WebElement getMenShoesText() {
		return menShoesText;
	}
	
	public WebElement getShoeSize() {
		return shoeSize;
	}
	
	public WebElement getShoeColour() {
		return shoeColour;
	}
	
	//method to select shoe size
	public KgMenPdp selectShoeSize() {
		this.shoeSize.click();
		return this;
	}
	
	//method to select shoe colour
	public KgMenPdp selectShoeColour() {
		this.shoeColour.click();
		return this;
	}
	
	//method to verify current url
	public boolean verifyCurrentUrl() {
		String url = driver.getCurrentUrl();
		return url.contains("/men/shoes");
	}
	
	//method to verify filters
	public boolean verifyFilters() {
		String filterUrl = driver.getCurrentUrl();
		return filterUrl.contains("/men/shoes?page=1#size/82e5202f20422e5/colour_group/black");
	}
}

