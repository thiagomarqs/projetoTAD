package TADs.Pedido.Nodes;

import entidades.Pedido.*;

public class NodeHistoricoPedido {
	
	private HistoricoPedido value;
	private NodeHistoricoPedido next;
		
	public NodeHistoricoPedido(HistoricoPedido value, NodeHistoricoPedido next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeHistoricoPedido(HistoricoPedido value) {
		this.value = value;
	}
	
	public HistoricoPedido getValue() {
		return value;
	}

	public void setValue(HistoricoPedido value) {
		this.value = value;
	}

	public NodeHistoricoPedido getNext() {
		return next;
	}

	public void setNext(NodeHistoricoPedido next) {
		this.next = next;
	}
}
