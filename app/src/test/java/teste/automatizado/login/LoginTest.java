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
        pageHome.openModalLogin();
    }

    @AfterEach
    void AfterEach() {
        this.pageHome.fechar();
    }

    @Test
    void openModalLogin() {
        assertTrue(pageHome.selectedModalLogin().isDisplayed());
    }

    @Test
    void testLoginSuccess() {
        String username = pageHome.config.getUsername();
        String password = pageHome.config.getPassword();
        pageHome.loginValidUser(username, password);
        assertTrue(pageHome.getUserLogged().equals("Chaiene"));
    }

    @Test
    void testLoginFail() {
        String username = pageHome.config.getUsername();
        pageHome.loginValidUser(username, "senha");
        assertTrue(pageHome.openModalMessageLogin().isDisplayed());
    }
}
