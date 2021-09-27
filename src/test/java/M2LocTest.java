import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.HashMap;
import java.util.Map;

public class M2LocTest {
    WebDriver driver;
    WebDriverWait wait;
    Actions hover;
    WebElement element;

    String[] popupsPaths = {
            "//*[@id=\"sm-sidebar\"]/div/p",
            "//*[@id=\"cookies-info\"]/div/div/div[2]/div/div/div[2]/button",
    };

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        Map<String, String> mobileEmulation = new HashMap<>();
        mobileEmulation.put("deviceName", "iPhone 6/7/8 Plus");
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.setExperimentalOption("mobileEmulation", mobileEmulation);
        chromeOptions.addArguments("--incognito");
        driver = new ChromeDriver(chromeOptions);
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
        Thread.sleep(2000);
    }
    public void printSuccess() {
        System.out.println("Finished with success!");
    }

    //@After section contains the only one method which is responsible for closing browser after finished test
//    @After
//    public void tearDown() {
//        driver.quit();
//    }

    @Test
    public void mainTest() throws InterruptedException {
        closePopups();
        test();
    }
    public void closePopups() throws InterruptedException {
        wait = new WebDriverWait(driver, 15);
        for (int i = 0; i < popupsPaths.length; i++) {
            wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(popupsPaths[i])));
            driver.findElement(By.xpath(popupsPaths[i])).click();
        }
        Thread.sleep(2000);
    }

    public void test() throws InterruptedException {
        driver.findElement(By.className("navbar-toggle")).click();
        driver.findElement(By.className("mega-menu-gender-1")).click();
        Thread.sleep(4000);
    }
}
