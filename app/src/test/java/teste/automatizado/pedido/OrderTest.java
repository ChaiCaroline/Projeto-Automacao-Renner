package teste.automatizado.pedido;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.login.LoginHomePage;
import teste.automatizado.produto.AddProductPage;

public class OrderTest {
    private OrderPage checkPage;

    @BeforeEach
    void setup() {
        // this.config = new ConfigLoader();
        LoginHomePage LoginPage = new LoginHomePage();
        LoginPage.openModalLogin();
        String username = LoginPage.config.getUsername();
        String password = LoginPage.config.getPassword();
        AddProductPage addProduct = LoginPage.loginValidUser(username, password);
        this.checkPage = new OrderPage(addProduct.driver);

    }

    @AfterEach
    void AfterEach() {
        checkPage.fechar();
    }

    @Test
    void finallyMethod() throws InterruptedException {
        // checkPage.finishShopping();
        checkPage.clickSacola();
        checkPage.firstCheck();
        checkPage.secondCheck();
        assertTrue(checkPage.paymentVisible());
    }

}
