package TADs.Mercado;

import java.util.ArrayList;
import java.util.List;

import TADs.Mercado.Nodes.NodeMercadoPedido;

import entidades.Mercado.*;
import entidades.Pedido.*;
import entidades.Produto.Produto;

public class ListaMercadoPedido {
	
	private NodeMercadoPedido head, tail;
	private int size;
	
	public ListaMercadoPedido() {
		head = tail = null;
		size = 0;
	}
	
	// Checa se a lista está vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	// Adiciona no final da lista.
	public void append(Pedido pedido) {
		
		Pedido pedi = new Pedido(pedido.Id, pedido.ListaProdutos, pedido.Status, pedido.Preco, pedido.IdMercado);
		
		System.out.println(pedi.Id);
		
		NodeMercadoPedido nodeMercado = new NodeMercadoPedido(pedi);
		
		if(isEmpty()) {
			head = tail = nodeMercado;
			size++;
		} else {
			tail.setNext(nodeMercado);
			tail = nodeMercado;
			size++;
		}
	}
	
	// Adiciona no inicio da lista.
	public void prepend(Pedido value) {
		NodeMercadoPedido node = new NodeMercadoPedido(value);
		
		if(isEmpty()){
			head = tail = node;
			size++;
		} else {
			node.setNext(head);
			head = node;
			size++;
		}
	}
	
	// Remove o head.
	public void removeFirst() {
		if(isEmpty())
			return;
		if(size == 1){
			head = tail = null;
			size--;
			return;
		}
		head = head.getNext();
		size--;
	}
		
	// Retorna o primeiro nó.
	public NodeMercadoPedido findFirst() {
		return head;
	}
	
	// Retorna o nó se encontrado, caso contrário retorna null.
	public NodeMercadoPedido find(int id) {
		
		List<NodeMercadoPedido> nodes = new ArrayList<NodeMercadoPedido>();
		
		NodeMercadoPedido currentNode = getHead();
		
		if (getHead() == null)
			return null;
		do {
			if(currentNode.getValue().Id == id)
				return currentNode;
			else
				currentNode = currentNode.getNext();
		}
		while(currentNode != null);
		
		return null;		
	}
	
	// Remove o head com base no valor passado.
	public void remove(int pedidoId) {
		if(isEmpty())
			return;
		
		else if(head.getValue().Id == pedidoId) {
			head = head.getNext();
			size--;
			return;			
		} 
	}
	
	// Printa a lista.
	public String print() {
		StringBuffer text = new StringBuffer();
		
		NodeMercadoPedido current;
		
		if(head != null) {	
			
			text.append("[");
			text.append("Id: " + head.getValue().Id + ", ");
			text.append("MercadoId: " + head.getValue().IdMercado + ", ");
			text.append("Preço Total: " + head.getValue().Preco + ", ");
			text.append("Status: " + head.getValue().Status);
			text.append("] ");
			text.append("\n");
			
			text.append("\nLista de produtos" + "\n");
			
			for (Produto produto : head.getValue().ListaProdutos) {
				text.append("[");
				text.append("Id: " + produto.getId()  + ", ");
				text.append("FornecedorId: " + produto.getFornecedorId() + ", ");
				text.append("Nome: " + produto.getNome()  + ", ");
				text.append("Descrição: " + produto.getDescricao()  + ", ");
				text.append("Preço: " + produto.getPreco()  + ", ");
				text.append("Quantidade: " + produto.getEstoque());
				text.append("] " + "\n");
			}
			
			text.append("\n");
			
			current = head.getNext();
			
			if(current != null) {
				while (current != null) {
					text.append("[");
					text.append("Id: " + current.getValue().Id + ", ");
					text.append("MercadoId: " + current.getValue().IdMercado + ", ");
					text.append("Preço Total: " + current.getValue().Preco + ", ");
					text.append("Status: " + current.getValue().Status);
					text.append("] ");
					text.append("\n");
					text.append("\nLista de produtos" + "\n");
					
					for (Produto produto : current.getValue().ListaProdutos) {
						text.append("[");
						text.append("Id: " + produto.getId()  + ", ");
						text.append("FornecedorId: " + produto.getFornecedorId() + ", ");
						text.append("Nome: " + produto.getNome()  + ", ");
						text.append("Descrição: " + produto.getDescricao()   + ", ");
						text.append("Preço: " + produto.getPreco()  + ", ");
						text.append("Quantidade: " + produto.getEstoque());
						text.append("] " + "\n");
					}
					
					current = current.getNext();
				}
			}
		}

		return text.toString();		
	}
	
	// Printa a lista.
	public String printByPedidoId(int pedidoId) {
		StringBuffer text = new StringBuffer();
		
		NodeMercadoPedido current;
		
		if(head != null) {	
			
			if(head.getValue().Id == pedidoId) {
				text.append("[");
				text.append("Id: " + head.getValue().Id + ", ");
				text.append("MercadoId: " + head.getValue().IdMercado + ", ");
				text.append("Preço Total: " + head.getValue().Preco + ", ");
				text.append("Status: " + head.getValue().Status);
				text.append("] ");
				text.append("\n");
				
				text.append("\nLista de produtos" + "\n");
				
				for (Produto produto : head.getValue().ListaProdutos) {
					text.append("[");
					text.append("Id: " + produto.getId()  + ", ");
					text.append("FornecedorId: " + produto.getFornecedorId() + ", ");
					text.append("Nome: " + produto.getNome()  + ", ");
					text.append("Descrição: " + produto.getDescricao()  + ", ");
					text.append("Preço: " + produto.getPreco()  + ", ");
					text.append("Quantidade: " + produto.getEstoque());
					text.append("] " + "\n");
					text.append("\n");
				}
				
				text.append("\n");
			}
			
			current = head.getNext();
			
			if(current != null) {
				
				while (current != null) {
					
					if(current.getValue().Id == pedidoId) {
						text.append("[");
						text.append("Id: " + current.getValue().Id + ", ");
						text.append("MercadoId: " + current.getValue().IdMercado + ", ");
						text.append("Preço Total: " + current.getValue().Preco + ", ");
						text.append("Status: " + current.getValue().Status);
						text.append("] ");
						text.append("\n");
						text.append("\nLista de produtos" + "\n");
						
						for (Produto produto : current.getValue().ListaProdutos) {
							text.append("[");
							text.append("Id: " + produto.getId()  + ", ");
							text.append("FornecedorId: " + produto.getFornecedorId() + ", ");
							text.append("Nome: " + produto.getNome()  + ", ");
							text.append("Descrição: " + produto.getDescricao()   + ", ");
							text.append("Preço: " + produto.getPreco()  + ", ");
							text.append("Quantidade: " + produto.getEstoque());
							text.append("] " + "\n");
							text.append("\n");
						}
					}
					
					current = current.getNext();
				}		
			}
		}

		return text.toString();		
	}
	
	// Retorna o tamanho da lista.
	public int getSize() {
		return size;
	}
	
	// Retorna o head da lista.
	public NodeMercadoPedido getHead(){
		return head;
	} 

}
