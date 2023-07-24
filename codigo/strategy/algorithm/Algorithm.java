package strategy.algorithm;

import java.util.ArrayList;

import decorator.Produto;
import strategy.criterio.Criterio;

//interface para os algoritmos de ordenação
public interface Algorithm {
    public void order(ArrayList<Produto> produtos, Criterio criterio);
}

