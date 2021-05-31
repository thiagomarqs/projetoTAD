package TADs.Fornecedor.Nodes;

import entidades.Fornecedor.*;

public class NodeAvaliacaoFornecedor {

	private Avaliacao value;
	private NodeAvaliacaoFornecedor next;
	
	public NodeAvaliacaoFornecedor(Avaliacao value, NodeAvaliacaoFornecedor next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeAvaliacaoFornecedor(Avaliacao value) {
		this.value = value;
	}
	
	public Avaliacao getValue() {
		return value;
	}

	public void setValue(Avaliacao value) {
		this.value = value;
	}

	public NodeAvaliacaoFornecedor getNext() {
		return next;
	}

	public void setNext(NodeAvaliacaoFornecedor next) {
		this.next = next;
	}
}
