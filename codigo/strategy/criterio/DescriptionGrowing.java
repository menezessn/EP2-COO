package strategy.criterio;

import decorator.Product;

public class DescriptionGrowing implements Standards {
    public int compare(Product l, Product r) {
        return l.getDescricao().compareToIgnoreCase(r.getDescricao());
    }
}
