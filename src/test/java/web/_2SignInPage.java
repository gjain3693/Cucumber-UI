package web;

import java.util.List;

import junit.framework.Assert;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;



/**
 * This class will perform sign in operation.
 * 
 * @author gauravp.jain
 *
 */

public class _2SignInPage {

	/**
	 * This method will check user is at sign in page before sign in.
	 * 
	 */

	@Given("^user is at sign in page$")
	public void user_is_at_sign_in_page()  {

		WebElement signInOption = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='sgnTab']/span[2]"));
		String actualTag = signInOption.getText();

		Assert.assertEquals("Sign in", actualTag);

	}

	/**
	 * This method will perform sign in operation.
	 * @param data will contain username and password as mentioned in feature file.
	 */

	@When("^user enter below details$")
	public void user_enter_below_details(DataTable data) {

		List<List<String>> readRecord = data.raw();


		String userName = readRecord.get(1).get(0);
		String password = readRecord.get(1).get(1);
		TestSequence.webDriver.findElement(
				By.xpath("//*[@id='userid']")).sendKeys(userName);
		TestSequence.webDriver.findElement(By.xpath("//*[@id='pass']")).sendKeys(password);

		boolean stayedSignIn = TestSequence.webDriver.findElement(
				By.xpath("//*[@id='csi']")).isSelected();

		if (!stayedSignIn) {
			TestSequence.webDriver.findElement(By.xpath("//*[@id='csi']")).click();
		}

		TestSequence.webDriver.findElement(By.xpath("//*[@id='sgnBt']")).click();

	}

	/**
	 * This method will verify user logged in successfully.
	 */
	@Then("^user logged in successfully$")
	public void user_logged_in_successfully()  {


	}





}
