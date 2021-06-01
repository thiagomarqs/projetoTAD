package programa;

import static java.lang.System.out;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;
import java.util.Scanner;

import TADs.Fornecedor.ListaAvaliacaoFornecedor;
import TADs.Fornecedor.ListaFornecedor;
import TADs.Fornecedor.Nodes.NodeFornecedor;
import TADs.Mercado.ListaMercado;
import TADs.Mercado.ListaMercadoPedido;
import TADs.Mercado.Nodes.NodeMercado;
import TADs.Mercado.Nodes.NodeMercadoPedido;
import TADs.Pedido.ListaHistoricoPedido;
import TADs.Produto.ListaProduto;
import TADs.Produto.Nodes.NodeProduto;
import entidades.Fornecedor.Avaliacao;
import entidades.Fornecedor.Fornecedor;
import entidades.Fornecedor.SortAvaliacao;
import entidades.Mercado.Mercado;
import entidades.Pedido.HistoricoPedido;
import entidades.Pedido.Pedido;
import entidades.Pedido.Sort.SortPedidoByAvaliation;
import entidades.Pedido.Sort.SortPedidoByPrice;
import entidades.Produto.Produto;
import persistencia.Persistencia;

public class Programa {
	
	// Persistencia
	Persistencia persistencia = new Persistencia();
		
	//#Fornecedor -----------------------------------------#
	
	//Fornecedor - Lista de usu�rios
	ListaFornecedor listaFornecedores = persistencia.obterFornecedores(); 
	
	//Fornecedor - Lista de Produtos
	ListaProduto listaFornecedorProduto = persistencia.obterTodosProdutos();
	
	//Fornecedor - Lista de avaliacao
	ListaAvaliacaoFornecedor listaAvaliacaoFornecedor = new ListaAvaliacaoFornecedor();
		
	//#Fornecedor -----------------------------------------#
	
	
	//Mercado -----------------------------------------#
		
	//Mercado - Lista de usu�rios
	ListaMercado listaMercados = persistencia.obterMercados();
	
	//Mercado - Lista de pedidos feitos pelo mercado
	ListaMercadoPedido listaMercadoPedidos = new ListaMercadoPedido(); 
	
	//Mercado - Lista de produtos que v�o fazer parte da fila de pedidos
	ListaProduto listaMercadoProduto = new ListaProduto(); 
	
	//Mercado - Lista de hist�rico de Pedidos executados
	ListaHistoricoPedido listaHistoricoPedido = new ListaHistoricoPedido();
	
	//Mercado -----------------------------------------#
	
	//MERCADO - VARIAVEIS GLOBAIS
	public double MercadoId = persistencia.idDisponivelMercado();
	public double CurrentMercadoId = 0;
	public String CurrentMercadoName;
	
	//PEDIDO - VARIAVEIS GLOBAIS
	public int idPedido = 1;

	//FORNECEDOR - VARIAVEIS GLOBAIS
	public int fornecedorId = persistencia.idDisponivelFornecedor();
	public int currentFornecedorId = 1;
	
	//PRODUTO - VARIAVEIS GLOBAIS
	public int idProduto = persistencia.idDisponivelProduto();
	
	
	Scanner sc = new Scanner(System.in);
	
	//Menu Principal -----------------------------------------#
	
	//Menu Principal - Tipo de usu�rio
	public void main() {
		int resp;
		boolean sair = false;
		
		while(!sair) {
			System.out.println("\n### BEM VINDO AO NOSSO SISTEMA ###");
			System.out.println("\nInforme o seu tipo de usu�rio: ");
			System.out.println("1 - Fornecedor");
			System.out.println("2 - Mercado");
			System.out.print("\n> Resposta: ");
			resp = sc.nextInt();
			
			switch(resp) {
				case 1:
					mainFornecedor(); break;
				case 2:
					mainMercado(); break;
				default:
					System.out.println("> Op��o Inv�lida");
			}
		}
	}
	
	//Menu Principal -----------------------------------------#
	
	
	//Fornecedor -----------------------------------------#
	
	//Fornecedor - Menu Deslogado
	public void mainFornecedor() {
		int resp;
		boolean sair = false;
		
		while(!sair) {
			System.out.println("\n### FORNECEDOR ONLINE ###");
			System.out.println("> Bem vindo ao Fornecedor Online!");
			System.out.println("> Op��es:");
			System.out.println("1 - Fazer login");
			System.out.println("2 - Fazer cadastro");
			System.out.println("3 - Sair (Retornar Menu Principal)");
			System.out.print("\n> Resposta: ");
			resp = sc.nextInt();
			
			switch(resp) {
				case 1:
					loginFornecedor(); break;
				case 2:
					cadastroFornecedor(); break;
				case 3:
					main(); break;
				default:
					System.out.println("> Op��o Inv�lida");
			}
		}
	}
	
	// Fornecedor - Menu Logado
	public void menuFornecedor() {
		int resp;
		boolean sair = false;
			
		Scanner scanner = new Scanner(System.in);
			
		while(!sair) {
			out.println("\n### MENU DO FORNECEDOR ###");
			out.println("> Op��es:");
			out.println("1 - Anunciar Produtos");
			out.println("2 - Ver Produtos Anunciados");
			out.println("3 - Consultar Avalia��es");
			System.out.println("4 - Sair (Retornar Menu)");
				
			out.print("\n> Resposta: ");
				
			resp = scanner.nextInt();
				
			switch(resp) {
				case 1:
					anunciarProdutos(); break;
				case 2:
					listarProdutosFornecedor(); break;
				case 3:
					listarAvaliacoesFornecedor(); break;
				case 4:
					mainFornecedor(); break;
				default:
					out.println("Op��o Inv�lida");
			}
		}
	}
	
	// Fornecedor - Login
	public void loginFornecedor() {
		out.println("\n### LOGIN ###");
	    Scanner in = new Scanner (System.in);

	    System.out.println("\nInforme o login:");
	    String username = in.nextLine();
	    System.out.println("\nInforme a senha:");
		String senha = in.nextLine();

		NodeFornecedor forn = listaFornecedores.find(username, senha);
		
		if(forn != null && forn.getValue() != null) {
			System.out.println("\nLogin feito com sucesso!");
			currentFornecedorId = forn.getValue().Id;
			menuFornecedor();
		}
		else {
			System.out.println("\nN�o foi poss�vel efetuar o Login");
			mainFornecedor();
		}			            	               	 
	}
		
	// Fornecedor - Cadastro
	public void cadastroFornecedor () {
	            
		out.println("\n### Cadastro Fornecedor ###");
				
		Scanner entrada = new Scanner(System.in);
				
		System.out.println("\nDigite seu username: ");
		String username = entrada.nextLine();
				
		System.out.println("\nInforme a senha: ");
		String senha = entrada.nextLine();
				
		System.out.println("\nInforme o endere�o completo: ");
		String endereco = entrada.nextLine();
				
		System.out.println("\nInforme o CEP: ");
		String cep = entrada.nextLine();
				
		System.out.println("\nInforme o numero da conta bancaria: ");
		String contaBanco = entrada.nextLine();

		Fornecedor f = new Fornecedor(fornecedorId, username, senha, endereco, cep, contaBanco);
			
		NodeFornecedor forn = listaFornecedores.find(username, senha);
		
		if(forn != null && forn.getValue() != null) {
			System.out.println("\nEste usu�rio j� existe. Tente novamente!");
			mainFornecedor();
		}
		else {
			listaFornecedores.append(f);
			persistencia.salvarFornecedor(f);
			currentFornecedorId = fornecedorId;
			fornecedorId += 1;
			
			out.println("\nParabens, " + f.novoUsername + " agora voc� um novo usuario do tipo FORNECEDOR.");
			menuFornecedor();
		}
	}
	
	// Fornecedor - "Anunciar Produtos"
	public void anunciarProdutos() {
		out.println("\n### ANUNCIAR PRODUTOS ###");
		
		boolean sair = false;	
		
		while(!sair) {
			Scanner scanner = new Scanner(System.in);
	
			System.out.println("\nInforme o nome do produto: ");
			String nome = scanner.nextLine();
	
			System.out.println("\nInforme a descri��o do produto: ");
			String descricao = scanner.nextLine();
	
			System.out.println("\nInforme o pre�o que deseja cobrar: ");
			float preco = scanner.nextFloat();
			
			System.out.println("\nInforme a quantidade: ");
			int estoque = scanner.nextInt();
	
			idProduto = persistencia.idDisponivelProduto();
			Produto produto = new Produto(idProduto, nome, descricao, preco, estoque, currentFornecedorId);
	
			listaFornecedorProduto.append(produto);
			persistencia.salvarProduto(produto);
			
			System.out.println("\nProduto adicionado!");
			
			System.out.println("\nDeseja continuar adicionando produtos?");
			System.out.println("Digite 0 PRA N�O");
				
			double opcao = scanner.nextDouble();
			
			idProduto += 1;
			
			if(opcao == 0) {		
				sair = true;
			}	
		}
		
		System.out.println("\nVoltando ao menu do fornecedor..");
	}	
	
	// Fornecedor - Listar Produtos
	public void listarProdutosFornecedor() {
		ListaProduto produtosFornecedor = persistencia.obterProdutosFornecedor(currentFornecedorId);
		if(produtosFornecedor.getSize() > 0) {		
			out.println("\n### Lista Produtos do Fornecedor");
			
			out.println(produtosFornecedor.print());
		}
		else
		{
			System.out.println("\nNenhum produto foi anunciado..");
			menuFornecedor();
		}
	}
	
	// Fornecedor - Listar Avalia��es
	public void listarAvaliacoesFornecedor() {
		
		Scanner scanner = new Scanner(System.in);
		
		if(listaAvaliacaoFornecedor.getSize() > 0) {		
			
			out.println("\n### Lista Avalia��es do Fornecedor");
			
			out.println(listaAvaliacaoFornecedor.print());
			
			out.println("\nOp��es");		
			out.println("1 - Comparar Avalia��es (Ordem Crescente)");
			out.println("2 - Comparar Avalia��es (Ordem Decrescente)");
	
			int opcao = scanner.nextInt();
			
			if(opcao == 1) {
				
				ArrayList<Avaliacao> arr = new ArrayList<Avaliacao>();
				
				arr = listaAvaliacaoFornecedor.getArrayList();
				
				Collections.sort(arr, new SortAvaliacao());
					
				StringBuffer text = new StringBuffer();
					
				for (Avaliacao ava : arr) {
					text.append("\n" + "[");
					text.append("IdPedido: " + ava.Avaliacao  + ", ");
					text.append("Nome Mercado" + ava.NomeMercado);
					text.append("] " + "\n");
				}
					
				System.out.println(text);
			}
			
			if(opcao == 2) {
				
				ArrayList<Avaliacao> arr = new ArrayList<Avaliacao>();
				
				arr = listaAvaliacaoFornecedor.getArrayList();
							
				Collections.sort(arr, new SortAvaliacao());
				
				Collections.reverse(arr);
			
				StringBuffer text = new StringBuffer();
					
				for (Avaliacao ava : arr) {
					text.append("\n" + "[");
					text.append("IdPedido: " + ava.Avaliacao  + ", ");
					text.append("Nome Mercado" + ava.NomeMercado);
					text.append("] " + "\n");
				}
					
				System.out.println(text);
			}
		}
		else
		{
			System.out.println("\nO fornecedor ainda n�o foi avaliado..");
			menuFornecedor();
		}
	}
	
	//Fornecedor -----------------------------------------#
	
	
	
	
	
	
	//Mercado - Main-----------------------------------------#
	public void mainMercado() {
		
		boolean sair = false;
		int resp = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		while(!sair) {
			System.out.println("\n> Menu do Mercado");
			System.out.println("> Op��es:");
			System.out.println("1 - Fazer login");
			System.out.println("2 - Fazer cadastro");
			System.out.println("3 - Sair (Retornar Menu Principal)");
			System.out.print("\n> Resposta: ");
			resp = scanner.nextInt();
			
			switch(resp) {
				case 1:
					loginMercado(); break;
				case 2:
					cadastroMercado(); break;
				case 3:
					main(); break;
				default:
					System.out.println("\nOp��o Inv�lida"); break;
			}
		}	
	}
	
	// Mercado - Login
	public void loginMercado() {
		out.println("\n### LOGIN - Mercado ###");
		Scanner in = new Scanner (System.in);

		System.out.println("\nInforme o CNPJ do Mercado: ");
		String cnpj = in.nextLine();
			
		NodeMercado merc = listaMercados.find(cnpj);
			
		if(merc != null && merc.getValue() != null) {
			System.out.println("\nLogin feito com sucesso!");
				
			CurrentMercadoName = merc.getValue().Nome;
			this.CurrentMercadoId = this.MercadoId;
				
			menuMercado();
		}
		else {
			System.out.println("\nN�o foi poss�vel efetuar o Login");
			mainMercado();
		}			          	            	               	 
	}
	
	// Mercado - Cadastro
	public void cadastroMercado() {
			            
		out.println("\n### Cadastro Mercado ###");
						
		Scanner entrada = new Scanner(System.in);
						
		System.out.println("\nInforme o nome do mercado: ");
		String nome = entrada.nextLine();
						
		System.out.println("\nInforme o cnpj do mercado: ");
		String cnpj = entrada.nextLine();
						
		System.out.println("\nInforme o endere�o do mercado: ");
		String endereco = entrada.nextLine();

		Mercado mercado = new Mercado(this.MercadoId, nome, cnpj, endereco);

		NodeMercado merc = listaMercados.find(cnpj);
			
		if(merc != null && merc.getValue() != null) {
			System.out.println("\nJ� existe um mercado com este cnpj!");
			mainMercado();
		}
		else {
			listaMercados.append(mercado);
			persistencia.salvarMercado(mercado);
				
			out.println("\nParabens! O mercado " + mercado.Nome + " foi cadastrado.");
				
			CurrentMercadoName = mercado.Nome;
			this.CurrentMercadoId = this.MercadoId;
			this.MercadoId += 1;
				
			menuMercado();
		}	
	}	
	//Mercado - Main-----------------------------------------#
	
	
	//Mercado - Menu de op��es para o mercado logado-----------------------------------------#
	public void menuMercado() {
		
		int resp;
		boolean sair = false;
				
		while(!sair) {
			System.out.println("\n### MENU DO MERCADO ###");
			System.out.println("> Op��es:");
			System.out.println("1 - Fazer Pedidos");
			System.out.println("2 - Listar Pedidos Cadastrados");
			System.out.println("3 - Listar Produtos dos Fornecedores");
			System.out.println("4 - Mandar Fornecedores Atenderem Pedidos");
			System.out.println("5 - Listar Pedidos Atendidos pelos Fornecedores (Hist�rico)");
			System.out.println("6 - Sair");
				
			System.out.print("\n> Resposta: ");
			resp = sc.nextInt();
				
			switch(resp) {
				case 1:
					fazerPedido(); break;
				case 2:
					listarPedidosCadastrados(); break;
				case 3:
					listarProdutosDoFornecedorParaOMercado(); break;
				case 4:
					fazerFornecedoresAtenderemPedido(); break;
				case 5:
					listarPedidosFeitos(); break;
				case 6:
					mainMercado(); break;
				default:
					System.out.println("\nOp��o Inv�lida"); break;
			}
		}
	}
	//Mercado - Menu de op��es para o mercado logado-----------------------------------------#

	
	//Mercado - Fazer Pedido -----------------------------------------#
	public void fazerPedido(){
		
		boolean sair = false;
		
		Scanner scanner = new Scanner(System.in);
		
		float total = 0;

		while(!sair) {	
			
			int id = 1;
			int quantidade = 0;
			
			NodeProduto nodeProduto = new NodeProduto();
			
			listarProdutosDoFornecedorParaOMercado();
			
			do{
				
				System.out.println("\nInforme o Id do Produto que deseja adicionar ao pedido: ");
				id = scanner.nextInt();	
				
				nodeProduto = listaFornecedorProduto.find(id);
				
				if(nodeProduto == null)
					System.out.println("\nEste id n�o existe..");
				
			}while(nodeProduto == null );
			
			do{
				System.out.println("\nInforme a quantidade desejada do produto: ");
				quantidade = scanner.nextInt();	
				
				if(quantidade < 1)
					System.out.println("\nQuantidade inv�lida");
				
			}while(quantidade < 1);
					
			
			//LOGICA ESTOQUE							
			Produto produto = nodeProduto.getValue();
				
			if(quantidade > produto.getEstoque()) {
				System.out.println("\nA quantidade escolhida excede o estoque. Por favor, tente novamente.");
				System.out.println("\nQuantidade disponivel do produto: " + produto.getEstoque());
				
				
				do{
					System.out.println("\nInforme a quantidade desejada do produto: ");
					quantidade = scanner.nextInt();	
					
					if(quantidade > produto.getEstoque()) {
						System.out.println("\nA quantidade escolhida excede o estoque. Por favor, tente novamente.");
						System.out.println("\nQuantidade disponivel do produto: " + produto.getEstoque());
					}
					
				}while(quantidade > produto.getEstoque());
				
				setEstoqueProduto(quantidade, produto);
				addProdutosCarrinhoMercado(quantidade, produto);
			}				
			else {
				setEstoqueProduto(quantidade, produto);
				addProdutosCarrinhoMercado(quantidade, produto);
			}
			
			float preco = produto.getPreco() * quantidade;
			
			total += preco;

			System.out.println("\nProduto adicionado");
											
			System.out.println("\nLista de produtos no pedido: ");
			System.out.println(listaMercadoProduto.print());
								
			System.out.println("\nDeseja continuar adicionando produtos ao pedido?: ");
			System.out.println("Digite 0 - Pra n�o");
			int option = scanner.nextInt();
				
			if(option == 0) {
				sair = true;
			}				
		}
		
		if(listaMercadoProduto.getSize() >= 1) {		
			addPedido(total);
		}
		
		System.out.println("\nDeseja fazer outro pedido? 1 - PARA SIM");
			
		int again = scanner.nextInt();
		
		if(again == 1)
			fazerPedido();
	}
	
	private void setEstoqueProduto(int quantidade, Produto produto) {
		
		NodeProduto curr = listaFornecedorProduto.getHead(); 
		
		int newEstoque = produto.getEstoque() - quantidade;
		
		while(curr != null) {		
			
			if(curr.getValue().getId() == produto.getId()) {
				curr.getValue().setEstoque(newEstoque);
			}
			
			curr = curr.getNext();
		}
	}
	
	private void addProdutosCarrinhoMercado(int quantidade, Produto produto) {
		
		Produto newProduto = new Produto(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), quantidade, produto.getFornecedorId());
		
		listaMercadoProduto.append(newProduto);	
	}
	
	private void addPedido(float total) {
				
		Pedido pedido = new Pedido();
		
		while(!listaMercadoProduto.isEmpty()) {		
			pedido.ListaProdutos.add(listaMercadoProduto.getHead().getValue());
			listaMercadoProduto.removeFirst();
		}		

		pedido.CreateAdd(idPedido, "Cadastrado", total, this.CurrentMercadoId);
		idPedido += 1;
		
		listaMercadoPedidos.append(pedido);
				
		System.out.println("\nPedido finalizado!");
	}
	//Mercado - Fazer Pedido -----------------------------------------#
	
	
	//Mercado - Listar Pedidos Cadastrados-----------------------------------------#		
	public void listarPedidosCadastrados() {
		
		Scanner scanner = new Scanner(System.in);
		
		int option = 0;
		
		if(listaMercadoPedidos.getSize() > 0) {		
			
			boolean sair = false;
			
			while (!sair) {
				
				out.println("\nLista Pedidos Cadastrados" + "\n");
				
				out.println(listaMercadoPedidos.print());
				
				System.out.println("\nOp��es: ");
				System.out.println("1 - Excluir Pedido: ");
				System.out.println("2 - Alterar Pedido: ");
				System.out.println("3 - Sair: ");
				
				option = scanner.nextInt();
				
				if(option == 1) {
					ExcluirPedidos();
				}
				else if(option == 2) {
					EditarPedidos();
				}
				else if(option == 3) {
					sair = true;
				}	
				else {
					System.out.println("Esta op��o n�o existe..");
				}
			}		
		}
		else
		{
			System.out.println("\nNenhum pedido foi cadastrado ainda.");
			menuMercado();
		}		
	}
	//Mercado - Listar Pedidos Cadastrados-----------------------------------------#
	
	
	//Mercado - Excluir Pedidos-----------------------------------------#	
		public void ExcluirPedidos() {
					
			if(listaMercadoPedidos.getSize() > 0) {			
					
				Scanner entrada = new Scanner(System.in);
								
				int id = 0;
				
				NodeMercadoPedido nodeMerc = new NodeMercadoPedido();
				
				do {
					
					System.out.println("\nLista Pedidos Cadastrados");
					System.out.println(listaMercadoPedidos.print());
					
					out.println("1 - Informe o Id do Pedido que deseja excluir: ");		
					id = entrada.nextInt();
					
					nodeMerc = listaMercadoPedidos.find(id);
					
					if(nodeMerc == null)
						System.out.println("Este id n�o existe..");			
				}
				while(nodeMerc == null);		
				
				listaMercadoPedidos.remove(id);
				
				System.out.println("\nPedido Removido");
			}
			else
			{
				System.out.println("\nNenhum pedido foi atendido ainda.");
				menuMercado();
			}		
		}
		//Mercado - Excluir Pedidos-----------------------------------------#
		
		
		//Mercado - Editar Pedidos-----------------------------------------#	
		public void EditarPedidos() {
						
			if(listaMercadoPedidos.getSize() > 0) {			
						
				Scanner entrada = new Scanner(System.in);
									
				int id = 0;
				int idProduto = 0;
					
				NodeMercadoPedido nodeMerc = new NodeMercadoPedido();
					
				do {
						
					System.out.println("\nLista Pedidos Cadastrados");
					System.out.println(listaMercadoPedidos.print());
						
					out.println("1 - Informe o Id do Pedido que deseja alterar: ");		
					id = entrada.nextInt();
						
					nodeMerc = listaMercadoPedidos.find(id);
						
					if(nodeMerc == null)
						System.out.println("Este id n�o existe..");	
				}
				while(nodeMerc == null);
				
				int option = 3;
				
				do {				
					System.out.println("\nLista de produtos no pedido: ");
					
					System.out.println(listaMercadoPedidos.printByPedidoId(id));
					
					System.out.println("\nDeseja adicionar produtos ao pedido ou alterar os que ja est�o?");
					System.out.println("1 - Adicionar");
					System.out.println("2 - Alterar");
					
					option = entrada.nextInt();
									
					Produto produto = new Produto();
					
					if(option == 1) {
						
						do {
							
							System.out.println("\nLista de produtos dos fornecedores: ");
							
							System.out.println(listaFornecedorProduto.print());
							
							System.out.println("\nInforme o id do produto que deseja adicionar ao pedido: ");
							
							idProduto = entrada.nextInt();
							
							NodeProduto nodeProduto = new NodeProduto();

							nodeProduto = listaFornecedorProduto.find(idProduto);
							
							if(nodeProduto != null) {
								produto.CreateAdd(nodeProduto.getValue().getId(), nodeProduto.getValue().getNome(),  nodeProduto.getValue().getDescricao(),nodeProduto.getValue().getPreco(),nodeProduto.getValue().getEstoque(),nodeProduto.getValue().getFornecedorId());
							}
																				
							if(nodeProduto == null)
								System.out.println("Este id n�o existe..");	
						
						}while(produto.getId() == 0 || produto.getNome() == null);
						
						Produto prod = new Produto();
						
						for (Produto p : listaMercadoPedidos.find(nodeMerc.getValue().Id).getValue().ListaProdutos) {
							if(p.getId() == produto.getId()) {
								prod.CreateAdd(p.getId(), p.getNome(),p.getDescricao(),p.getPreco(),p.getEstoque(),p.getFornecedorId());
							}
						}
						
						int choose = 4;
						
						if(prod.getId() != 0 && prod.getNome() != null) {							
							do {	
								System.out.println("\nEste produto ja existe nesse pedido..");
								
								System.out.println("\nDeseja adicionar ou remover a quantidade deste produto?");
								
								System.out.println("1 - Adicionar");
								System.out.println("2 - Remover");
								
								choose = entrada.nextInt();
								
								if(choose == 1) {
									setQuantidadeToAdd(id, produto);								
								}	
								else if(choose == 2) {
									setQuantidadeToRemove(id, produto);
								}
								else {
									System.out.println("\nEsta op��o n�o existe..");
								}
							}
							while(choose > 3 || choose < 1);						
						}
						else {
							
							int quantidade = 0;
							
							System.out.println("\nEste produto n�o existe nesse pedido..");
							
							do {
								
								System.out.println("\nDetalhes do produto: ");
								
								System.out.println(produto.print());
								
								System.out.println("\nInforme a quantidade que deseja adicionar desse produto: ");
								
								quantidade = entrada.nextInt();

								if(quantidade > produto.getEstoque()) {
									System.out.println("\nA quantidade excede o estoque..");
								}
								else if(quantidade == produto.getEstoque()) {
									listaFornecedorProduto.remove(produto.getId());
										
									for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
										if(p.getId() == produto.getId()) {
											p.setEstoque(quantidade);
										}
									}
								}
								else {																				
									listaFornecedorProduto.find(produto.getId()).getValue().setEstoque(produto.getEstoque() - quantidade);		
										
									for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
										if(p.getId() == idProduto) {
											p.setEstoque(quantidade);
										}
									}
								}											
							}
							while(quantidade > produto.getEstoque());			
						}
					}
					else if(option == 2) {
												
						Produto prod = new Produto();
						
						do {
						
							System.out.println("\nPedido: ");
							
							System.out.println(listaMercadoPedidos.printByPedidoId(id));
							
							System.out.println("\nSelecione o id do produto: ");
							
							int produtoId = entrada.nextInt();
							
							NodeProduto nodePro = listaFornecedorProduto.getHead();
							
							while(nodePro != null) {
								
								if(nodePro.getValue().getId() == produtoId) {									
									prod.CreateAdd(nodePro.getValue().getId(), nodePro.getValue().getNome(), nodePro.getValue().getDescricao(), nodePro.getValue().getPreco(), nodePro.getValue().getEstoque(), nodePro.getValue().getFornecedorId());
								}
								nodePro = nodePro.getNext();
							}
						}
						while(prod.getId() == 0 && prod.getDescricao() == null);
						
						int qnt = 0;
											
						do {
							
							System.out.println("\nDeseja adicionar ou remover a quantidade deste produto?");
							
							System.out.println("1 - Adicionar");
							System.out.println("2 - Remover");
							
							qnt = entrada.nextInt();
							
							if(qnt == 1) {
								setQuantidadeToAdd(id, prod);								
							}	
							else if(qnt == 2) {
								setQuantidadeToRemove(id, prod);
							}
							else {
								System.out.println("\nEsta op��o n�o existe..");
							}
						}
						while(qnt > 2 || qnt < 1);	
					}
				}
				while(option > 2 || option < 1);	
			}
			else {
				System.out.println("\nNenhum pedido foi cadastrado ainda.");
				menuMercado();	
			}
		}

		public void setQuantidadeToAdd(int idPedido, Produto produto) {
			
			int quantidade = 0;
			
			Scanner entrada = new Scanner(System.in);
			
			int produtoId = produto.getId();
			int estoque = produto.getEstoque();
						
			do {
				
				System.out.println(produto.print());
				System.out.println("\nSe lembre que o produto possui " + estoque + " de estoque..");
				
				System.out.println("\nInforme a quantidade que deseja adicionar: ");
						
				quantidade = entrada.nextInt();
												
				if(quantidade > estoque) {
					System.out.println("\nA quantidade excede o estoque..");
				}
				else if(quantidade == estoque) {	
										
					float newPrice = 0;
					
					for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
						if(p.getId() == produtoId) {
							p.setEstoque(p.getEstoque() + quantidade);
						}
						
						float precoTotalProduto = p.getPreco() * p.getEstoque();
						newPrice += precoTotalProduto;
					}
					
					listaMercadoPedidos.find(idPedido).getValue().setPreco(newPrice);
												
					listaFornecedorProduto.remove(produtoId);
					
					System.out.println("\nSucesso!");
					System.out.println("Quantidade adicionada");
				}
				else {				
					
					float newPrice = 0;
					
					for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
						if(p.getId() == produtoId) {
							p.setEstoque(p.getEstoque() + quantidade);
						}
						
						float precoTotalProduto = p.getPreco() * p.getEstoque();
						newPrice += precoTotalProduto;
					}
					
					listaMercadoPedidos.find(idPedido).getValue().setPreco(newPrice);
					
					//setando os itens de volta para o fornecedor
					NodeProduto nodePro = listaFornecedorProduto.getHead();
					
					while(nodePro != null) {
						if(nodePro.getValue().getId() == produtoId) {
							nodePro.getValue().setEstoque(nodePro.getValue().getEstoque() - quantidade);
						}
						nodePro = nodePro.getNext();
					}
					
					System.out.println("\nSucesso!");
					System.out.println("Quantidade adicionada");
				}											
			}
			while(quantidade > estoque);		
		}
		
		public void setQuantidadeToRemove(int idPedido, Produto produto) {
				
			int quant = 1000000;
				
			Scanner entrada = new Scanner(System.in);
			
			Produto prodMerc = new Produto();
			
			for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
				if(p.getId() == produto.getId()) {
					prodMerc = p;
				}
			}
			
			int produtoId = prodMerc.getId();
			int estoque = prodMerc.getEstoque();
				
			do {
				
				System.out.println(prodMerc.print());
				System.out.println("\nSe lembre que o produto possui " + estoque + " de estoque..");
				
				System.out.println("\nInforme a quantidade que deseja remover: ");
					
				quant = entrada.nextInt();
					
				if(quant > estoque) {
					System.out.println("\nA quantidade informada excede o estoque do produto");
				}
				else if(quant == estoque) {								

					listaMercadoPedidos.find(idPedido).getValue().ListaProdutos.remove(prodMerc);
					
					System.out.println("\nProduto removido!");
						
					if(listaMercadoPedidos.find(idPedido).getValue().ListaProdutos.size() == 0) {
						System.out.println("\nNo pedido n�o ha mais produtos, ent�o ele ser� excluido!");
						listaMercadoPedidos.remove(idPedido);
					}
					
					//setando os itens de volta para o fornecedor
					NodeProduto nodePro = listaFornecedorProduto.getHead();
									
					while(nodePro != null) {
						if(nodePro.getValue().getId() == produtoId) {
							nodePro.getValue().setEstoque(nodePro.getValue().getEstoque() + quant);
						}
						nodePro = nodePro.getNext();
					}
					
					System.out.println("\nAs quantidades removida do produto foram devolvidas para o fornecedor!");
				}
				else {		
					
					float newPrice = 0;
					
					for (Produto p : listaMercadoPedidos.find(idPedido).getValue().ListaProdutos) {
						if(p.getId() == produtoId) {
							p.setEstoque(p.getEstoque() - quant);
						}	
						float precoTotalProduto = p.getPreco() * p.getEstoque();
						
						newPrice += precoTotalProduto;
					}
					
					listaMercadoPedidos.find(idPedido).getValue().setPreco(newPrice);
					
					System.out.println("\nProduto removido!");
					
					//setando os itens de volta para o fornecedor
					NodeProduto nodePro = listaFornecedorProduto.getHead();
					
					while(nodePro != null) {
						if(nodePro.getValue().getId() == produtoId) {
							nodePro.getValue().setEstoque(nodePro.getValue().getEstoque() + quant);
						}
						nodePro = nodePro.getNext();
					}
					
					System.out.println("\nAs quantidades removida do produto foram devolvidas para o fornecedor!");
						
					System.out.println("\nEstoque alterado! Veja a situa��o do pedido ");
					System.out.println(listaMercadoPedidos.printByPedidoId(idPedido));
				}
			}
			while(quant > estoque);
		}
		//Mercado - Editar Pedidos-----------------------------------------#	
		
		//Mercado - Listar Pedidos do Fornecedor Para o Mercado-----------------------------------------#
		public void listarProdutosDoFornecedorParaOMercado() {
			
			if(listaFornecedorProduto.getSize() > 0) {		
				out.println("\nLista Produtos do Fornecedor");
				
				out.println(listaFornecedorProduto.print());
			}
			else
			{
				System.out.println("\nNenhum produto cadastrado pelos fornecedores.");
				menuMercado();
			}				
		}
		//Mercado - Listar Pedidos do Fornecedor Para o Mercado-----------------------------------------#
		
		
	//Mercado - Fazer Fornecedores Atenderem os Pedidos do Mercado----------------------------------------#
	public void fazerFornecedoresAtenderemPedido() {
			
		if(listaMercadoPedidos.getSize() > 0) {		
			out.println("\n### Lista Pedidos Feitos");
				
			out.println(listaMercadoPedidos.print());
				
			System.out.println("\nOs pedidos que o seu mercado " + CurrentMercadoName + 
					" fez j� est�o na fila para serem atendidos..");
				
			System.out.println("\nFornecedores atendendo os pedidos..");
			System.out.println("\nCom isso, a lista de pedidos vai ser esvaziada!");
										
			System.out.println("\nFornecedores atendendo os pedidos..");
				
			while(!listaMercadoPedidos.isEmpty()) {
					
				int avaliacao = getRandomNumberInRange(1, 5);

				HistoricoPedido historicoPedido = 
					new HistoricoPedido(
							listaMercadoPedidos.getHead().getValue().Id, CurrentMercadoName, listaFornecedores.getHead().getValue().novoUsername, 
							avaliacao, listaMercadoPedidos.getHead().getValue().Preco, listaMercadoPedidos.getHead().getValue().ListaProdutos);
					
				listaAvaliacaoFornecedor.append(new Avaliacao(avaliacao, CurrentMercadoName));
							
				listaHistoricoPedido.append(historicoPedido);
				listaMercadoPedidos.removeFirst();							
			}
				
			System.out.println("\nProcesso finalizado!");
			System.out.println("\nTodos os pedidos foram atendidos");
				
			System.out.println("\nRedirecionando para MENU DO MERCADO: ");
		}
		else
		{
			out.println("\nNenhum pedido foi feito ainda..");
		}
	}
	//Mercado - Fazer Fornecedores Atenderem os Pedidos do Mercado----------------------------------------#
	
	
	//Mercado - Listar Pedidos Feitos (Hist�rico)-----------------------------------------#	
	public void listarPedidosFeitos() {
			
		if(listaHistoricoPedido.getSize() > 0) {	
			
			Scanner entrada = new Scanner(System.in);
						
			int option = 0;
			
			ArrayList<HistoricoPedido> arr = new ArrayList<HistoricoPedido>();
			
			arr = listaHistoricoPedido.getArrayList();
			
			do {
				
				out.println("\nLista Pedidos Atendidos (Hist�rico)");
				
				out.println(listaHistoricoPedido.print());
				
				out.println("\nOp��es");		
				out.println("1 - Comparar Pedidos por Pre�o (Ordem Crescente)");
				out.println("2 - Comparar Pedidos por Avaliacao (Ordem Crescente)");
				out.println("3 - Sair");
				
				option = entrada.nextInt();
				
				if(option == 1) {
					
					Collections.sort(arr, new SortPedidoByPrice());
						
					StringBuffer text = new StringBuffer();
						
					for (HistoricoPedido hist : arr) {
						text.append("\n" + "[");
						text.append("IdPedido: " + hist.IdPedido  + ", ");
						text.append("Pre�o: " + hist.Preco);
						text.append("] " + "\n");
					}
						
					System.out.println(text);
				}
				else if(option == 2) {
											
					StringBuffer text = new StringBuffer();
						
					Collections.sort(arr, new SortPedidoByAvaliation());
						
					for (HistoricoPedido hist : arr) {
						text.append("\n" + "[");
						text.append("IdPedido: " + hist.IdPedido  + ", ");
						text.append("Avalia��o: " + hist.Avaliacao);
						text.append("] " + "\n");
					}
						
					System.out.println(text);
				}	
			}
			while(option != 3);		
		}
		else
		{
			System.out.println("\nNenhum pedido foi atendido ainda.");
			menuMercado();
		}		
	}
	//Mercado - Listar Pedidos Feitos (Hist�rico)-----------------------------------------#	
	
	
	//Helpers
	private static int getRandomNumberInRange(int min, int max) {
        Random r = new Random();
        return r.nextInt((max - min) + 1) + min;
    }
}
