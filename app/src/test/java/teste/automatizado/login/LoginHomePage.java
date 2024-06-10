package teste.automatizado.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;
import teste.automatizado.produto.AddProductPage;

public class LoginHomePage extends PageObject {
    private By usernameBy = By.cssSelector(".header__user-content:nth-child(4) .user-info__strong");
    private By buttonEntreECadastreBy = By.cssSelector(".header__user-content:nth-child(4) .user-info > span");
    private By usernameModalBy = By.name("login");
    private By passwordModalBy = By.name("password");
    private By modalLoginBy = By.cssSelector(".modal-login-wrap:nth-child(2)");
    private By messageErrorLogin = By.cssSelector(".Alert_globalErrorAlert__HiuWF > .Alert_modal__8w2js");

    public LoginHomePage() {
        super(null);
        this.driver.get(config.getUrl());
    }

    public void openModalLogin() {
        this.wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header")));
        this.driver.findElement(buttonEntreECadastreBy).click();
        this.wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoginBy));
    }

    public WebElement selectedModalLogin() {
        WebElement modalSelect = this.driver.findElement(modalLoginBy);
        return modalSelect;
    }

    public AddProductPage loginValidUser(String username, String password) {
        WebElement inputUser = this.driver.findElement(usernameModalBy);
        WebElement inputPass = this.driver.findElement(passwordModalBy);

        inputUser.sendKeys(username);
        inputPass.sendKeys(password);
        driver.findElement(By.cssSelector(".modal-login__form-action > .Button_button__vcDFE")).click();

        return new AddProductPage(driver);
    }

    public String getUserLogged() {
        WebElement clientLogged = this.wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
        return clientLogged.getText();
    }

    public WebElement openModalMessageLogin() {
        WebElement modalFailLogin = this.wait.until(ExpectedConditions.visibilityOfElementLocated(messageErrorLogin));
        return modalFailLogin;
    }

}
