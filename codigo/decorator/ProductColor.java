package decorator;

public class ProductColor extends ProductDecorator {


    private String color;

    public ProductColor(Product Product, String color) {

        super(Product);
        this.color = color;

    }

    public String formataParaImpressao() {

        return "<span style=\"color: " + this.color + "\">" + super.formataParaImpressao() + "</span>";
    }

}
