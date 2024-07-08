/*
 * created by max$
 */


package de.sconto.stepDefinitions;

import de.skonto.pages.HomePage;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;

import static com.codeborne.selenide.Selenide.open;
import static com.codeborne.selenide.WebDriverRunner.getWebDriver;
import static de.skonto.pages.HomePage.baseURL;

public class HomePageSteps {
    HomePage homePage;

    @Given("User is on HomePage")
    public void user_is_on_home_page() {
        homePage = open(baseURL, HomePage.class);
        getWebDriver().manage().window().maximize();
        homePage.acceptCookies();
    }


}
