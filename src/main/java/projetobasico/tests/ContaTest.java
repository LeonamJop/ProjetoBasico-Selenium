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
	public void deve1_InserirConta() {
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
	public void deve2_AlterarConta() {
		menuPage.acessarTelaListarConta();
		
		contasPage.clicarAlterarConta("Conta para alterar");
		contasPage.setNome("Conta para alterada");
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMesagemSucesso());
	}
	
	@Test
	public void deve3_InserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome("Conta mesmo nome");
		contasPage.salvar();
		
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}
