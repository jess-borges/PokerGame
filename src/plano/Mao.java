package plano;

import java.util.ArrayList;
import java.util.Collections;

public class Mao {
	
	private ArrayList<Carta> cartas;
	public static final int tamanhoMao = 5;
	
	public void addCarta(Carta carta) { //SET///////////////////////////////////////////////////método adicionado
		if(this.cartas.size() < Mao.tamanhoMao) {
			this.cartas.add(carta);
		}
		/* Mantem as cartas dao mao ordenadas a partir do fim da distribuicao das cartas*/
		if (this.cartas.size() == Mao.tamanhoMao){ 
			Collections.sort(this.cartas);
		}
	}
	
	public Carta retiraCarta(int idCarta) { //GET///////////////////////////////////////////////método adicionado
		Carta carta = null;
		
		if(idCarta >= 0 && idCarta < this.cartas.size()) {
			carta = this.cartas.remove(idCarta);
		}
		
		return carta;
	}
	
	public int getIdentificadorCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta.getIdentificador();
	}
	
	public Naipe getNaipeCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta.getNaipe();
	}
	
	public Carta getCarta(int id){//////////////////////////////////////////////////método adicionado
		Carta carta;
		carta = cartas.get(id);
		return carta;
	}
	
	public boolean estaEmSequencia(){//////////////////////////////////////////////////método adicionado
		int i; 
		for (i = 0; i < Mao.tamanhoMao-1; i++){
			if (getCarta(i).getIdentificador() != (getCarta(i+1).getIdentificador() + 1)){
				return false;				
			}
		}
		return true;
	}
	
	public Carta getMenorCarta(){//////////////////////////////////////////////////método adicionado		
		return this.cartas.get(Mao.tamanhoMao - 1);
	}
	public Carta getMaiorCarta(){//////////////////////////////////////////////////método adicionado
		return this.cartas.get(0);
	}
}