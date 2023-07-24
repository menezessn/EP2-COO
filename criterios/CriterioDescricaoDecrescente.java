package criterios;
import decorator.Produto;

public class CriterioDescricaoDecrescente implements CriterioOrdenacao{
    @Override
    public int comparar(Produto p1, Produto p2) {
        return p2.getDescricao().compareToIgnoreCase(p1.getDescricao());
    }
}
