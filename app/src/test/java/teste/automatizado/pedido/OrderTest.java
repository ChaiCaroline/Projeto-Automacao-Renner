package teste.automatizado.pedido;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebElement;

import teste.automatizado.ConfigLoader;
import teste.automatizado.pedido.OrderPage;
//import teste.automatizado.produto.AddProductPage;

public class OrderTest {
    private ConfigLoader config;
    private OrderPage checkPage;
    // private AddProductPage addProduct;

    @BeforeEach
    void setup() {
        this.config = new ConfigLoader();
        this.checkPage = new OrderPage();
        // this.addProduct = new AddProductPage();
    }

    // @AfterEach
    // void AfterEach() {
    // OrderPage.fechar();
    // }

    @Test
    void finallyMethod() throws InterruptedException {
        String codeProductTest = "606674641";
        String username = config.getUsername();
        String password = config.getPassword();
        checkPage.loginSite(username, password);
        checkPage.searchProduct(codeProductTest);
        checkPage.selectFirstProduct();
        checkPage.addCarProduct();
        checkPage.finishShopping();
        checkPage.firstCheck();
        checkPage.secondCheck();
        assertTrue(checkPage.paymentVisible());
    }

}
