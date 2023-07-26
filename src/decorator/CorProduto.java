package src.decorator;

public class CorProduto extends ProdutoDecorator {
	
	private String color;
	
	public CorProduto(Produto p, String color) {
		super(p);
		this.color = color;
	}
	
	@Override
	public String formataParaImpressao() {

        return "<span style=\"color: " + this.color + "; " + super.formataParaImpressao() + "</span>";
    }
}
