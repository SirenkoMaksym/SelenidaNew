/*
 * created by max$
 */


package de.skonto.pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.skonto.utils.PropertiesLoader;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HomePage {
    public static String baseURL = PropertiesLoader.loadProperty("url");
    @FindBy(css = "[data-accept-action='all']")
    WebElement acceptButton;

    public HomePage acceptCookies() {
        if ($(acceptButton).exists()) {
            $(acceptButton).click();
        }
        return Selenide.page(this);

    }

    @FindBy(css = ".headerElement--login")
    WebElement loginIcon;

    public LoginPage clickOnLoginIcon() {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        $(loginIcon).click();
        return Selenide.page(LoginPage.class);
    }

    @FindBy(css = ".headerElement__status--login")
    WebElement statusLogin;

    public SelenideElement UserNameStatus() {
        return $(statusLogin).should(exist);
    }
    @FindBy(id="loginEmail-error")
    WebElement statusLoginNotExist;
    public SelenideElement UserNameStatusNew(String message) {
        return $(statusLoginNotExist).shouldHave(text(message));
    }
}
