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

public class MouseActions {
    WebDriver driver;

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
        WebElement element = driver.findElement(By.id("login_credentials"));
        WebElement element1 = driver.findElement(By.id("login-button"));
        Actions action = new Actions(driver);
//        action.click(element).build().perform();
//        action.clickAndHold(element).build().perform();
//        action.release().build().perform();
//        action.contextClick(element).build().perform();
//        action.doubleClick(element).build().perform();
        action.dragAndDrop(element, element1).build().perform();
        action.moveToElement(element1).build().perform();
        Thread.sleep(2000);
    }
}
