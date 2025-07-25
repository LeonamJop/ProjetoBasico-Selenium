package projetobasico.pages;

import org.openqa.selenium.By;

import projetobasico.core.BasePage;

public class ContasPage extends BasePage {
	
	public void setNome(String nome) {
		escreve("nome", nome);
	}
	
	public void salvar() {
		clicarBotaoPorTexto("Salvar");
	}
	
	public String obterMesagemSucesso() {
		return obterTexto(By.xpath("//div[@class='alert alert-success']"));
	}
	
	public String obterMensagemErro() {
		return obterTexto(By.xpath("//div[@class='alert alert-danger']"));
	}

	public void clicarAlterarConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas")
			.findElement(By.xpath("//span[@class='glyphicon glyphicon-edit']")).click();
	}
	
	public void clicarExcluirConta(String string) {
		obterCelula("Conta", string, "Ações", "tabelaContas").click();
	}
}
