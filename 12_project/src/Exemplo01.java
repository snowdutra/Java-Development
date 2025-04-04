import java.util.Stack;
import java.util.Scanner;

public class Exemplo01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Stack<Integer> pilha = new Stack<>();
        int valor;

        System.out.println("Digite os valores para a pilha:");
        valor = sc.nextInt();
        
        // Armazenando o resto da divisão --> Empilhando
        while(valor != 0) {
            pilha.push(valor % 2);
            valor = valor / 2;
        }

        System.out.println("Os valores empilhados foram: " + pilha);
        System.out.println("Desempilhando os valores: ");
       
       // Desempilhando os valores
        while(!pilha.isEmpty()) {
            System.out.print(pilha.pop() + " ");
        }

        System.out.println("\nA pilha está vazia: " + pilha.isEmpty());
        System.out.println("Tamanho da pilha: " + pilha.size());
    }
}
