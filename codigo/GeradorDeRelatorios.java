import java.io.PrintWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.util.*;

import decorator.Produto;
import decorator.ProdutoItalico;
import decorator.ProdutoNegrito;
import decorator.ProdutoPadrao;
import strategy.algorithm.Algorithm;
import strategy.algorithm.InsertionSort;
import strategy.algorithm.QuickSort;
import strategy.criterio.Criterio;
import strategy.criterio.DescCresc;
import strategy.criterio.DescDecresc;
import strategy.criterio.EstoqueCresc;
import strategy.criterio.EstoqueDecresc;
import strategy.criterio.PrecoCresc;
import strategy.criterio.PrecoDecresc;
import strategy.filtro.CategoriaIgual;
import strategy.filtro.DescricaoContem;
import strategy.filtro.EstoqueMenorIgual;
import strategy.filtro.Filtro;
import strategy.filtro.IntervaloDePreco;
import strategy.filtro.Todos;

public class GeradorDeRelatorios {
	public static final String ALG_INSERTIONSORT = "insertion";
	public static final String ALG_QUICKSORT = "quick";

	public static final String CRIT_DESC_CRESC = "descricao_c";
	public static final String CRIT_PRECO_CRESC = "preco_c";
	public static final String CRIT_ESTOQUE_CRESC = "estoque_c";
	public static final String CRIT_DESC_DECRESC = "descricao_d";
	public static final String CRIT_PRECO_DECRESC = "preco_d";
	public static final String CRIT_ESTOQUE_DECRESC = "estoque_d";

	public static final String FILTRO_TODOS = "todos";
	public static final String FILTRO_ESTOQUE_MENOR_OU_IQUAL_A = "estoque_menor_igual";
	public static final String FILTRO_CATEGORIA_IGUAL_A = "categoria_igual";
	public static final String FILTRO_INTERVALO_DE_PRECO = "intervalo_de_preco";
	public static final String FILTRO_DESCRICAO_CONTEM = "descricao_contem";

	// operador bit a bit "ou" pode ser usado para combinar mais de
	// um estilo de formatacao simultaneamente (veja como no main)
	public static final int FORMATO_PADRAO = 0b0000;
	public static final int FORMATO_NEGRITO = 0b0001;
	public static final int FORMATO_ITALICO = 0b0010;

	private ArrayList<Produto> produtos;
	private Filtro filtro;
	private Algorithm algorithm;
	private Criterio criterio;
	private String argFiltro;

	public GeradorDeRelatorios(ArrayList<Produto> produtos, Algorithm algorithm, Criterio criterio, Filtro filtro, String argFiltro) {

		this.produtos = new ArrayList<Produto>(produtos);

		this.algorithm = algorithm;
		this.criterio = criterio;
		this.filtro = filtro;
	}

	public void debug() {

		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'");
	}

	public void geraRelatorio(String arquivoSaida) throws IOException {

		debug();

		algorithm.order(produtos, criterio);

		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for (int i = 0; i < produtos.size(); i++) {

			Produto p = produtos.get(i);
			
			if(filtro.equals(p)){

				out.print("<li>");

				out.print(p.formataParaImpressao());

				out.println("</li>");
				count++;
			}
		}

		out.println("</ul>");
		out.println(count + " produtos listados, de um total de " + produtos.size() + ".");
		out.println("</body>");
		out.println("</html>");

		out.close();
	}

	public static ArrayList<Produto> carregaProdutos(File dados) throws FileNotFoundException {
		ArrayList<Produto> list = new ArrayList<Produto>();

		try (Scanner scanner = new Scanner(dados)) {
			scanner.useDelimiter(",");

			while (scanner.hasNextLine()) {
				Produto produto = new ProdutoPadrao(
						scanner.nextInt(),
						scanner.next(),
						scanner.next(),
						scanner.nextInt(),
						scanner.nextDouble());
				if (scanner.nextBoolean() == true)
					produto = new ProdutoNegrito(produto);
				if (scanner.nextBoolean() == true)
					produto = new ProdutoItalico(produto);
					
				list.add(produto);
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

		return list;
	}

	public static void main(String[] args) throws FileNotFoundException {

		if (args.length < 5) {

			System.out.println("Uso:");
			System.out.println("\tjava " + GeradorDeRelatorios.class.getName()
					+ " <algoritmo> <critério de ordenação> <critério de filtragem> <parâmetro de filtragem> <nome do arquivo>");
			System.out.println("Onde:");
			System.out.println("\talgoritmo: 'quick' ou 'insertion'");
			System.out.println("\tcriterio de ordenação: 'preco_c' ou 'descricao_c' ou 'estoque_c' ou 'preco_d' ou 'descricao_d' ou 'estoque_d'");
			System.out.println("\tcriterio de filtragem: 'todos' ; 'estoque_menor_igual' ; 'categoria_igual' ; 'intervalo_de_preco' ; 'descricao_contem' ");
			System.out.println("\tparâmetro de filtragem: argumentos adicionais necessários para a filtragem");
			System.out.println("\tnome do arquivo: '{nome_do_arquivo}.csv");
			System.out.println();
			System.exit(1);
		}

		String opcao_algoritmo = args[0];
		String opcao_criterio_ord = args[1];
		String opcao_criterio_filtro = args[2];
		String opcao_parametro_filtro = args[3];
		String nome_do_arquivo = args[4];

		Algorithm algorithm;

		switch (opcao_algoritmo) {
			case ALG_INSERTIONSORT:
				algorithm = new InsertionSort();
				break;
			case ALG_QUICKSORT:
				algorithm = new QuickSort();
				break;
			default:
				throw new RuntimeException("Algoritmo inválido!");
		}

		Criterio criterioOrdenacao;

		switch (opcao_criterio_ord) {
			case CRIT_DESC_CRESC:
				criterioOrdenacao = new DescCresc();
				break;
			case CRIT_PRECO_CRESC:
				criterioOrdenacao = new PrecoCresc();
				break;
			case CRIT_ESTOQUE_CRESC:
				criterioOrdenacao = new EstoqueCresc();
				break;
			case CRIT_DESC_DECRESC:
				criterioOrdenacao = new DescDecresc();
				break;
			case CRIT_PRECO_DECRESC:
				criterioOrdenacao = new PrecoDecresc();
				break;
			case CRIT_ESTOQUE_DECRESC:
				criterioOrdenacao = new EstoqueDecresc();
				break;
			default:
				throw new RuntimeException("Critério de ordenação inválido!");
		}

		Filtro criterioFiltro;

		switch (opcao_criterio_filtro) {
			case FILTRO_TODOS:
				criterioFiltro = new Todos();
				break;
			case FILTRO_ESTOQUE_MENOR_OU_IQUAL_A:
				criterioFiltro = new EstoqueMenorIgual(opcao_parametro_filtro);
				break;
			case FILTRO_CATEGORIA_IGUAL_A:
				criterioFiltro = new CategoriaIgual(opcao_parametro_filtro);
				break;
			case FILTRO_DESCRICAO_CONTEM:
				criterioFiltro = new DescricaoContem(opcao_parametro_filtro);
				break;
			case FILTRO_INTERVALO_DE_PRECO:
				String[] valores = opcao_parametro_filtro.split("-");
				double valor_min = Double.parseDouble(valores[0]);
				double valor_max = Double.parseDouble(valores[1]);
				criterioFiltro = new IntervaloDePreco( valor_min, valor_max);
				break;
			default:
				throw new RuntimeException("Critério de filtro inválido!");
		}

		GeradorDeRelatorios gdr = new GeradorDeRelatorios(
				carregaProdutos(new File(nome_do_arquivo)),
				algorithm,
				criterioOrdenacao,
				criterioFiltro,
				opcao_parametro_filtro
				);

		try {
			gdr.geraRelatorio("saida.html");
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
}
