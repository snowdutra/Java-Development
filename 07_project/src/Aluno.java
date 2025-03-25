import java.util.ArrayList;

/**
 * Classe que representa um aluno com RA, nome, disciplinas matriculadas e médias.
 */
public class Aluno {
    private final int ra; // Registro Acadêmico do aluno
    private final String nome; // Nome do aluno
    private final ArrayList<String> listaDisciplina; // Lista de disciplinas matriculadas
    private final ArrayList<Double> listaMedia; // Lista de médias correspondentes às disciplinas

    /**
     * Construtor da classe Aluno.
     * 
     * @param ra   Registro Acadêmico do aluno.
     * @param nome Nome do aluno.
     */
    public Aluno(int ra, String nome) {
        this.ra = ra;
        this.nome = nome;
        this.listaDisciplina = new ArrayList<>();
        this.listaMedia = new ArrayList<>();
    }

    /**
     * Matricula o aluno em uma disciplina.
     * 
     * @param disciplina Nome da disciplina.
     */
    public void matricular(String disciplina) {
        listaDisciplina.add(disciplina);
        listaMedia.add(0.0); // Inicializa a média com 0.0
    }

    /**
     * Registra a média de uma disciplina específica.
     * 
     * @param disciplina Nome da disciplina.
     * @param media      Média a ser registrada.
     */
    public void registrarMedia(String disciplina, double media) {
        int index = listaDisciplina.indexOf(disciplina);
        if (index != -1) {
            listaMedia.set(index, media);
        }
    }

    /**
     * Calcula a média geral do aluno com base nas médias registradas.
     * 
     * @return A média geral ou 0.0 se não houver médias registradas.
     */
    public double calcularMediaGeral() {
        if (listaMedia.isEmpty()) return 0.0;

        double soma = 0.0;
        for (double nota : listaMedia) {
            soma += nota;
        }
        return soma / listaMedia.size();
    }

    /**
     * Retorna o RA do aluno.
     * 
     * @return RA do aluno.
     */
    public int getRa() {
        return ra;
    }

    /**
     * Retorna o nome do aluno.
     * 
     * @return Nome do aluno.
     */
    public String getNome() {
        return nome;
    }

    /**
     * Retorna a lista de disciplinas matriculadas.
     * 
     * @return Lista de disciplinas.
     */
    public ArrayList<String> getListaDisciplinas() {
        return listaDisciplina;
    }

    /**
     * Retorna a lista de médias registradas.
     * 
     * @return Lista de médias.
     */
    public ArrayList<Double> getListaMedias() {
        return listaMedia;
    }

    /**
     * Retorna uma representação textual do aluno.
     * 
     * @return String com informações do aluno.
     */
    @Override
    public String toString() {
        return "RA: " + ra + "\nNome: " + nome + "\nDisciplinas: " + listaDisciplina + "\nMédias: " + listaMedia;
    }
}
