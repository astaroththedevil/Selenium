import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;

public class SeleniumWebsiteChromedriverDownloadTest {

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
    public void shouldDownloadDriver() throws InterruptedException{

        driver.get("https://www.selenium.dev/");
        driver.manage().window().maximize();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"main_navbar\"]/ul/li[4]/a/span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"m-documentationgetting_started\"]/span")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"m-documentationgetting_startedinstalling_browser_drivers\"]/span")).click();
        Thread.sleep(1500);
        ((JavascriptExecutor) driver).executeScript("window.open()");
        ArrayList<String> tabs = new ArrayList<String>(driver.getWindowHandles());

        driver.switchTo().window(tabs.get(1));
        driver.get("https://chromedriver.storage.googleapis.com/index.html");
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[100]/td[2]/a")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("/html/body/table/tbody/tr[4]/td[2]/a")).click();
        Thread.sleep(2000);
        driver.switchTo().window(tabs.get(0));
        Thread.sleep(3000);
        printSuccess();
    }
}
