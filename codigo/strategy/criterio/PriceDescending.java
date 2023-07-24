package strategy.criterio;
import decorator.Product;

public class PriceDescending implements Standards {
    public int compare (Product l, Product r) {
        return r.getPreco() > l.getPreco() ? 1 : 0;
    }
    
}
