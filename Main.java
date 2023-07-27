

import src.GeradorDeRelatorios;
import src.LeitorCSV;
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
        List <Produto> produtos = null;
        CriterioOrdenacao opcao_criterio_ord = null ;
        String opcao_parametro_filtro =null;
        Filtro opcao_criterio_filtro = null;
        Algoritmo opcao_algoritmo = null;


        if(args.length > 3 && args[2].equals("todos")) {
            produtos = LeitorCSV.csvReader(args[3]);
            opcao_criterio_ord = CriterioFromString.stringToCriterio(args[1]);
            opcao_parametro_filtro = args[2];
            opcao_criterio_filtro = FiltroFromString.StringToFiltro(args[2], "2");
            opcao_algoritmo = AlgoritmoFromString.stringToAlgoritmo(args[0], produtos, opcao_criterio_ord);
        } else if(args.length < 5 ){

            System.out.println("Uso:");
            System.out.println("\tjava Main.java <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <caminho do arquivo CSV>");
            System.out.println("Onde:");
            System.out.println("\talgoritmo: 'quick' ou 'insertion'");
            System.out.println("\tcriterio de ordenação: 'preco_c', 'descricao_c', 'estoque_c', preco_d', 'descricao_d' ou 'estoque_d' ");
            System.out.println("\tcriterio de filtragem: 'todos' ou 'estoque_menor_igual' ou 'categoria_igual' ou 'seleciona_intervalo' ou 'descricao_contem' ");
            System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem, caso use intervalo, separe por / (barra) ");
            System.out.println("\tcaminho do arquivo: caminho do arquivo CSV contendo os produtos a partir da pasta raiz do programa");
            System.out.println();
            System.exit(1);
        }


        else {
            produtos = LeitorCSV.csvReader(args[4]);
            opcao_criterio_ord = CriterioFromString.stringToCriterio(args[1]);
            opcao_parametro_filtro = args[3];
            opcao_criterio_filtro = FiltroFromString.StringToFiltro(args[2], opcao_parametro_filtro);
            opcao_algoritmo = AlgoritmoFromString.stringToAlgoritmo(args[0], produtos, opcao_criterio_ord ) ;
        }

        GeradorDeRelatorios gdr = new GeradorDeRelatorios(
                opcao_algoritmo,
                opcao_criterio_ord,
                opcao_criterio_filtro,
                opcao_parametro_filtro,
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
