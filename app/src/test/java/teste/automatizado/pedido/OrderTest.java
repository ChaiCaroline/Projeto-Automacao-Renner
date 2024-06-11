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
        LoginHomePage LoginPage = new LoginHomePage();
        LoginPage.openModalLogin();
        AddProductPage addProduct = LoginPage.loginValidUser(LoginPage.config.getUsername(),
                LoginPage.config.getPassword());
        this.checkPage = new OrderPage(addProduct.driver);

    }

    @AfterEach
    void AfterEach() {
        checkPage.fechar();
    }

    @Test
    void finallyMethod() throws InterruptedException {
        checkPage.clickSacola();
        checkPage.firstCheck();
        checkPage.secondCheck();
        assertTrue(checkPage.paymentVisible());
        checkPage.pagymentCheck();
        assertTrue(checkPage.page("https://hml01.lojasrenner.com.br/confirmacao-pedido"));
    }

}
