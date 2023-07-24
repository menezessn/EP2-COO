package decorator;

public class ProdutoItalico extends ProdutoDecorator {

        public ProdutoItalico(Produto Produto) {
            super(Produto);
        }


    public String formataParaImpressao(){

        return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;

    }

}

