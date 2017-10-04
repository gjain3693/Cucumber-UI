package web;

import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeSet;

import junit.framework.Assert;

import org.openqa.selenium.By;


import utility.Screenshot;
import cucumber.api.DataTable;
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
	 * This method will verify current page.
	 * @param currentPage will contain name of current page as mentioned in feature file.
	 */

	@When("^user navigated to \"([^\"]*)\" page$")
	public void user_navigated_to_page(String currentPage) {

		String openPage = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='gh-title']")).getText();

		Assert.assertEquals(openPage, currentPage);

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

	/**
	 * This method will verify help page options.
	 * @param helpOptions will contains options as mentioned in feature file.
	 */

	@Then("^user will find below catagory for help \"([^\"]*)\"$")
	public void user_will_find_below_catagory_for_help(String helpOptions)  {


		String solution = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='body']/div[2]/div[4]/div[2]/h2")).getText();
		String topic = TestSequence.webDriver.findElement(
				By.xpath(" //*[@id='browseByTopic']")).getText();

		Set<String> helpTopic = new TreeSet<String>();
		helpTopic.add(helpOptions);	

		Iterator it = helpTopic.iterator();
		while (it.hasNext()) {
			it.next();
			helpTopic.contains(solution);
			helpTopic.contains(topic);
		}

	}


}
