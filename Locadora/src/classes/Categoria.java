package classes;

public class Categoria {
	
	private String nome;
	private String preco;
	private Integer id;
	static int contador = 0;
	
	public Categoria(String nome, String preco) {
		super();
		this.nome = nome;
		this.preco = preco;
		this.id = contador++;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getPreco() {
		return preco;
	}

	public void setPreco(String preco) {
		this.preco = preco;
	}
	
	public Integer getId() {
		return id;
	}

}