import java.util.Scanner;

class Hora {
    private final int horas;
    private final int minutos;
    private final int segundos;

    public Hora(int horas, int minutos, int segundos) {
        this.horas = validadorHora(horas);
        this.minutos = validadorMinSeg(minutos);
        this.segundos = validadorMinSeg(segundos);
    }

    private int validadorHora(int h) {
        return (h >= 0 && h <= 23) ? h : 0;
    }

    private int validadorMinSeg(int v) {
        return (v >= 0 && v <= 59) ? v : 0;
    }

    public String getHora() {
        return String.format("%02d:%02d:%02d", horas, minutos, segundos);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        System.out.print("Informe a hora: ");
        int hora = scanner.nextInt();

        System.out.print("Informe os minutos: ");
        int minutos = scanner.nextInt();

        System.out.print("Informe os segundos: ");
        int segundos = scanner.nextInt();

        scanner.close();
        
        Hora h = new Hora(hora, minutos, segundos);
        System.out.println("Hora criada: " + h.getHora());
    }
}
