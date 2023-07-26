package src.decorator;
public class ProdutoItaeNeg extends ProdutoDecorator{

	public ProdutoItaeNeg(Produto p) {
		super(p);
	}
	
	@Override
	public String formataParaImpressao() {
		return "font-weight:bold; font-style: italic\">" +  super.formataParaImpressao();
	}
}
