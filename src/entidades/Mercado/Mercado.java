package entidades.Mercado;

public class Mercado {
	
	public double Id;
	public String Nome;
	public String Cnpj;
	public String Endereco;
	
	public Mercado(double id, String nome, String cnpj, String endereco) {
		this.Id = id;
		this.Nome = nome;
		this.Cnpj = cnpj;
		this.Endereco = endereco;
	}
}
