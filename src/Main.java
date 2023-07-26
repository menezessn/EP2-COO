package src;

import src.algoritmos.Algoritmo;
import src.algoritmos.AlgoritmoFromString;
import src.criterios.CriterioFromString;
import src.criterios.CriterioOrdenacao;
import src.decorator.Produto;
import src.filtros.Filtro;
import src.filtros.FiltroFromString;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import static src.Option.*;


import static src.GeradorDeRelatorios.*;


public class Main {
    public static void main(String [] args) throws IOException {



        if(args.length < 4){

            System.out.println("Uso:");
            System.out.println("\tjava " + GeradorDeRelatorios.class.getName() + " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <opções de formatação>");
            System.out.println("Onde:");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println("\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c'");
            System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual'");
            System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem");
            System.out.println("\topções de formatação: 'negrito' e/ou 'italico'");
            System.out.println();
            System.exit(1);
        }

        //Algoritmo opcao_algoritmo = AlgoritmoFromString.stringToAlgoritmo(args[0]) ;
        List <Produto> produtos = LeitorCSV.csvReader();

        CriterioOrdenacao opcao_criterio_ord = CriterioFromString.stringToCriterio(args[1]);
        String opcao_parametro_filtro = args[3];
        Filtro opcao_criterio_filtro = FiltroFromString.StringToFiltro(args[2], opcao_parametro_filtro);
        Algoritmo opcao_algoritmo = AlgoritmoFromString.stringToAlgoritmo(args[0], produtos, opcao_criterio_ord ) ;


        String [] opcoes_formatacao = new String[2];
        opcoes_formatacao[0] = args.length > 4 ? args[4] : null;
        opcoes_formatacao[1] = args.length > 5 ? args[5] : null;
        int formato = FORMATO_PADRAO;

        for(int i = 0; i < opcoes_formatacao.length; i++) {

            String op = opcoes_formatacao[i];
            formato |= (op != null ? op.equals("negrito") ? FORMATO_NEGRITO : (op.equals("italico") ? FORMATO_ITALICO : 0) : 0);
        }



        GeradorDeRelatorios gdr = new GeradorDeRelatorios(
                opcao_algoritmo,
                opcao_criterio_ord,
                opcao_criterio_filtro,
                opcao_parametro_filtro,
                formato,
                produtos
        );

        try{
            gdr.geraRelatorio("saida.html");
        }
        catch(IOException e){

            e.printStackTrace();
        }
    }
}
