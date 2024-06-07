package teste.automatizado.produto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.ConfigLoader;
import teste.automatizado.login.LoginHomePage;

public class AddProductTest {
    private ConfigLoader config;
    private AddProductPage addProduct;

    @BeforeEach
    void setup() {
        this.config = new ConfigLoader();
        LoginHomePage LoginPage = new LoginHomePage();
        LoginPage.openModalLogin();
        String username = config.getUsername();
        String password = config.getPassword();
        addProduct = LoginPage.loginValidUser(username, password);
    }

    // @AfterEach
    // void AfterEach() {
    // AddProductPage.fechar();
    // }

    @Test
    void AddproductABag() {
        String codeProductTest = "606674641";
        addProduct.searchProduct(codeProductTest);
        addProduct.selectFirstProduct();
        assertTrue(addProduct.verifyFirstProduct(codeProductTest).getText().contains(codeProductTest));
        addProduct.addCarProduct();
        assertTrue(addProduct.isPage("https://hml01.lojasrenner.com.br/sacola"));
    }
}
