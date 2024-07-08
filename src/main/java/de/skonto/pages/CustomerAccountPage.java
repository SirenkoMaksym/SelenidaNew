/*
 * created by max$
 */


package de.skonto.pages;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

public class CustomerAccountPage {
    @FindBy(css = ".titleHeadline")
    WebElement userNameTitle;
    public SelenideElement userName(String name) {
        try{
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        return $(userNameTitle).shouldHave(text(name));
    }
}
