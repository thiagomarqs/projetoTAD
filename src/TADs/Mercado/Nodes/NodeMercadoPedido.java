package TADs.Mercado.Nodes;

import entidades.Pedido.*;

public class NodeMercadoPedido {
	
	private Pedido value;
	private NodeMercadoPedido next;
	
	public NodeMercadoPedido() {
	}
	
	public NodeMercadoPedido(Pedido value, NodeMercadoPedido next) {
		this.value = value;
		this.next = next;
	}
	
	public NodeMercadoPedido(Pedido value) {
		this.value = value;
	}
	
	public Pedido getValue() {
		return value;
	}

	public void setValue(Pedido value) {
		this.value = value;
	}

	public NodeMercadoPedido getNext() {
		return next;
	}

	public void setNext(NodeMercadoPedido next) {
		this.next = next;
	}
}
