package strategies.filtro;

import decorator.Produto;

public interface Filtro { 
    public boolean equals(Produto produto);
}