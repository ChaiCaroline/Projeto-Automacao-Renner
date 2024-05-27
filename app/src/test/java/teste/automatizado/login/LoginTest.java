package teste.automatizado.login;

import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import teste.automatizado.ConfigLoader;

public class LoginTest {
    private LoginHomePage pageHome;
    private ConfigLoader config;

    @BeforeEach
    void setup() {
        this.config = new ConfigLoader();
        this.pageHome = new LoginHomePage();
        pageHome.openModalLogin();
    }

    @AfterEach
    void AfterEach() {
        LoginHomePage.fechar();
    }

    @Test
    void openModalLogin() {
        assertTrue(pageHome.selectedModalLogin().isDisplayed());
    }

    @Test
    void testLoginSuccess() {
        String username = config.getUsername();
        String password = config.getPassword();
        pageHome.loginValidUser(username, password);
        assertTrue(pageHome.getUserLogged().equals("Chaiene"));
    }

    @Test
    void testLoginFail() {
        String username = config.getUsername();
        pageHome.loginValidUser(username, "senha");
        assertTrue(pageHome.openModalMessageLogin().isDisplayed());
    }
}
