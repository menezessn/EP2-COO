
public class ProdutoItalico extends ProdutoDecorator {

	public ProdutoItalico(Produto p) {
		super(p);
	}

	public String formataParaImpressao() {
		return "<span style=\"font-weight:bold\">" + super.formataParaImpressao() + "</span>" ;
	}
}
