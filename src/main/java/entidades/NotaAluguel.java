package entidades;

import java.util.Date;

public class NotaAluguel {
	private int preço;
	private Date dataEntrega;
	private int pontuacao = 0;

	public int getPreço() {
		return preço;
	}

	public void setPreço(int preço) {
		this.preço = preço;
	}

	public Date getDataEntrega() {
		return dataEntrega;
	}

	public void setDataEntrega(Date time) {
		dataEntrega = time;	
	}

	public int getPontuacao() {
		return pontuacao;
	}

	public void setPontuacao(int pontuacao) {
		this.pontuacao = pontuacao;
	}
}
