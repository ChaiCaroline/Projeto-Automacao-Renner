# language: pt

@login
Funcionalidade: Validar Login

Contexto:
    Dado que o usuario esta na tela inicial
    E nao tem nenhuma conta conectada
Quando o usuario ao clicar em Entre ou Cadastre se

Cenário: Validar quando o usuário clicar em Entre ou Cadastre - se, um modal deverá ser exibido.
Então devera ser exibido o modal de identificacao

Cenário: Validar quando o usuário informar no login usuário e senha válidas, se o usuário e logado.
E preencher os campos de CPF e senha com informacoes validas
Então o usuario devera ser autentiado com sucesso

Esquema do Cenário: Validar quando o usuário tentar realizar login, com as credencias incorretas
E preencher os campos de '<usuario>' e '<senha>' com informacoes invalidas
Então devera retorna mensagem ao usuario de informacoes incorretas

Exemplos:
| usuario                    | senha       |
| chaiene                    | 123         |
| rochacaroline502@gmail.com | 123         |
| chaiene                    | chaiene1996 |

Cenário: Validar a funcionalidade quando o usuario clicar em "Esqueci a senha"
E o usuario ao clicar em esqueci a senha
Então devera exibir um modal pra preencher com o email para recuperacao da senha

Cenário: Validar o usuário consegue logar, usando sua rede social
Quando o usuario clicar em fazer login atraves do facebook ou google
Então devera abrir uma tela para o usuario selecionar o email associado a sua conta

Cenário: Validar a funcionalidade quando o usuario clicar no botao "Quero me Cadastrar"
E o usuario clicar em quero me Cadastrar
Então devera ser exibido ao usuario modal de cadastro