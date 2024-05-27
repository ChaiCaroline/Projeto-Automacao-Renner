package teste.automatizado.produto;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.ConfigLoader;

public class AddProductTest {
    private ConfigLoader config;
    private AddProductPage addProduct;

    @BeforeEach
    void setup() {
        this.config = new ConfigLoader();
        this.addProduct = new AddProductPage();
    }

    @AfterEach
    void AfterEach() {
        AddProductPage.fechar();
    }

    @Test
    void SearchProduct() {
        String codeProductTest = "606674641";
        String username = config.getUsername();
        String password = config.getPassword();
        addProduct.loginSite(username, password);
        addProduct.searchProduct(codeProductTest);
        addProduct.selectFirstProduct();
        assertTrue(addProduct.verifyFirstProduct(codeProductTest).getText().contains(codeProductTest));
    }
}
