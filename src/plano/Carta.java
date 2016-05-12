package plano;

public class Carta {
	
	private int naipe;
	private int identificador;
	
	public Carta(int naipe, int identificador) { 
		this.naipe = naipe;
		this.identificador = identificador;
	}
	
	public int getNaipe() { 
		return this.naipe;
	}
	
	public int getIdentificador() { 
		return this.identificador;
	}

	public void setNaipe(int naipe) { 
		this.naipe = naipe;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
