import java.io.Serializable;
import java.util.ArrayList;

public class ECommerce implements Serializable{
	
	private String nome;
	private ArrayList<Categoria> categorias;
	private ArrayList<Usuario> usuarios;
	
	
	public ECommerce(String nome) {
		this.nome = nome;
		this.categorias = new ArrayList<Categoria>();
		this.usuarios = new ArrayList<Usuario>();
		this.usuarios.add(new Usuario("admim","admim","admim"));
	}
	
	public void adicionaCategoria(String nome) {
		this.categorias.add(new Categoria(nome));
	}
	public String toString() {
		String lista = "";
		for (int i = 0; i < this.categorias.size(); i++) {
			lista += (i+1) + ". " + this.categorias.get(i).toString();		
		}
		return lista;
	}
	public void adicionaProduto (int categoria, String produto) {
		this.categorias.get(--categoria).addProduto(produto);
	}

	public void removeCategoria(int enderecoCategoria) {
		this.categorias.remove(--enderecoCategoria);
		
	}

	public void removeProduto(int enderecoCategoria, int enderecoProduto) {
		this.categorias.get(--enderecoCategoria).removeProduto(enderecoCategoria);
		
	}

	public boolean compara(String nome) {
		for(Categoria i : categorias) {
			if (i.getNome() == this.nome)
				return true;
		}
		
		return false;
	}

	public boolean adicionaUsuario(String nome2, String eMail, String senha) {
		for (int i = 0; i < this.usuarios.size(); i++) {
			if (this.usuarios.get(i).getEmail().equals(eMail)){				
				return true;
			}
		}
		this.usuarios.add(new Usuario(nome2,eMail,senha));
		return false;
	}

	public String listarUsuario() {
		String lista = "";
		for (int i = 0; i < this.usuarios.size(); i++) {
			lista += (i+1) + ". " + this.usuarios.get(i).getEmail() + "\n";		
		}
		return lista;
	}
	
	

}
