package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.MenuPage;
import projetobasico.pages.ResumoPage;

public class ResumoTest extends BaseTest {
	
	private MenuPage menuPage = new MenuPage();
	private ResumoPage resumoPage = new ResumoPage();
	
	@Test
	public void deveExcluirMovimentacao() {
		menuPage.acessarTelaResumo();
		
		resumoPage.excluirMovimentacao();
		
		Assert.assertEquals("Movimentação removida com sucesso!", resumoPage.obterMesagemSucesso());
	}
}
