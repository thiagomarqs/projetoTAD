package persistencia;

import entidades.Produto.Produto;

public class TestePersistencia {

	public static void main(String[] args) {
//		Fornecedor f = new Fornecedor(1, "joao", "123", "rua do joao 123", "12345678", "12312312312");
//		Mercado m = new Mercado(1, "Estrela Mercados", "12312312312", "Rua estrela 123");
		Produto prod = new Produto(1, "banana", "banana", (float) 32.00, 200, 2);
		Persistencia p = new Persistencia();
//		p.idDisponivelMercado();
//		p.idDisponivelFornecedor();
//		p.salvarFornecedor(f);
//		p.salvarMercado(m);
//		ListaFornecedor fornecedores = p.obterFornecedores();
//		p.salvarProduto(prod);
//		p.obterProdutos();
//		p.idDisponivelProduto(2);
		p.obterProdutosFornecedor(3);
	}

}
