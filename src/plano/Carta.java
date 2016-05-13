package plano;

public class Carta implements Comparable<Carta>{
	
	private Naipe naipe;
	private int identificador;
	
	public Carta(){
		this.naipe = Naipe.NULO;
		this.identificador = 0;
	}
	
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
	@Override
	public String toString(){//////////////////////////////////////////////////método adicionado
		String str;
		str = new String("");
		switch(this.identificador){
			case 1:
				str = str.concat(CartaEspecial.A.name());
				break;
			case 11:
				str = str.concat(CartaEspecial.J.name());
				break;
			case 12:
				str = str.concat(CartaEspecial.Q.name());
				break;
			case 13:
				str = str.concat(CartaEspecial.K.name());
				break;
			default:	
				str = str.concat(Integer.toString(this.getIdentificador()));
				
		}
		str = str.concat(" ");
		str = str.concat(this.naipe.name());
		return str;
	}
}
