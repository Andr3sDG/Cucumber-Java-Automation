package org.example.steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.example.base.BaseUtil;
import org.example.pageObjects.FormAuthenticationPage;
import org.junit.Assert;

public class FormAuthenticationSteps extends BaseUtil {

    private BaseUtil base;

    public FormAuthenticationSteps(BaseUtil base) {
        this.base = base;
    }

    @Given("I enter to the login page")
    public void iEnterToTheLoginPage() {
        base.Driver.navigate().to("https://ss-testing-automated-exercise.herokuapp.com/login");
    }

    @When("I enter my username = {string} and password = {string}")
    public void iEnterMyUsernameAndPassword(String username, String password) {
        FormAuthenticationPage page = new FormAuthenticationPage(base.Driver);
        page.sendCredentials(username, password);
    }

    @And("I click on login")
    public void iClickOnLogin() {
        FormAuthenticationPage page = new FormAuthenticationPage(base.Driver);
        page.login();
    }

    @Then("I should be able to see the main page")
    public void iShouldBeAbleToSeeTheMainPage() throws InterruptedException {
        FormAuthenticationPage page = new FormAuthenticationPage(base.Driver);
        Assert.assertTrue(page.loginSuccessful(base.Driver));
    }
}
