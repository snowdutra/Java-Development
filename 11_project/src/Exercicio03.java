// Exercício 3: Primeiro número repetido consecutivo
import java.util.ArrayList;
import java.util.Scanner;

class Repetido {
    public static void encontrarRepetido(ArrayList<Integer> lista) {
        for (int i = 1; i < lista.size(); i++) {
            if (lista.get(i) == lista.get(i - 1)) {
                System.out.println("Primeiro número repetido consecutivo: " + lista.get(i));
                return;
            }
        }
        System.out.println("Nenhum número repetido consecutivo encontrado.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> lista = new ArrayList<>();
        
        System.out.println("Digite os elementos da lista dando espaço entre eles (digite sair para finalizar):");
        while (scanner.hasNextInt()) {
            lista.add(scanner.nextInt());
        }

        encontrarRepetido(lista);
        scanner.close();
    }
}


