package entidades.Pedido.Sort;

import java.util.Comparator;

import entidades.Pedido.*;

public class SortPedidoByPrice implements Comparator<HistoricoPedido> {
	
	public int compare(HistoricoPedido p1, HistoricoPedido p2)
    {    	
        return Math.round(p1.Preco - p2.Preco);
    }
}
