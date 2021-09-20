import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Moliera2AddProductToCartWaitClassTest {

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
                "//*[@id=\"goto-cart\"]"
        };

        wait = new WebDriverWait(driver, 15);

        for (int i = 0; i < paths.length; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(paths[i])));
            driver.findElement(By.xpath(paths[i])).click();
        }
        Thread.sleep(3000);
        printSuccess();
    }
}
