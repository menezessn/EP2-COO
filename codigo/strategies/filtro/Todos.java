package strategies.filtro;

import decorator.Produto;

public class Todos implements Filtro {

    public boolean equals(Produto produto){
        return true;
    }
}