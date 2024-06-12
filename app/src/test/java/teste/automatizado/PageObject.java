package teste.automatizado;

import java.time.Duration;

import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.WebDriverWait;

public abstract class PageObject {
    public WebDriver driver;
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

        // Tempo de espera por utilizar o wait.util de forma explicita
        wait = new WebDriverWait(this.driver, Duration.ofSeconds(15));

        // Instanciamos as configurações, para ter acesso dados sensiveis, como url,
        // login e senha.
        config = new ConfigLoader();

        // Iremos definir um Timeout para em caso de não encontrar o elemento na página.
        // De forma implicita
        this.driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
    }

    // Configurar para fechar.
    public void fechar() {
        this.driver.quit();
    }

    // Para ter acesso a url da página atual, e comparar.
    public String page() {
        return this.driver.getCurrentUrl();
    }

}
