package persistencia;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import entidades.Fornecedor.Fornecedor;
import entidades.Mercado.Mercado;

public class Persistencia {
	private String path = "src/persistencia/cadastros/";
	private String pathFornecedores = path + "fornecedores.txt";
	private String pathMercados = path + "mercados.txt";
	
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
}
