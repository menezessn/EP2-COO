package decorator;

public class ProdutoNegrito extends ProdutoDecorator {

    public ProdutoNegrito(Produto Produto) {

        super(Produto);
    }

    @Override


    public String formataParaImpressao(){

        return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;

    }

}



