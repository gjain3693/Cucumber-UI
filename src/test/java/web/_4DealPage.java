package web;

import junit.framework.Assert;

import org.openqa.selenium.By;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

/**
 *  This is step defination class which will execute steps as per feature file.
 * @author gauravp.jain
 *
 */

public class _4DealPage {
	
	/**
	 * This method will verify user is logged into to Ebay.
	 * @throws InterruptedException will be thrown when a thread 
	 * is waiting or sleeping and another thread interrupts
	 */
	
	@Given("^user is logged in at Ebay$")
	public void user_is_logged_in_at_Ebay() throws InterruptedException  {
	    
		Thread.sleep(3000);

		String loginName = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-ug']")).getText();

		Assert.assertEquals("Hi Gaurav!", loginName);
	}
	
	/**
	 *This method will navigate user to Deals page. 
	 * @param desiredPage will contain name of page as mentioned in feature file.
	 */
	
	@When("^user Click on \"([^\"]*)\" link$")
	public void user_Click_on_link(String desiredPage)  {
		String page = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-p-1']/a")).getText();
		TestSequence.webDriver.findElement(By.xpath("//*[@id='gh-p-1']/a")).click();
		Assert.assertEquals(page,desiredPage);
	}

	/**
	 *This method will verify name of page. 
	 * @param expectedPage will contain name of page as mentioned in feature file.
	 */
	
	@Then("^user navigate to \"([^\"]*)\" page$")
	public void user_navigate_to_page(String expectedPage)  {
		
		String actualPage = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='s2']/h1/a")).getText();
	
		Assert.assertEquals(expectedPage, actualPage);
	
	}



}
