package testCase;

import com.microsoft.playwright.*;

public class LaunchBrowser {
    public static void main(String[] args) throws InterruptedException {
        Playwright playwright = Playwright.create();
        Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
        BrowserContext browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920, 1080));
        Page page = browserContext.newPage();
        page.navigate("https://rahulshettyacademy.com/seleniumPractise/#/");
        System.out.println(page.title());
        Thread.sleep(3000);
        page.close();
        playwright.close();

    }
}
