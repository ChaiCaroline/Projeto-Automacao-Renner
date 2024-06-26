package teste.automatizado.pedido;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;

public class AddProductPage extends PageObject {
    private By inputSearch = By.name("Ntt");
    private By buttonCar = By.cssSelector(".ProductInformation_actionBuy__8RfyL");
    private By codeProduct = By
            .cssSelector(".ProductTitle_ref__YJWpm > small");
    private By myBag = By.cssSelector(".checkout_cart");

    public AddProductPage(WebDriver driver) {
        super(driver);
        this.driver = driver;
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

    public WebElement addCarProduct() throws InterruptedException {
        Thread.sleep(1000);
        wait.until(ExpectedConditions
                .presenceOfElementLocated(By.cssSelector(".ReactProductDetails_productDetails__mX3Ex")));
        WebElement buttonCarVisible = wait.until(ExpectedConditions.visibilityOfElementLocated(buttonCar));
        buttonCarVisible.click();
        return buttonCarVisible;
    }

    public boolean isPage(String page) {
        wait.until(ExpectedConditions.presenceOfElementLocated(myBag));
        return driver.getCurrentUrl().equals(page);
    }
}
