package Add;

import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import static org.junit.Assert.assertEquals;

public class AddPersonMultiple {

    @ParameterizedTest
    @CsvSource(value={"Jimmy:22:291842:White:192:145:1234 Made up ln","Baaaaav:22:193842:Still White:172:135:63C Trusel Lane","Rob:22:5948272:Very White:184:132:216 Wild Rose Court"},delimiter = ':') // six numbers
    public void addMultiplePeople(String name,String age,String ssn,String race,String height,String weight,String street)
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        driver.findElement(By.linkText("Add")).click();
        driver.findElement(By.linkText("Add Person")).click();
        WebElement namew = driver.findElement(By.name("name"));
        WebElement agew = driver.findElement(By.name("age"));
        WebElement ssnw = driver.findElement(By.name("ssn"));
        WebElement racew = driver.findElement(By.name("race"));
        WebElement heightw = driver.findElement(By.name("height"));
        WebElement weightw = driver.findElement(By.name("weight"));
        Select streetw = new Select(driver.findElement(By.name("street")));
        namew.sendKeys(name);
        agew.sendKeys(age);
        ssnw.sendKeys(ssn);
        racew.sendKeys(race);
        heightw.sendKeys(height);
        weightw.sendKeys(weight);
        streetw.selectByVisibleText(street);
        driver.findElement(By.xpath("//input[@type='submit' and @value='Add']")).click();
        driver.findElement(By.linkText("Search")).click();
        driver.findElement(By.linkText("List all People")).click();
        String Expected = name;
        String Actual = driver.findElement(By.name(ssn+"name")).getText();
        assertEquals(Expected,Actual);
        driver.close();
    }
}
