import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class LocatorsTest {

    @Test
    public void typesOfLocators(){
        //Telling the system where to find chromedriver. On windows you also need add  .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Instantiate the driver
        WebDriver driver = new ChromeDriver();
        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element
        WebElement element;
        //ID
        element = driver.findElement(By.id("user-name"));
        //Name
        //driver.findElement(By.name("name of locator"));
        //Class name
        driver.findElement(By.className("form_input"));
        //Tag name
        driver.findElement(By.tagName("input"));
        //CSS selector
        driver.findElement(By.cssSelector("#user-name"));
        //Xpath
        driver.findElement(By.xpath("//*[@id=\"user-name\"]"));
        driver.quit();

        //Telling the system where to find chromedriver. On windows you also need to add  .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Instantiate the driver
        driver = new ChromeDriver();
        //2. Navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text"));
        //7. qit the driver
        driver.quit();
    }
}
