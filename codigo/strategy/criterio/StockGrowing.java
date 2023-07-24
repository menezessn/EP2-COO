package strategy.criterio;
import decorator.Product;

public class StockGrowing implements Standards {
    public int compare(Product l, Product r) {
        return l.getQtdEstoque() < r.getQtdEstoque() ? 1 : 0;
    }
}
