# Integrantes do Grupo:

**Nome**: Marcelo de Menezes Nascimento N°Usp: 13727078

**Nome**: Gabriel Lacerda Domingues N°Usp: 13781987

**Nome**: Gustavo Felisberto de Oliveira N°Usp: 

# Como compilar e executar  o programa

Para compilar o programa basta inserir o comando "javac main.java" pelo terminal, estando dentro da pasta raiz do código.

Para executar, basta inserir o comando e os parâmetros "java Main.java [algoritmo] [critério de ordenação] [critério de filtragem]
 [parâmetro de filtragem] [caminho do arquivo CSV]".

Caso o filtro seja todos, não inserir o parâmetro de filtragem.

É necessário inserir os parâmetros da maneira correta, se não exceções serão lançadas.

algoritmo: 'quick' ou 'insertion'

criterio de ordenação: 'preco_c', 'descricao_c', 'estoque_c' ( "_c" para ordenações crescentes), preco_d', 'descricao_d' ou 'estoque_d' ( "_d" para ordenações decrescentes")

criterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'seleciona_intervalo' ou 'descricao_contem'


parâmetro de filtragem: argumentos adicionais necessários para a filtragem, caso use intervalo, separe por / (barra)


caminho do arquivo: caminho do arquivo CSV contendo os produtos a partir da pasta raiz do programa