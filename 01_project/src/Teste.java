import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {
   
        int idade = 12;
        float nota = 7.5F;
        double valor = 59.78;

        Scanner in = new Scanner(System.in);

        System.out.print("Qual a sua idade?   ");
        idade = in.nextInt();
        System.out.print("Qual sua nota?   ");
        nota = in.nextFloat();
        System.out.print("Qual o valor do café?   ");
        valor = in.nextDouble();

        System.out.println("Sua idade é: " + idade + " anos");
        System.out.println("Sua nota é: " + nota);
        System.out.println("Valor = R$ " + valor); 

        in.close();
    }
}