package teste.automatizado.pedido;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import dev.failsafe.internal.util.Durations;
import teste.automatizado.ConfigLoader;
import teste.automatizado.PageObject;

public class OrderPage extends PageObject {

    private By finishButton = By.cssSelector(".end_buy");

    /* apagar depois */
    private By inputSearch = By.name("Ntt");
    private By buttonCar = By.className("ProductInformation_actionBuy__8RfyL");
    private By usernameModalBy = By.name("login");
    private By passwordModalBy = By.name("password");
    private By buttonEntreECadastreBy = By.cssSelector(".header__user-content:nth-child(4) .user-info > span");
    private By modalLoginBy = By.cssSelector(".modal-login-wrap:nth-child(2)");
    private By codeProduct = By
            .cssSelector(".ProductTitle_ref__YJWpm > small");
    private By myBag = By.cssSelector(".checkout_cart");

    public OrderPage() {
        super(null);
        // driver = PageObject.initializeDriver();
        ConfigLoader config = new ConfigLoader();
        driver.get(config.getUrl());
    }

    public void finishShopping() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oo-loader']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
        // wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".row_buttons")));
        WebElement button = wait.until(ExpectedConditions.elementToBeClickable(finishButton));
        Thread.sleep(5000);
        button.click();
    }

    public void firstCheck() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe("https://hml01.lojasrenner.com.br/checkout"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".adresses")));
        By lastCep = By.xpath("//input[@value='Address##1']/following-sibling::div");

        driver.findElement(lastCep).click();
    }

    public void secondCheck() throws InterruptedException {
        Thread.sleep(5000);
        WebElement verifyModal = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content")));
        // driver.findElement(By.cssSelector(".content"));
        if (verifyModal.isDisplayed()) {
            driver.findElement(By.id("messageOk")).click();
            Thread.sleep(3000);
            // driver.findElement(By.xpath("//*[contains(@id,'STANDARD')]")).click();
            driver.findElement(By.xpath("//input[@value='CONTINGENCY']")).click();
            driver.findElement(By.xpath("//*[@class='action_1 js-confirm-delivery button-ds' and @href='#']")).click();
        }
    }

    public boolean paymentVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".active_info")));
        return driver.findElement(By.cssSelector(".active_info")).isDisplayed();
    }

    /* Arrumar */
    public void loginSite(String username, String password) {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header")));
        driver.findElement(buttonEntreECadastreBy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoginBy));
        WebElement inputUser = driver.findElement(usernameModalBy);
        WebElement inputPass = driver.findElement(passwordModalBy);

        inputUser.sendKeys(username);
        inputPass.sendKeys(password);
        driver.findElement(By.cssSelector(".modal-login__form-action > .Button_button__vcDFE")).click();
    }

    public WebElement searchProduct(String product) {
        WebElement input = driver.findElement(inputSearch);
        input.sendKeys(product);
        input.submit();
        return input;
    }

    public WebElement selectFirstProduct() {
        WebElement firstProduct = wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".ProductBox_productImg__B_6VV")));
        firstProduct.click();
        return firstProduct;
    }

    public WebElement verifyFirstProduct(String product) {
        WebElement code = wait.until(ExpectedConditions.visibilityOfElementLocated(codeProduct));
        return code;
    }

    public WebElement addCarProduct() {
        WebElement buttonCarVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCar));
        buttonCarVisible.click();
        return buttonCarVisible;
    }

}
