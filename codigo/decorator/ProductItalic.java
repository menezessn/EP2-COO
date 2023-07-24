package decorator;

public class ProductItalic extends ProductDecorator {

        public ProductItalic(Product Product) {
            super(Product);
        }


    public String formataParaImpressao(){

        return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;

    }

}

