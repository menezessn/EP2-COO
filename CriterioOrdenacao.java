//Interface para implementar as classes com os criterios de ordenação a serem utilizados para o padrão stratefy
public interface CriterioOrdenacao {
    int comparar(Produto p1, Produto p2);
}
