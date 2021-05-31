package TADs.Pedido;

import java.util.ArrayList;

import entidades.Pedido.*;
import entidades.Produto.*;
import TADs.Pedido.Nodes.*;

public class ListaHistoricoPedido {
	
	private NodeHistoricoPedido head, tail;
	private int size;
	
	public ListaHistoricoPedido() {
		head = tail = null;
		size = 0;
	}
	
	//Checa se a lista esta vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	//Adiciona ao final da lista.
	public void append(HistoricoPedido historico) {
			
		HistoricoPedido historicoPedido = new HistoricoPedido(historico.IdPedido, historico.NomeMercado, historico.NomeFornecedor, historico.Avaliacao, historico.Preco, historico.ListaProdutos);
			
		NodeHistoricoPedido nodeHistorico = new NodeHistoricoPedido(historicoPedido);
			
		if(isEmpty()) {
			head = tail = nodeHistorico;
			size++;
		} else {
			tail.setNext(nodeHistorico);
			tail = nodeHistorico;
			size++;
		}
	}
	
	// Adiciona ao inicio da lista.
	public void prepend(HistoricoPedido value) {
		NodeHistoricoPedido node = new NodeHistoricoPedido(value);
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
	
	// Remove o head com base no valor passado.
	public void remove(String nomeFornecedor) {
		if(isEmpty())
			return;
		
		else if(head.getValue().NomeFornecedor.equals(nomeFornecedor)) {
			head = head.getNext();
			size--;
			return;			
		} 
	}
	
	
	// Retorna o primeiro nó.
	public NodeHistoricoPedido findFirst() {
		return head;
	}
	
	// Retorna o nó se encontrado, caso contrário retorna null.
	public NodeHistoricoPedido find(String nomeFornecedor) {
		
		NodeHistoricoPedido currentNode = head;
		
		if (currentNode == null)
			return null;
		do {
			if(currentNode.getValue().NomeFornecedor.equals(nomeFornecedor))
				return currentNode;
			else
				currentNode = currentNode.getNext();
		}
		while(currentNode != null);
		
		return null;	
	}
	
	// Printa a lista.
	public String print() {
		
		StringBuffer text = new StringBuffer();
	
		NodeHistoricoPedido current;
		
		if(head != null) {	
			text.append("[");
			text.append("IdPedido: " + head.getValue().IdPedido  + ", ");
			text.append("NomeFornecedor: " + head.getValue().NomeFornecedor  + ", ");
			text.append("NomeMercado: " + head.getValue().NomeMercado  + ", ");
			text.append("Preço: " + head.getValue().Preco  + ", ");
			text.append("Avaliação: " + head.getValue().Avaliacao);
			text.append("] ");
			text.append("\n");
			
			text.append("\nLista de produtos" + "\n");
			
			
			for (Produto produto : head.getValue().ListaProdutos) {
				text.append("[");
				text.append("Id: " + produto.getId()  + ", ");
				text.append("Fornecedor Id: " + produto.getFornecedorId() + ", ");
				text.append("Nome: " + produto.getNome()  + ", ");
				text.append("Descrição: " + produto.getDescricao()  + ", ");
				text.append("Preço: " + produto.getPreco()  + ", ");
				text.append("Quantidade: " + produto.getEstoque());
				text.append("] " + "\n");
			}
					
			current = head.getNext();
			
			if(current != null) {
				while (current != null) {		
					text.append("\n[");
					text.append("IdPedido: " + current.getValue().IdPedido + ", ");
					text.append("NomeFornecedor: " + current.getValue().NomeFornecedor + ", ");
					text.append("NomeMercado: " + current.getValue().NomeMercado + ", ");
					text.append("Preço: " + current.getValue().Preco  + ", ");
					text.append("Avaliação: " + current.getValue().Avaliacao);
					text.append("] ");
					text.append("\n");
					
					text.append("\nLista de produtos" + "\n");
						
					for (Produto produto : current.getValue().ListaProdutos) {
						text.append("[");
						text.append("Id: " + produto.getId()  + ", ");
						text.append("Fornecedor Id: " + produto.getFornecedorId() + ", ");
						text.append("Nome: " + produto.getNome()  + ", ");
						text.append("Descrição: " + produto.getDescricao()  + ", ");
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
	
	public ArrayList<HistoricoPedido> getArrayList() {
				
		NodeHistoricoPedido current;
		
		ArrayList<HistoricoPedido> arr = new ArrayList<HistoricoPedido>();
		
		if(head != null) {
			
			arr.add(head.getValue());
			
			current = head.getNext();
			
			while (current != null) {	
					
				arr.add(current.getValue());
					
				current = current.getNext();
			}			
		}
		
		return arr;
	}
	
	// Retorna o tamanho da lista.
	public int getSize() {
		return size;
	}
	
	// Retorna o head da lista.
	public NodeHistoricoPedido getHead(){
		return head;
	} 
}
