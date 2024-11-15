package stepDefinition;

import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import pageObject.OfferPage;
import utils.TestContextSetup;

import java.util.Iterator;
import java.util.Set;

public class OfferPagesStepDefinition {
    public String offerPageProductName;
    TestContextSetup testContextSetup;

    public OfferPagesStepDefinition(TestContextSetup testContextSetup) {
        this.testContextSetup = testContextSetup;
    }

    @Then("user searched for {string} shortname in offers page")
    public void user_searched_for_shortname_in_offers_page(String ShortName) throws InterruptedException {
        switchToOffersPage();
        Thread.sleep(3000);
        OfferPage offerPage = new OfferPage(testContextSetup.driver);
        offerPage.searchItem(ShortName);
        offerPageProductName = offerPage.getProductName();
        System.out.println(offerPageProductName + " is extracted from offers page");
    }

    public void switchToOffersPage() throws InterruptedException {
        testContextSetup.driver.findElement(By.linkText("Top Deals")).click();
        Set<String> s1 = testContextSetup.driver.getWindowHandles();
        Iterator<String> i1 = s1.iterator();
        String parentWindow = i1.next();
        String childWindow = i1.next();
        testContextSetup.driver.switchTo().window(childWindow);
    }

    @Then("validate product name in offers page match with landing page")
    public void validate_product_name_in_offers_page_match_with_landing_page() throws InterruptedException {
        Thread.sleep(3000);
        if (offerPageProductName.equals(testContextSetup.landingPageProductName)) {
            System.out.println("Landing page product is matching to the Offer page Product");
        } else {
            System.out.println("Landing page product is different");
        }
        testContextSetup.driver.quit();
    }

}
