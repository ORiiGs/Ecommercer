import java.io.EOFException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Principal {
	private static ECommerce comercio;
	private static final String NOMEdoARQUIVO = "ECommerce.txt";
	
	public static void main(String[] args) {
		int menu = 0;
		Scanner entrada = new Scanner(System.in);
		importaDados();		
		System.out.println(comercio.toString());
		
		do {
			switch (menu) {
				case 0: System.out.println("Digite a opção:\n 1. Login\n 2. Cadastrar\n 3. Sair");
						menu = Integer.parseInt(entrada.nextLine());
					break;
					
				case 1: 
					break;
					
				case 2: System.out.println("Digite o nome de usuário");
						String nome = entrada.nextLine();
						
						System.out.println("Digite seu E-mail");
						String eMail = entrada.nextLine();
						
						System.out.println("Digite uma senha");
						String senha = entrada.nextLine();
						
						if (comercio.adicionaUsuario(nome,eMail,senha)) {
							System.out.println("Usuário ja existe");
						} else {
							System.out.println("Conta criada com sucesso");
						}
		
						
						System.out.println(comercio.listarUsuario());	
						
						menu = 0;
				
					break;
					
				default:
			}
			
			
		}while (menu != 3);
		
//do {
//			
//			switch(menu) {
//			
//			case 0: System.out.println("Escolha uma area: \n 1. Categorias \n 2. Produtos \n 3. Sair do Programa");
//					menu = Integer.parseInt(entrada.nextLine());
//			break;
//				
//			case 1: System.out.println("O que você deseja: \n 1. Adicionar categoria \n 2. Remover categoria \n 3. Voltar");
//						int opcao = Integer.parseInt(entrada.nextLine());
//						
//						do {
//						
//							switch(opcao) {
//							
//							case 1: System.out.println("Digite o nome da categoria: ");
//									comercio.adicionaCategoria(entrada.nextLine());
//									System.out.println(comercio.toString());
//									opcao = 3;
//									break;
//							
//							
//							case 2: System.out.println("Qual categoria você deseja remover: ");
//									System.out.println(comercio.toString());
//									int categ = Integer.parseInt(entrada.nextLine());
//									comercio.removeCategoria(categ);
//									System.out.println(comercio.toString());
//									opcao = 3;
//									break;
//									
//							case 3: menu = 0;
//							break;
//							
//							}
//							
//						}while (opcao != 3);
//							
//								
//					
//			break;
//			
//			case 2: System.out.println("Digite o número da categoria a qual o novo produto pertence \n" + comercio.toString());
//					int categoria = Integer.parseInt(entrada.nextLine());
//					System.out.println("Digite o nome do novo produto: ");
//					comercio.adicionaProduto(categoria, entrada.nextLine());
//					System.out.println(comercio.toString());
//					menu = 0;
//			break;
//			
//			case 3:
//				continuar = false;
//			}
//			
//		}while (continuar == true);
		exportaDados();
		
		
		System.out.println("Fim");

	}
	
	private static ObjectInputStream input;
	
	public static void importaDados() {
		//abre o arquivo
		if (Files.exists(Paths.get(NOMEdoARQUIVO))){
			try {
				input = new ObjectInputStream(Files.newInputStream(Paths.get(NOMEdoARQUIVO)));
				}			
			
			catch (IOException ioException) {
				System.err.println("Erro ao abrir araquivo");
				System.exit(1);
				}
			
			//Ler o arquivo
			try {
				comercio = (ECommerce) input.readObject();
			}
			
			catch(EOFException endOfFileException){
				System.out.printf("%No more records%n");
				
			}
			
			catch(ClassNotFoundException classNotFoundException) {
				System.err.println("Tipo do objeto errado");
			}
			
			catch (IOException ioExcepcion) {
				System.err.println("Erro ao ler arquivo");
			}
			
			//fecha o arquivo
			try {
				if (input != null) 
					input.close();
			}
			catch(IOException ioExcepcion) {
				System.err.println("Erro ao fechar arquivo");
			}
			
			
		}
		else {
			System.out.println("Arquivo não existe");
			comercio = new ECommerce("Informática");
		}
	}
	
	private static ObjectOutputStream output;
	
	//salva os dados em arquivo sereliazado
	public static void exportaDados() {
		//abre o arquivo
		try {
			output = new ObjectOutputStream(Files.newOutputStream(Paths.get(NOMEdoARQUIVO)));
		}
		catch (IOException ioException) {
			System.err.println("Erro ao abrir araquivo");
			System.exit(1);
		}
		try {
			//serializa o objeto em um arquivo
			output.writeObject(comercio);
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
