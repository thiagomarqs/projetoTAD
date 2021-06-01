package persistencia;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import TADs.Fornecedor.ListaFornecedor;
import TADs.Mercado.ListaMercado;
import TADs.Produto.ListaProduto;
import entidades.Fornecedor.Fornecedor;
import entidades.Mercado.Mercado;
import entidades.Produto.Produto;

public class Persistencia {
	private String path = "src/persistencia/cadastros/";
	private File pathFornecedores = new File(path + "fornecedores.csv");
	private File pathMercados = new File(path + "mercados.csv");
	private File pathProdutos = new File(path + "produtos.csv");
	
	// Construtor cria os arquivos se nao existirem
	public Persistencia() {
		if(pathFornecedores.exists() == false) {
			try {
				pathFornecedores.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(pathMercados.exists() == false) {
			try {
				pathMercados.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(pathProdutos.exists() == false) {
			try {
				pathMercados.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	
	
	
	
	public void salvarFornecedor(Fornecedor f) {
		StringBuilder sb = new StringBuilder();
		sb.append(
				f.Id + "," 
				+ f.novoUsername + "," 
				+ f.senha + "," 
				+ f.endereco + "," 
				+ f.cep + "," 
				+ f.contaBanco
				);
		String fornecedor = sb.toString();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathFornecedores, true))){
			bw.write(fornecedor + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salvarMercado(Mercado m) {
		StringBuilder sb = new StringBuilder();
		sb.append(m.Id + "," + m.Nome + "," + m.Cnpj + ","+ m.Endereco);
		
		String mercado = sb.toString();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathMercados, true))){
			bw.write(mercado + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public void salvarProduto(Produto p) {
		StringBuilder sb = new StringBuilder();
		sb.append(p.getId() + ","
				+ p.getNome() + ","
				+ p.getDescricao() + ","
				+ p.getPreco() + ","
				+ p.getEstoque() + ","
				+ p.getFornecedorId()
				);
		String produto = sb.toString();
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(pathProdutos, true))){
			bw.write(produto + "\n");
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	
	
	
	
	// retorna uma lista de fornecedores a partir do arquivo csv
	public ListaFornecedor obterFornecedores() {
		ListaFornecedor fornecedores = new ListaFornecedor();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathFornecedores))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				int id = Integer.parseInt(dados[0]);
				String nome = dados[1];
				String senha = dados[2];
				String endereco = dados[3];
				String cep = dados[4];
				String contaBanco = dados[5];
				
				Fornecedor f = new Fornecedor(id, nome, senha, endereco, cep, contaBanco);
				
				fornecedores.append(f);
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return fornecedores;
	}
	
	// retorna uma lista de mercados a partir do arquivo csv
	public ListaMercado obterMercados() {
		ListaMercado mercados = new ListaMercado();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathMercados))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				double id = Double.parseDouble(dados[0]);
				String nome = dados[1];
				String cnpj = dados[2];
				String endereco = dados[3];
				
				Mercado m = new Mercado(id, nome, cnpj, endereco);
				
				mercados.append(m);
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return mercados;
	}
	
	// retorna uma lista de produtos a partir do arquivo csv
	public ListaProduto obterTodosProdutos() {
		ListaProduto produtos = new ListaProduto();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathProdutos))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				int id = Integer.parseInt(dados[0]);
				String nome = dados[1];
				String descricao = dados[2];
				float preco = (float) Double.parseDouble(dados[3]);
				int estoque = Integer.parseInt(dados[4]);
				int fornecedorId = Integer.parseInt(dados[5]);
				
				Produto p = new Produto(id, nome, descricao, preco, estoque, fornecedorId);
				
				produtos.append(p);
				
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produtos;
		
	}
	
	// retorna uma lista de produtos de apenas um fornecedor a partir do arquivo csv
	public ListaProduto obterProdutosFornecedor(int idFornecedor) {
		ListaProduto produtos = new ListaProduto();
		
		try(BufferedReader br = new BufferedReader(new FileReader(pathProdutos))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				if(Integer.parseInt(dados[5]) == idFornecedor) {
					int id = Integer.parseInt(dados[0]);
					String nome = dados[1];
					String descricao = dados[2];
					float preco = (float) Double.parseDouble(dados[3]);
					int estoque = Integer.parseInt(dados[4]);
					int fornecedorId = Integer.parseInt(dados[5]);
					
					Produto p = new Produto(id, nome, descricao, preco, estoque, fornecedorId);
					
					produtos.append(p);
				}

				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return produtos;
	}
	
	
	// retorna o id disponivel para registrar um novo fornecedor
	public int idDisponivelFornecedor() {
		int id = 0;
		try(BufferedReader br = new BufferedReader(new FileReader(pathFornecedores))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				id = Integer.parseInt(dados[0]);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		id++;
		return id;
	}
	
	// retorna o id disponivel para registrar um novo mercado
	public double idDisponivelMercado() {
		double id = 0.0;
		try(BufferedReader br = new BufferedReader(new FileReader(pathMercados))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				id = Double.parseDouble(dados[0]);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		id++;
		return id;
	}
	
	// retorna o id disponivel para registrar um novo produto
		public int idDisponivelProduto(int idFornecedor) {
			int id = 0;
			try(BufferedReader br = new BufferedReader(new FileReader(pathProdutos))){
				String line = br.readLine();
				while(line != null) {
					String[] dados = line.split(",");
					if(Integer.parseInt(dados[5]) == idFornecedor) {
						id = Integer.parseInt(dados[0]);
					}
					line = br.readLine();
				}
			} catch (FileNotFoundException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			id++;
			return id;
		}
}
