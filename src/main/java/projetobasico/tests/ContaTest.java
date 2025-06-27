package projetobasico.tests;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import projetobasico.core.BaseTest;
import projetobasico.core.Propriedades;
import projetobasico.pages.ContasPage;
import projetobasico.pages.MenuPage;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		
		contasPage.clicarAlterarConta("Conta do Teste");
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		Assert.assertEquals("Conta alterada com sucesso!", contasPage.obterMesagemSucesso());
	}
	
	@Test
	public void deve3_InserirContaComMesmoNome() {
		menuPage.acessarTelaInserirConta();
		
		contasPage.setNome(Propriedades.NOME_CONTA_ALTERADA);
		contasPage.salvar();
		
		
		Assert.assertEquals("Já existe uma conta com esse nome!", contasPage.obterMensagemErro());
	}
}
