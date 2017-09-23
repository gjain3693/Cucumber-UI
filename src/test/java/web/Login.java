package web;

import java.io.File;
import java.util.concurrent.TimeUnit;

import org.junit.Before;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Login {
	
	WebDriver webDriver;
	String webDriverKey;
	String webDriverPath;
	DesiredCapabilities capabilities;
	
	
	@Before public void setDriver(){


		capabilities = DesiredCapabilities.internetExplorer();
		capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
		capabilities.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
		capabilities.setCapability("requireWindowFocus", true);
		capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);

	}
	
	
	@Given("^We have ebay url as \"([^\"]*)\"$")
	public void we_have_ebay_url_as(String url)  {
		webDriverKey="webdriver.ie.driver";
		webDriverPath="F:\\IEDriver\\IEDriverServer.exe";
		System.setProperty(webDriverKey,webDriverPath);
		webDriver=new InternetExplorerDriver(capabilities);
		webDriver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
		webDriver.findElement(By.tagName("html")).sendKeys(Keys.chord(Keys.CONTROL, "0"));
		webDriver.manage().window().maximize();
		webDriver.get(url);
	
		
	}
	
	@When("^we click on sign in$")
	public void we_click_on_sign_in() {
		
		WebElement sign=webDriver.findElement(By.xpath("//*[@id='gh-ug']/a"));
		sign.click();
	 
	}
	
	
	@Then("^login page open successfuly$")
	public void login_page_open_successfuly() {
		
		WebElement signInOption=webDriver.findElement(By.xpath("//*[@id='sgnTab']/span[2]"));
		String expectedTag= signInOption.getText();

		Assert.assertEquals(expectedTag, "SignIn");
		
	   
	}

}
