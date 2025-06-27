package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.ContasPage;
import projetobasico.pages.MenuPage;


public class RemoverMovimentacaoContaTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void deveRetornarErroAoExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta("Conta do Teste Alterada");
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
