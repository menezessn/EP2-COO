package decorator;

public class ProductBold extends ProductDecorator {

    public ProductBold(Product Product) {

        super(Product);
    }

    @Override


    public String formataParaImpressao(){

        return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;

    }

}



