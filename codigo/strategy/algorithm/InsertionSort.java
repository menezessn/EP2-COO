package strategy.algorithm;

import java.util.ArrayList;
import decorator.Product;
import strategy.criterio.Standards;


public class InsertionSort implements Algorithm {

    //implementa a ordenação com o insertionSort
    public void order(ArrayList<Product> products, Standards standards) {
        for (int i = 1; i < products.size(); i++) {

            Product x = products.get(i);
            int j = (i - 1);

            while (j >= 0 && standards.compare(x, products.get(j)) > 0) {

                products.set(j + 1, products.get(j));
                j--;
            }
            products.set(j + 1, x);
        }
    }
}
