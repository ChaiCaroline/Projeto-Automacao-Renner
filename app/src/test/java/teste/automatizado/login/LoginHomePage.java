package teste.automatizado.login;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;

import teste.automatizado.PageObject;
import teste.automatizado.produto.AddProductPage;

public class LoginHomePage extends PageObject {

    public LoginHomePage() {
        super(null);
        this.driver.get(config.getUrl());
    }

    public WebElement buttonOpenModal() {
        return this.driver.findElement(By.cssSelector(".user-info > span"));
    }

    public WebElement openModalLogin() {
        WebElement modalLogin = this.wait
                .until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(".modal-login-wrap:nth-child(2)")));
        return modalLogin;
    }

    // Refatorar esse código
    public AddProductPage loginValidUser(String username, String password) {
        this.driver.findElement(By.name("login")).sendKeys(username);
        this.driver.findElement(By.name("password")).sendKeys(password);
        driver.findElement(By.xpath("//div[contains(@class, 'modal-login__form-action')]/button")).click();

        return new AddProductPage(driver);
    }

    public Boolean userLogged(String user) {
        boolean clientLogged = this.wait
                .until(ExpectedConditions.textToBePresentInElementLocated(By.className("user-info__strong"), user));
        return clientLogged;
    }

    public WebElement messagemErrorModalLogin() {
        return driver.findElement(By.className("modal-alert-message"));
    }

    public void buttonForgotMyPassword() {
        driver.findElement(By.xpath("//div[@class='modal-login__forgot-password']/button")).click();
    }

    public WebElement modalForgotMyPassword() {
        return wait.until(ExpectedConditions
                .visibilityOfElementLocated(By.xpath("//div[@class='modal-forgot-password-wrap']/div/div")));
    }

    public void clickLoginSocial() {
        // wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='login-google-button']/.."))).click();
        driver.findElement(By.className("modal-login__social-login-btn")).click();
    }

    public void buttonRegister() {
        driver.findElement(By.xpath("//div[contains(@class, 'modal-login__register-container')]/button")).click();
    }

    public void modalRegister() {
        driver.findElement(By.xpath("//div[contains(@class, 'modal-loginRegister')]")).click();
    }

    public void clickModalMessageError() {
        driver.findElement(By.xpath("//button[contains(text(), 'OK')]")).click();
    }
}
