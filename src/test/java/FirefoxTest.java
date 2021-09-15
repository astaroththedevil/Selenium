import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class FirefoxTest {
    @BeforeClass
    public static void setupClass(){
        System.setProperty("webdriver.gecko.driver", "resources/geckodriver");
        WebDriverManager.firefoxdriver().setup();
    }
    @Test
    public void firstTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        driver.quit();
    }
    @Test
    public void secondTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://example.cypress.io/");
        Thread.sleep(3000);
        driver.quit();
    }
    @Test
    public void thirdTest() throws InterruptedException {
        WebDriver driver = new FirefoxDriver();
        driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
        Thread.sleep(4000);
        driver.quit();
    }
}
