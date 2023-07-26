package src.algoritmos;
import src.decorator.Produto;
import src.criterios.CriterioOrdenacao;

import java.util.List;

//Esta classe contém a ordenação utilizando InsertionSort
public class AlgoritmoInsertionSort implements Algoritmo{
    private List<Produto> produtos;
    private CriterioOrdenacao criterio;

    public AlgoritmoInsertionSort(List<Produto> produtos, CriterioOrdenacao criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
        ordena(0, produtos.size() - 1 );
    }
    @Override
    public void ordena(int ini, int fim) {
        for(int i = ini; i <= fim; i++){

            Produto x = produtos.get(i);
            int j = (i - 1);

            while(j >= ini && criterio.comparar(x, produtos.get(j)) > 0){
                produtos.set(j+1, produtos.get(j));
                j--;
            }

            produtos.set(j+1, x);

        }
    }
}
