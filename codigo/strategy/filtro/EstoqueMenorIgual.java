package strategy.filtro;

import decorator.Product;

public class EstoqueMenorIgual implements Filtro {

    private String argFiltro;

    public EstoqueMenorIgual(String argFiltro){
        this.argFiltro = argFiltro;
    }

    public boolean equals(Product product){
        return product.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}
