package TADs.Fornecedor;

import TADs.Fornecedor.Nodes.NodeFornecedor;

import entidades.Fornecedor.*;

public class ListaFornecedor {
	
	private NodeFornecedor head, tail;
	private int size;
	
	public ListaFornecedor() {
		head = tail = null;
		size = 0;
	}
	
	// Checa se a lista está vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	// Adiciona no final da lista.
	public void append(Fornecedor fornecedor) {
		Fornecedor fornecedorEntity = new Fornecedor(fornecedor.Id, fornecedor.novoUsername, fornecedor.senha, fornecedor.endereco, fornecedor.cep, fornecedor.contaBanco);
		
		NodeFornecedor nodeFornecedor = new NodeFornecedor(fornecedorEntity);
		
		if(isEmpty()) {
			head = tail = nodeFornecedor;
			size++;
		} else {
			tail.setNext(nodeFornecedor);
			tail = nodeFornecedor;
			size++;
		}
	}
	
	// Adiciona no inicio da lista.
	public void prepend(Fornecedor value) {
		NodeFornecedor node = new NodeFornecedor(value);
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
	public NodeFornecedor findFirst() {
		return head;
	}
	
	// Retorna o nó se encontrado, caso contrário retorna null.
	public NodeFornecedor find(String username, String senha) {
		NodeFornecedor currentNode = head;
		if (currentNode == null)
			return null;
		do {
			if(currentNode.getValue().novoUsername.equals(username) && currentNode.getValue().senha.equals(senha))
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
		
		NodeFornecedor current = head;
		
		if(head != null) {
			text += "]";
			text += "Nome: " + head.getValue().novoUsername + ", ";
			text += "CEP: " + head.getValue().cep;
			text += "] ";
			
			current = head.getNext();
			
			while (current.getNext() != null) {
				text += "\n[";
				text += "Nome: " + current.getValue().novoUsername + ", ";
				text += "CEP: " + current.getValue().cep;
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
	public NodeFornecedor getHead(){
		return head;
	} 

}
