package src.criterios;
import src.decorator.Produto;

public class CriterioPrecoDecrescente implements CriterioOrdenacao{
    @Override
    public int comparar(Produto p1, Produto p2) {
        return Double.compare(p2.getPreco(), p1.getPreco());
    }
}
