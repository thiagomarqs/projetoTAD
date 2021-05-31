package entidades.Fornecedor;

public class Fornecedor {
	
	public int Id;
	public String novoUsername;
	public String senha;
	public String endereco;
	public String cep;
    public String contaBanco;
    
    public Fornecedor() {      
    }

    public Fornecedor(int id, String novoUsername, String senha, String endereco, String cep, String contaBanco) {
    	this.Id = id;
    	this.novoUsername = novoUsername;
        this.senha = senha;
        this.endereco = endereco;
        this.cep = cep;
        this.contaBanco = contaBanco;        
    }
}
