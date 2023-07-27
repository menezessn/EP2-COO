package src;

import src.algoritmos.Algoritmo;
import src.criterios.CriterioOrdenacao;
import java.io.PrintWriter;
import java.io.IOException;
import java.util.List;
import src.decorator.Produto;
import src.filtros.Filtro;


public class GeradorDeRelatorios {


	private List<Produto> produtos;
	private Algoritmo algoritmo;
	private CriterioOrdenacao criterio;
	private Filtro  filtro;
	private String argFiltro;


	public GeradorDeRelatorios( Algoritmo algoritmo, CriterioOrdenacao criterio, Filtro filtro, String argFiltro, List<Produto> produtos){


		this.algoritmo = algoritmo;
		this.criterio = criterio;

		this.filtro = filtro;
		this.argFiltro = argFiltro;
		this.produtos = produtos;
	}

	public void debug(){

		System.out.println("Gerando relatório para array contendo " + produtos.size() + " produto(s)");
		System.out.println("parametro filtro = '" + argFiltro + "'"); 
	}


	public void geraRelatorio(String arquivoSaida) throws IOException {

		debug();

		algoritmo.ordena(0, produtos.size() - 1);

		PrintWriter out = new PrintWriter(arquivoSaida);

		out.println("<!DOCTYPE html><html>");
		out.println("<head><title>Relatorio de produtos</title></head>");
		out.println("<body>");
		out.println("Relatorio de Produtos:");
		out.println("<ul>");

		int count = 0;

		for(int i = 0; i < produtos.size(); i++){

			Produto p = produtos.get(i);
			//boolean selecionado = false;
			boolean selecionado = filtro.seleciona(p);

			if(selecionado){

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

}
