package strategy.filtro;

import decorator.Product;

public class IntervaloDePreco implements Filtro{
    
    private double min;
    private double max;

    public IntervaloDePreco(double minimo, double maximo){
        this.min = minimo;
        this.max = maximo;
    }

    public boolean equals(Product product){
        return (product.getPreco() >= this.min & product.getPreco() <= this.max);
    }

}
