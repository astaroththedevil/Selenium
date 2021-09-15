import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ChromeTest {

        //This method will run once before all of the tests in our class
        @BeforeClass
        public static void setupClass(){
            WebDriverManager.chromedriver().setup();
        }
        @Test
        public void firstTest() throws InterruptedException{
            WebDriver driver = new ChromeDriver();
            driver.get("https://the-internet.herokuapp.com/");
            Thread.sleep(3000);
            driver.quit();
        }
        @Test
        public void secondTest() throws InterruptedException{
            WebDriver driver = new ChromeDriver();
            driver.get("https://example.cypress.io/");
            Thread.sleep(3000);
            driver.quit();
        }
        @Test
        public void thirdTest() throws InterruptedException {
            WebDriver driver = new ChromeDriver();
            driver.get("https://react-shopping-cart-67954.firebaseapp.com/");
            Thread.sleep(3000);
            driver.quit();
        }

}
