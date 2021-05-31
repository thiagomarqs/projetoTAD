package entidades.Fornecedor;

import java.util.Comparator;

public class SortAvaliacao implements Comparator<Avaliacao> {
	
	public int compare(Avaliacao ava1, Avaliacao ava2)
	{    	
		return (int)ava1.Avaliacao - ava2.Avaliacao;
	} 

}
