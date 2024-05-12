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

public class GreenkartStepDefinitions {

	public WebDriver driver;
	public String LandingpageProductName;
	public String offerPageProductName;

	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with shortname called as {string} and extarcted actual name of the product")
	public void user_searched_with_shortname_called_as_and_extarcted_actual_name_of_the_product(String shortName) throws InterruptedException {
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		String LandingpageProductName = driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(LandingpageProductName + " is Extracted from home page");

	}

	@Then("user searched for {string} shortname in offers page")
	public void user_searched_for_shortname_in_offers_page(String shortName) throws InterruptedException {
		driver.findElement(By.partialLinkText("Top Deals")).click();

		Set<String> allwindow = driver.getWindowHandles();
		Iterator<String> window = allwindow.iterator();
		String parentwindow = window.next();
		String childwindow = window.next();

		driver.switchTo().window(childwindow);
		driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		String offerPageProductName = driver.findElement(By.cssSelector("tr td:nth-child(1)")).getText();

	}
	@Then("validate product name in offers page matches with Landing page")
	public void validate_product_name_in_offers_page_matches_with_landing_page() {
	    Assert.assertEquals(offerPageProductName, LandingpageProductName);
	}
	
	
	
	
	
	 
	}


 