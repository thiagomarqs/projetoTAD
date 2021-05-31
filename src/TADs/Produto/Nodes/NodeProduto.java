package TADs.Produto.Nodes;

import entidades.Produto.*;

public class NodeProduto {
	
	private Produto value;
	private NodeProduto next;
	
	public NodeProduto() {
	}
	
	public NodeProduto(Produto value, NodeProduto next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeProduto(Produto value) {
		this.value = value;
	}
	
	public Produto getValue() {
		return value;
	}

	public void setValue(Produto value) {
		this.value = value;
	}

	public NodeProduto getNext() {
		return next;
	}

	public void setNext(NodeProduto next) {
		this.next = next;
	}
}
