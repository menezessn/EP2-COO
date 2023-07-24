package strategy.filtro;

import decorator.Product;

public class DescricaoContem implements Filtro {

    private String argFiltro;

    public DescricaoContem(String argFiltro){
        this.argFiltro = argFiltro;
    }

    public boolean equals(Product product){
        return product.getDescricao().contains(this.argFiltro);
        
    }    
}
