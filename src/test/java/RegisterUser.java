import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class RegisterUser {
    WebDriver driver;
    WebDriverWait wait;
    WebElement mail, sth;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://cryptogmail.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }

    String success = "Finished with success!";

    public void printSuccess() {
        System.out.println(success);
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div/div[1]/div")));
        mail = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[1]/div"));
        String address = mail.getText();
        System.out.println(address);
        printSuccess();
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(3000);
    }
}
