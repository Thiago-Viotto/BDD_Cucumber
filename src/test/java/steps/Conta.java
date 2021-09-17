package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.junit.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import runners.RunnerFunctionalTest;

public class Conta {

	String contaEsperada;

	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		RunnerFunctionalTest.getDriver().get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("informo o usuário {string}")
	public void informoOUsuário(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("email")).sendKeys(string);
	}

	@Quando("a senha {string}")
	public void aSenha(String string) {
		RunnerFunctionalTest.getDriver().findElement(By.id("senha")).sendKeys(string);
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
		RunnerFunctionalTest.getDriver().findElement(By.className("btn-primary")).click();
	}

	@Então("visualizo a página inicial")
	public void visualizoAPáginaInicial() {
		String alert = RunnerFunctionalTest.getDriver().findElement(By.className("alert")).getText();
		org.junit.Assert.assertEquals("Bem vindo, a@a.com!", alert);
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
		RunnerFunctionalTest.getDriver().findElement(By.className("dropdown-toggle")).click();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
		RunnerFunctionalTest.getDriver().findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
		contaEsperada = string;
		RunnerFunctionalTest.getDriver().findElement(By.id("nome")).clear();
		RunnerFunctionalTest.getDriver().findElement(By.id("nome")).sendKeys(string);
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
		RunnerFunctionalTest.getDriver().findElement(By.className("btn-primary")).click();
	}

	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String string) {
		String alert = RunnerFunctionalTest.getDriver().findElement(By.className("alert")).getText();
		org.junit.Assert.assertEquals(string, alert);
	}

	@Quando("clico no ícone de editar")
	public void clicoNoÍconeDeEditar() {
		RunnerFunctionalTest.getDriver().findElement(By.xpath("//*[@id=\"tabelaContas\"]/tbody/tr[1]/td[2]/a[1]/span")).click();
	}

	@After(order = 1, value = "@functional") // roda primeiro
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot) RunnerFunctionalTest.getDriver()).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@functional") // roda depois do 1
	public void fechar() {
		RunnerFunctionalTest.getDriver().quit();
	}

}
