package criterios;
import decorator.Produto;

public class CriterioEstoqueDecrescente implements CriterioOrdenacao{
    @Override
    public int comparar(Produto p1, Produto p2) {
        return Integer.compare(p2.getQtdEstoque(), p1.getQtdEstoque());
    }
}
