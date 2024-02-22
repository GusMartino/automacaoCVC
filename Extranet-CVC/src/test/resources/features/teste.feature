#language: pt
#encoding: utf-8
#Author: gustavo.oliveira@izziremessas.com.br

@Regressivo @TESTE
Funcionalidade: Validação de tela inicial e login
  Eu como usuario desejo efetuar login

  @CT01 
  Cenário: CT01 Fazer cotação e login com sucesso em primeiro acesso e salvar conta
    Dado que efetuo login preeencho cpf "teste" e senha "Teste@123"
    Quando vou em tal lugar
    Então válido tal coisa
  
  @CT02 
  Cenário: CT01 Fazer cotação e login com sucesso em primeiro acesso e salvar conta
    Dado que efetuo login
    Quando vou em tal lugar
    Então válido tal coisa  
    