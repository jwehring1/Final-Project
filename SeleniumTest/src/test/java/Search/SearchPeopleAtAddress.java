package Search;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.fail;
import static org.junit.Assert.assertEquals;

public class SearchPeopleAtAddress {

    @Test
    public void test()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("Search For People")).click();
            WebElement adr = driver.findElement(By.name("street"));
            adr.sendKeys("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
            String Expected = "http://localhost:8080/web_sandbox_war/SearchPplByAddrView";
            String Actual = driver.getCurrentUrl();
            assertEquals(Expected,Actual);
        }catch(Exception e){
            fail();
        }
        driver.close();
    }
}
