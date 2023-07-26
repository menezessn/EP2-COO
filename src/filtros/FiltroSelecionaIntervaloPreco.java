package src.filtros;

import src.decorator.Produto;

public class FiltroSelecionaIntervaloPreco implements Filtro{

    private String argFiltro;

    public FiltroSelecionaIntervaloPreco(String argFiltro) {
        this.argFiltro = argFiltro;
    }

    @Override
    public boolean seleciona(Produto p) {
        String[] intervalo = argFiltro.split("/");
        double precoMinimo = Double.parseDouble(intervalo[0]);
        double precoMaximo = Double.parseDouble(intervalo[1]);
        return (p.getPreco()>=precoMinimo && p.getPreco()<=precoMaximo);
    }
}
