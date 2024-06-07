package teste.automatizado;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    protected WebDriver driver;
    protected WebDriverWait wait;
    public ConfigLoader config;

    public PageObject(WebDriver driver) {
        System.setProperty("webdriver.chrome.driver", "src/driver/chromedriver.exe");

        if (driver != null) {
            this.driver = driver;
        } else {
            ChromeOptions options = new ChromeOptions();
            options.setPageLoadStrategy(PageLoadStrategy.EAGER);
            this.driver = new ChromeDriver(options);
        }

        wait = new WebDriverWait(this.driver, Duration.ofSeconds(30));
        config = new ConfigLoader();
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
    }

    public void fechar() {
        this.driver.quit();
    }

}
