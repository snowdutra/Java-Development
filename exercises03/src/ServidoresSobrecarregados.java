import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ServidoresSobrecarregados {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Quantos servidores? ");
        int n = sc.nextInt();
        
        List<Integer> cargas = new ArrayList<>();
        System.out.println("Digite as cargas, separadas por espaço:");
        for (int i = 0; i < n; i++) {
            cargas.add(sc.nextInt());
        }

        int dias = 0;
        while (true) {

            boolean desligou = false;
            List<Boolean> desligar = new ArrayList<>();
            desligar.add(false);

            for (int i = 1; i < cargas.size(); i++) {
                if (cargas.get(i) > cargas.get(i - 1)) {
                    desligar.add(true);
                    desligou = true;
                } else {
                    desligar.add(false);
                }
            }

            if (!desligou) break;

            List<Integer> nova = new ArrayList<>();
            for (int i = 0; i < cargas.size(); i++) {
                if (!desligar.get(i)) {
                    nova.add(cargas.get(i));
                }
            }
            cargas = nova;
            dias++;
        }

        System.out.println("Dias até estabilizar: " + dias);
        sc.close();
    }
}