package plano;

import java.util.ArrayList;

public class Mao {
	
	private ArrayList<Carta> cartas;
	public static final int tamanhoMao = 5;
	
	public void addCarta(Carta carta) { //SET///////////////////////////////////////////////////método adicionado
		if(this.cartas.size() < 5) {
			this.cartas.add(carta);
		}
	}
	
	public Carta retiraCarta(int idCarta) { //GET///////////////////////////////////////////////método adicionado
		Carta carta = null;
		
		if(idCarta >= 0 && idCarta < this.cartas.size()) {
			carta = this.cartas.get(idCarta);
		}
		
		return carta;
	}
	
	public int getIdentificadorCarta(int id){
		Carta carta;
		carta = cartas.get(id);
		return carta.getIdentificador();
	}
	
	public Naipe getNaipeCarta(int id){
		Carta carta;
		carta = cartas.get(id);
		return carta.getNaipe();
	}
	
	public Carta getCarta(int id){
		Carta carta;
		carta = cartas.get(id);
		return carta;
	}
}