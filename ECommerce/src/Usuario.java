import java.io.Serializable;

public class Usuario implements Serializable{

	private String nome;
	private String eMail;
	private String senha;
	
	public Usuario(String nome, String eMail, String senha) {
		this.nome = nome;
		this.eMail = eMail;
		this.senha = senha;
	}
	
	public String getEmail() {
		return this.eMail;
	}

}
