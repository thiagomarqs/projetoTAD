package TADs.Mercado.Nodes;

import entidades.Mercado.*;

public class NodeMercado {
	
	private Mercado value;
	private NodeMercado next;
	
	public NodeMercado(Mercado value, NodeMercado next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeMercado(Mercado value) {
		this.value = value;
	}
	
	public Mercado getValue() {
		return value;
	}

	public void setValue(Mercado value) {
		this.value = value;
	}

	public NodeMercado getNext() {
		return next;
	}

	public void setNext(NodeMercado next) {
		this.next = next;
	}
}
