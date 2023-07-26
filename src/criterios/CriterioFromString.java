package src.criterios;
import static src.Option.*;

public class CriterioFromString {
    public static CriterioOrdenacao stringToCriterio(String criterio) throws RuntimeException{
        if (criterio.equals(CRIT_PRECO_CRESC)){
            return new CriterioPrecoCrescente();
        }
        if (criterio.equals(CRIT_DESC_CRESC)){
            return new CriterioDescricaoCrescente();
        }
        if (criterio.equals(CRIT_ESTOQUE_CRESC)){
            return new CriterioEstoqueCrescente();
        }
        if (criterio.equals(CRIT_PRECO_DECRESC)){
            return new CriterioPrecoDecrescente();
        }
        if (criterio.equals(CRIT_DESC_DECRESC)){
            return new CriterioDescricaoDecrescente();
        }
        if (criterio.equals(CRIT_ESTOQUE_DECRESC)){
            return new CriterioEstoqueDecrescente();
        }
        else {
            throw new RuntimeException("Criterio Inválido");
        }
    }
}
