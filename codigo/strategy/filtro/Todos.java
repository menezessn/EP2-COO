package strategy.filtro;

import decorator.Product;

public class Todos implements Filtro {

    public boolean equals(Product product){
        return true;
    }
}