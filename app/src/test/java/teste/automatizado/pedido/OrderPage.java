package teste.automatizado.pedido;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;

public class OrderPage extends PageObject {
    private By finishButton = By.cssSelector(".end_buy");

    public OrderPage(WebDriver driver) {
        super(driver);
        driver.get(config.getUrl());
    }

    public void clickSacola() {
        driver.get("https://hml01.lojasrenner.com.br/checkout");
    }

    public void finishShopping() throws InterruptedException {
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.xpath("//div[@class='oo-loader']")));
        wait.until(ExpectedConditions.visibilityOfElementLocated(finishButton));
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
        if (verifyModal.isDisplayed()) {
            driver.findElement(By.id("messageOk")).click();
            // Thread.sleep(3000);
            driver.findElement(By.xpath("//input[@name='shippingOption-1']")).click();
            driver.findElement(By.xpath("//*[@class='action_1 js-confirm-delivery button-ds' and @href='#']")).click();
        }
    }

    public boolean paymentVisible() {
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".active_info")));
        return driver.findElement(By.cssSelector(".active_info")).isDisplayed();
    }

    public void pagymentCheck() throws InterruptedException {
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[@data-payment-type='creditCard']/..")).click();
        driver.findElement(By.xpath("//ul[@class='checkout-wallet checkout-wallet_creditCard']")).click();
        wait.until(
                ExpectedConditions.presenceOfElementLocated(By.xpath("//div[@class='checkout-wallet_card-content']")));
        driver.findElement(By.xpath("//input[@name='securityCode']")).sendKeys("483");

        // botão parece que nao esta clicando, tentar outro seletores
        Thread.sleep(2000);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".form__credit_card--installments_selected")));
        driver.findElement(By.xpath("//div[@class='form__credit_card--installments']")).click();

        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ul[@transition='expand']/li[1]")));
        driver.findElement(By.cssSelector(".form__credit_card--installments_options > .us")).click();
        driver.findElement(By.xpath("//button[contains(@class, 'form__credit_card--button')]")).click();

        Thread.sleep(3000);
    }

}
