import java.util.Scanner;
import java.util.TreeSet;
import java.util.Iterator;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        TreeSet<Zona> zonas = new TreeSet<>((a, b) -> a.getNome().compareToIgnoreCase(b.getNome()));

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Registrar Zona");
            System.out.println("2. Adicionar sensor (apenas zona urbana)");
            System.out.println("3. Imprimir relatório");
            System.out.println("4. Finalizar");
            System.out.print("Escolha uma opção: ");
            int op = Integer.parseInt(sc.nextLine());

            if (op == 1) {
                System.out.print("Nome da zona: ");
                String nome = sc.nextLine();
                System.out.print("Tipo (urbana/rural): ");
                String tipo = sc.nextLine().toLowerCase();
                if (tipo.equals("urbana")) {
                    zonas.add(new ZonaUrbana(nome));
                } else {
                    zonas.add(new ZonaRural(nome));
                }
                System.out.println("Zona registrada!");
            } else if (op == 2) {
                System.out.print("Nome da zona urbana: ");
                String nome = sc.nextLine();
                ZonaUrbana zona = null;
                for (Zona z : zonas) {
                    if (z.getNome().equalsIgnoreCase(nome) && z instanceof ZonaUrbana) {
                        zona = (ZonaUrbana) z;
                        break;
                    }
                }
                if (zona == null) {
                    System.out.println("Zona urbana não encontrada!");
                } else {
                    System.out.print("ID do sensor: ");
                    int id = Integer.parseInt(sc.nextLine());
                    System.out.print("Data da coleta: ");
                    String data = sc.nextLine();
                    System.out.print("Valor AQI: ");
                    double valor = Double.parseDouble(sc.nextLine());
                    zona.adicionarSensor(new Sensor(id, data, valor));
                    System.out.println("Sensor adicionado!");
                }
            } else if (op == 3) {
                System.out.print("Nome da zona para relatório: ");
                String nome = sc.nextLine();
                Zona zona = null;
                for (Zona z : zonas) {
                    if (z.getNome().equalsIgnoreCase(nome)) {
                        zona = z;
                        break;
                    }
                }
                if (zona == null) {
                    System.out.println("Zona não encontrada!");
                } else {
                    System.out.println("\n=== RELATÓRIO DE EMERGÊNCIA AMBIENTAL ===");
                    String rel = zona.relatorio();
                    System.out.println(rel);

                    // Mensagem extra para zona urbana com média > 300
                    if (zona instanceof ZonaUrbana) {
                        ZonaUrbana zu = (ZonaUrbana) zona;
                        if (zu.calcularMedia() > 300) {
                            System.out.println(">>> ALERTA EXTREMO: Média crítica ultrapassada!");
                        }
                    }
                }
            } else if (op == 4) {
                System.out.println("Finalizando...");
                break;
            } else {
                System.out.println("Opção inválida!");
            }
        }
        sc.close();
    }
}