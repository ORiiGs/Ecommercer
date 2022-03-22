import java.io.IOException;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public final class Arquivo {
	private String path;
	private static ObjectOutputStream output;
	
	public void salva(Object objeto, String path) {
		//abre o arquivo
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(path))); // diretório do arquivo
		}
		catch (IOException ioException) {
			System.err.println("Erro ao abrir araquivo");
			System.exit(1);
		}
		
		//adiciona os dados
		try {
			//serializa o objeto em um arquivo
			output.writeObject(objeto);
		}
		catch (IOException ioExcepcion) {
			System.err.println("Erro ao gravar arquivo");
		}
		
		//fecha o arquivo
		try {
			if (output != null) 
				output.close();
		}
		catch(IOException ioExcepcion) {
			System.err.println("Erro ao fechar arquivo");
		}
	}
}
