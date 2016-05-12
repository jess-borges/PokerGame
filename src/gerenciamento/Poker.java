package gerenciamento;

import java.util.ArrayList;
import plano.Jogador;
import plano.Carta;

public class Poker {
	
	private int numeroJogadores;
	private int estado;
	private int maiorAposta;
	private int dealer;
	private Baralho baralho;
	private ArrayList<Jogador> jogadores;
	
	public Poker(/*int numeroJogadores, ArrayList<String> nomesJogadores*/) {
		this.baralho = new Baralho();
	}
	
	public void jogar() {
		//
	}
	
	public void novaRodada() {
		this.estado = 0;
		this.dealer++; //fazer o módulo//////////////////////////////////////////////////////
	}
	
	/*private void identificaJogadores() {
		System.out.println("Quantos jogadores participarão? <2 - 6>:");
		Scanner reader = new Scanner(System.in);
		int n = reader.nextInt();
		reader.close(); //conferir se é realmente assim
		
		if (n < 2)
			n = 2;
		if (n > 7)
			n = 7;
		
		this.numeroJogadores = n;
		
		int i;
		
		for(i=0; i<n; i++) {
			//lê e armazena os nomes dos jogadores
		}
	}*/ // JESSSSSSSSSSS 
	
	private void distribuiCartas() {
		int i, j;
		Carta auxCarta;
		Jogador auxJogador;
		
		for(i=0; i<this.numeroJogadores; i++) {
			for(j=0; j<5; j++) {
				carta = this.baralho.pedeCarta();
				jogador = this.jogadores.get(i);
				jogador.mao
			}
		}
	}
	
	private void iniciaApostas() {
		//
	}
	
	private void primeiraAposta() {
		//
	}
	
	private void draw() {
		//
	}
	
	private void segundaAposta() {
		//
	}
}