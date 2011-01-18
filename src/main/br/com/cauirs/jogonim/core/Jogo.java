package br.com.cauirs.jogonim.core;
import java.util.Random;

import br.com.cauirs.jogonim.excecoes.JogadaInvalida;


public class Jogo {
	
	public static final int MAXIMO_JOGADORES = 2;
	
	public Jogo(Jogador primeiroJogador, Jogador segundoJogador)
	{
		this.pilhaDeBolas = new PilhaBolas( sortearNumeroDeBolas() );
		this.primeiroJogador = primeiroJogador;
		this.segundoJogador = segundoJogador;
		
		sortearQuemComecaOJogo();
	}
	
	private PilhaBolas pilhaDeBolas;
	
	private Jogador primeiroJogador;
	private Jogador segundoJogador;
	
	private Jogador jogadorDaVez;
	
	public int jogar() throws JogadaInvalida
	{
		int bolasRetiradas = jogadorDaVez.jogar( pilhaDeBolas );
		return bolasRetiradas;
	}
	
	public int sortearNumeroDeBolas()
	{
		Random randonomico = new Random();
		return randonomico.nextInt(90) + 10;
	}
	
	public PilhaBolas getPilhaDeBolas() 
	{
		return pilhaDeBolas;
	}

	public void sortearQuemComecaOJogo() 
	{
		Random randonomico = new Random();
		int numeroJogador = randonomico.nextInt(MAXIMO_JOGADORES) + 1;
		
		if( numeroJogador == 1 )
			jogadorDaVez = primeiroJogador;
		else
			jogadorDaVez = segundoJogador;
	}
	
	public void passarAVez()
	{
		if( jogadorDaVez.equals(primeiroJogador) )
			jogadorDaVez = segundoJogador;
		else
			jogadorDaVez = primeiroJogador;
	}

	public Jogador getJogadorDaVez() 
	{
		return jogadorDaVez;
	}

	public boolean chegouAoFim() 
	{
		return pilhaDeBolas.getNumeroBolas() == 0;
	}
	
}