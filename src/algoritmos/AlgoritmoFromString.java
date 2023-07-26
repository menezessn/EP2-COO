package src.algoritmos;

import static src.Option.*;

import src.Option;
import src.criterios.CriterioOrdenacao;
import src.decorator.Produto;
import java.util.List;

//Essa classe é responsável por fazer a leitura de uma string e transformá-la em um algoritmo específico
public class AlgoritmoFromString {

    public static Algoritmo stringToAlgoritmo(String Algoritmo, List<Produto> produtos, CriterioOrdenacao criterio) throws RuntimeException{
            if (Algoritmo.equals(ALG_QUICKSORT)){
            return new AlgoritmoQuickSort(produtos, criterio);
            }
            else if (Algoritmo.equals(ALG_INSERTIONSORT)){
            return new AlgoritmoInsertionSort(produtos, criterio);
            } else {
            throw new RuntimeException("Criterio Inválido");
            }
        }

}
