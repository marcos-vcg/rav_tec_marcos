package classes;

public class Filme {

	private String titulo;
	private Genero genero;
	private Integer copias;
	private String sinopse;
	private String duracao;
	private String lancamento;
//	private Object imagem;
	private Categoria categoria;

	public Filme(String titulo, Genero genero, Integer copias, String sinopse, String duracao, String lancamento,
			/*Object imagem,*/ Categoria categoria) {
		super();
		this.titulo = titulo;
		this.genero = genero;
		this.copias = copias;
		this.sinopse = sinopse;
		this.duracao = duracao;
		this.lancamento = lancamento;
//		this.imagem = imagem;
		this.categoria = categoria;

	}

	public String getTitulo() {
		return titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public Genero getGenero() {
		return genero;
	}

	public void setGenero(Genero genero) {
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

/*	public Object getImagem() {
		return imagem;
	}

	public void setImagem(Object imagem) {
		this.imagem = imagem;
	}
*/
	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

}
