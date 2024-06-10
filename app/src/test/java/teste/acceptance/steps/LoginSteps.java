package teste.acceptance.steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import teste.automatizado.login.LoginHomePage;

public class LoginSteps {
    private LoginHomePage loginPage;

    @Dado("O usuario esta na pagina da Renner")
    public void o_usuario_esta_na_pagina_da_renner() {
        this.loginPage = new LoginHomePage();
    }

    @Quando("o usuario clicar em Entre ou Cadastre se")
    public void o_usuario_clicar_em_entre_ou_cadastre_se() {
        loginPage.openModalLogin();
    }

    @Entao("devera ser exibido o modal para efetuar o login no site")
    public void devera_ser_exibido_o_modal_para_efetuar_o_login_no_site() {
        assertTrue(loginPage.selectedModalLogin().isDisplayed());
        loginPage.fechar();
    }
}
