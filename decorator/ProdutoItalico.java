package decorator;
public class ProdutoItalico extends ProdutoDecorator {

	public ProdutoItalico(Produto p) {
		super(p);
	}

	public String formataParaImpressao() {
		return "font-style: italic;\">" + super.formataParaImpressao();
	}
}
