package org.example.pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class FormAuthenticationPage {

    private WebDriver driver;

    @FindBy(how = How.ID, using = "username")
    public WebElement usernameInput;

    @FindBy(how = How.ID, using = "password")
    public WebElement passwordInput;

    @FindBy(how = How.XPATH, using = "/html/body/div[2]/div/div/form/button")
    public WebElement loginButton;

    public FormAuthenticationPage(WebDriver Driver) {
        this.driver = Driver;
        PageFactory.initElements(driver, this);
    }

    public void sendCredentials(String username, String password) {
        usernameInput.sendKeys(username);
        passwordInput.sendKeys(password);
    }

    public void login() {
        loginButton.click();
    }

    public boolean loginSuccessful(WebDriver driver) {
        String currentUrl = driver.getCurrentUrl();
        if(currentUrl.equals("https://ss-testing-automated-exercise.herokuapp.com/secure")){
            return true;
        } else {
            return false;
        }
    }

}
