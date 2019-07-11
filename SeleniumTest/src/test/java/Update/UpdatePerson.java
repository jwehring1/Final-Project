package Update;

import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.fail;

public class UpdatePerson {

    public void reset()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        driver.findElement(By.linkText("Update")).click();
        WebElement person = driver.findElement(By.name("ssn"));
        person.sendKeys("Dane");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement street = driver.findElement(By.name("street"));
        height.sendKeys("193");
        weight.sendKeys("183");
        street.sendKeys("1234 Made up ln");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
        driver.close();
    }

    @Test
    public void test()
    {
        reset(); //Resets the value just in case you run the test twice in a row
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");


        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("List all People")).click();
        int ExpectedHeight = 193;
        int ActualHeight = Integer.parseInt(driver.findElement(By.name("18472249height")).getText());
        assertEquals(ExpectedHeight,ActualHeight);
        double ExpectedWeight = 183;
        double ActualWeight = Double.parseDouble(driver.findElement(By.name("18472249weight")).getText());
        assertEquals(ExpectedHeight,ActualHeight);
        String ExpectedStreet = "1234 Made up ln";
        String ActualStreet = driver.findElement(By.name("18472249street")).getText();
        assertEquals(ExpectedStreet,ActualStreet);


        driver.findElement(By.linkText("Update")).click();
        WebElement person = driver.findElement(By.name("ssn"));
        person.sendKeys("Dane");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
        WebElement height = driver.findElement(By.name("height"));
        WebElement weight = driver.findElement(By.name("weight"));
        WebElement street = driver.findElement(By.name("street"));
        height.sendKeys("138");
        weight.sendKeys("173");
        street.sendKeys("2452 Errors");
        driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("List all People")).click();
        ExpectedHeight = 138;
        ActualHeight = Integer.parseInt(driver.findElement(By.name("18472249height")).getText());
        assertEquals(ExpectedHeight,ActualHeight);
        ExpectedWeight = 173;
        ActualWeight = Double.parseDouble(driver.findElement(By.name("18472249weight")).getText());
        assertEquals(ExpectedHeight,ActualHeight);
        ExpectedStreet = "2452 Errors";
        ActualStreet = driver.findElement(By.name("18472249street")).getText();
        assertEquals(ExpectedStreet,ActualStreet);
        driver.close();
    }
}
