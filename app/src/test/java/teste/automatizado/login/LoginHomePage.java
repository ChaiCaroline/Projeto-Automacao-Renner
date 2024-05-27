package teste.automatizado.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.ConfigLoader;
import teste.automatizado.PageObject;

public class LoginHomePage extends PageObject {
    protected WebDriver driver;

    private By usernameBy = By.cssSelector(".header__user-content:nth-child(4) .user-info__strong");
    private By buttonEntreECadastreBy = By.cssSelector(".header__user-content:nth-child(4) .user-info > span");
    private By usernameModalBy = By.name("login");
    private By passwordModalBy = By.name("password");
    private By modalLoginBy = By.cssSelector(".modal-login-wrap:nth-child(2)");
    private By messageErrorLogin = By.cssSelector(".Alert_globalErrorAlert__HiuWF > .Alert_modal__8w2js");

    public LoginHomePage() {
        super();
        driver = PageObject.initializeDriver();
        ConfigLoader config = new ConfigLoader();
        driver.get(config.getUrl());
    }

    public void openModalLogin() {
        wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//header")));
        driver.findElement(buttonEntreECadastreBy).click();
        wait.until(ExpectedConditions.visibilityOfElementLocated(modalLoginBy));
    }

    public WebElement selectedModalLogin() {
        WebElement modalSelect = driver.findElement(modalLoginBy);
        return modalSelect;
    }

    public void loginValidUser(String username, String password) {
        WebElement inputUser = driver.findElement(usernameModalBy);
        WebElement inputPass = driver.findElement(passwordModalBy);

        inputUser.sendKeys(username);
        inputPass.sendKeys(password);
        driver.findElement(By.cssSelector(".modal-login__form-action > .Button_button__vcDFE")).click();
    }

    public String getUserLogged() {
        WebElement clientLogged = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameBy));
        return clientLogged.getText();
    }

    public WebElement openModalMessageLogin() {
        WebElement modalFailLogin = wait.until(ExpectedConditions.visibilityOfElementLocated(messageErrorLogin));
        return modalFailLogin;
    }

}
