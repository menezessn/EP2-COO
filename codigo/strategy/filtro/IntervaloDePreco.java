package strategy.filtro;

import decorator.Produto;

public class IntervaloDePreco implements Filtro{
    
    private double min;
    private double max;

    public IntervaloDePreco(double minimo, double maximo){
        this.min = minimo;
        this.max = maximo;
    }

    public boolean equals(Produto produto){
        return (produto.getPreco() >= this.min & produto.getPreco() <= this.max);
    }

}
