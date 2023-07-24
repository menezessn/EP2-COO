
public class ProdutoNegrito extends ProdutoDecorator {

	public ProdutoNegrito(Produto p) {
		super(p);
	}
	
	@Override
	public String formataParaImpressao() {
		return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;
	}
	
}
