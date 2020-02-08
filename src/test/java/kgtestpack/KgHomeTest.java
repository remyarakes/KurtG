package kgtestpack;

import java.util.concurrent.TimeUnit;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import common.DriverManager;
import pageobjects.KgBrandUgg;
import pageobjects.KgHome;
import pageobjects.KgMenBoots;
import pageobjects.KgMenPdp;

import static org.testng.Assert.assertEquals;

/*
 * author: remya
 */

public class KgHomeTest {
	private WebDriver driver;
	private final static Logger logger = Logger.getLogger(KgHomeTest.class);

	//Method to open the website 'kurtgeiger.com' in chrome browser
	@BeforeTest
	public void init() {
		//DriverManager.driver;
		driver = DriverManager.getDriver("chrome");
		logger.info("Open Browser");
		KgHome home = new KgHome(driver);
		home.openHomePage();
		String url = driver.getCurrentUrl();
		logger.info("Current url is:" + url);
	}

	/*Scenario 1 : Given the user is on the home page
  			  	   When the user select men category from the header
  			  	   Then the user should see list of products
  			  	   When the user select the boots category
  			  	   Then the user should see only boots	*/	
	@Test (priority = 0)
		public void clickSubMenuBoots() {
			KgHome menu = new KgHome(driver);
			driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
			menu.mouseOverCategoryMen();
			logger.info("The menu item Men is selected, submenu item boots is clicked");
			KgMenBoots menBoots = new KgMenBoots(driver);
			boolean verify =  menBoots.verifyCurrentUrl();
			Assert.assertTrue(verify); //assert the current url
			String bootsText = menBoots.getMensBootsText();
			assertEquals("MEN'S BOOTS", bootsText); //assert the text displayed
			logger.info("The user is redirected to the men's boots page");
		}
	
	/*Scenario 2 : Given the user is on the home page
 	   			   When the user select Brands category from the header
 	   			   Then the user should see list of brands
 	   			   And the user select UGG brand from the list
 	   			   Then the user should see the list of products from UGG	*/
	@Test (priority = 1)
	public void selectSubMenuUgg() {
		KgHome brand = new KgHome(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		brand.mouseOverCategoryBrand();
		logger.info("The category brand is selected and the brand list UGG is clicked");
		KgBrandUgg brandUgg = new KgBrandUgg(driver);
		boolean verify = brandUgg.verifyCurrentUrl();
		Assert.assertTrue(verify); //assert the current url
		String brandUggTest =  brandUgg.getBrandUggText();
		assertEquals("UGG", brandUggTest); //assert the text UGG
		logger.info("The user is redirected to the UGG page ");
	}
	
	/*Scenario 3: Given the user select men category from the header
	 			  And the user is on PDP
	 			  When the select any colour and size for the chosen men category
	 			  And the user adds the product to the bag
	 			  Then the user should see the bag with the single item
	 			  And when the user clicks 'proceed to checkout'
	 			  Then the user should be navigated to the checkout page */
	@Test (priority = 2)
	public void checkoutProcess() {
		KgHome checkout = new KgHome(driver);
		driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
		checkout.clickCategoryMen();
		logger.info("The category Men has been clicked");
		KgMenPdp men = new KgMenPdp(driver);
		boolean verify =men.verifyCurrentUrl();
		Assert.assertTrue(verify); //assert the current url
		men.selectShoeSize().selectShoeSize(); //selecting the shoe size and colour
		logger.info("Shoe colour and size has been selected");
		boolean verifyFilter = men.verifyFilters();
		Assert.assertTrue(verifyFilter);//assert the url after filtering
		logger.info("Men's shoes are filtered and displayed based on the size and colour");
		logger.info("Method name is changed");
		
		
	}
	
	//Method to close the browser
		@AfterTest
		public void closeBrowser() {
			driver.close();
			logger.info("chrome browser is closed");
			driver = null;
		}
	
}

