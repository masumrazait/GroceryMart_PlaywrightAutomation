package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class LandingPagesStepDefinition {
    TestContextSetup testContextSetup;
    public String landingPageProductName;

    public LandingPagesStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Given("user is on GreenCart Landing page")
    public void user_is_on_green_cart_landing_page() {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver.exe");
        testContextSetup.driver = new ChromeDriver();
        testContextSetup.driver.get("https://rahulshettyacademy.com/seleniumPractise/#/");
        testContextSetup.driver.manage().window().maximize();
        testContextSetup.driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @When("user searched with shortname {string} and extracted actual name of product")
    public void user_searched_with_shortname_and_extracted_actual_name_of_product(String ShortName) throws InterruptedException {
        testContextSetup.driver.findElement(By.xpath("//input[@type='search']")).sendKeys(ShortName);
        Thread.sleep(3000);
        landingPageProductName = testContextSetup.driver.findElement(By.cssSelector("h4.product-name")).getText().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from home page");
    }
}
