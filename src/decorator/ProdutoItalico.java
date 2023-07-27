package src.decorator;
public class ProdutoItalico extends ProdutoDecorator {
	
	private String color;
	public ProdutoItalico(Produto p, String color) {
		super(p);
		this.color = color;
	}

	public String formataParaImpressao() {
		return "<span style=\"color: " + this.color + "; font-style: italic\">" + super.formataParaImpressao() + "</span>";
	}
}
