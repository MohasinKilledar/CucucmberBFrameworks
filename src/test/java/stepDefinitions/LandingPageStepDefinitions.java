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

public class LandingPageStepDefinitions {

	public WebDriver driver;
	public String LandingpageProductName;
	public String offerPageProductName;
	TestContextSetup testContextsetup;
	
	public LandingPageStepDefinitions(TestContextSetup testContextsetup)
	{
		this.testContextsetup = testContextsetup;
	}
	
	

	@Given("user is on GreenKart landing page")
	public void user_is_on_green_kart_landing_page() {
		testContextsetup.driver = new ChromeDriver();
		testContextsetup.driver.manage().window().maximize();
		testContextsetup.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
		testContextsetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
	}

	@When("user searched with shortname called as {string} and extarcted actual name of the product")
	public void user_searched_with_shortname_called_as_and_extarcted_actual_name_of_the_product(String shortName) throws InterruptedException {
		testContextsetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(shortName);
		Thread.sleep(2000);
		 testContextsetup.LandingpageProductName = testContextsetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
		System.out.println(LandingpageProductName + " is Extracted from home page");

	}

	
	
	 
	}


 