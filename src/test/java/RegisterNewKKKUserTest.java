import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

public class RegisterNewKKKUserTest {
    WebDriver driver;
    WebDriverWait wait;
    WebElement newMail, userFirstName, userLastName, phoneNum, mail;
    String address = new String();
    ArrayList<String> tabs;

    @Before
    public void setup() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "resources/chromedriver");
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        driver = new ChromeDriver(options);
        driver.get("https://cryptogmail.com/");
        driver.manage().window().maximize();
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
    public void test() throws InterruptedException {
        createNewEmailAddress();
        openNewTabInBrowser();
        shouldClosePopup();
        shouldOpenKKKForm();
        shouldFillTheForm();
        shouldSelectCheckboxes();
        shouldConfirmSubscription();
        sleep();
        switchBackToTabWithMail();
        sleep();
        printSuccess();
    }

    public void createNewEmailAddress() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("/html/body/div/div/div[1]/div/div[1]/div")));
        newMail = driver.findElement(By.xpath("/html/body/div/div/div[1]/div/div[1]/div"));
        address = newMail.getText();
    }

    public void openNewTabInBrowser() {
        ((JavascriptExecutor) driver).executeScript("window.open()");
        tabs = new ArrayList<String>(driver.getWindowHandles());
        driver.switchTo().window(tabs.get(1));
        driver.get("https://www.moliera2.com/");
    }

    private void shouldClosePopup() {
        wait = new WebDriverWait(driver, 15);
        wait.until(ExpectedConditions.elementToBeClickable(By.className("close-cookie-info")));
        driver.findElement(By.className("close-cookie-info")).click();
    }

    public void shouldOpenKKKForm() {
        driver.navigate().to("https://www.moliera2.com/k-k-form");
    }

    public void shouldFillTheForm() {
        userFirstName = driver.findElement(By.id("kkuser-name"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("kkuser-name")));
        userFirstName.sendKeys("Janusz");
        userFirstName.sendKeys(Keys.TAB);
        userLastName = driver.switchTo().activeElement();
        userLastName.sendKeys("Nosacz");
        userLastName.sendKeys(Keys.TAB);
        phoneNum = driver.switchTo().activeElement();
        phoneNum.sendKeys("000111222");
        phoneNum.sendKeys(Keys.TAB);
        mail = driver.switchTo().activeElement();
        mail.sendKeys(address);
    }

    public void shouldSelectCheckboxes() {
        driver.findElement(By.xpath("//*[@id=\"kkuserdesigner-feature_value_id_top\"]/div[4]/div/label/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"kkuserdesigner-feature_value_id_top\"]/div[7]/div/label/div[1]/span")).click();
        driver.findElement(By.xpath("//*[@id=\"kk-form\"]/div[5]/div/ul/li[1]/div/label/div[1]/span")).click();
    }

    public void shouldConfirmSubscription() {
        driver.findElement(By.className("btn-widget")).click();
    }

    public void switchBackToTabWithMail() {
        driver.switchTo().window(tabs.get(0));
    }

    public void sleep() throws InterruptedException {
        Thread.sleep(4000);
    }
}
