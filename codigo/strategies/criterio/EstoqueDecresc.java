package strategies.criterio;
import decorator.Produto;

public class EstoqueDecresc implements Criterio {
    public int compare(Produto l, Produto r) {
        return r.getQtdEstoque() < l.getQtdEstoque() ? 1 : 0;
    }
}
