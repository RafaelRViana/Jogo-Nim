package br.com.cauirs.jogonim.excecoes;

public class JogadaInvalida extends Exception 
{

	private static final long serialVersionUID = 1L;
	
	public JogadaInvalida(String mensagemErro) 
	{
		this.mensagemErro = mensagemErro;
	}

	private String mensagemErro;

	public String getMensagemErro() 
	{
		return mensagemErro;
	}
	
}