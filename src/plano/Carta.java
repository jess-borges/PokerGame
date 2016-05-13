package plano;

public class Carta implements Comparable<Carta>{
	
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
	
	public int compareTo(Carta carta){
		if (this.getIdentificador() < carta.getIdentificador()) {
            return -1;
        }
        if (this.getIdentificador() > carta.getIdentificador()) {
            return 1;
        }
        return 0;
	}
}
