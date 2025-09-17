import java.util.Scanner;

public class CalcMMCDinamico {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
       
       System.out.print("Digite o limite superior para a divisibilidade: ");
       int limite = scanner.nextInt();
       
       int menorMultiplo = calcularMMC(limite);
       
       System.out.println("O menor número positivo divisível por todos os números de 1 até " + limite + " é: " + menorMultiplo);
       
       scanner.close();
   }
   
   public static int calcularMMC(int limite) {
       int resultado = 1;
       for (int i = 2; i <= limite; i++) {
           resultado = mmc(resultado, i);
       }
       return resultado;
   }

   // cálculo do mínimo múltiplo comum (ele depende do máximo divisor comum)
   public static int mmc(int a, int b) {
       return (a * b) / Math.max(mdc(a, b), 1);
   }

   // cálculo do MDC usando o algoritmo de Euclides
   public static int mdc(int a, int b) {
       while (b != 0) {
           int temp = b;
           b = a % b;
           a = temp;
       }
       return a;
   }
}