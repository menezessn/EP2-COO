public class CriterioString {
    public static CriterioOrdenacao stringToCriterio(String criterio) throws RuntimeException{
        if (criterio.equals("preco_c")){
            return new CriterioPreco();
        }
        if (criterio.equals("descricao_c")){
            return new CriterioDescricao();
        }
        if (criterio.equals("estoque_c")){
            return new CriterioEstoque();
        } else {
            throw new RuntimeException("Criterio Inválido");
        }
    }
}
