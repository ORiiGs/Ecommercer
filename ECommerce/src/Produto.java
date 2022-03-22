import java.io.Serializable;
import java.util.ArrayList;

public class Produto implements Serializable{

	private String nome;
	
	public Produto(String nome) {
		this.nome = nome;
	}
	public String toString () {
		return this.nome;
	}
}
