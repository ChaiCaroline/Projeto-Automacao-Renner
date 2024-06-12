package teste.acceptance.steps;

import static org.junit.Assert.assertTrue;

import io.cucumber.java.After;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.E;
import io.cucumber.java.pt.Entao;
import io.cucumber.java.pt.Quando;
import teste.automatizado.login.LoginHomePage;

public class LoginSteps {
    private LoginHomePage loginPage;

    @After("@login")
    public void AfterAll() {
        loginPage.fechar();
    }

    // Cenario 1
    @Dado("que o usuario esta na tela inicial")
    public void que_o_usuario_esta_na_tela_inicial() {
        this.loginPage = new LoginHomePage();
    }

    @E("nao tem nenhuma conta conectada")
    public void nao_tem_nenhuma_conta_conectada() {
        loginPage.buttonOpenModal().getText().equals("Entre ou Cadastre-se");
    }

    @Quando("o usuario ao clicar em Entre ou Cadastre se")
    public void o_usuario_ao_clicar_em_entre_ou_cadastre_se() {
        loginPage.buttonOpenModal().click();
    }

    @Entao("devera ser exibido o modal de identificacao")
    public void devera_ser_exibido_o_modal_de_identificacao() {
        assertTrue(loginPage.openModalLogin().isDisplayed());
    }

    // Cenario 2
    @E("preencher os campos de CPF e senha com informacoes validas")
    public void preencher_os_campos_de_CPF_e_senha_com_informacoes_validas() {
        loginPage.loginValidUser("rochacaroline502@gmail.com", "chaiene1996");
    }

    @Entao("o usuario devera ser autentiado com sucesso")
    public void o_usuario_devera_ser_autentiado_com_sucesso() {
        assertTrue(loginPage.userLogged("Chaiene"));
    }

    // Cenario 3
    @E("preencher os campos de {string} e {string} com informacoes invalidas")
    public void preencher_os_campos_de_usuario_e_senha_com_informacoes_invalidas(String usuario, String senha) {
        loginPage.loginValidUser(usuario, senha);
    }

    @Entao("devera retorna mensagem ao usuario de informacoes incorretas")
    public void devera_retorna_mensagem_ao_usuario_de_informacoes_incorretas() {
        loginPage.messagemErrorModalLogin();
    }

    // Cenario 4
    @E("o usuario ao clicar em esqueci a senha")
    public void o_usuario_ao_clicar_em_esqueci_a_senha() {
        loginPage.buttonForgotMyPassword();
    }

    @Entao("devera exibir um modal pra preencher com o email para recuperacao da senha")
    public void devera_exibir_um_modal_pra_preencher_com_o_email_para_recuperacao_da_senha() {
        assertTrue(loginPage.modalForgotMyPassword().isDisplayed());
    }

    // Cenario 5
    @E("o usuario clicar em fazer login atraves do facebook ou google")
    public void o_usuario_clicar_em_fazer_login_atraves_do_facebook_ou_google() {
        loginPage.clickLoginSocial();
    }

    @Entao("devera abrir uma tela para o usuario selecionar o email associado a sua conta")
    public void devera_abrir_uma_tela_para_o_usuario_selecionar_o_email_associado_a_sua_conta() {
        System.out.println(loginPage.page());
        assertTrue(loginPage.page().contains("facebook.com"));
    }

    // Cenario 6
    @E("o usuario clicar em quero me Cadastrar")
    public void o_usuario_clicar_em_quero_me_Cadastrar() {
        loginPage.buttonRegister();
    }

    @Entao("devera ser exibido ao usuario modal de cadastro")
    public void devera_ser_exibido_ao_usuario_modal_de_cadastro() {
        loginPage.modalRegister();
    }
}
