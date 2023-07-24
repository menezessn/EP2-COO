package strategy.algorithm;
import java.util.ArrayList;

import decorator.Produto;
import strategy.criterio.Criterio;

public class QuickSort implements Algorithm {

    ArrayList<Produto> produtos;
    Criterio criterio;

    private int particiona(int ini, int fim) {
        Produto x = produtos.get(ini);
        int i = ini - 1;
        int j = fim + 1;

        while(true) {
            do {
                j--;
            } while(criterio.compare(produtos.get(j), x) > 0);
            do {
                i++;
            } while(criterio.compare(produtos.get(i), x) < 0);
			if(i < j){
				Produto temp = produtos.get(i);
				produtos.set(i, produtos.get(j));
				produtos.set(j, temp);
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

    public void order(ArrayList<Produto> produtos, Criterio criterio) {
        this.produtos = produtos;
        this.criterio = criterio;

        orderQuick(0, produtos.size()-1);
    }
}
