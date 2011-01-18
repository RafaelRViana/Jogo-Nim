package br.com.cauirs.jogonim.core;

public class Utilitarios {

	public static Boolean isPotenciaDeDoisMenosUm( int numero )
	{
		switch( numero )
		{
			case 1	: 
			case 3	:
			case 7	:
			case 15	:
			case 31	:
			case 63	:
				return Boolean.TRUE;
				
			default :
				return Boolean.FALSE;
		}
	}
	
}
