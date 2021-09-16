import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class MolieraFirstTest {

    @BeforeClass
    public static void setupClass(){
        WebDriverManager.chromedriver().setup();
    }

    @Test
    public void moliera() throws InterruptedException{
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.moliera2.com/");
        driver.manage().window().maximize();
        Thread.sleep(3000);
        String title = driver.getTitle();

        driver.findElement(By.xpath("//*[@id=\"cookies-info\"]/div/div/div[2]/div/div/div[2]/button")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id=\"sm-sidebar\"]/div[1]/p")).click();
        Thread.sleep(1500);
        driver.findElement(By.xpath("//*[@id=\"desktop-top-banner\"]/div/a/img")).click();
        Thread.sleep(20000);
        driver.quit();





    }
}
