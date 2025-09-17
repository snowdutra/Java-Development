import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Digite o RA do aluno: ");
        int ra = scanner.nextInt();
        scanner.nextLine(); // Consumes the newline left-over
        
        System.out.print("Digite o nome do aluno: ");
        String nome = scanner.nextLine();
        
        Aluno aluno = new Aluno(ra, nome);
        
        while (true) {
            System.out.print("Digite o nome da disciplina (ou 'sair' para finalizar): ");
            String disciplina = scanner.nextLine();
            if (disciplina.equalsIgnoreCase("sair")) {
                break;
            }
            aluno.matricular(disciplina);
            
            System.out.print("Digite a média da disciplina: ");
            double media = scanner.nextDouble();
            scanner.nextLine(); // Consumes the newline left-over
            aluno.registrarMedia(disciplina, media);
        }
        
        System.out.println(aluno.toString());
        System.out.printf("Média Geral: %.2f%n", aluno.calcularMediaGeral());
        
        scanner.close();
    }
}

