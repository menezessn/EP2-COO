package criterios;
import decorator.Produto;

public class CriterioEstoqueCrescente implements CriterioOrdenacao{
    @Override
    public int comparar(Produto p1, Produto p2) {
        return Integer.compare(p1.getQtdEstoque(), p2.getQtdEstoque());
    }
}
