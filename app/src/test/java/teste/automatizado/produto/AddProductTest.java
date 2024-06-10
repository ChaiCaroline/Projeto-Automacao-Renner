package teste.automatizado.produto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.login.LoginHomePage;

public class AddProductTest {
    // private ConfigLoader config;
    private AddProductPage addProduct;

    @BeforeEach
    void setup() {
        // this.config = new ConfigLoader();
        LoginHomePage LoginPage = new LoginHomePage();
        LoginPage.openModalLogin();
        String username = LoginPage.config.getUsername();
        String password = LoginPage.config.getPassword();
        addProduct = LoginPage.loginValidUser(username, password);
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
