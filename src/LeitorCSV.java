package src;
import src.decorator.ProdutoItaeNeg;
import src.decorator.ProdutoItalico;
import src.decorator.ProdutoNegrito;
import src.decorator.CorProduto;
import src.decorator.Produto;
import src.decorator.ProdutoPadrao;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class LeitorCSV {
    public static List<Produto> csvReader(String caminho)  {

        List<Produto> produtos = new ArrayList<>();
        String arquivoCSV = caminho;



        try (BufferedReader br = new BufferedReader(new FileReader(arquivoCSV))) {
            String linha;
            boolean primeiraLinha = true; // Para ignorar o cabeçalho do CSV

            while ((linha = br.readLine()) != null) {
                if (primeiraLinha) {
                    primeiraLinha = false;
                    continue; // Ignorar o cabeçalho
                }

                String[] campos = linha.split(","); // Divide a linha pelos caracteres de vírgula
                for(int i = 0; i < campos.length; i++) {
                    campos[i] = campos[i].trim(); // Remove espaços em branco
                }
                Integer id = Integer.parseInt(campos[0]);
                String descricao = campos[1];
                String categoria = campos[2];
                int qtdEstoque = Integer.parseInt(campos[3]);
                double preco = Double.parseDouble(campos[4]);
                Boolean negrito = Boolean.parseBoolean(campos[5]);
				Boolean italico = Boolean.parseBoolean(campos[6]);
				String cor = campos[7];
			
                Produto produto = new ProdutoPadrao(id, descricao, categoria, qtdEstoque,preco);
		    
                if(negrito) {
                    
                    produto = new ProdutoNegrito(produto, cor);
                }
                if(italico) {
                    produto = new ProdutoItalico(produto, cor);
                }
                if(negrito && italico) {
                    produto = new ProdutoItaeNeg(produto, cor);
                }
                produtos.add(produto);

            }

            return produtos;
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        // Agora você tem a lista de produtos criada a partir do arquivo CSV
        // Faça o que for necessário com a lista de produtos.
    }
}
