package Home;

import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class Navigate {
@Test
    public void test()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            for (int i = 0; i < 5; i++) {
                driver.findElement(By.linkText("Home")).click();
                String Actual = driver.findElement(By.name("title")).getText();
                String Expected = "~ ADDRESS BOOK ~";
                assertEquals(Expected,Actual);
                if (i != 0)
                    driver.navigate().back();
                driver.findElement(By.linkText("Search")).click();
                Actual = driver.findElement(By.name("title")).getText();
                Expected = "Search";
                assertEquals(Expected,Actual);
                if (i != 1)
                    driver.navigate().back();
                driver.findElement(By.linkText("Add")).click();
                Actual = driver.findElement(By.name("title")).getText();
                Expected = "Add";
                assertEquals(Expected,Actual);
                if (i != 2)
                    driver.navigate().back();
                driver.findElement(By.linkText("Update")).click();
                Actual = driver.findElement(By.name("title")).getText();
                Expected = "Update";
                assertEquals(Expected,Actual);
                if (i != 3)
                    driver.navigate().back();
                driver.findElement(By.linkText("Delete")).click();
                Actual = driver.findElement(By.name("title")).getText();
                Expected = "Delete";
                assertEquals(Expected,Actual);
                if (i != 4)
                    driver.navigate().back();
                if (i == 0)
                    driver.findElement(By.linkText("Search")).click();
                else if (i == 1)
                    driver.findElement(By.linkText("Add")).click();
                else if (i == 2)
                    driver.findElement(By.linkText("Update")).click();
                else if (i == 3)
                    driver.findElement(By.linkText("Delete")).click();
            }
        }catch(Exception e)
            {

            }
        driver.close();
    }
}
