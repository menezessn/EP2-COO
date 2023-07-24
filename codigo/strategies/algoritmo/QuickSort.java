package strategies.algoritmo;
import java.util.ArrayList;

import decorator.Produto;
import strategies.criterio.Criterio;

public class QuickSort implements Algoritmo{

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

    private void ordenaRec(int ini, int fim) {
        if (ini < fim) {
            int q = particiona(ini, fim);

            ordenaRec(ini, q);
            ordenaRec(q + 1, fim);
        }
    }

    public void ordena(ArrayList<Produto> produtos, Criterio criterio) {
        this.produtos = produtos;
        this.criterio = criterio;

        ordenaRec(0, produtos.size()-1);
    }
}
