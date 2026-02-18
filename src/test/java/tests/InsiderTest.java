package tests;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import pages.*;
import utilities.BaseTest;

import java.time.Duration;

public class InsiderTest extends BaseTest {

    @Test
    public void insiderQAFlow() {

        HomePage home = new HomePage(driver);
        CareersPage careers = new CareersPage(driver);
        QAJobsPage jobs = new QAJobsPage(driver);
        LeverPage lever = new LeverPage(driver);

        // 1. Visit insider.com
        home.open();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@id='wt-cli-accept-all-btn']")));
        home.cookies.click();
        Assert.assertTrue(home.isOpened());
        Assert.assertTrue(home.blocksLoaded());

        // 2. See all QA Jobs
        careers.open();
        careers.clickSeeAllJobs();

        // 3. Filter jobs by Location - Istanbul, Turkey and department - Quality Assurance
        jobs.selectLocation();
        jobs.selectDepartment();

        // 4. Check presence of jobs list
        Assert.assertTrue(jobs.jobListVisible());

        // 5. Check that all jobs’ Position contains “Quality”, Department contains “Quality Assurance”, Location contains “Istanbul, Turkey”
        Assert.assertTrue(jobs.validateJobs());

        // 6. Click the View Role Button
        jobs.clickFirstJob();
        jobs.switchToNewTab();

        // 7. Lever Application form page
        Assert.assertTrue(lever.isOpened());
    }
}
