import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Moliera2Below2000PLNProductTest {

    WebDriver driver;

    @Before
    public void setup() {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
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
    public void shouldOpenProductBelow2000PLN() throws InterruptedException {
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cookies-info\"]/div/div/div[2]/div/div/div[2]/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"sm-sidebar\"]/div[1]/p")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"pjax-content\"]/div/div[3]/div[1]/div[4]/div/div/div[3]/div/div/a/img")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"product-list\"]/div[2]/a/div[2]/div[1]/h2")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"cart-product-form-1825741\"]/div[2]/div[1]/div[1]/div[2]/span[2]")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cart-product-form-1825741\"]/div[2]/div[1]/div[1]/div[3]/ul/li[2]/div")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cart-product-form-1825741\"]/div[4]/div/div/a")).click();
        Thread.sleep(3500);
        driver.findElement(By.xpath("//*[@id=\"goto-cart\"]")).click();
        Thread.sleep(4000);

        printSuccess();
    }
}
