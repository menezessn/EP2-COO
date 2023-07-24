package algoritmos;
import decorator.Produto;
import criterios.CriterioOrdenacao;

import java.util.List;

public class InsertionSort implements Algoritmo{
    private List<Produto> produtos;
    private CriterioOrdenacao criterio;

    public InsertionSort(List<Produto> produtos, CriterioOrdenacao criterio) {
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

                //produtos[j + 1] = produtos[j];
                produtos.set(j+1, produtos.get(j));
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

            //produtos[j + 1] = x;
            produtos.set(j+1, x);
        }
    }
}
