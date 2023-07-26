package src.filtros;

import src.decorator.Produto;

public class FiltroCategoriaIgualA implements Filtro{
    private String argFiltro;

    public FiltroCategoriaIgualA(String argFiltro) {
        this.argFiltro = argFiltro;
    }

    @Override
    public boolean seleciona(Produto p) {
        return p.getCategoria().equalsIgnoreCase(argFiltro);
    }
}
