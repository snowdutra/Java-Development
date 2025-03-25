import java.util.Arrays;
import java.util.Scanner;

public class Exercicio02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Quantidade de números: ");
        int n = scanner.nextInt();
        
        int[] numeros = new int[n];
        System.out.print("Digite os números: ");
        
        for (int i = 0; i < n; i++) {
            numeros[i] = scanner.nextInt();
        }
        
        int[] pares = separarNumeros(numeros, true);
        int[] impares = separarNumeros(numeros, false);
        
        System.out.println("Pares: " + Arrays.toString(pares));
        System.out.println("Ímpares: " + Arrays.toString(impares));
        
        scanner.close();
    }
    
    private static int[] separarNumeros(int[] numeros, boolean pares) {
        int[] resultado = new int[numeros.length/2 + numeros.length%2];
        int index = 0;
        
        for (int num : numeros) {
            if ((num % 2 == 0) == pares) {
                resultado[index++] = num;
            }
        }
        
        return resultado;
    }
}

