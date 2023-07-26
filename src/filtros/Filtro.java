package src.filtros;

import src.decorator.Produto;

//Essa é a interface que será responsável pelos parametros de cada filtro, as classes
// deverão implementar seleciona para verificar se tal produto será ou não adicionado no arquivo
public interface Filtro {
    public boolean seleciona(Produto p);
}
