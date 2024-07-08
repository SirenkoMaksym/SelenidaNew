/*
 * created by max$
 */


package de.skonto.pages;

import com.codeborne.selenide.Selenide;
import com.codeborne.selenide.SelenideElement;
import de.skonto.utils.PropertiesLoader;
import io.cucumber.datatable.DataTable;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;
import java.util.Map;

import static com.codeborne.selenide.Condition.exist;
import static com.codeborne.selenide.Selenide.$;
import static io.cucumber.core.internal.com.fasterxml.jackson.databind.type.LogicalType.Map;

public class LoginPage {
    private static final String validEMail = PropertiesLoader.loadProperty("valid.email");
    private static final String validPassword = PropertiesLoader.loadProperty("valid.password");
    private static final String invalidPassword1 = PropertiesLoader.loadProperty("valid.incorrectpassword1");
    private static final String invalidPassword2 = PropertiesLoader.loadProperty("valid.incorrectpassword2");
    private static final String invalidPassword3 = PropertiesLoader.loadProperty("valid.incorrectpassword3");
    private static final String invalidPassword4 = PropertiesLoader.loadProperty("valid.incorrectpassword4");





    @FindBy(css = ".existingAccount__headline")
    WebElement loginFormTitle;

    public SelenideElement loginFormTitle() {
        return $(loginFormTitle).should(exist);
    }

    @FindBy(id = "loginEmail")
    WebElement emailInput;
    @FindBy(id = "loginPassword")
    WebElement passwordInput;

    public LoginPage validloginInput() {
        $(emailInput).val(validEMail);
        $(passwordInput).val(validPassword);
        return Selenide.page(LoginPage.class);
    }

    public LoginPage validloginInputTable(String email, String password) {
        $(emailInput).val(email);
        $(passwordInput).val(password);
        return Selenide.page(LoginPage.class);
    }

    @FindBy(id = "login-submit")
    WebElement anmeldenButton;

    public HomePage clickOnAnmelden() {
        $(anmeldenButton).click();
        return Selenide.page(HomePage.class);
    }

    public LoginPage invalidLoginInput(DataTable table) {

        List<Map<String, String>> newTable = table.asMaps();
        String email = newTable.get(0).get("email");
        String password = newTable.get(0).get("password");

        validloginInputTable(email, password);
        return Selenide.page(LoginPage.class);
    }

    public LoginPage invalidPasswordInput() {
        $(emailInput).val(validEMail);
        $(passwordInput).val(invalidPassword1);
        return Selenide.page(LoginPage.class);
    }
    public LoginPage invalidPasswordInput1() {
        $(emailInput).val(validEMail);
        $(passwordInput).val(invalidPassword2);
        return Selenide.page(LoginPage.class);
    }
    public LoginPage invalidPasswordInput2() {
        $(emailInput).val(validEMail);
        $(passwordInput).val(invalidPassword3);
        return Selenide.page(LoginPage.class);
    }
    public LoginPage invalidPasswordInput3() {
        $(emailInput).val(validEMail);
        $(passwordInput).val(invalidPassword4);
        return Selenide.page(LoginPage.class);
    }
}
