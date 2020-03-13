package org.example.steps;

import cucumber.api.CucumberOptions;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import io.github.bonigarcia.wdm.WebDriverManager;
import org.example.base.BaseUtil;
import org.junit.runner.RunWith;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

//@RunWith(Cucumber.class)
//@CucumberOptions(plugin = {"pretty"}, glue = "steps")
public class Hooks extends BaseUtil {

    private BaseUtil base;

    public Hooks(BaseUtil base) {
        this.base = base;
    }

    @Before
    public void initializeTest() {
        WebDriverManager.chromedriver().version(base.Version).setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox", "--disable-popup-blocking");
        base.Driver = new ChromeDriver(options);
        base.Driver.manage().window().maximize();
    }

    @After
    public void tearDownTest() {
        base.Driver.quit();
    }

}
