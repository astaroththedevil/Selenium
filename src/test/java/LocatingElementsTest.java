import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.junit.Assert.assertTrue;

public class LocatingElementsTest {
    WebDriver driver;

    @Before
    public void setUp() {
        //Telling the system where to find chromedriver. On windows you also need add  .exe
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        //1. Instantiate the driver
        driver = new ChromeDriver();
    }

    @After
    public void tearDown() {
        //7. Quit the driver
        driver.quit();
    }

    @Test
    public void elementsQuiz1() {

        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element //4. Check the state
        WebDriverWait wait = new WebDriverWait(driver, 10);
        WebElement element = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("user-name")));
        //5. Take action //6. Record result
        assertTrue(element.isDisplayed());

    }

    @Test
    public void typesOfLocators() {
        //2. Navigate to the URL
        driver.get("https://www.saucedemo.com/");
        //3. Find element
        WebElement element;
        //ID
        driver.findElement(By.id("user-name"));
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
    }

    @Test
    public void typesOfLocators2() {
        //2. Navigate to the URL
        driver.get("https://ultimateqa.com/simple-html-elements-for-automation/");
        //Link text
        driver.findElement(By.linkText("Click me using this link text!"));
        //Partial link text
        driver.findElement(By.partialLinkText("link text"));
    }
}
