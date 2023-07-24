package src;
import algoritmos.Algoritmo;
import algoritmos.InsertionSort;
import algoritmos.QuickSort;
import criterios.CriterioOrdenacao;

import java.util.ArrayList;
import java.util.List;

public class AlgoritmoFromString {

    public static Algoritmo stringToAlgoritmo(String Algoritmo, List<Produto> produtos, CriterioOrdenacao criterio) throws RuntimeException{
            if (Algoritmo.equals("quick")){
            return new QuickSort(produtos, criterio);
            }
            else if (Algoritmo.equals("insertion")){
            return new InsertionSort(produtos, criterio);
            } else {
            throw new RuntimeException("Criterio Inválido");
            }
        }

}
