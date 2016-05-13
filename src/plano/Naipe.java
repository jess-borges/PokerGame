package plano;

public enum Naipe {
	NULO(0), /* para definir um carta nula, uma carta que será diferente de todas as cartas */
	COPAS(1), 
	ESPADAS(2), 
	OUROS(3),
	PAUS(4); 
	
	/*
	 * Definir ordem, o valor do naipe vai ser importante para comparar por naipe*/
	private int valor;
	
	private Naipe(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
