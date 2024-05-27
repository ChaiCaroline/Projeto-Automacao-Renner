package teste.automatizado.produto;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import teste.automatizado.ConfigLoader;
import teste.automatizado.PageObject;

public class AddProductPage extends PageObject {
    private By inputSearch = By.name("Ntt");
    private By buttonCar = By.className("ProductInformation_actionBuy__8RfyL");
    private By usernameModalBy = By.name("login");
    private By passwordModalBy = By.name("password");
    private By buttonEntreECadastreBy = By.cssSelector(".header__user-content:nth-child(4) .user-info > span");
    private By modalLoginBy = By.cssSelector(".modal-login-wrap:nth-child(2)");
    private By codeProduct = By
            .cssSelector(".ProductTitle_ref__YJWpm > small");

    public AddProductPage() {
        super();
        driver = PageObject.initializeDriver();
        ConfigLoader config = new ConfigLoader();
        driver.get(config.getUrl());
    }

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
                .until(ExpectedConditions.visibilityOfElementLocated(By.className("ProductBox_title__x9UGh")));
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

    public boolean isPage(String page) {
        return driver.getCurrentUrl().equals(page);
    }
}
