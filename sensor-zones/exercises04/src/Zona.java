public abstract class Zona {
    private String nome;

    public Zona(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public abstract String relatorio();
}