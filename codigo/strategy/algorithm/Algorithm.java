package strategy.algorithm;

import java.util.ArrayList;

import decorator.Product;
import strategy.criterio.Standards;

//interface para os algoritmos de ordenação
public interface Algorithm {
    public void order(ArrayList<Product> products, Standards standards);
}

