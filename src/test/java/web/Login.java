package web;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import utility.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This class will initialize web driver 
 * and launch browser along with initial login page navigation.
 * @author gauravp.jain
 *
 */

public class Login {
	
	
	String webDriverKey;
	String webDriverPath;
	DesiredCapabilities capabilities;
	

	/**
	 * This method will set url of ebay at browser and will open browser at 100% zoom level.
	 * @param url will contain url for ebay as mentioned in feature file.
	 */
	
	@Given("^We have ebay url as \"([^\"]*)\"$")
	public void we_have_ebay_url_as(String url)  {
		
		webDriverKey = "webdriver.ie.driver";
		webDriverPath = "F:\\IEDriver\\IEDriverServer.exe";
		System.setProperty(webDriverKey,webDriverPath);
		TestSequence.webDriver = new InternetExplorerDriver(capabilities);
		TestSequence.webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		TestSequence.webDriver.findElement(
				By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		TestSequence.webDriver.manage().window().maximize();
		TestSequence.webDriver.get(url);
	
		
	}
	
	/**
	 * This method will click on sign in hyperlink to navigate at sign in page.
	 */
	
	@When("^we click on sign in$")
	public void we_click_on_sign_in() {
		
		WebElement sign = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']/a"));
		sign.click();
	 
	}
	
	/**
	 * This method will verify navigate page is sign in page or not.
	 * @param expectedTag will contain sign in tag as mentioned in story file.
	 */
	
	@Then("^login page open successfuly as \"([^\"]*)\" tag appears$")
	public void login_page_open_successfuly_as_tag_appears(String expectedTag) {
		
		Screenshot screenshot = new Screenshot();
		
		WebElement signInOption = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='sgnTab']/span[2]"));
		String actualTag = signInOption.getText();

		Assert.assertEquals(actualTag, expectedTag);
		screenshot.takeScreenShot("Sign In page");
		
	   
	}

}
