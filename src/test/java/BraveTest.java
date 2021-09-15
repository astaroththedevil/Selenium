import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BraveTest {

    @BeforeClass
    public static void setupClass(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromiumdriver().setup();
    }
    @Test
    public void braveTest() throws InterruptedException {
        ChromeOptions options = new ChromeOptions();
        options.setBinary("/opt/brave.com/brave/brave-browser");
        WebDriver driver = new ChromeDriver(options);
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        driver.quit();
    }
}
