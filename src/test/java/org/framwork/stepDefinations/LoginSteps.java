package org.framwork.stepDefinations;

import io.cucumber.java.en.*;
import org.framwork.hooks.Hooks;
import org.opensource.pages.LoginPage;

public class LoginSteps {
    LoginPage loginPage = new LoginPage();
    @Given("user is on login page")
    public void user_is_on_login_page() {
        System.out.println("user is on login page");
    }
    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        loginPage.enterUserEmail("vasavaarun015@gmail.com");
        loginPage.enterPassword("Arun1512");
        loginPage.clickOnLoginButton();
    }
    @Then("user should be navigated to the home page")
    public void user_should_be_navigated_to_the_home_page(){
        System.out.println("user should be navigated to the home page");
        loginPage.waitForMyAccHeader();
        Hooks.takeScreenshot("successful login screenshot");
    }
    @When("user enters invalid username and password")
    public void enter_invalid_credentials(){
        loginPage.enterUserEmail("vasavaarun015@gmail.com");
        loginPage.enterPassword("Arun");
        loginPage.clickOnLoginButton();
    }
    @Then("User should get no match found message")
    public void validate_invalid_credentials(){
        loginPage.checkInvalidUserWarning();
        Hooks.takeScreenshot( "Invalid Login Screenshot");
    }
}