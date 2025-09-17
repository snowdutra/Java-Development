import javax.swing.JOptionPane;

class Cidade {
    String nome;
    ListaDupla<Ligacao> ligacoes;

    Cidade(String nome) {
        this.nome = nome;
        this.ligacoes = new ListaDupla<>();
    }

    public void adicionarLigacao(Ligacao ligacao) {
        if (buscarLigacao(ligacao.destino) == null) {
            ligacoes.adicionar(ligacao);
        } else {
            JOptionPane.showMessageDialog(null, "Já existe uma ligação para " + ligacao.destino + "!");
        }
    }

    public Ligacao buscarLigacao(String destino) {
        No<Ligacao> atual = ligacoes.inicio;
        while (atual != null) {
            if (atual.dado.destino.equalsIgnoreCase(destino)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    @Override
    public String toString() {
        return "Cidade: " + nome;
    }
}