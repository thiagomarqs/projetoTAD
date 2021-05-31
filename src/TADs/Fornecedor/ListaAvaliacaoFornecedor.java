package TADs.Fornecedor;

import java.util.ArrayList;

import TADs.Fornecedor.Nodes.*;
import TADs.Pedido.Nodes.NodeHistoricoPedido;
import entidades.Fornecedor.*;
import entidades.Pedido.HistoricoPedido;

public class ListaAvaliacaoFornecedor {
	
	private NodeAvaliacaoFornecedor head, tail;
	private int size;
	
	public ListaAvaliacaoFornecedor() {
		head = tail = null;
		size = 0;
	}
	
	// Checa se a lista esta vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	// Adiciona ao final da lista.
	public void append(Avaliacao avaliacao) {
			
		Avaliacao avalia = new Avaliacao(avaliacao.Avaliacao, avaliacao.NomeMercado);
			
		NodeAvaliacaoFornecedor nodeAva = new NodeAvaliacaoFornecedor(avalia);
			
		if(isEmpty()) {
			head = tail = nodeAva;
			size++;
		} else {
			tail.setNext(nodeAva);
			tail = nodeAva;
			size++;
		}
	}
	
	// Adiciona ao inicio da lista.
	public void prepend(Avaliacao value) {
		NodeAvaliacaoFornecedor node = new NodeAvaliacaoFornecedor(value);
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
	public NodeAvaliacaoFornecedor findFirst() {
		return head;
	}
	
	// Printa a lista.
	public String print() {
		
		StringBuffer text = new StringBuffer();
		
		NodeAvaliacaoFornecedor current;
		
		if(head != null) {
			Avaliacao value = head.getValue();
			
			text.append("[");
			text.append("Avaliacao: " + value.Avaliacao  + ", ");
			text.append("NomeMercado: " + value.NomeMercado);
			text.append( "] ");
												
			current = head.getNext();
				
			while (current != null) {	
				
				Avaliacao avalia = current.getValue();
					
				text.append("\n" + "[");
				text.append("Avaliacao: " + avalia.Avaliacao  + ", ");
				text.append("NomeMercado: " + avalia.NomeMercado);
				text.append("] ");
				
				current = current.getNext();
			}			
		}
		
		return text.toString();	
	}
	
	public ArrayList<Avaliacao> getArrayList() {
		
		NodeAvaliacaoFornecedor current;
		
		ArrayList<Avaliacao> arr = new ArrayList<Avaliacao>();
		
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
	public NodeAvaliacaoFornecedor getHead(){
		return head;
	} 

}
