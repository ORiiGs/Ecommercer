import java.io.Serializable;
import java.util.ArrayList;

public class Categoria implements Serializable{
	
	private String nome;
	private ArrayList<Produto> produtos;
	
	public Categoria(String nome) {
		this.nome = nome;
		this.produtos = new ArrayList<Produto>();
	}
	
	public String toString () {
		String lista = this.nome +"\n";
		for (int i = 0; i < this.produtos.size(); i++) {
			lista += "  " + (i+1) + ". " + this.produtos.get(i).toString() + "\n";			
		}
		return lista;
	}
	public void addProduto(String nome) {
		this.produtos.add(new Produto(nome));
	}

	public void removeProduto(int enderecoCategoria) {
		this.produtos.remove(enderecoCategoria);
		
	}
	
	public String getNome() {
		return this.nome;
	}

}
