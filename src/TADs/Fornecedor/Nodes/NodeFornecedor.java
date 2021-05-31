package TADs.Fornecedor.Nodes;

import entidades.Fornecedor.*;

public class NodeFornecedor {
	
	private Fornecedor value;
	private NodeFornecedor next;
	
	public NodeFornecedor(Fornecedor value, NodeFornecedor next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeFornecedor(Fornecedor value) {
		this.value = value;
	}
	
	public Fornecedor getValue() {
		return value;
	}

	public void setValue(Fornecedor value) {
		this.value = value;
	}

	public NodeFornecedor getNext() {
		return next;
	}

	public void setNext(NodeFornecedor next) {
		this.next = next;
	}
}
