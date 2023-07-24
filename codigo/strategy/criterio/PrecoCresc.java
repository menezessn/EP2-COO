package strategy.criterio;
import decorator.Produto;

public class PrecoCresc implements Criterio{
    public int compare (Produto l, Produto r) {
        return l.getPreco() > r.getPreco() ? 1 : 0;
    }
    
}
