package strategy.criterio;

import decorator.Produto;

public class DescCresc implements Criterio {
    public int compare(Produto l, Produto r) {
        return l.getDescricao().compareToIgnoreCase(r.getDescricao());
    }
}
