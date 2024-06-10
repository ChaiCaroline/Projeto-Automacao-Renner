package teste.automatizado.pedido;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;

public class OrderPage extends PageObject {
    private By finishButton = By.cssSelector(".end_buy");
    // private By myBag = By.cssSelector(".checkout_cart");

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

}
