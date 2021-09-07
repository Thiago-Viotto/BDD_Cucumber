package servicos;

import java.util.Calendar;

import javax.management.RuntimeErrorException;

import entidades.Filme;
import entidades.NotaAluguel;
import entidades.TipoAluguel;

public class AluguelService {
	
	public NotaAluguel alugar(Filme filme, TipoAluguel tipo) throws Exception {
		if (filme.getEstoque() == 0) {
			throw new RuntimeErrorException(null, "Não é possível alugar filme sem estoque");
		} else {
			NotaAluguel nota = new NotaAluguel();
			
			switch (tipo) {
			case EXTENDIDO: 
				Calendar cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 3); // data de entrega é amanhã
				nota.setDataEntrega(cal.getTime());
				nota.setPontuacao(nota.getPontuacao() + 2);
				nota.setPreço(filme.getAluguel()*2);
				break;
			case COMUM: 
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 1);
				nota.setDataEntrega(cal.getTime());
				nota.setPontuacao(nota.getPontuacao() + 1);
				nota.setPreço(filme.getAluguel());
				break;
			case SEMANAL:
				cal = Calendar.getInstance();
				cal.add(Calendar.DAY_OF_MONTH, 7); 
				nota.setDataEntrega(cal.getTime());
				nota.setPontuacao(nota.getPontuacao() + 3);
				nota.setPreço(filme.getAluguel() * 3);
				break;
			default:
				nota.setPreço(filme.getAluguel());
				break;
			}
			
			filme.setEstoque(filme.getEstoque() - 1);
				
			return nota;
		}
	}

}
