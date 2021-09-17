package steps;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.Select;

import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import runners.RunnerFunctionalTest;

public class Movimentação {

	@Quando("seleciono Criar Movimentação")
	public void selecionoCriarMovimentação() {
		RunnerFunctionalTest.getDriver().findElement(By.linkText("Criar Movimentação")).click();
	}

	@Quando("informo o tipo de movimentação {string}")
	public void informoOTipoDeMovimentação(String string) {
		Select dropdown = new Select(RunnerFunctionalTest.getDriver().findElement(By.id("tipo")));
		dropdown.selectByVisibleText(string);
	}

	@Quando("informo a data de movimentação {string}")
	public void informoADataDeMovimentação(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("data_transacao")).sendKeys(string);
	}

	@Quando("informo a data de pagamento {string}")
	public void informoADataDePagamento(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("data_pagamento")).sendKeys(string);
	}

	@Quando("informo a descrição {string}")
	public void informoADescrição(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("descricao")).sendKeys(string);
	}

	@Quando("informo o interessado {string}")
	public void informoOInteressado(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("interessado")).sendKeys(string);
	}

	@Quando("informo o valor {double}")
	public void informoOValor(Double double1) {
		RunnerFunctionalTest.getDriver().findElement(By.id("valor")).sendKeys(double1.toString());
	}

	@Quando("informo a conta de movimentação {string}")
	public void informoAContaDeMovimentação(String string) {
		Select dropdown = new Select(RunnerFunctionalTest.getDriver().findElement(By.id("conta")));
		dropdown.selectByVisibleText(string);
	}

	@Quando("seleciono a {string}")
	public void selecionoA(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("status_pendente")).click();
	}

	@Quando("clico em Salvar")
	public void clicoEmSalvar() {
		RunnerFunctionalTest.getDriver().findElement(By.className("btn-primary")).click();
	}

	@Então("recebo a mensagem de movimentação {string}")
	public void receboAMensagemDeMovimentação(String string) {
		Assert.assertEquals("Movimentação adicionada com sucesso!", string);
	}

}
