# language: pt

@unit
Funcionalidade: Alugar filme
	Como um usuário
	Eu quero cadastrar aluguéis de filmes
	Para controlar a data e o preço da entrega
	
Cenário: Deve alugar filme com sucesso
	Dado um filme 
	| estoque |   2   |
	| preço   |   3   |
	| tipo    | comum |
	E que o preço do aluguel seja R$ 3
	Quando alugar
	Então o preço do aluguel será R$ 3
	E a data de entrega será em 1 dia
	E o estoque do filme será 1 unidade
	
	
Cenário: Não deve alugar filme sem estoque
	Dado um filme com estoque de 0 unidades
	Quando alugar
	Então não será possível por falta de estoque
	E o estoque do filme será 0 unidade
	
# Scenario Outline
Esquema do Cenário: Deve dar condições especiais dependendo do tipo da categoria
	Dado um filme com estoque de 2 unidades
	E que o preço do aluguel seja R$ <preço>
	E que o tipo do aluguel seja <tipo>
	Quando alugar
	Então o preço do aluguel será R$ <valor>
	E a data de entrega será em <qtdDias> dias
	E a pontuação recebida será de <pontuação> pontos
	
	# examples
	Exemplos:
	| preço | tipo        | valor | qtdDias | pontuação |
	|  4    | "EXTENDIDO" |   8   |    3    |    2      |
	|  4    | "COMUM"     |   4   |    1    |    1      |
	|  4    | "SEMANAL"   |  12   |    7    |    3      |


	
	