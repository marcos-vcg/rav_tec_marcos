package classes;

public class Cliente {

	private static int contador;
	private int id;
	private String nome;
	private String cpf;
	private String telefone;
	private String email;
	private String nascimento;
	private String endereco;
/*	private Object foto;*/

	public Cliente(String nome, String cpf, String telefone, String email, String string, String endereco/*,
			Object foto*/) {
		super();
		this.id = contador++;
		this.nome = nome;
		this.cpf = cpf;
		this.telefone = telefone;
		this.email = email;
		this.nascimento = string;
		this.endereco = endereco;
//		this.foto = foto;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNascimento() {
		return nascimento;
	}

	public void setNascimento(String nascimento) {
		this.nascimento = nascimento;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

/*	public Object getFoto() {
		return foto;
	}

	public void setFoto(Object foto) {
		this.foto = foto;
	}*/

}
