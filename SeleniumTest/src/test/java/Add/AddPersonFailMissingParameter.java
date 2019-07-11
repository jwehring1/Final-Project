package Add;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.concurrent.TimeUnit;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class AddPersonFailMissingParameter {
    @Test
    public void test()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Add")).click();
            driver.findElement(By.linkText("Add Person")).click();
            WebElement name = driver.findElement(By.name("name"));
            WebElement age = driver.findElement(By.name("age"));
            WebElement ssn = driver.findElement(By.name("ssn"));
            WebElement race = driver.findElement(By.name("race")); //Height is not inputted
            WebElement weight = driver.findElement(By.name("weight"));
            Select street = new Select(driver.findElement(By.name("street")));
            name.sendKeys("Dane");
            age.sendKeys("22");
            ssn.sendKeys("18472249");
            race.sendKeys("African American");
            weight.sendKeys("153");
            street.selectByVisibleText("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Add']")).click();
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("List all People")).click();
            String Expected = "Dane";
            String Actual = driver.findElement(By.name("18472249name")).getText();
            assertEquals(Expected, Actual);
        }catch(Exception e)
        {
            fail("Not all fields were inserted!");
        }
        driver.close();
    }
}
