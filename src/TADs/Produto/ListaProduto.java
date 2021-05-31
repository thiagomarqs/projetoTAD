package TADs.Produto;

import TADs.Produto.Nodes.*;

import entidades.Produto.*;

public class ListaProduto {
	
	private NodeProduto head, tail;
	private int size;
	
	public ListaProduto() {
		head = tail = null;
		size = 0;
	}
	
	// Checa se a lista esta vazia.
	public boolean isEmpty() {
		return size == 0;
	}

	// Adiciona no final da lista.
	public void append(Produto produto) {
		
		Produto produtoEntity = new Produto(produto.getId(), produto.getNome(), produto.getDescricao(), produto.getPreco(), produto.getEstoque(), produto.getFornecedorId());
		
		NodeProduto nodeProduto = new NodeProduto(produtoEntity);
		
		if(isEmpty()) {
			head = tail = nodeProduto;
			size++;
		} else {
			tail.setNext(nodeProduto);
			tail = nodeProduto;
			size++;
		}
	}
	
	// Adiciona no inicio da lista.
	public void prepend(Produto value) {
		NodeProduto node = new NodeProduto(value);
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
	public void remove(int produtoId) {
		System.out.println(produtoId);
		if(isEmpty())
			return;
		
		else if(head.getValue().getId() == produtoId) {
			head = head.getNext();
			size--;
			return;			
		} 
	}
	
	
	// Retorna o primeiro nó.
	public NodeProduto findFirst() {
		return head;
	}
	
	// Retorna um nó se encontrado, caso contrário retorna null.
	public NodeProduto find(int produtoId) {
		NodeProduto currentNode = head;
		if (currentNode == null)
			return null;
		do {
			if(currentNode.getValue().getId() == produtoId)
				return currentNode;
			else
				currentNode = currentNode.getNext();
		}
		while(currentNode != null);
		
		return null;
		
	}
	
	// Retorna um nó se encontrado, caso contrário retorna null.
	public void updateEstoque(int produtoId, int quantidade) {
		
		NodeProduto currentNode = head;
		
		if (currentNode == null) {	
			do {
				Produto produto = currentNode.getValue();
				
				if(produto.getId() == produtoId) {
					
					int novoEstoque = produto.getEstoque() - quantidade;
										
					currentNode.getValue().setEstoque(novoEstoque);
				}				
				else {
					currentNode = currentNode.getNext();
				}
					
			}	
			while(currentNode != null);
		}	
	}
	
	// Retorna um nó se encontrado, caso contrário retorna null.
	public void updateEstoqueMercado(int produtoId, int quantidade) {
			
		NodeProduto currentNode = head;
			
		if (currentNode == null) {	
			do {
				Produto produto = currentNode.getValue();
					
				if(produto.getId() == produtoId) {						
					produto.setEstoque(quantidade);
				}				
				else {
					currentNode = currentNode.getNext();
				}
						
			}	
			while(currentNode != null);
		}	
	}
		
	
	// Printa a lista.
	public String print() {
		StringBuffer text = new StringBuffer();
		
		NodeProduto current;
		
		if(head != null) {	
			text.append("[");
			text.append("Id: " + head.getValue().getId() + ", ");
			text.append("Fornecedor Id: " + head.getValue().getFornecedorId() + ", ");
			text.append("Nome: " + head.getValue().getNome() + ", ");
			text.append("Descricao: " + head.getValue().getDescricao() + ", ");
			text.append("Preco: " + head.getValue().getPreco() + ", ");
			text.append("Quantidade: " + head.getValue().getEstoque());
			text.append("] ");
			
			current = head.getNext();
			
			while (current != null) {
				text.append("\n[");
				text.append("Id: " + current.getValue().getId() + ", ");
				text.append("Fornecedor Id: " + head.getValue().getFornecedorId() + ", ");
				text.append("Nome: " + current.getValue().getNome() + ", ");
				text.append("Descricao: " + current.getValue().getDescricao() + ", ");
				text.append("Preco: " + current.getValue().getPreco() + ", ");
				text.append("Quantidade: " + current.getValue().getEstoque());
				text.append("] ");
				current = current.getNext();
			}
		}	
		
		return text.toString();		
	}
	
	// Retorna o tamanho da lista.
	public int getSize() {
		return size;
	}
	
	public NodeProduto getHead(){
		return head;
	} 

}
