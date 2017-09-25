package web;


import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;

@RunWith(Cucumber.class)
@CucumberOptions(features = {"classpath:features/_1LoginPage.feature","classpath:features/_2SingIn.feature"},glue = {"web"},format = {"pretty"})

public class TestSequence {

	DesiredCapabilities capabilities;
	public static WebDriver webDriver;
	
	/**
	 * This method will set pre-requisite for IE-driver.
	 */
	@Before public void setDriver() {
		
	capabilities = DesiredCapabilities.internetExplorer();
	capabilities.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
	capabilities.setCapability(CapabilityType.BROWSER_NAME, "IE");
	capabilities.setCapability(InternetExplorerDriver
			.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS,true);
	capabilities.setCapability("requireWindowFocus", true);
	capabilities.setCapability(InternetExplorerDriver.IGNORE_ZOOM_SETTING, true);
		
			}
	
	/**
	 * This method will close browser.
	 */
	@After public void closeBrowser() {
		
		webDriver.close();
		
	}
	

}
