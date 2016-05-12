package plano;

public class Carta {
	
	private Naipe naipe;
	private int identificador;
	
	public Carta(Naipe naipe, int identificador) { 
		this.naipe = naipe;
		this.identificador = identificador;
	}
	
	public Naipe getNaipe() { 
		return this.naipe;
	}
	
	public int getIdentificador() { 
		return this.identificador;
	}

	public void setNaipe(Naipe naipe) { 
		this.naipe = naipe;
	}
	
	public void setIdentificador(int identificador) {
		this.identificador = identificador;
	}
}
