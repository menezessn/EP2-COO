
public class ProdutoItalico extends ProdutoDecorator {

	public ProdutoItalico(Produto p) {
		super(p);
	}

	@Override
	public String formataParaImpressao() {
		return "<span style=\"font-weight:italic\">" + super.formataParaImpressao() + "</span>" ;
	}
}
