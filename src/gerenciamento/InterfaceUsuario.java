package gerenciamento;

import java.util.ArrayList;
import java.util.Scanner;

import plano.Jogador;
import plano.Carta;
import plano.Jogador;
import gerenciamento.Comando;

public class InterfaceUsuario {
	/////////////JESS ALTERANDO////////////////////////////////////////////////////
	
	static String stringCorrente;
	static Scanner scanner = new Scanner(System.in);
	
	public static void printBoasVindas() {
		String str, entrada;
		Comando comando;
		
		str = new String("");
		str = str.concat("\nWelcome to Poker 5-Cards Draw. \n Type:");
		str = str.concat("\n\n RULES: check the rules and commands before playing");
		str = str.concat("\n\n PLAY: play! \n\n>");
		System.out.println(str);
		
		entrada = InterfaceUsuario.scanner.next();
		if (entrada.startsWith(Comando.RULES.name())){
			comando = Comando.RULES;
			/* chama metodo que mostra as regras */
		}
		else{
			if (entrada.startsWith(Comando.PLAY.name())){
				comando = Comando.PLAY;
				/* simplesmente termina as boas vindas para que se possa jogar */
			}
			else{
				comando = Comando.INVALID;
				System.out.println("\nThe type is invalid. Try again!\n");
				InterfaceUsuario.printBoasVindas();
			}
		}		
	}
	
	public static int getNumeroJogadores() {
		int entrada;
		
		System.out.println("\n\nLet\'s register the players. \nHow many players? ");
		entrada = InterfaceUsuario.scanner.nextInt();
		return entrada;		
	}
	
	public static String getNomeJogador(int id) {/////////////////////////////////////////////////////////////////////////////////modificado
		String entrada;
		System.out.println("\nName of " + id + "th player:" );
		entrada = InterfaceUsuario.scanner.next();
		return entrada;
	}
	
	public static int getNumeroFichasPilha() {
		int entrada;
		System.out.println("\nHow many poker chips you want the players to start with? ");
		entrada = InterfaceUsuario.scanner.nextInt();
		return entrada;
	}
	
	public static void printQuadroJogadores(ArrayList<Jogador> jogadores, int idDealer) {
		int i, numeroJogadores, espacamento;
		Jogador jogador;
		
		
		numeroJogadores = jogadores.size();
		espacamento = 10;
		for(i = 0; i < numeroJogadores; i++) {
			jogador = jogadores.get((idDealer + 3 + i) % numeroJogadores);
			/* escrever quadro */
		}
	}
	
	/* Mostra as apostas de cada jogador a partir do small blind (que joga logo depois do dealer) */
	public static void printApostas(int pote, ArrayList<Jogador> jogadores, int idDealer) {//////////modificada////////////////
		int i, numeroJogadores;
		Jogador jogador;
		
		
		System.out.println("\n--Apostas--");
		numeroJogadores = jogadores.size();
		for(i = 0; i < numeroJogadores; i++) {
			jogador = jogadores.get((idDealer + i - 1 ) % numeroJogadores);
			System.out.println("\n" + jogador.getNome() + ": " + (jogador.getPote()));
		}
		
	}
	
	public static Comando decifraComando(Jogador jogador) { ///////////////////////////////////////////////////////////////////////
		
	}
	
	public static int getRaise() { 
		//
	}
 	
	public static ArrayList<Integer> getCartasDraw() { ////////////////////////////////////////////////////////////////////////////////
		//
	}
	
	public static void printPote(int pote, int apostaMaxima) {
		//
	}
	
	public static void printShowDown(ArrayList<Jogador> jogadores, int idVencedor, int pote) {
		//
	}
}
