package TADs.Mercado;

import TADs.Mercado.Nodes.*;
import entidades.Mercado.*;

public class ListaMercado {

	private NodeMercado head, tail;
	private int size;
	
	public ListaMercado() {
		head = tail = null;
		size = 0;
	}
	
	// Checa se a lista está vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	// Adiciona no final da lista.
	public void append(Mercado mercado) {
		
		Mercado mercadoEntity = new Mercado(mercado.Id, mercado.Nome, mercado.Cnpj, mercado.Endereco);
		
		NodeMercado nodeMercado = new NodeMercado(mercadoEntity);
		
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
	public void prepend(Mercado value) {
		NodeMercado node = new NodeMercado(value);
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
	public NodeMercado findFirst() {
		return head;
	}
	
	// Retorna o nó se encontrado, caso contrário retorna null.
	public NodeMercado find(String cnpj) {
		NodeMercado currentNode = head;
		if (currentNode == null)
			return null;
		do {
			if(currentNode.getValue().Cnpj.equals(cnpj))
				return currentNode;
			else
				currentNode = currentNode.getNext();
		}
		while(currentNode != null);
		
		return null;		
	}
	
	// Printa a lista.
	public String print() {
		String text = "";
		
		NodeMercado current;
		
		if(head != null) {	
			text += "[";
			text += "Cnpj: " + head.getValue().Cnpj + ", ";
			text += "Nome: " + head.getValue().Nome;
			text += "] ";
			
			current = head.getNext();
			
			while (current != null) {
				text += "\n[";
				text += "Cnpj: " + current.getValue().Cnpj + ", ";
				text += "Nome: " + current.getValue().Nome;
				text += "] ";
				current = current.getNext();
			}
		}

		return text;		
	}
	
	// Retorna o tamanho da lista.
	public int getSize() {
		return size;
	}
	
	// Retorna o head da lista.
	public NodeMercado getHead(){
		return head;
	} 
}
