import java.util.Scanner;

public class SomaParesFibFlex {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.print("Digite o valor limite: ");
        int limite = sc.nextInt();
        
        int a = 1, b = 2, soma = 0;

        while (b <= limite) {
            if (b % 2 == 0) {
                soma += b;
            }
            int proximo = a + b;
            a = b;
            b = proximo;
        }

        System.out.println("A soma dos termos pares da sequência de Fibonacci até " + limite + " é: " + soma);
        
        sc.close();
    }
}