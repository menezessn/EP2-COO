package strategies.filtro;

import decorator.Produto;

public class CategoriaIgual implements Filtro{

    private String argFiltro;

    public CategoriaIgual(String argFiltro){
        this.argFiltro = argFiltro;
    }
    
    public boolean equals(Produto produto){
        return produto.getCategoria().equalsIgnoreCase(this.argFiltro);
    }
}

