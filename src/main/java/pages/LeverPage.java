package pages;

import org.openqa.selenium.WebDriver;
import utilities.WaitUtils;

public class LeverPage {

    WebDriver driver;
    WaitUtils wait;

    public LeverPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
    }

    public boolean isOpened(){

        return driver.getCurrentUrl().contains("lever.co");
    }
}
