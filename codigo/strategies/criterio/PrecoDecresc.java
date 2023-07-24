package strategies.criterio;
import decorator.Produto;

public class PrecoDecresc implements Criterio{
    public int compare (Produto l, Produto r) {
        return r.getPreco() > l.getPreco() ? 1 : 0;
    }
    
}
