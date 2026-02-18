package pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.WaitUtils;
import java.time.Duration;
import java.util.List;

public class QAJobsPage {

    WebDriver driver;
    WaitUtils wait;

    public QAJobsPage(WebDriver driver){
        this.driver = driver;
        wait = new WaitUtils(driver);
        PageFactory.initElements(driver,this);
    }

    @FindBy(xpath = "//select[@id='filter-by-location']")
    WebElement locationDropdown;

    @FindBy(xpath = "//select[@id='filter-by-department']")
    WebElement departmentDropdown;

    @FindBy(css = ".position-list-item")
    List<WebElement> jobs;

    @FindBy(xpath="(//a[contains(text(),'View Role')])[1]")
    WebElement firstViewRoleBtn;

    @FindBy(xpath = "//option[@class='job-location istanbulturkiye']")
    WebElement istanbulTurkiyeOpt;

    @FindBy(xpath = "//option[@class='job-team qualityassurance']")
    WebElement qaJob;

    @FindBy(xpath = "//span[contains(text(), 'Quality Assurance')]")
    WebElement qaDepartmentText;

    public void selectLocation(){
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", locationDropdown);
        wait.waitForClickability(locationDropdown);
        locationDropdown.click();
        wait.waitForClickability(istanbulTurkiyeOpt);
        istanbulTurkiyeOpt.click();
    }

    public void selectDepartment(){
        departmentDropdown.click();
        wait.waitForClickability(qaJob);
        qaJob.click();
    }

    public boolean jobListVisible(){
        wait.waitForListToLoad(jobs);
        return jobs.size() > 0;
    }

    public boolean validateJobs() {
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView({behavior: 'smooth', block: 'center'});", firstViewRoleBtn);
        wait.waitForNumberOfElementsToBe(By.xpath("//span[contains(@class, 'position-department') and text()='Quality Assurance']"), 4);
        wait.waitForVisibility(qaDepartmentText);

        for(WebElement job : jobs){

            String position =
                    job.findElement(By.cssSelector("p.position-title"))
                            .getText().trim();

            String department =
                    job.findElement(By.cssSelector(".position-department"))
                            .getText().trim();

            String location =
                    job.findElement(By.cssSelector(".position-location"))
                            .getText().trim();

            if(!position.equals("Quality")) // The reason only the "Quality" check is being done here is because the title of bootcamp 26 is "Quality Engineering". return false;

            if(!department.equals("Quality Assurance"))
                return false;

            if(!location.equals("Istanbul, Turkiye"))
                return false;

        }
        return true;
    }

    public void clickFirstJob(){
        By firstBtn = By.xpath("(//a[contains(text(),'View Role')])[1]");
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(firstBtn)).click();
    }

    public void switchToNewTab(){

        String current = driver.getWindowHandle();

        for(String window : driver.getWindowHandles()){
            if(!window.equals(current)){
                driver.switchTo().window(window);
                break;
            }
        }
    }
}
