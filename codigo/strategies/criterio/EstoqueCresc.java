package strategies.criterio;
import decorator.Produto;

public class EstoqueCresc implements Criterio {
    public int compare(Produto l, Produto r) {
        return l.getQtdEstoque() < r.getQtdEstoque() ? 1 : 0;
    }
}
