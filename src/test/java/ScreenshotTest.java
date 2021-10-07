import io.github.bonigarcia.wdm.WebDriverManager;
import org.apache.commons.io.FileUtils;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import java.io.File;
import java.io.IOException;

public class ScreenshotTest {
    WebDriver driver;
    WebElement element;

    @Before
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://www.saucedemo.com/");
        driver.manage().window().maximize();
    }
    @After
    public void tearDown(){
        driver.quit();
    }
    @Test
    public void test(){
        //screenshot of direct element
        element = driver.findElement(By.id("login-button"));
        File scrFile = element.getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(scrFile, new File("resources/image2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        //screenshot of full site content
        File fullScrFile = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
        try {
            FileUtils.copyFile(fullScrFile, new File("resources/fullimage2.png"));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
