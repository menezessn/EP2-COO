package strategies.algoritmo;

import java.util.ArrayList;
import decorator.Produto;
import strategies.criterio.Criterio;

public class InsertionSort implements Algoritmo {

    public void ordena(ArrayList<Produto> produtos, Criterio criterio) {
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
