package pageobjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/*
 * author: remya
 * Page object class to represent the home page.
 */

//Finding the webelements 
public class KgHome {
	private WebDriver driver;
	@FindBy(xpath = "//*[@id='top-nav']/ul/li[7]/div[1]/a/span")
	@CacheLookup
	private WebElement categoryMen;
	
	@FindBy(xpath = "//*[@id='top-nav']/ul/li[7]/div[2]/div[1]/div[2]/ul[2]/li/span/a")
	@CacheLookup
	private WebElement subMenuBoots;
	
	@FindBy(xpath = "//*[@id='top-nav']/ul/li[10]/div[1]/a/span")
	@CacheLookup
	private WebElement categoryBrand;
	
	@FindBy(xpath = "//*[@id='top-nav']/ul/li[10]/div[2]/div[1]/div[2]/ul[9]/li/span/a")
	@CacheLookup
	private WebElement subMenuUgg;
	
	public KgHome(WebDriver driver) {
		PageFactory.initElements(driver,this);
		this.driver=driver;
	}

	public WebElement getCategoryMen() {
		return categoryMen;
	}
	
	public WebElement getSubMenuBoots() {
		return subMenuBoots;
	}

	//method to open the home page
	public void openHomePage(){
		driver.get("https://www.kurtgeiger.com/");
	}
	
	//method to select the category 'Men', navigating to the sub menu 'boots' and clicking it
	public KgHome mouseOverCategoryMen() {
		Actions action = new Actions (driver);
		action.moveToElement(categoryMen).perform();
		action.moveToElement(subMenuBoots).click().perform();
		return this;
	}
	
	//method to select the category 'Brand', navigating to the list of brands and clicking the brand 'UGG'
	public KgHome mouseOverCategoryBrand() {
		Actions action = new Actions(driver);
		action.moveToElement(categoryBrand).perform();
		action.moveToElement(subMenuUgg).click().perform();
		return this;
	}
}
