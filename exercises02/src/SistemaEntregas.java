import javax.swing.JOptionPane;

public class SistemaEntregas {
    static ListaDupla<Cidade> cidades = new ListaDupla<>();

    public static void main(String[] args) {
        while (true) {
            String opcao = JOptionPane.showInputDialog(null, """
                                                             Escolha uma opção:
                                                             1. Cadastrar cidade
                                                             2. Cadastrar ligação
                                                             3. Listar cidades e ligações
                                                             4. Buscar ligação
                                                             5. Calcular tempo total da rota
                                                             6. Filtrar rotas por tempo máximo
                                                             7. Sair""");

            if (opcao == null || (opcao.equals("7") && confirmarSaida())) break;

            switch (opcao) {
                case "1" -> cadastrarCidade();
                case "2" -> cadastrarLigacao();
                case "3" -> listarCidades();
                case "4" -> buscarLigacao();
                case "5" -> calcularTempoRota();
                case "6" -> filtrarRotasPorTempo();
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static boolean confirmarSaida() {
        int confirmacao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja sair?", "Confirmação", JOptionPane.YES_NO_OPTION);
        return confirmacao == JOptionPane.YES_OPTION;
    }

    private static void cadastrarCidade() {
        String nomeCidade = JOptionPane.showInputDialog("Nome da cidade:");
        if (nomeCidade != null && !nomeCidade.equals("") && buscarCidade(nomeCidade) == null) {
            cidades.adicionar(new Cidade(nomeCidade));
        } else {
            JOptionPane.showMessageDialog(null, "Cidade já cadastrada ou nome inválido!");
        }
    }

    private static void cadastrarLigacao() {
        String cidadeOrigem = JOptionPane.showInputDialog("Cidade de origem:");
        String cidadeDestino = JOptionPane.showInputDialog("Cidade de destino:");
        
        if (cidadeOrigem == null || cidadeDestino == null || cidadeOrigem.equals("") || cidadeDestino.equals("")) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }

        String distanciaStr = JOptionPane.showInputDialog("Distância:");
        String trafegoStr = JOptionPane.showInputDialog("Fator de tráfego:");
        String pedagiosStr = JOptionPane.showInputDialog("Número de pedágios:");
        
        if (distanciaStr == null || trafegoStr == null || pedagiosStr == null) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }

        try {
            double distancia = Double.parseDouble(distanciaStr);
            double trafego = Double.parseDouble(trafegoStr);
            int pedagios = Integer.parseInt(pedagiosStr);

            Cidade origem = buscarCidade(cidadeOrigem);
            if (origem != null) {
                origem.adicionarLigacao(new Ligacao(cidadeDestino, distancia, trafego, pedagios));
            } else {
                JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada!");
            }
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira valores numéricos válidos.");
        }
    }

    private static Cidade buscarCidade(String nome) {
        No<Cidade> atual = cidades.inicio;
        while (atual != null) {
            if (atual.dado.nome.equalsIgnoreCase(nome)) {
                return atual.dado;
            }
            atual = atual.proximo;
        }
        return null;
    }

    private static void listarCidades() {
        String resultado = "Cidades e suas ligações:\n";
        No<Cidade> atual = cidades.inicio;
        while (atual != null) {
            resultado += atual.dado + "\n";
            No<Ligacao> ligacaoAtual = atual.dado.ligacoes.inicio;
            while (ligacaoAtual != null) {
                resultado += "  " + ligacaoAtual.dado + "\n";
                ligacaoAtual = ligacaoAtual.proximo;
            }
            atual = atual.proximo;
        }
        JOptionPane.showMessageDialog(null, resultado);
    }

    private static void buscarLigacao() {
        String cidadeOrigem = JOptionPane.showInputDialog("Cidade de origem:");
        String cidadeDestino = JOptionPane.showInputDialog("Cidade de destino:");
        if (cidadeOrigem == null || cidadeDestino == null || cidadeOrigem.equals("") || cidadeDestino.equals("")) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }

        Cidade origem = buscarCidade(cidadeOrigem);
        if (origem != null) {
            Ligacao ligacao = origem.buscarLigacao(cidadeDestino);
            if (ligacao != null) {
                JOptionPane.showMessageDialog(null, ligacao.toString());
            } else {
                JOptionPane.showMessageDialog(null, "Ligação não encontrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada!");
        }
    }

    private static void calcularTempoRota() {
        String rota = JOptionPane.showInputDialog("Digite a rota (ex: Cidade1,Cidade2,Cidade3):");
        if (rota == null || rota.equals("")) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }

        String[] cidadesRota = rota.split(",");
        double tempoTotal = 0;
        for (int i = 0; i < cidadesRota.length - 1; i++) {
            Cidade origem = buscarCidade(cidadesRota[i].strip());
            if (origem == null) {
                JOptionPane.showMessageDialog(null, "Cidade " + cidadesRota[i] + " não encontrada!");
                return;
            }
            Ligacao ligacao = origem.buscarLigacao(cidadesRota[i + 1].strip());
            if (ligacao == null) {
                JOptionPane.showMessageDialog(null, "Ligação entre " + cidadesRota[i] + " e " + cidadesRota[i + 1] + " não encontrada!");
                return;
            }
            tempoTotal += ligacao.calcularTempo();
        }
        JOptionPane.showMessageDialog(null, "Tempo total da rota: " + tempoTotal + " minutos.");
    }

    private static void filtrarRotasPorTempo() {
        String tempoMaxStr = JOptionPane.showInputDialog("Digite o tempo máximo (em minutos):");
        if (tempoMaxStr == null || tempoMaxStr.equals("")) {
            JOptionPane.showMessageDialog(null, "Entrada inválida!");
            return;
        }

        try {
            double tempoMax = Double.parseDouble(tempoMaxStr);
            String resultado = "Rotas com tempo menor ou igual a " + tempoMax + " minutos:\n";
            No<Cidade> atual = cidades.inicio;
            while (atual != null) {
                No<Ligacao> ligacaoAtual = atual.dado.ligacoes.inicio;
                while (ligacaoAtual != null) {
                    if (ligacaoAtual.dado.calcularTempo() <= tempoMax) {
                        resultado += atual.dado.nome + " -> " + ligacaoAtual.dado + "\n";
                    }
                    ligacaoAtual = ligacaoAtual.proximo;
                }
                atual = atual.proximo;
            }
            JOptionPane.showMessageDialog(null, resultado);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
        }
    }
}