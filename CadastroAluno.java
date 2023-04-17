import java.util.Scanner;
import java.util.TreeMap;
import java.util.Map;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CadastroAluno {
	static Scanner teclado = new Scanner(System.in);
	
	// Criando um mapa para manipular os dados cadastrados(rgm e disciplinas)
    static Map < String, List<String> > alunos = new TreeMap<>();
    
	public static void main(String[] args) {
		
	    // Loop para cadastrar 60 alunos automaticamente 
	    for (int i = 1; i <= 60; i++) {
	        // Definindo RGM e disciplinas para cada aluno
	    	
	    	// especificando que o RGM terá inicio 2023 + um número inteiro com quatro dígitos
	        String rgm = "2023" + String.format("%04d", i);
	        //     rgm = "2023" + 0001 ; rgm = 20230001
	        //     ...
	        //     rgm = "2023" + 0060 ; rgm = 20230060
	        List<String> disciplinas = Arrays.asList("Estrutura de Dados I", "Matemática Discreta", "Programação Orientada a Objetos");

	        // Adicionando o aluno e suas disciplinas ao mapa "alunos"
	        alunos.put(rgm, disciplinas);
	    }
	   
        System.out.println("\tMENU:");
        System.out.println("1. Incluir aluno");
        System.out.println("2. Buscar aluno");
        System.out.println("3. Remover aluno");
        System.out.println("4. Mostrar todos os alunos");
        
        int opcao;
        do {
            System.out.print("\nEscolha uma opção: ");
            opcao = teclado.nextInt();
            teclado.nextLine(); 
            
            switch (opcao) {
                case 1:
                    incluirAluno();
                    break;
                case 2:
                    buscarAluno();
                    break;
                case 3:
                    removerAluno();
                    break;
                case 4:
                    mostrarAlunos();
                    break;
                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);
    }
	
	public static void incluirAluno() {
        System.out.println("\nCADASTRANDO ALUNO:");

        // Perguntar ao usuário quantos alunos deseja incluir
        System.out.print("Quantos alunos deseja cadastrar? ");
        int tamanhoSala = teclado.nextInt();
        teclado.nextLine();        

        // Loop para fazer cadastro dos alunos
        for (int i = 0; i < tamanhoSala; i++) {
            System.out.printf("\nCadastro do aluno %d :", i + 1);

            // Recebendo RGM do aluno
            System.out.print("\nRGM: ");
            String rgm = teclado.nextLine();

            // Lista para armazenar as disciplinas do aluno
            List<String> disciplinas = new ArrayList<>();

            // Loop para cadastrar as disciplinas do aluno
            String resposta;
            do {
                System.out.print("Disciplina: ");
                String disciplina = teclado.nextLine();
                disciplinas.add(disciplina); // adicionando a disciplina a lista "disciplinas"

                System.out.print("Deseja colocar mais disciplina [S/N]? ");
                resposta = teclado.nextLine();
            } while (resposta.equalsIgnoreCase("S"));


            // Adicionando o aluno e suas disciplinas ao mapa "alunos"
            alunos.put(rgm, disciplinas);
        }
	}
	
	// 1. Mostre todos os aluno, e respectivas disciplinas, cadastrados

	public static void mostrarAlunos() {
        
        // Loop para retornar todos os dados às variáveis e mostra-los
        System.out.println("\nALUNOS CADASTRADOS:");         
        for (Map.Entry <String, List<String> > entradaMapa : alunos.entrySet()) {
            String rgm = entradaMapa.getKey(); // retornando a chave do mapa 
            List<String> disciplinas = entradaMapa.getValue(); // retornando os valores do mapa
            
            // Mostrando os dados
            System.out.println("RGM: " + rgm);
            System.out.println("Disciplinas: " + disciplinas + "\n");
        }
	}
	
    // 2. Procure um aluno pelo RGM e mostrando seus dados, caso exista ou mensagem de "não existe"

	public static void buscarAluno() {
		
		// Condição para enquanto não for encontrado um aluno pedir novamente o rgm novamente
    	List<String> buscaAluno;
		do {
            System.out.print("\nDigite o RGM do aluno que deseja buscar: ");
            String rgmBusca = teclado.nextLine();
            // Lista para receber os valores do aluno que foi procurado
            buscaAluno = alunos.get(rgmBusca);
            // Condição para caso o rgm não seja encontrado
            if (buscaAluno != null) {
                System.out.println("RGM: " + rgmBusca);
                System.out.println("Disciplinas: " + buscaAluno);
            } else {
                System.out.printf("Aluno %s não encontrado. Tente novamente!\n", rgmBusca);
            }
    	}while(buscaAluno == null);
	}
	
    // 3. Remova um aluno pelo RGM

	public static void removerAluno() {
    	// Condição para enquanto não for encontrado um aluno pedir o rgm novamente
		List<String> remocaoAluno;
        do {
            System.out.print("\nDigite o RGM do aluno que deseja remover: ");
            String rgmRemocao = teclado.nextLine();
            // Lista para buscar os valores e removê-los da lista
            remocaoAluno = alunos.remove(rgmRemocao);
            // Condição para caso o rgm não seja encontrado
            if (remocaoAluno != null) {
                System.out.printf("Aluno %s removido com sucesso.\n", rgmRemocao);
            } else {
                System.out.printf("Aluno %s não encontrado. Tente novamente!\n", rgmRemocao);
            }
        }while(remocaoAluno == null);
	}	
}
