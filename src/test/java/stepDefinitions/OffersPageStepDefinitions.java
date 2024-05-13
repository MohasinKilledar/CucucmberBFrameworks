package stepDefinitions;

import java.time.Duration;
import java.util.Iterator;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import utils.TestContextSetup;

public class OffersPageStepDefinitions {

	
	public String offerPageProductName;
	TestContextSetup testContextsetup;
	
	public OffersPageStepDefinitions(TestContextSetup testContextsetup)
	{
		this.testContextsetup = testContextsetup;
	}


	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		testContextsetup.driver.findElement(By.partialLinkText("Top Deals")).click();

		Set<String> allwindow = testContextsetup.driver.getWindowHandles();
		Iterator<String> window = allwindow.iterator();
		String parentwindow = window.next();
		String childwindow = window.next();

		testContextsetup.driver.switchTo().window(childwindow);
		testContextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		 offerPageProductName = testContextsetup.driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

	}
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageProductName, testContextsetup.LandingpageProductName);
	}
	 
	
	 
	}


 