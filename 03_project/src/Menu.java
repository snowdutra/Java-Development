import java.util.Scanner;

public class Menu {

    private Scanner sc = new Scanner(System.in);

    public void menu() {
        int opcao;

        do {
            System.out.println("1. Somar");
            System.out.println("2. Dividir");
            System.out.println("3. Finalizar");
            System.out.print("Escolha uma opção: ");
            opcao = sc.nextInt();

            if (opcao < 1 || opcao > 3) {
                System.out.println("Opção inválida. Tente novamente.");
            } else {
                switch (opcao) {
                    case 1:
                        somar();
                        break;
                    case 2:
                        dividir();
                        break;
                    case 3:
                        System.out.println("Finalizando o programa.");
                        break;
                    default:
                        break;
                }
            }
        } while (opcao != 3);

    }

    private void somar() {
        System.out.print("Digite o primeiro número: ");
        double num1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = sc.nextDouble();
        double resultado = num1 + num2;
        System.out.println("Resultado: " + resultado);
    }

    private void dividir() {
        System.out.print("Digite o primeiro número: ");
        double num1 = sc.nextDouble();
        System.out.print("Digite o segundo número: ");
        double num2 = sc.nextDouble();
        if (num2 == 0) {
            System.out.println("Erro: Divisão por zero não é permitida.");
        } else {
            double resultado = num1 / num2;
            System.out.println("Resultado: " + resultado);
        }
    }

}

