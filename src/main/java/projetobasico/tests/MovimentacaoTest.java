package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.MenuPage;
import projetobasico.pages.MovimentacaoPage;

public class MovimentacaoTest extends BaseTest{
	
	private MenuPage menuPage = new MenuPage();
	private MovimentacaoPage movPage = new MovimentacaoPage();
	
	@Test
	public void deveInserirMovimentacao() {
		menuPage.acessarTelaListarMovimentacao();
		
		movPage.setDataMovimentacao("04/06/2025");
		movPage.setDataPagamento("04/06/2025");
		movPage.setDescricao("Movimentação do Teste");
		movPage.setInteressado("Interessado Qualquer");
		movPage.setValor("500");
		movPage.setConta("Conta do Teste Alterada");
		movPage.setStatusPago();
		movPage.salvar();
		
		Assert.assertEquals("Movimentação adicionada com sucesso!", movPage.obterMesagemSucesso());
	}
}
