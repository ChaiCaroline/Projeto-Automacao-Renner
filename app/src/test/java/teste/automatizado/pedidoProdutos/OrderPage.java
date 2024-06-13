package teste.automatizado.pedidoProdutos;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;

public class OrderPage extends PageObject {
    public OrderPage(WebDriver driver) {
        super(driver);
        driver.get(config.getUrl());
    }

    public void clickSacola() {
        driver.get("https://hml01.lojasrenner.com.br/checkout");
    }

    public void finishShopping() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oo-loader']")));
        wait.until(ExpectedConditions.elementToBeClickable(By.className(".end_buy"))).click();
    }

    public void firstCheck() throws InterruptedException {
        wait.until(ExpectedConditions.urlToBe("https://hml01.lojasrenner.com.br/checkout"));
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".adresses")));
        By lastCep = By.xpath("//input[@value='Address##1']/following-sibling::div");

        driver.findElement(lastCep).click();
    }

    public void secondCheck() throws InterruptedException {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(".content")));
        wait.until(ExpectedConditions.elementToBeClickable(By.id("messageOk"))).click();
        wait.until(
                ExpectedConditions.elementToBeClickable(By.xpath("//input[@data-deliverymethodtype='STANDARD']")))
                .click();
    }

    public void paymentVisible() {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//A[contains(text(), 'IR PARA PAGAMENTO')]")))
                .click();
    }

    public void pagymentCheck() throws InterruptedException {
        wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[@data-payment-type='creditCard']/..")))
                .click();
        wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//ul[@class='checkout-wallet checkout-wallet_creditCard']"))).click();
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout-wallet_card-content']")));
        driver.findElement(By.xpath("//input[@name='securityCode']")).sendKeys("483");
        WebElement inputParcelas = wait.until(ExpectedConditions
                .elementToBeClickable(By.xpath("//div[@class='form__credit_card--installments']/div")));
        inputParcelas.click();
        WebElement parcelas = wait
                .until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@transition='expand']/li[1]")));
        if (!parcelas.isDisplayed()) {
            inputParcelas.click();
        }
        driver.findElement(By.cssSelector(".form__credit_card--installments_options > .us")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'form__credit_card--button')]")).click();
        wait.until(ExpectedConditions.urlToBe("https://hml01.lojasrenner.com.br/confirmacao-pedido"));
    }

}
