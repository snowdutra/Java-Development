import java.util.LinkedList;

public class ZonaUrbana extends Zona implements Emergencia {
    private LinkedList<Sensor> sensores;

    public ZonaUrbana(String nome) {
        super(nome);
        this.sensores = new LinkedList<Sensor>();
    }

    public void adicionarSensor(Sensor sensor) {
        sensores.add(sensor);
    }

    public double calcularTotal() {
        double total = 0;
        for (Sensor s : sensores) {
            total += s.getValor();
        }
        return total;
    }

    public double calcularMedia() {
        if (sensores.size() == 0) return 0;
        return calcularTotal() / sensores.size();
    }

    @Override
    public String classificarNivelEmergencia(double media) {
        if (media <= 50) return "Sem risco";
        else if (media <= 100) return "Monitoramento intensificado";
        else if (media <= 150) return "Alerta para grupos sensíveis";
        else if (media <= 200) return "Alerta Amarelo";
        else if (media <= 300) return "Alerta Laranja";
        else return "Alerta Vermelho (emergência total)";
    }

    @Override
    public String relatorio() {
        double total = calcularTotal();
        double media = calcularMedia();
        String nivel = classificarNivelEmergencia(media);

        StringBuilder sb = new StringBuilder();
        sb.append("Zona: ").append(getNome()).append("\n");
        sb.append(String.format("Total semanal: %.2f\n", total));
        sb.append(String.format("Média semanal: %.2f\n", media));
        sb.append("Nível de emergência: ").append(nivel);

        if (nivel.equals("Alerta Vermelho (emergência total)")) {
            sb.append("\n>>> Ação imediata recomendada: evacuação ou restrição de atividades externas.");
        }

        return sb.toString();
    }
}