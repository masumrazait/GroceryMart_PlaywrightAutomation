package stepDefinition;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.chrome.ChromeDriver;
import pageObject.LandingPage;
import utils.TestContextSetup;

import java.util.concurrent.TimeUnit;

public class LandingPagesStepDefinition {
    public String landingPageProductName;
    public String offerPageProductName;
    TestContextSetup testContextSetup;


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
        LandingPage landingPage = new LandingPage(testContextSetup.driver);
        landingPage.searchItem(ShortName);
        Thread.sleep(3000);
        testContextSetup.landingPageProductName = landingPage.getProductName().split("-")[0].trim();
        System.out.println(landingPageProductName + " is extracted from home page");
    }
}
