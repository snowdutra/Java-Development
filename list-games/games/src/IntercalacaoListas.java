// IntercalacaoListas.java
import java.util.LinkedList;
import java.util.Scanner;

public class IntercalacaoListas {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Tamanho da primeira lista: ");
        int n1 = sc.nextInt();
        LinkedList<Integer> lista1 = new LinkedList<>();
        System.out.println("Digite os " + n1 + " valores em ordem crescente:");
        for (int i = 0; i < n1; i++) {
            lista1.add(sc.nextInt());
        }

        System.out.print("Tamanho da segunda lista: ");
        int n2 = sc.nextInt();
        LinkedList<Integer> lista2 = new LinkedList<>();
        System.out.println("Digite os " + n2 + " valores em ordem crescente:");
        for (int i = 0; i < n2; i++) {
            lista2.add(sc.nextInt());
        }

        LinkedList<Integer> resultado = new LinkedList<>();
        while (!lista1.isEmpty() && !lista2.isEmpty()) {
            if (lista1.get(0) <= lista2.get(0)) {
                resultado.add(lista1.remove(0));
            } else {
                resultado.add(lista2.remove(0));
            }
        }

        while (!lista1.isEmpty()) {
            resultado.add(lista1.remove(0));
        }
        while (!lista2.isEmpty()) {
            resultado.add(lista2.remove(0));
        }


        System.out.println("Lista intercalada em ordem crescente:");
        for (int x : resultado) {
            System.out.print(x + " ");
        }
        sc.close();
    }
}