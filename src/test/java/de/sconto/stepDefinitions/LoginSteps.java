/*
 * created by max$
 */


package de.sconto.stepDefinitions;

import com.codeborne.selenide.Selenide;
import de.skonto.pages.CustomerAccountPage;
import de.skonto.pages.HomePage;
import de.skonto.pages.LoginPage;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {
    HomePage home;
    LoginPage login;
    CustomerAccountPage customer;

    @When("User clicks on User icon")
    public void click_on_User_icon() {
        home = Selenide.page(HomePage.class);
        login = home.clickOnLoginIcon();
    }

    @Then("User verifies Login form")
    public void verify_login_form() {
        login.loginFormTitle();
    }

    @When("User enters valid data")
    public void enter_valid_data() {
        login.validloginInput();
    }
    @When("User enters invalid data")
    public void enter_invalid_data(DataTable table){
        login.invalidLoginInput(table);
    }
    @When("User enters invalid password from Property")
    public void enter_invalid_password(){
        login.invalidPasswordInput();
    }
    @When("User enters invalid password from Property1")
    public void enter_invalid_password1(){
        login.invalidPasswordInput1();
    }
    @When("User enters invalid password from Property2")
    public void enter_invalid_password2(){
        login.invalidPasswordInput2();
    }
    @When("User enters invalid password from Property3")
    public void enter_invalid_password3(){
        login.invalidPasswordInput3();
    }

    @And("User clicks on Anmelden button")
    public void click_on_Anmelden_Button() {
        login.clickOnAnmelden();
    }

    @Then("User verivies user name status")
    public void verify_user_name_status() {
        home.UserNameStatus();
    }
    @Then("User verivies user name new status")
    public void verify_user_name_new_status() {
        home.UserNameStatusNew("Benutzername nicht gefunden oder Passwort falsch.");
    }

    @Then("User verifies user name")
    public void verify_user_name(){
        customer=Selenide.page(CustomerAccountPage.class);
        customer.userName("Bob Merkel");
    }

}
