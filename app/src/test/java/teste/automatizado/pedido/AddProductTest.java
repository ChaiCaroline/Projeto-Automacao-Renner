package teste.automatizado.pedido;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.login.LoginHomePage;

public class AddProductTest {
    private AddProductPage addProduct;

    @BeforeEach
    void setup() {
        LoginHomePage LoginPage = new LoginHomePage();
        LoginPage.buttonOpenModal().click();
        LoginPage.openModalLogin();
        addProduct = LoginPage.loginValidUser(LoginPage.username, LoginPage.password);
    }

    @AfterEach
    void AfterEach() {
        addProduct.fechar();
    }

    @Test
    void AddproductABag() throws InterruptedException {
        String codeProductTest = "606674641";
        addProduct.searchProduct(codeProductTest);
        addProduct.selectFirstProduct();
        assertTrue(addProduct.verifyFirstProduct(codeProductTest).getText().contains(codeProductTest));
        addProduct.addCarProduct();
        assertTrue(addProduct.isPage("https://hml01.lojasrenner.com.br/sacola"));
    }
}
