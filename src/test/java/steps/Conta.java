package steps;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.After;
import io.cucumber.java.Scenario;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import junit.framework.Assert;

public class Conta {

	WebDriver driver = new ChromeDriver();
	String contaEsperada;

	@Dado("que estou acessando a aplicação")
	public void queEstouAcessandoAAplicação() {
		driver.get("https://seubarriga.wcaquino.me/login");
	}

	@Quando("informo o usuário {string}")
	public void informoOUsuário(String string) {
		driver.findElement(By.id("email")).sendKeys(string);
	}

	@Quando("a senha {string}")
	public void aSenha(String string) {
		driver.findElement(By.id("senha")).sendKeys(string);
	}

	@Quando("seleciono entrar")
	public void selecionoEntrar() {
		driver.findElement(By.className("btn-primary")).click();
	}

	@Então("visualizo a página inicial")
	public void visualizoAPáginaInicial() {
		String alert = driver.findElement(By.className("alert")).getText();
		org.junit.Assert.assertEquals("Bem vindo, Thiago!", alert);
	}

	@Quando("seleciono Contas")
	public void selecionoContas() {
		driver.findElement(By.className("dropdown-toggle")).click();
	}

	@Quando("seleciono Adicionar")
	public void selecionoAdicionar() {
		driver.findElement(By.linkText("Adicionar")).click();
	}

	@Quando("informo a conta {string}")
	public void informoAConta(String string) {
		contaEsperada = string;
		driver.findElement(By.id("nome")).sendKeys(string);
	}

	@Quando("seleciono Salvar")
	public void selecionoSalvar() {
		driver.findElement(By.className("btn-primary")).click();
	}

	@Então("recebo a mensagem {string}")
	public void receboAMensagem(String string) {
		String alert = driver.findElement(By.className("alert")).getText();
		org.junit.Assert.assertEquals(string, alert);
	}

	@After(order = 1, value = "@functional") // roda primeiro
	public void screenshot(Scenario cenario) {
		File file = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(file, new File("target/screenshots/" + cenario.getName() + ".jpg"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@After(order = 0, value = "@functional") // roda depois do 1
	public void fechar() {
		driver.quit();
	}

}
