package br.com.cauirs.jogonim.core;

import br.com.cauirs.jogonim.excecoes.JogadaInvalida;

public class PilhaBolas {

	public static final int MAXIMO_BOLAS = 100;
	public static final int MINIMO_BOLAS = 10;
	public static final int MENOR_JOGADA_POSSIVEL = 1;
	
	private int numeroBolas;

	public PilhaBolas(int numeroBolas) 
	{
		if( numeroBolas < MINIMO_BOLAS )
			throw new RuntimeException("Não pode iniciar a pilha com menos do que 10 bolas.");
		else if( numeroBolas > MAXIMO_BOLAS )
			throw new RuntimeException("Não pode iniciar a pilha com mais do que 100 bolas.");
			
		this.numeroBolas = numeroBolas;
	}

	public void retirarBola(int quantidadeBolasRetiradas) throws JogadaInvalida 
	{
		if( quantidadeBolasRetiradas < MENOR_JOGADA_POSSIVEL )
			throw new JogadaInvalida("Não pode retirar da pilha menos do que uma bola.");
		else if( quantidadeBolasRetiradas > getJogadaMaxima() )
			throw new JogadaInvalida("Não pode retirar da pilha mais do que a metade do numero de bolas da pilha.");
		
		this.numeroBolas -= quantidadeBolasRetiradas;
	}
	
	public int getJogadaMaxima()
	{
		int maximoDeBolas = numeroBolas / 2;
		
		if( maximoDeBolas < MENOR_JOGADA_POSSIVEL )
			maximoDeBolas = MENOR_JOGADA_POSSIVEL;
		
		return maximoDeBolas;
	}
	
	public int getNumeroBolas() 
	{
		return numeroBolas;
	}
	
}