package strategy.filtro;

import decorator.Product;

public class CategoriaIgual implements Filtro{

    private String argFiltro;

    public CategoriaIgual(String argFiltro){
        this.argFiltro = argFiltro;
    }
    
    public boolean equals(Product product){
        return product.getCategoria().equalsIgnoreCase(this.argFiltro);
    }
}

