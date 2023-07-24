package strategy.criterio;
import decorator.Product;

public class StockDescending implements Standards {
    public int compare(Product l, Product r) {
        return r.getQtdEstoque() < l.getQtdEstoque() ? 1 : 0;
    }
}
