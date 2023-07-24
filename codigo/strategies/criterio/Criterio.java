package strategies.criterio;

import decorator.Produto;

public interface Criterio{
    public int compare(Produto l, Produto r);
}
