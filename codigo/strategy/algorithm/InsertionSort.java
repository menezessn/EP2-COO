package strategy.algorithm;

import java.util.ArrayList;
import decorator.Produto;
import strategy.criterio.Criterio;


public class InsertionSort implements Algorithm {

    //implementa a ordenação com o insertionSort
    public void order(ArrayList<Produto> produtos, Criterio criterio) {
        for (int i = 1; i < produtos.size(); i++) {

            Produto x = produtos.get(i);
            int j = (i - 1);

            while (j >= 0 && criterio.compare(x, produtos.get(j)) > 0) {

                produtos.set(j + 1, produtos.get(j));
                j--;
            }
            produtos.set(j + 1, x);
        }
    }
}
