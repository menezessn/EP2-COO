package src.filtros;

import src.decorator.Produto;

public class FiltroDescricaoContemSubstring implements Filtro {

    private String argFiltro;

    public FiltroDescricaoContemSubstring(String argFiltro) {
        this.argFiltro = argFiltro;
    }

    @Override
    public boolean seleciona(Produto p) {
        return p.getDescricao().toUpperCase().contains(argFiltro.toUpperCase());
    }
}
