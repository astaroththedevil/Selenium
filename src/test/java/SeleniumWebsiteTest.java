import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebsiteTest {

    WebDriver driver;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        driver = new ChromeDriver();
    }
    String success = "Finished with success!";
    public void printSuccess(){
        System.out.println(success);
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void shouldOpenBrowserManipulation() throws InterruptedException {
        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"m-documentationwebdriver\"]/span")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"m-documentationwebdriverbrowser_manipulation\"]/span")).click();

        System.out.println(driver.getTitle());
        printSuccess();
    }
}
