package algoritmos;

import criterios.CriterioOrdenacao;
import src.Produto;

public class QuickSort implements Algoritmo{

    private Produto[] produtos;
    private CriterioOrdenacao criterio;

    public QuickSort(Produto[] produtos, CriterioOrdenacao criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
        ordena(0, produtos.length - 1);
    }

    //Adcionei o padrão strategy em particiona
    private int particiona(int ini, int fim){

        Produto x = produtos[ini];
        int i = (ini - 1);
        int j = (fim + 1);

        while(true){

            do {
                j--;
            } while (criterio.comparar(produtos[j], x) > 0);

            do {
                i++;
            } while (criterio.comparar(produtos[i], x) < 0);

//			if(criterio.equals(CRIT_DESC_CRESC)){
//
//				do{
//					j--;
//
//				} while(produtos[j].getDescricao().compareToIgnoreCase(x.getDescricao()) > 0);
//
//				do{
//					i++;
//
//				} while(produtos[i].getDescricao().compareToIgnoreCase(x.getDescricao()) < 0);
//			}
//			else if(criterio.equals(CRIT_PRECO_CRESC)){
//
//				do{
//					j--;
//
//				} while(produtos[j].getPreco() > x.getPreco());
//
//				do{
//					i++;
//
//				} while(produtos[i].getPreco() < x.getPreco());
//			}
//
//			else if(criterio.equals(CRIT_ESTOQUE_CRESC)){
//
//				do{
//					j--;
//
//				} while(produtos[j].getQtdEstoque() > x.getQtdEstoque());
//
//				do{
//					i++;
//
//				} while(produtos[i].getQtdEstoque() < x.getQtdEstoque());
//
//			}
//			else{
//
//				throw new RuntimeException("Criterio invalido!");
//			}

            if(i < j){
                Produto temp = produtos[i];
                produtos[i] = produtos[j];
                produtos[j] = temp;
            }
            else return j;
        }
    }
    @Override
    public void ordena(int ini, int fim) {
        if(ini < fim) {

            int q = particiona(ini, fim);

            ordena(ini, q);
            ordena(q + 1, fim);
        }
    }
}
