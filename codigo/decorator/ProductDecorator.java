package decorator;

abstract public class ProductDecorator implements Product {
    private Product product;
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
    public ProductDecorator(Product product) {
        this.product = product;

    }

    public String formataParaImpressao(){

        return product.formataParaImpressao();

    }
}
