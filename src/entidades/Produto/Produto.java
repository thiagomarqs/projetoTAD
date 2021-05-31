package entidades.Produto;

public class Produto {
	
	private int Id;
	private int FornecedorId;
	private String Nome;
	private String Descricao;
	private float Preco;
	private double IdMercado;
	private int Estoque;
	
	public Produto() {
		
	}
	
	public void CreateAdd(int id, String nome, String descricao, float preco, int estoque, int fornecedorId) {
		this.Id = id;
		this.Nome = nome;
		this.Descricao = descricao;
		this.Preco = preco;
		this.Estoque = estoque;
		this.FornecedorId = fornecedorId;
	}
	
	public void CreateAdd(int id, String nome, String descricao, float preco, int estoque, int fornecedorId, double idMercado) {
		this.Id = id;
		this.Nome = nome;
		this.Descricao = descricao;
		this.Preco = preco;
		this.Estoque = estoque;
		this.FornecedorId = fornecedorId;
		this.IdMercado = idMercado;
	}
	
	public Produto(int id, String nome, String descricao, float preco, int estoque, int fornecedorId) {
		this.Id = id;
		this.Nome = nome;
		this.Descricao = descricao;
		this.Preco = preco;
		this.Estoque = estoque;
		this.FornecedorId = fornecedorId;
	}

	public int getId() {
		return Id;
	}

	public void setId(int id) {
		Id = id;
	}
	
	public int getFornecedorId() {
		return FornecedorId;
	}

	public void setFornecedorId(int fornecedorId) {
		FornecedorId = fornecedorId;
	}

	public String getNome() {
		return Nome;
	}

	public void setNome(String nome) {
		Nome = nome;
	}

	public String getDescricao() {
		return Descricao;
	}

	public void setDescricao(String descricao) {
		Descricao = descricao;
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

	public int getEstoque() {
		return Estoque;
	}

	public void setEstoque(int estoque) {
		Estoque = estoque;
	}
	
	public String print() {
		
		StringBuffer text = new StringBuffer();
		
		text.append("[");
		text.append("Id: " + getId() + ", ");
		text.append("FornecedorId: " + getFornecedorId() + ", ");
		text.append("Nome: " + getNome() + ", ");
		text.append("Descrição: " + getDescricao() + ", ");
		text.append("Preco: " + getPreco() + ", ");
		text.append("Quantidade: " + getEstoque());
		text.append("] ");
		text.append("\n");
		
		return text.toString();
	}
}
