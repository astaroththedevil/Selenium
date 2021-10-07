import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ExplicitWaitTest {
    WebDriver driver;
    WebElement element;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        WebElement element = new WebDriverWait(driver, 10).until(driver -> driver.findElement(By.className("close-cookie-info")));
        element.click();
    }
}
