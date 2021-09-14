# language: pt

@unit
Funcionalidade: Saldo

#Cenário: Deve sacar sem ter dinheiro na conta bancária
#	Dado que eu quero sacar 100
#	Quando o valor da minha conta for menor que 90
#	Então a mensagem de erro "Saldo insuficiente" deve ser exibida
	
	
#Cenário: Deve entregar dois dias depois
#	Dado que a data da entrega é dia 05/04/2021
#	Quando passar 2 dias
#	Então a data da entrega será dia 07/04/2021 
	
Cenário: Deve criar steps genéricos para estes passos
    Dado que o ticket é 'AF345'
    Dado que o valor da passagem é R$ 230,45
    Dado que o nome do passageiro é "Fulano da Silva"
    Dado que o telefone do passageiro é 9999-9999

Cenário: Deve reaproveitar os steps "Dado" do cenário anterior
    Dado que o ticket é 'AB167'
    Dado que o ticket especial é 'AB167'
    Dado que o valor da passagem é R$ 1120,23
    Dado que o nome do passageiro é "Cicrano de Oliveira"
    Dado que o telefone do passageiro é 9888-8888