import java.util.Scanner;

public class SomaMultiplosFlex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o valor limite: ");
        int limite = sc.nextInt();
        
        int sum = 0;

        for (int i = 1; i < limite; i++) {
            if (i % 3 == 0 || i % 5 == 0) {
                sum += i;
            }
        }

        System.out.println("A soma dos múltiplos de 3 e 5 abaixo de " + limite + " é: " + sum);
        
        sc.close();
    }
}