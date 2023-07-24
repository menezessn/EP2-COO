package criterios;
import decorator.Produto;
public class CriterioFromString {
    public static CriterioOrdenacao stringToCriterio(String criterio) throws RuntimeException{
        if (criterio.equals("preco_c")){
            return new CriterioPrecoCrescente();
        }
        if (criterio.equals("descricao_c")){
            return new CriterioDescricaoCrescente();
        }
        if (criterio.equals("estoque_c")){
            return new CriterioEstoqueCrescente();
        } else {
            throw new RuntimeException("Criterio Inválido");
        }
    }
}
