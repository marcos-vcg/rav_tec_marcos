package classes;

import java.awt.image.BufferedImage;

import javax.swing.Icon;

public class Filme {

	private String titulo;
	private String genero;
	private Integer copias;
	private String sinopse;
	private String duracao;
	private String lancamento;
	private Icon imagem;
	private String categoria;

	public Filme(String titulo, String genero, Integer copias, String lancamento) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.copias = copias;
		this.lancamento = lancamento;
	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getGenero() {
		return genero;
	}

	public void setGenero(String genero) {
		this.genero = genero;
	}

	public Integer getCopias() {
		return copias;
	}

	public void setCopias(Integer copias) {
		this.copias = copias;
	}

	public String getSinopse() {
		return sinopse;
	}

	public void setSinopse(String sinopse) {
		this.sinopse = sinopse;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public String getLancamento() {
		return lancamento;
	}

	public void setLancamento(String lancamento) {
		this.lancamento = lancamento;
	}

	public Icon getImagem() {
		return imagem;
	}

	public void setImagem(Icon imagem) {
		this.imagem = imagem;
	}

	public String getCategoria() {
		return categoria;
	}

	public void setCategoria(String string) {
		this.categoria = string;
	}

}
