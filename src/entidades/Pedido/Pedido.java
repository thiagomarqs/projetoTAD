package entidades.Pedido;

import java.util.ArrayList;

import entidades.Produto.*;

public class Pedido {
	
	public int Id;
	public ArrayList<Produto> ListaProdutos;
	public String Status;
	public float Preco;
	public double IdMercado;
	
	public Pedido() {
		ListaProdutos = new ArrayList<Produto>();
	}
	
	public Pedido(Produto produto) {
		this.ListaProdutos.add(produto);
	}
	
	public Pedido(int id, String status, float preco, double idMercado) {
		this.Id = id;
		this.Status = status;
		this.Preco = preco;
		this.IdMercado = idMercado;
	}
	
	public Pedido(int id, ArrayList<Produto> listaProdutos, String status, float preco, double idMercado) {
		this.Id = id;
		this.ListaProdutos = listaProdutos;
		this.Status = status;
		this.Preco = preco;
		this.IdMercado = idMercado;
	}
	
	public void CreateAdd(int id, String status, float preco, double idMercado) {
		this.Id = id;
		this.Status = status;
		this.Preco = preco;
		this.IdMercado = idMercado;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}

	public ArrayList<Produto> getListaProdutos() {
		return ListaProdutos;
	}

	public void setListaProdutos(ArrayList<Produto> listaProdutos) {
		ListaProdutos = listaProdutos;
	}

	public String getStatus() {
		return Status;
	}

	public void setStatus(String status) {
		Status = status;
	}

	public float getPreco() {
		return Preco;
	}

	public void setPreco(float preco) {
		Preco = preco;
	}

	public double getIdMercado() {
		return IdMercado;
	}

	public void setIdMercado(double idMercado) {
		IdMercado = idMercado;
	}
}
