package projetobasico.pages;

import projetobasico.core.BasePage;

public class MenuPage extends BasePage {
	
	public void acessarTelaInserirConta() {
		clicaLink("Contas");
		clicaLink("Adicionar");
	}
	
	public void acessarTelaListarConta() {
		clicaLink("Contas");
		clicaLink("Listar");
	}

	public void acessarTelaInserirMovimentacao() {
		clicaLink("Criar Movimentação");
	}
	
	public void acessarTelaResumo() {
		clicaLink("Resumo Mensal");
	}
	
	public void acessarTelaPrincipal() {
		clicaLink("Home");
	}
	
}
