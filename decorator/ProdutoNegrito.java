package decorator;
public class ProdutoNegrito extends ProdutoDecorator {

	public ProdutoNegrito(Produto p) {
		super(p);
	}
	
	@Override
	public String formataParaImpressao() {
		return "font-weight: bold;\">" + super.formataParaImpressao();
	}
	
}
