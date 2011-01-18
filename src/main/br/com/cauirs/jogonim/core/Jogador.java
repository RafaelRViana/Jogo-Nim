package br.com.cauirs.jogonim.core;

import br.com.cauirs.jogonim.excecoes.JogadaInvalida;

public class Jogador {

	public Jogador(String nomeJogador, TipoJogador tipoJogador) 
	{
		this.nome = nomeJogador;
		this.tipoDeJogador = tipoJogador;
	}
	
	private String nome;
	private TipoJogador tipoDeJogador;

	public int jogar( PilhaBolas pilhaDeBolas ) throws JogadaInvalida 
	{
		return tipoDeJogador.retirarDa(pilhaDeBolas);
	}

	@Override
	public String toString() 
	{
		return nome;
	}
	
}