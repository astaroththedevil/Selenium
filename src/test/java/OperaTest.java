import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.opera.OperaDriver;

public class OperaTest {

    @BeforeClass
    public static void setupClass(){
        System.setProperty("webdriver.opera.driver", "resources/operadriver");
        WebDriverManager.operadriver().setup();
    }
    @Test
    public void firstTest() throws InterruptedException {
        WebDriver driver = new OperaDriver();
        driver.get("https://the-internet.herokuapp.com/");
        Thread.sleep(2000);
        driver.quit();
    }
}
