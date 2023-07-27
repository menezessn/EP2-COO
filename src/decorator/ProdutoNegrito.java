package src.decorator;
public class ProdutoNegrito extends ProdutoDecorator {
	
	private String color;
	public ProdutoNegrito(Produto p, String color) {
		super(p);
		this.color = color;
	}
	
	@Override
	public String formataParaImpressao() {
		return "<span style=\"color: " + this.color + "; font-weight: bold\">" + super.formataParaImpressao() + "</span>";
	}
	
}
