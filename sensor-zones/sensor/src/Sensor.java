public class Sensor {
    private int ID;
    private String data;
    private double valor;

    public Sensor(int ID, String data, double valor) {
        this.ID = ID;
        this.data = data;
        this.valor = valor;
    }

    public int getID() {
        return ID;
    }

    public String getData() {
        return data;
    }

    public double getValor() {
        return valor;
    }
}