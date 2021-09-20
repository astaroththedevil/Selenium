import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class Moliera2AddProductToCartTest {

    WebDriver driver;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"cookies-info\"]/div/div/div[2]/div/div/div[2]/button")).click();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id=\"sm-sidebar\"]/div[1]/p")).click();
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
    public void shouldAddProductToCart() throws InterruptedException {

        String[] paths = {
            "//*[@id=\"pjax-content\"]/div/div[3]/div[1]/div[4]/div/div/div[1]/div[2]/div/a/button",
            "//*[@id=\"product-list\"]/div[3]/a/div[2]/div[1]/h2",
            "//*[@id=\"cart-product-form-1830629\"]/div[2]/div[1]/div[1]/div[2]/span[2]",
            "//*[@id=\"cart-product-form-1830629\"]/div[2]/div[1]/div[1]/div[3]/ul/li[8]/div",
            "//*[@id=\"cart-product-form-1830629\"]/div[4]/div/div/a",
            "//*[@id=\"goto-cart\"]"
        };

        for (int i = 0; i < paths.length; i++) {
            driver.findElement(By.xpath(paths[i])).click();
            Thread.sleep(2500);
        }
    }
}
