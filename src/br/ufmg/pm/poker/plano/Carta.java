package br.ufmg.pm.poker.plano;

public class Carta {
	
	private int naipe;
	private int identificador;
	
	public Carta(int naipe, int identificador) { //método adicionado//////////////////////////////////////////////////
		this.naipe = naipe;
		this.identificador = identificador;
	}
	
	public int getNaipe() { //método adicionado//////////////////////////////////////////////////////////////////////
		return this.naipe;
	}
	
	public int getIdentificador() { //método adicionado//////////////////////////////////////////////////////////////
		return this.identificador;
	}

	public void setNaipe(int naipe) { //método adicionado////////////////////////////////////////////////////////////
		this.naipe = naipe;
	}
	
	public void setIdentificador(int identificador) { //método adicionado////////////////////////////////////////////
		this.identificador = identificador;
	}
}
