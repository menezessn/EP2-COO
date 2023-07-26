package src;

public class Option {

    public static final String ALG_INSERTIONSORT = "insertion";
    public static final String ALG_QUICKSORT = "quick";

    public static final String CRIT_DESC_CRESC = "descricao_c";
    public static final String CRIT_PRECO_CRESC = "preco_c";
    public static final String CRIT_ESTOQUE_CRESC = "estoque_c";
    public static final String CRIT_DESC_DECRESC = "descricao_d";
    public static final String CRIT_PRECO_DECRESC = "preco_d";
    public static final String CRIT_ESTOQUE_DECRESC = "estoque_d";

    public static final String FILTRO_TODOS = "todos";
    public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = "estoque_menor_igual";
    public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";
    public static final String FILTRO_SELECIONA_INTERVALO_PRECO = "seleciona_intervalo";
    public static final String FILTRO_DESCRICAO_CONTEM_SUBSTRING= "descricao_contem";

    // operador bit a bit "ou" pode ser usado para combinar mais de
    // um estilo de formatacao simultaneamente (veja como no main)
    public static final int FORMATO_PADRAO  = 0b0000;
    public static final int FORMATO_NEGRITO = 0b0001;
    public static final int FORMATO_ITALICO = 0b0010;
}
