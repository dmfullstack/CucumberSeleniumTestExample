package test.example.stepdefs;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.Test;

import cucumber.api.java.After;
import cucumber.api.java.en.Then;
import test.example.WebDriverFactory;
import test.example.pageobjects.DemoPageObjects;

public class DemoSearchStepDefs {
	
	private WebDriver webDriver = WebDriverFactory.getBrowser("Firefox");
	private DemoPageObjects homePageObjects = new DemoPageObjects(webDriver);

	@Then("^Verify that there is a search field that will produce a search for the word \"([^\"]*)\"$")
	public void verify_that_there_is_a_search_field_that_will_produce_a_search_for_the_word(String searchWord) throws Throwable {
		homePageObjects.performProductSearch(searchWord);
		Assert.assertTrue(homePageObjects.checkSearchResults());
	}
	
	@AfterSuite
	public void tearDown()
	{
		System.out.println("Got to after suite");
		WebDriverFactory.closeDrivers();
	}
}
