package entidades.Pedido;

import java.util.ArrayList;

import entidades.Produto.Produto;

public class HistoricoPedido {
		
	public double IdPedido;
	public String NomeMercado;
	public String NomeFornecedor;
	public int Avaliacao;
	public float Preco;
	public ArrayList<Produto> ListaProdutos;

		
	public HistoricoPedido(double idPedido, String nomeMercado, String nomeFornecedor, int avaliacao, float preco, ArrayList<Produto> listaProduto) {
		this.IdPedido = idPedido;
		this.NomeMercado = nomeMercado;
		this.NomeFornecedor = nomeFornecedor;
		this.Avaliacao = avaliacao;
		this.Preco = preco;
		this.ListaProdutos = listaProduto;

	}
}
