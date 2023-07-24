package strategy.criterio;
import decorator.Product;

public class DescriptionDescending implements Standards {
    public int compare(Product l, Product r) {
        return r.getDescricao().compareToIgnoreCase(l.getDescricao());
    }
}
