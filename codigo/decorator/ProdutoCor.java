package decorator;

public class ProdutoCor extends ProdutoDecorator{


    private String color;

    public ProdutoCor(Produto Produto, String color) {

        super(Produto);
        this.color = color;

    }

    public String formataParaImpressao() {

        return "<span style=\"color: " + this.color + "\">" + super.formataParaImpressao() + "</span>";
    }

}
