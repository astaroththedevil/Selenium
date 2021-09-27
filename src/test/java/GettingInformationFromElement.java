import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class GettingInformationFromElement {
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
        WebElement logIn = driver.findElement(By.id("login_credentials"));
        System.out.println("Text: " + logIn.getText());
        System.out.println("Tag name: " + logIn.getTagName());
        System.out.println("Attribute: " + logIn.getAttribute("type"));
        System.out.println("Displayed?: " + logIn.isDisplayed());
        System.out.println("Enabled?: " + logIn.isEnabled());
        System.out.println("Selected? : " + logIn.isSelected());
        System.out.println("Location: " + logIn.getLocation());
        System.out.println("Size of an element: " + logIn.getSize());
    }
}

