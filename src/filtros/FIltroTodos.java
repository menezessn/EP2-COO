package src.filtros;

import src.decorator.Produto;

public class FIltroTodos implements Filtro{
    @Override
    public boolean seleciona(Produto p) {
        return true;
    }
}
