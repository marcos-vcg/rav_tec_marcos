package classes;

import java.util.Date;

public class Locacao {
	
	private String filme;
	private Genero genero;
	private Date locacao;
	private Date devolucao;
	private Integer id;
	static int contador = 0;
	
	public Locacao(String filme, Genero genero, Date locacao) {
		super();
		this.filme = filme;
		this.genero = genero;
		this.locacao = locacao;
		this.id = contador++;
	}

	public String getFilme() {
		return filme;
	}

	public void setFilme(String filme) {
		this.filme = filme;
	}
	
	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
		this.genero = genero;
	}
	
	public Date getLocacao() {
		return locacao;
	}

	public void setLocacao(Date locacao) {
		this.locacao = locacao;
	}
	
	public Date getDevolucao() {
		return devolucao;
	}

	public void setDevolucao(Date devolucao) {
		this.devolucao = devolucao;
	}
	
	public Integer getId() {
		return id;
	}
}
