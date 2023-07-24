package strategies.algoritmo;

import java.util.ArrayList;

import decorator.Produto;
import strategies.criterio.Criterio;

public interface Algoritmo{
    public void ordena(ArrayList<Produto> produtos, Criterio criterio);
}

