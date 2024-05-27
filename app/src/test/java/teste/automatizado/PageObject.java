package teste.automatizado;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    protected static WebDriver driver;
    protected static WebDriverWait wait;

    public PageObject() {

    }

    public static WebDriver initializeDriver() {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.setPageLoadStrategy(PageLoadStrategy.EAGER);
        driver = new ChromeDriver(options);
        wait = new WebDriverWait(driver, Duration.ofSeconds(30));
        return driver;
    }

    public static void fechar() {
        driver.quit();
    }

}
