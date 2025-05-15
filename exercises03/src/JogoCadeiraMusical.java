// JogoCadeiraMusical.java
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class JogoCadeiraMusical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Número de jogadores (n): ");
        int n = sc.nextInt();
        System.out.print("Elimina a cada k batidas: ");
        int k = sc.nextInt();

        Queue<Integer> fila = new LinkedList<>();
        for (int i = 1; i <= n; i++) {
            fila.add(i); 
        }

        while (fila.size() > 1) {

            for (int i = 1; i < k; i++) {
                fila.add(fila.poll()); 
            }

            int eliminado = fila.poll();
            System.out.println("Eliminado: jogador " + eliminado);
        }

        System.out.println("Vencedor: jogador " + fila.poll());
        sc.close();
    }
}