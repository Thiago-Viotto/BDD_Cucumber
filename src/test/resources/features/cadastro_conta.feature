#language: pt

@functional
Funcionalidade: Cadastro de contas
  Como um usuário 
  Gostaria de cadastrar contas
  Para que eu possa distribuir meu dinheiro de uma forma mais organizada
  
  Contexto:
  	Dado que estou acessando a aplicação
    Quando informo o usuário "z@z.com"
    E a senha "12345"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Contas
    E seleciono Adicionar
    
  #Esquema do Cenário: Deve validar erros ao criar conta
    #E informo a conta "<conta>"
    #E seleciono Salvar
    #Então recebo a mensagem "<mensagem>"
#
#Exemplos:
  #| conta            | mensagem                           |
  #| Conta de Teste   | Conta adicionada com sucesso!      |
  #|                  | Informe o nome da conta            |
  #| Conta mesmo nome | Já existe uma conta com esse nome! |
    
  Esquema do Cenário: Deve validar ao editar conta
    E informo a conta "<conta>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem1>"
  	Quando clico no ícone de editar
    E informo a conta "<contaEditada>"
    E seleciono Salvar
    Então recebo a mensagem "<mensagem2>"

Exemplos:
  | conta               |          contaEditada              |               mensagem1            |         mensagem2                   |                 
  | Conta de Teste edit | Conta de Teste edited              | Conta adicionada com sucesso!      | Conta alterada com sucesso!         |
  | conta 3 edit        |                                    | Conta adicionada com sucesso!      | Informe o nome da conta             |   
  | Conta edit nome     | Conta mesmo nome                   |  Conta adicionada com sucesso!     |  Já existe uma conta com esse nome! |