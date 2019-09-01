import com.google.gson.internal.Streams;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicInteger;

public class LeetCodeCrawler {

    @Test
    public void crawlLeetCode(){

        System.setProperty("webdriver.chrome.driver","/Users/bkrishnankutty/Desktop/MyStudySite/chromedriver");
        WebDriver driver = new ChromeDriver();
        driver.get("https://leetcode.com/problemset/algorithms/?difficulty=Medium");
        WebDriverWait wait = new WebDriverWait(driver,260);
        wait.until(ExpectedConditions.visibilityOf(driver.findElement(By.cssSelector(" div.table-responsive.question-list-table > table > tbody.reactable-data > tr > td:nth-child(3) > div > a"))));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        WebElement addRow = driver.findElement(By.cssSelector("select.form-control"));
        //This will scroll the page till the element is found
        js.executeScript("arguments[0].scrollIntoView();", addRow);
        addRow.sendKeys("all");
        driver.manage().timeouts().implicitlyWait(2000L, TimeUnit.MILLISECONDS);
        List<WebElement> records  = driver.findElements(By.cssSelector(" div.table-responsive.question-list-table > table > tbody.reactable-data > tr > td:nth-child(3) > div > a"));
        AtomicInteger i= new AtomicInteger(1);
        records.forEach((n) -> {
            System.out.println(i.getAndIncrement()+")"+n.getText());
        });

                driver.quit();
    }
}
