package steps;

import java.util.Calendar;
import java.util.Date;
import java.util.Map;

import org.junit.Assert;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.pt.Dado;
import io.cucumber.java.pt.Então;
import io.cucumber.java.pt.Quando;
import servicos.AluguelService;


public class Alugar_Filme_Step {

	private Filme filme;
	private AluguelService aluguel = new AluguelService();
	private NotaAluguel notaAluguel;
	private String erro;
	private TipoAluguel tipoAluguel;

	@Dado("um filme com estoque de {int} unidades")
	public void umFilmeComEstoqueDeUnidades(Integer int1) {
		filme = new Filme();
		filme.setEstoque(int1);
	}

	@Dado("um filme")
	public void umFilme(DataTable dataTable) {
		Map<String, String> map = dataTable.asMap(String.class, String.class);
		filme = new Filme();
		filme.setEstoque(Integer.parseInt(map.get("estoque")));
		filme.setAluguel(Integer.parseInt(map.get("preço")));
		tipoAluguel = map.get("tipo").equals("SEMANAL") ? TipoAluguel.SEMANAL
				: map.get("tipo").equals("EXTENDIDO") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	}

	@Dado("que o preço do aluguel seja R$ {int}")
	public void queOPreçoDoAluguelSejaR$(Integer int1) {
		filme.setAluguel(int1);
	}

	@Quando("alugar")
	public void alugar() {
		try {
			notaAluguel = aluguel.alugar(filme, tipoAluguel);
		} catch (Exception e) {
			erro = e.getMessage();
		}
	}

	@Então("não será possível por falta de estoque")
	public void nãoSeráPossívelPorFaltaDeEstoque() {
		Assert.assertEquals("Não é possível alugar filme sem estoque", erro);
	}

	@Então("o preço do aluguel será R$ {int}")
	public void oPreçoDoAluguelSeráR$(Integer int1) {
		Assert.assertEquals((int) int1, notaAluguel.getPreço());
	}

	@Então("a data de entrega será em {int} dia(s)")
	public void aDataDeEntregaSeráNoDiaSeguinte(Integer int1) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, int1);
		notaAluguel.setDataEntrega(cal.getTime());
		Assert.assertEquals(cal.getTime(), notaAluguel.getDataEntrega());

	}

	@Então("o estoque do filme será {int} unidade")
	public void oEstoqueDoFilmeSeráUnidade(Integer int1) {
		Assert.assertEquals((int) int1, filme.getEstoque());
	}

	@Dado("que o tipo do aluguel seja {string}")
	public void queOTipoDoAluguelSejaExtendido(String tipo) {
		tipoAluguel = tipo.equals("SEMANAL") ? TipoAluguel.SEMANAL
				: tipo.equals("EXTENDIDO") ? TipoAluguel.EXTENDIDO : TipoAluguel.COMUM;
	}

	@Então("a pontuação recebida será de {int} ponto(s)")
	public void aPontuaçãoRecebidaSeráDePontos(Integer int1) {
		Assert.assertEquals((int) int1, notaAluguel.getPontuacao());
	}

}
