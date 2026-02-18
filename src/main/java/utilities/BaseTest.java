package utilities;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

public class BaseTest {

    protected WebDriver driver;

    @BeforeMethod
    public void setup(){
        driver = DriverFactory.getDriver();
    }

    @AfterMethod
    public void teardown(){
        DriverFactory.quitDriver();
    }
}
