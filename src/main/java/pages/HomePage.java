package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.ConfigReader;
import utilities.WaitUtils;
import java.util.List;

public class HomePage {

    WebDriver driver;
    WaitUtils wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(css = "section")
    List<WebElement> blocks;

    @FindBy(xpath = "//a[@id='wt-cli-accept-all-btn']")
    public WebElement cookies;

    public void open(){
        driver.get(ConfigReader.getProperty("baseUrl"));
    }

    public boolean isOpened(){
        return driver.getTitle().contains("Insider");
    }

    public boolean blocksLoaded(){
        wait.waitForVisibility(blocks.get(0));
        return blocks.size() > 3;
    }
}
