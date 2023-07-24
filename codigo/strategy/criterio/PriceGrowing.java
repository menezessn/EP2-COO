package strategy.criterio;
import decorator.Product;

public class PriceGrowing implements Standards {
    public int compare (Product l, Product r) {
        return l.getPreco() > r.getPreco() ? 1 : 0;
    }
    
}
