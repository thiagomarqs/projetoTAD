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
import entidades.Fornecedor.Fornecedor;
import entidades.Mercado.Mercado;

public class Persistencia {
	private String path = "src/persistencia/cadastros/";
	private File pathFornecedores = new File(path + "fornecedores.csv");
	private File pathMercados = new File(path + "mercados.csv");
	
	// O proprio construtor cria os arquivos se nao existirem
	public Persistencia() {
		if(!pathFornecedores.exists()) {
			try {
				pathFornecedores.createNewFile();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
		if(!pathMercados.exists()) {
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
	
	
	// retorna o idDisponivel para registrar um novo mercado
	public double idDisponivelMercado() {
		double id = 0.0;
		try(BufferedReader br = new BufferedReader(new FileReader(pathMercados))){
			String line = br.readLine();
			while(line != null) {
				String[] dados = line.split(",");
				id = Double.parseDouble(dados[0]);
				System.out.println(id);
				line = br.readLine();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		id++;
		System.out.println("return: " + id);
		return id;
	}
}
