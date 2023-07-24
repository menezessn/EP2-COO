package decorator;

abstract public class ProdutoDecorator implements Produto {
    private Produto produto;
    public void setQtdEstoque(int qtdEstoque) {

    }

    @Override
    public void setPreco(double preco) {

    }

    @Override
    public int getId() {
        return 0;
    }

    @Override
    public String getDescricao() {
        return null;
    }

    @Override
    public String getCategoria() {
        return null;
    }

    @Override
    public int getQtdEstoque() {
        return 0;
    }

    @Override
    public double getPreco() {
        return 0;
    }
    public ProdutoDecorator(Produto produto) {
        this.produto = produto;

    }

    public String formataParaImpressao(){

        return produto.formataParaImpressao();

    }
}
