package strategy.criterio;
import decorator.Produto;

public class DescDecresc implements Criterio {
    public int compare(Produto l, Produto r) {
        return r.getDescricao().compareToIgnoreCase(l.getDescricao());
    }
}
