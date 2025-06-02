package projetobasico.tests;

import org.junit.Assert;
import org.junit.Test;

import projetobasico.core.BaseTest;
import projetobasico.pages.ContasPage;
import projetobasico.pages.MenuPage;

public class ContaTest extends BaseTest {
	
	MenuPage menuPage = new MenuPage();
	ContasPage contasPage = new ContasPage();
	
	@Test
	public void deveInserirConta() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta do Teste");
		contasPage.salvar();
		
		Assert.assertEquals("Conta adicionada com sucesso!", contasPage.obterMesagemSucesso());
	}
	
	@Test
	public void deveRetornarErroAoInserirContaSemNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.salvar();
		
		Assert.assertEquals("Informe o nome da conta", contasPage.obterMensagemErro());
	}
	
	@Test
	public void deveAlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome("Conta do Teste Alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMesagemSucesso());
	}
}
