#language: pt

@movimentacao
Funcionalidade: Cadastro de movimentações
  Como um usuário 
  Gostaria de cadastrar movimentações de conta
  Para que eu possa controlar as minhas contas
  
  Contexto:
  	Dado que estou acessando a aplicação
    Quando informo o usuário "z@z.com"
    E a senha "12345"
    E seleciono entrar
    Então visualizo a página inicial
    Quando seleciono Criar Movimentação
    
  Esquema do Cenário: Deve validar ao criar movimentação
    E informo o tipo de movimentação "<tipoMovimentação>"
    E informo a data de movimentação "<dataMovimentação>" 
    E informo a data de pagamento "<dataPagamento>" 
    E informo a descrição "<descrição>" 
    E informo o interessado "<interessado>" 
    E informo o valor <valor> 
    E informo a conta de movimentação "<conta>" 
   	E seleciono a "<situação>"
    E clico em Salvar
    Então recebo a mensagem de movimentação "<mensagem>"

Exemplos:
  | tipoMovimentação  |  dataMovimentação |  dataPagamento  |   descrição     |  interessado  |  valor   |        conta              | situação  | mensagem                               |                       
  | Receita           |  25/08/2021       | 25/01/2023      | Importante      |  João         |  100.00  |  Conta para movimentacoes | Pendente  | Movimentação adicionada com sucesso!   |
  
