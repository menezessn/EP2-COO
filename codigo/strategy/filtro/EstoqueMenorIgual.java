package strategy.filtro;

import decorator.Produto;

public class EstoqueMenorIgual implements Filtro {

    private String argFiltro;

    public EstoqueMenorIgual(String argFiltro){
        this.argFiltro = argFiltro;
    }

    public boolean equals(Produto produto){
        return produto.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}
