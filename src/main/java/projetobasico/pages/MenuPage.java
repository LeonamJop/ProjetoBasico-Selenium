package projetobasico.pages;

import projetobasico.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicaLink("Contas");
		clicaLink("Adicionar");
	}

}
