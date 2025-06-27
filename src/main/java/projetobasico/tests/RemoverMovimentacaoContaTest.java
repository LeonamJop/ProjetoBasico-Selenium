package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.core.Propriedades;
import projetobasico.pages.ContasPage;
import projetobasico.pages.MenuPage;


public class RemoverMovimentacaoContaTest extends BaseTest{
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void deveRetornarErroAoExcluirContaComMovimentacao() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarExcluirConta(Propriedades.NOME_CONTA_ALTERADA);
		
		Assert.assertEquals("Conta em uso na movimentações", contasPage.obterMensagemErro());
	}
}
