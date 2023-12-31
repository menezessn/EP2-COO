package src.criterios;
import src.decorator.Produto;
public class CriterioDescricaoCrescente implements CriterioOrdenacao{
    @Override
    public int comparar(Produto p1, Produto p2) {
        return p1.getDescricao().compareToIgnoreCase(p2.getDescricao());
    }
}
