package src.decorator;
public class ProdutoItaeNeg extends ProdutoDecorator{
	
	private String color;
	public ProdutoItaeNeg(Produto p, String color) {
		super(p);
		this.color = color;
	}
	
	@Override
	public String formataParaImpressao() {
		return "<span style=\"color: " + this.color + "; font-weight:bold; font-style: italic\">" +  super.formataParaImpressao() + "</span>";
	}
}
