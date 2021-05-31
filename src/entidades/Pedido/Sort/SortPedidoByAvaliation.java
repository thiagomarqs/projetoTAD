package entidades.Pedido.Sort;

import java.util.Comparator;

import entidades.Pedido.*;

public class SortPedidoByAvaliation implements Comparator<HistoricoPedido> {
	
	public int compare(HistoricoPedido p1, HistoricoPedido p2)
	{    	
		return (int)p1.Avaliacao - p2.Avaliacao;
	} 
}
