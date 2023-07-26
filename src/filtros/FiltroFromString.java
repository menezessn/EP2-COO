package src.filtros;

import static src.Option.*;
public class FiltroFromString{

    public static Filtro StringToFiltro (String filtro, String argFiltro) throws RuntimeException{
        if (filtro.equals(FILTRO_TODOS)){
            return new FIltroTodos();
        } else if (filtro.equals(FILTRO_CATEGORIA_IGUAL_A)) {
            return new FiltroCategoriaIgualA(argFiltro);
        } else if (filtro.equals(FILTRO_ESTOQUE_MENOR_OU_IQUAL_A)) {
            return new FiltroEstoqueMenorIGualA(argFiltro);
        } else if (filtro.equals(FILTRO_SELECIONA_INTERVALO_PRECO)) {
            return new FiltroSelecionaIntervaloPreco(argFiltro);
        } else if (filtro.equals(FILTRO_DESCRICAO_CONTEM_SUBSTRING)) {
            return new FiltroDescricaoContemSubstring(argFiltro);
        } else{
            throw new RuntimeException("Filtro Inválido");
        }
    }
}
