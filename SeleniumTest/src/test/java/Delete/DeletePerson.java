package Delete;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

public class DeletePerson {
    @Test
    public void test() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        driver.findElement(By.linkText("Delete")).click();
        Select person = new Select(driver.findElement(By.name("ssn")));
        try {
            person.selectByVisibleText("Dane");
        }catch(Exception e)
        {
            fail("The person entered does not exist!");
        }
        driver.findElement(By.xpath("//input[@type='submit' and @value='Delete']")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("List all People")).click();
        String Expected = "";
        try {
            String Actual = driver.findElement(By.name("18472249name")).getText();
            fail("User was still found!");
        }catch(Exception e)
        {

        }
        driver.close();
    }
}
