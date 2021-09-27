import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;

public class KeyBoardActions {
    WebDriver driver;
    WebElement element;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test() throws InterruptedException {
        WebElement login = driver.findElement(By.id("user-name"));
        WebElement pass = driver.findElement(By.id("password"));
        WebElement btn = driver.findElement(By.id("login-button"));
        Actions action = new Actions(driver);
        action.sendKeys(login, "problem_user").build().perform();
        sleep();
        action.sendKeys(pass, "secret_sauce").build().perform();
        sleep();
        action.clickAndHold(btn).pause(1000).release().build().perform();
        sleep();
    }
    public void sleep() throws InterruptedException {
        Thread.sleep(1000);
    }
}
