import com.google.common.base.Strings;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.firefox.FirefoxDriver;
//comment the above line and uncomment below line to use Chrome
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

class Navigate {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            for(int i=0; i<5; i++) {
                driver.findElement(By.linkText("Home")).click();
                TimeUnit.SECONDS.sleep(1);
                if(i!=0)
                    driver.navigate().back();
                driver.findElement(By.linkText("Search")).click();
                TimeUnit.SECONDS.sleep(1);
                if(i!=1)
                    driver.navigate().back();
                driver.findElement(By.linkText("Add")).click();
                TimeUnit.SECONDS.sleep(1);
                if(i!=2)
                    driver.navigate().back();
                driver.findElement(By.linkText("Update")).click();
                TimeUnit.SECONDS.sleep(1);
                if(i!=3)
                    driver.navigate().back();
                driver.findElement(By.linkText("Delete")).click();
                TimeUnit.SECONDS.sleep(1);
                if(i!=4)
                    driver.navigate().back();
                if(i==0)
                    driver.findElement(By.linkText("Search")).click();
                else if(i==1)
                    driver.findElement(By.linkText("Add")).click();
                else if(i==2)
                    driver.findElement(By.linkText("Update")).click();
                else if(i==3)
                    driver.findElement(By.linkText("Delete")).click();
            }

        }catch(Exception e){

        }
    }
}

class AddPerson {
    public static void main(String[] args) {
        String[] races = {"White","African American","African","Pacific Islander","Hispanic","Native American","Asian","Asian American"};
        String[] addrs = {"1234 Made up ln","2452 Errors", "83392 Castle Ln", "795 Wrangler Ave", "63C Trusel Lane", "187 Augusta St", "37 Hickory Street", "79 Tower Street", "38274 Edgewood St", "8066 Lilac St", "216 Wild Rose Court", "99441 Silver Spear Street"};
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        AddPerson p = new AddPerson();
        for(int i=0; i<100; i++) {
            driver.findElement(By.linkText("Add")).click();
            driver.findElement(By.linkText("Add Person")).click();
            WebElement name = driver.findElement(By.name("name"));
            WebElement age = driver.findElement(By.name("age"));
            WebElement ssn = driver.findElement(By.name("ssn"));
            WebElement race = driver.findElement(By.name("race"));
            WebElement height = driver.findElement(By.name("height"));
            WebElement weight = driver.findElement(By.name("weight"));
            WebElement street = driver.findElement(By.name("street"));
            Random rand = new Random();
            name.sendKeys(generateName());
            age.sendKeys(Integer.toString((int) (Math.random() * 100)));
            ssn.sendKeys(Integer.toString((int) (Math.random() * 1000000000)));
            race.sendKeys(races[rand.nextInt(8)]);
            height.sendKeys(Integer.toString((int) (Math.random() * 250)));
            weight.sendKeys(Integer.toString((int) (Math.random() * 300)));
            street.sendKeys(addrs[rand.nextInt(12)]);
            driver.findElement(By.xpath("//input[@type='submit' and @value='Add']")).click();
        }
    }

    private static String[] Beginning = { "Kr", "Ca", "Ra", "Mrok", "Cru",
            "Ray", "Bre", "Zed", "Drak", "Mor", "Jag", "Mer", "Jar", "Mjol",
            "Zork", "Mad", "Cry", "Zur", "Creo", "Azak", "Azur", "Rei", "Cro",
            "Mar", "Luk" };
    private static String[] Middle = { "air", "ir", "mi", "sor", "mee", "clo",
            "red", "cra", "ark", "arc", "miri", "lori", "cres", "mur", "zer",
            "marac", "zoir", "slamar", "salmar", "urak" };
    private static String[] End = { "d", "ed", "ark", "arc", "es", "er", "der",
            "tron", "med", "ure", "zur", "cred", "mur" };

    private static Random rand = new Random();

    public static String generateName() {

        return Beginning[rand.nextInt(Beginning.length)] +
                Middle[rand.nextInt(Middle.length)]+
                End[rand.nextInt(End.length)];

    }

}

class DeletePerson {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Delete")).click();
            WebElement person = driver.findElement(By.name("ssn"));
            person.sendKeys("Dane");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Delete']")).click();
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("List all People")).click();
        }catch(Exception e){

        }
    }
}

class AddPersonFail {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");

            driver.findElement(By.linkText("Add")).click();
            driver.findElement(By.linkText("Add Person")).click();
            WebElement name = driver.findElement(By.name("name"));
            WebElement age = driver.findElement(By.name("age"));
            WebElement race = driver.findElement(By.name("race"));
            WebElement height = driver.findElement(By.name("height"));
            WebElement weight = driver.findElement(By.name("weight"));
            WebElement street = driver.findElement(By.name("street"));
            name.sendKeys("Bob");
            age.sendKeys("24");
            race.sendKeys("African American");
            height.sendKeys("163");
            weight.sendKeys("158");
            street.sendKeys("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Add']")).click();
    }
}

class UpdatePerson {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Update")).click();
            WebElement person = driver.findElement(By.name("ssn"));
            person.sendKeys("Dane");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
            WebElement name = driver.findElement(By.name("name"));
            WebElement height = driver.findElement(By.name("height"));
            WebElement weight = driver.findElement(By.name("weight"));
            WebElement street = driver.findElement(By.name("street"));
            height.sendKeys("193");
            weight.sendKeys("173");
            street.sendKeys("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Update']")).click();
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("List all People")).click();
        }catch(Exception e){

        }
    }
}

class ListAllPeople {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("List all People")).click();
        }catch(Exception e){

        }
    }
}

class ListAllAdrresses {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("List all Addresses")).click();
        }catch(Exception e){

        }
    }
}

class SearchAtAddress {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("Search For Address")).click();
            WebElement adr = driver.findElement(By.name("street"));
            adr.sendKeys("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
        }catch(Exception e){

        }
    }
}

class SearchPeopleAtAddress {
    public static void main(String[] args) {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\793899\\Downloads\\chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("http://localhost:8080/web_sandbox_war/");
        try {
            driver.findElement(By.linkText("Search")).click();
            driver.findElement(By.linkText("Search For People")).click();
            WebElement adr = driver.findElement(By.name("street"));
            adr.sendKeys("2452 Errors");
            driver.findElement(By.xpath("//input[@type='submit' and @value='Search']")).click();
        }catch(Exception e){

        }
    }
}
