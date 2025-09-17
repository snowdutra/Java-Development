import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

/**
 * Classe Util que gerencia as operações relacionadas aos alunos.
 */
public class Util {
    private final List<Aluno> listaAluno = new ArrayList<>(); // Lista de alunos cadastrados

    /**
     * Exibe o menu principal e gerencia as opções escolhidas pelo usuário.
     */
    public void menu() {
        String[] opcoes = {
            "Cadastrar aluno", 
            "Matricular disciplina", 
            "Registrar média", 
            "Pesquisar aluno", 
            "Imprimir alunos", 
            "Finalizar"
        };
        int escolha;

        do {
            escolha = JOptionPane.showOptionDialog(
                null, 
                "Escolha uma opção", 
                "Menu", 
                JOptionPane.DEFAULT_OPTION, 
                JOptionPane.INFORMATION_MESSAGE, 
                null, 
                opcoes, 
                opcoes[0]
            );

            switch (escolha) {
                case 0 -> cadastrar();
                case 1 -> matricularDisciplina();
                case 2 -> registrarMedia();
                case 3 -> pesquisar();
                case 4 -> imprimir();
            }
        } while (escolha != 5);
    }

    /**
     * Cadastra um novo aluno na lista.
     */
    private void cadastrar() {
        try {
            int ra = Integer.parseInt(JOptionPane.showInputDialog("Digite o RA do aluno:"));
            String nome = JOptionPane.showInputDialog("Digite o nome do aluno:");
            listaAluno.add(new Aluno(ra, nome));
            JOptionPane.showMessageDialog(null, "Aluno cadastrado com sucesso!");
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "RA inválido! Digite um número.");
        }
    }

    /**
     * Matricula um aluno em uma disciplina.
     */
    private void matricularDisciplina() {
        try {
            int ra = Integer.parseInt(JOptionPane.showInputDialog("Informe o RA do aluno:"));
            Aluno aluno = encontrarAluno(ra);
            if (aluno != null) {
                String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");
                aluno.matricular(disciplina);
                JOptionPane.showMessageDialog(null, "Disciplina " + disciplina + " matriculada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "RA inválido! Digite um número.");
        }
    }

    /**
     * Registra a média de um aluno em uma disciplina.
     */
    private void registrarMedia() {
        try {
            int ra = Integer.parseInt(JOptionPane.showInputDialog("Informe o RA do aluno:"));
            Aluno aluno = encontrarAluno(ra);
            if (aluno != null) {
                String disciplina = JOptionPane.showInputDialog("Digite o nome da disciplina:");
                double media = Double.parseDouble(JOptionPane.showInputDialog("Digite a média do aluno para " + disciplina + ":"));
                aluno.registrarMedia(disciplina, media);
                JOptionPane.showMessageDialog(null, "Média registrada com sucesso!");
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Média inválida! Digite um número.");
        }
    }

    /**
     * Pesquisa um aluno pelo RA e exibe suas informações.
     */
    private void pesquisar() {
        try {
            int ra = Integer.parseInt(JOptionPane.showInputDialog("Informe o RA do aluno para pesquisa:"));
            Aluno aluno = encontrarAluno(ra);
            if (aluno != null) {
                JOptionPane.showMessageDialog(null, "Aluno encontrado:\n" + aluno);
            } else {
                JOptionPane.showMessageDialog(null, "Aluno não encontrado.");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "RA inválido! Digite um número.");
        }
    }

    /**
     * Imprime a lista de todos os alunos cadastrados.
     */
    private void imprimir() {
        if (listaAluno.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Nenhum aluno cadastrado.");
        } else {
            StringBuilder aux = new StringBuilder();
            for (Aluno aluno : listaAluno) {
                aux.append(aluno).append("\n\n");
            }
            JOptionPane.showMessageDialog(null, aux.toString());
        }
    }

    /**
     * Encontra um aluno pelo RA.
     * 
     * @param ra RA do aluno a ser encontrado.
     * @return O objeto Aluno correspondente ou null se não encontrado.
     */
    private Aluno encontrarAluno(int ra) {
        for (Aluno aluno : listaAluno) {
            if (aluno.getRa() == ra) {
                return aluno;
            }
        }
        return null;
    }
}