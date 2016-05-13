package plano;

public enum CartaEspecial {
	A(1),
	J(11),
	Q(12),
	K(13);
	
	private int valor;
	
	private CartaEspecial(int valor){
		this.valor = valor;
	}
	
	public int getValor(){
		return this.valor;
	}
}
