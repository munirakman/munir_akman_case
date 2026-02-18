package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import utilities.ConfigReader;
import utilities.WaitUtils;

public class CareersPage {

    WebDriver driver;
    WaitUtils wait;

    public CareersPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//a[@href='https://insiderone.com/careers/open-positions/?department=qualityassurance']")
    WebElement seeAllJobsBtn;

    public void open(){
        driver.get(ConfigReader.getProperty("qaUrl"));
    }

    public void clickSeeAllJobs(){
        wait.waitForClickability(seeAllJobsBtn);
        seeAllJobsBtn.click();
    }
}
