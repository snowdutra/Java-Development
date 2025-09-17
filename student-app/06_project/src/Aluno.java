import java.util.ArrayList;

public class Aluno {

    private final int ra;
    private final String nome;
    private final ArrayList<String> listaDisciplina;
    private final ArrayList<Double> listaMedia;

    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
        this.listaDisciplina = new ArrayList<>();
        this.listaMedia = new ArrayList<>();
    }

    public void matricular(String disciplina) {
        listaDisciplina.add(disciplina);
        listaMedia.add(0.0);
    }

    public void registrarMedia(String disciplina, double media) {
        int index = listaDisciplina.indexOf(disciplina);
        if (index != -1) {
            listaMedia.set(index, media);
        }
    }

    public double calcularMediaGeral() {
        if (listaMedia.isEmpty()) return 0.0;

        double soma = 0.0;
        for (double nota : listaMedia) {
            soma += nota;
        }
        return soma / listaMedia.size();
    }

    public int getRa() {
        return ra;
    }

    public String getNome() {
        return nome;
    }

    public ArrayList<String> getListaDisciplinas() {
        return new ArrayList<>(listaDisciplina);
    }

    public ArrayList<Double> getListaMedias() {
        return new ArrayList<>(listaMedia);
    }

    @Override
    public String toString() {
        return "RA: " + ra + "\nNome: " + nome + "\nDisciplinas: " + listaDisciplina + "\nMédias: " + listaMedia;
    }
}
