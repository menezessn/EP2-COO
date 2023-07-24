package strategy.criterio;

import decorator.Product;

public interface Standards {
    public int compare(Product l, Product r);
}
