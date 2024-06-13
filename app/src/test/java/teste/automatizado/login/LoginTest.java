package teste.automatizado.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class LoginTest {
    private LoginHomePage pageHome;

    @BeforeEach
    void setup() {
        pageHome = new LoginHomePage();
        pageHome.buttonOpenModal().click();
        pageHome.openModalLogin();
    }

    @AfterEach
    void AfterEach() {
        this.pageHome.fechar();
    }

    @Test
    void openModalLogin() {
        assertTrue(pageHome.openModalLogin().isDisplayed());
    }

    @Test
    void testLoginSuccess() {
        pageHome.loginValidUser(pageHome.username, pageHome.password);
        assertTrue(pageHome.userLogged("Chaiene"));
    }

    @Test
    void testLoginFail() {
        pageHome.loginValidUser(pageHome.username, "senha");
        assertTrue(pageHome.messagemErrorModalLogin().isDisplayed());
    }
}
