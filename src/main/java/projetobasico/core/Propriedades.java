package projetobasico.core;

public class Propriedades {

	public static boolean FECHAR_BROWSER = false;
	
	public static Browsers browser = Browsers.CHROME;
	
	public static String NOME_CONTA_ALTERADA = "Conta alterada" + System.currentTimeMillis();
	
	public enum Browsers {
		CHROME,
		EDGE
	}
}
