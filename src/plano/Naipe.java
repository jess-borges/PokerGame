package plano;

public enum Naipe {
	COPAS(1), 
	ESPADAS(2), 
	OURO(3),
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
