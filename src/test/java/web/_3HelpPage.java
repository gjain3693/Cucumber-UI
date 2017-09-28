package web;

import junit.framework.Assert;

import org.openqa.selenium.By;

import utility.Screenshot;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 * This is step defination class which will execute steps as per feature file.
 * @author gauravp.jain
 *
 */

public class _3HelpPage  {
	
	
	/**
	 * This method will verify current page.
	 * @throws InterruptedException will be thrown when a thread 
	 * is waiting or sleeping and another thread interrupts
	 */
	

	@Given("^user logged into Ebay$")
	public void user_logged_into_Ebay() throws InterruptedException  {
	  
		Thread.sleep(3000);
		String loginName = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']")).getText();
		
		Assert.assertEquals("Hi Gaurav!", loginName);
		
	   
	}


	
	/**
	 * This method will navigate user to Customer service page.
	 */
	
	@When("^user click on Help & Contact link$")
	public void user_click_on_Help_Contact_link()  {
	    
		TestSequence.webDriver.findElement(By.xpath("//*[@id='gh-p-3']/a")).click();
	    
	}

	
	/**
	 * This method will verify current page is Customer Service or not.
	 * @param help will contain current page name as mentioned in story file.
	 * 
	 */
	
	@Then("^user will navigate to \"([^\"]*)\" page$")
	public void user_will_navigate_to(String help) {
		String pageTitle = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-title']")).getText();
		
		Assert.assertEquals(pageTitle, help);
		Screenshot screenShot = new Screenshot();
		screenShot.takeScreenShot("Customer Service");
	    
	}

}
