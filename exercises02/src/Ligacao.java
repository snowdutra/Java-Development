class Ligacao {
    String destino;
    double distancia, fatorTrafego;
    int pedagios;

    Ligacao(String destino, double distancia, double fatorTrafego, int pedagios) {
        this.destino = destino;
        this.distancia = distancia;
        this.fatorTrafego = fatorTrafego;
        this.pedagios = pedagios;
    }

    public double calcularTempo() {
        return (distancia * fatorTrafego) + (pedagios * 2);
    }

    @Override
    public String toString() {
        return destino + " | Distância: " + String.format("%.2f", distancia) + " km | Tráfego: " + String.format("%.2f", fatorTrafego) +
               " | Pedágios: " + pedagios + " | Tempo: " + String.format("%.2f", calcularTempo()) + " minutos";
    }
}