package strategy.algorithm;
import java.util.ArrayList;

import decorator.Product;
import strategy.criterio.Standards;

public class QuickSort implements Algorithm {

    ArrayList<Product> products;
    Standards standards;

    private int particiona(int ini, int fim) {
        Product x = products.get(ini);
        int i = ini - 1;
        int j = fim + 1;

        while(true) {
            do {
                j--;
            } while(standards.compare(products.get(j), x) > 0);
            do {
                i++;
            } while(standards.compare(products.get(i), x) < 0);
			if(i < j){
				Product temp = products.get(i);
				products.set(i, products.get(j));
				products.set(j, temp);
			}
			else return j;
        }

    }

    private void orderQuick(int ini, int fim) {
        if (ini < fim) {
            int q = particiona(ini, fim);

            orderQuick(ini, q);
            orderQuick(q + 1, fim);
        }
    }

    public void order(ArrayList<Product> products, Standards standards) {
        this.products = products;
        this.standards = standards;

        orderQuick(0, products.size()-1);
    }
}
