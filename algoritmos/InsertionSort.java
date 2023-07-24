package algoritmos;

import criterios.CriterioOrdenacao;
import src.Produto;

public class InsertionSort implements Algoritmo{
    private Produto[] produtos;
    private CriterioOrdenacao criterio;

    public InsertionSort(Produto[] produtos, CriterioOrdenacao criterio) {
        this.produtos = produtos;
        this.criterio = criterio;
        ordena(0, produtos.length - 1);
    }
    @Override
    public void ordena(int ini, int fim) {
        for(int i = ini; i <= fim; i++){

            Produto x = produtos[i];
            int j = (i - 1);

            while(j >= ini && criterio.comparar(x, produtos[j]) > 0){

                produtos[j + 1] = produtos[j];
                j--;


//					if(criterio.equals(CRIT_DESC_CRESC)){
//
//						if( x.getDescricao().compareToIgnoreCase(produtos[j].getDescricao()) < 0 ){
//							produtos[j + 1] = produtos[j];
//							j--;
//						}
//						else break;
//					}
//					else if(criterio.equals(CRIT_PRECO_CRESC)){
//
//						if(x.getPreco() < produtos[j].getPreco()){
//
//							produtos[j + 1] = produtos[j];
//							j--;
//						}
//						else break;
//					}
//					else if(criterio.equals(CRIT_ESTOQUE_CRESC)){
//
//						if(x.getQtdEstoque() < produtos[j].getQtdEstoque()){
//
//							produtos[j + 1] = produtos[j];
//							j--;
//						}
//						else break;
//					}
//					else throw new RuntimeException("Criterio invalido!");
            }

            produtos[j + 1] = x;
        }
    }
}
