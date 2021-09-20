import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Moliera2PlaceAnOrderTest {

    WebDriver driver;
    WebDriverWait wait;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
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
    public void shouldAddProductToCart() throws InterruptedException {
        String[] paths = {
                "//*[@id=\"cookies-info\"]/div/div/div[2]/div/div/div[2]/button",
                "//*[@id=\"sm-sidebar\"]/div[1]/p",
                "//*[@id=\"pjax-content\"]/div/div[3]/div[1]/div[4]/div/div/div[1]/div[2]/div/a/button",
                "//*[@id=\"product-list\"]/div[3]/a/div[2]/div[1]/h2",
                "//*[@id=\"cart-product-form-1830629\"]/div[2]/div[1]/div[1]/div[2]/span[2]",
                "//*[@id=\"cart-product-form-1830629\"]/div[2]/div[1]/div[1]/div[3]/ul/li[8]/div",
                "//*[@id=\"cart-product-form-1830629\"]/div[4]/div/div/a",
                "//*[@id=\"goto-cart\"]",
                "//*[@id=\"pjax-content\"]/div/div[3]/section/div/div[2]/div/div[4]/a",
                "//*[@id=\"pjax-content\"]/div/div[3]/section/div/div/div/ul/li[3]/a",
                "//*[@id=\"delivery-type-form\"]/div/div/label"
        };

        wait = new WebDriverWait(driver, 15);

        for (int i = 0; i < paths.length; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paths[i])));
            driver.findElement(By.xpath(paths[i])).click();
        }
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"user-name\"]")).sendKeys("Janusz");
        driver.findElement(By.xpath("//*[@id=\"user-lastname\"]")).sendKeys("Nosacz");
        driver.findElement(By.xpath("//*[@id=\"user-city\"]")).sendKeys("Warszawa");
        driver.findElement(By.xpath("//*[@id=\"user-street\"]")).sendKeys("Krucza");
        driver.findElement(By.xpath("//*[@id=\"user-home_number\"]")).sendKeys("16/22");
        driver.findElement(By.xpath("//*[@id=\"user-postal_code\"]")).sendKeys("00-526");
        driver.findElement(By.xpath("//*[@id=\"user-email\"]")).sendKeys("r.sypniewski@moliera2.com");
        driver.findElement(By.xpath("//*[@id=\"user-phone\"]")).sendKeys("224700001");
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"pjax-content\"]/div/div[3]/section/div/div[2]/div[2]/div/div[4]/a")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\"payment-type-form\"]/div/div/label")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"payment-type-form\"]/div/div/label")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"pjax-content\"]/div/div[3]/section/div/div[2]/div[2]/div/div[4]/a")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[4]/div[1]/label/div[1]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"summary\"]/div/div[4]/div[2]/div/a")).click();

        Thread.sleep(10000);
        printSuccess();
    }
}
