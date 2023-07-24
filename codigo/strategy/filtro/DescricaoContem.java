package strategy.filtro;

import decorator.Produto;

public class DescricaoContem implements Filtro {

    private String argFiltro;

    public DescricaoContem(String argFiltro){
        this.argFiltro = argFiltro;
    }

    public boolean equals(Produto produto){
        return produto.getDescricao().contains(this.argFiltro);
        
    }    
}
