package plano;

public enum CartaEspecial {	
	J(11),
	Q(12),
	K(13),
	A(1);
	
	private int valor;
	
	private CartaEspecial(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
