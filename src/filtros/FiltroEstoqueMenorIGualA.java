package src.filtros;

import src.decorator.Produto;

public class FiltroEstoqueMenorIGualA implements Filtro {
    private String argFiltro;

    public FiltroEstoqueMenorIGualA(String argFiltro) {
        this.argFiltro = argFiltro;
    }

    @Override
    public boolean seleciona(Produto p) {
        return p.getQtdEstoque() <= Integer.parseInt(argFiltro);
    }
}
