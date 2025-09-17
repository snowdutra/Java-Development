import javax.swing.JOptionPane;

public class SistemaEntregas {
    static ListaDupla<Cidade> cidades = new ListaDupla<>();

    public static void main(String[] args) {
        while (true) {
            String[] menuPrincipal = {
                "Gerenciar Cidades",
                "Gerenciar Ligações",
                "Sair"
            };

            int escolhaPrincipal = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu Principal",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                menuPrincipal,
                menuPrincipal[0]
            );

            if (escolhaPrincipal == -1 || (escolhaPrincipal == 2 && confirmarSaida())) break;

            switch (escolhaPrincipal) {
                case 0 -> menuCidades();
                case 1 -> menuLigacoes();
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void menuCidades() {
        String[] opcoesCidades = {
            "Cadastrar cidade",
            "Listar cidades",
            "Voltar"
        };

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu de Cidades",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoesCidades,
                opcoesCidades[0]
            );

            if (escolha == -1 || escolha == 2) break;

            switch (escolha) {
                case 0 -> cadastrarCidade();
                case 1 -> listarCidades();
                default -> JOptionPane.showMessageDialog(null, "Opção inválida!");
            }
        }
    }

    private static void menuLigacoes() {
        String[] opcoesLigacoes = {
            "Cadastrar ligação",
            "Buscar ligação",
            "Calcular tempo total da rota",
            "Filtrar rotas por tempo máximo",
            "Editar ligação",
            "Voltar"
        };

        while (true) {
            int escolha = JOptionPane.showOptionDialog(
                null,
                "Escolha uma opção:",
                "Menu de Ligações",
                JOptionPane.DEFAULT_OPTION,
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcoesLigacoes,
                opcoesLigacoes[0]
            );

            if (escolha == -1 || escolha == 5) break;

            switch (escolha) {
                case 0 -> cadastrarLigacao();
                case 1 -> buscarLigacao();
                case 2 -> calcularTempoRota();
                case 3 -> filtrarRotasPorTempo();
                case 4 -> editarLigacao();
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

            if (distancia < 0 || trafego < 0 || pedagios < 0) {
                JOptionPane.showMessageDialog(null, "Valores negativos não são permitidos!");
                return;
            }

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

    private static void editarLigacao() {
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
                String[] opcoesEdicao = {
                    "Alterar destino",
                    "Alterar distância",
                    "Alterar fator de tráfego",
                    "Alterar número de pedágios",
                    "Cancelar"
                };

                int escolha = JOptionPane.showOptionDialog(
                    null,
                    "O que deseja editar?",
                    "Editar Ligação",
                    JOptionPane.DEFAULT_OPTION,
                    JOptionPane.PLAIN_MESSAGE,
                    null,
                    opcoesEdicao,
                    opcoesEdicao[0]
                );

                switch (escolha) {
                    case 0 -> {
                        String novoDestino = JOptionPane.showInputDialog("Novo destino:");
                        if (novoDestino != null && !novoDestino.equals("")) {
                            ligacao.destino = novoDestino;
                            JOptionPane.showMessageDialog(null, "Destino alterado com sucesso!");
                        } else {
                            JOptionPane.showMessageDialog(null, "Destino inválido!");
                        }
                    }
                    case 1 -> {
                        String novaDistanciaStr = JOptionPane.showInputDialog("Nova distância:");
                        if (novaDistanciaStr != null && !novaDistanciaStr.isEmpty()) {
                            double novaDistancia = Double.parseDouble(novaDistanciaStr);
                            if (novaDistancia >= 0) {
                                ligacao.distancia = novaDistancia;
                                JOptionPane.showMessageDialog(null, "Distância alterada com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Distância inválida!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                        }
                    }
                    case 2 -> {
                        String novoTrafegoStr = JOptionPane.showInputDialog("Novo fator de tráfego:");
                        if (novoTrafegoStr != null && !novoTrafegoStr.isEmpty()) {
                            double novoTrafego = Double.parseDouble(novoTrafegoStr);
                            if (novoTrafego >= 0) {
                                ligacao.fatorTrafego = novoTrafego;
                                JOptionPane.showMessageDialog(null, "Fator de tráfego alterado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Fator de tráfego inválido!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                        }
                    }
                    case 3 -> {
                        String novoPedagioStr = JOptionPane.showInputDialog("Novo número de pedágios:");
                        if (novoPedagioStr != null && !novoPedagioStr.isEmpty()) {
                            int novoPedagio = Integer.parseInt(novoPedagioStr);
                            if (novoPedagio >= 0) {
                                ligacao.pedagios = novoPedagio;
                                JOptionPane.showMessageDialog(null, "Número de pedágios alterado com sucesso!");
                            } else {
                                JOptionPane.showMessageDialog(null, "Número de pedágios inválido!");
                            }
                        } else {
                            JOptionPane.showMessageDialog(null, "Por favor, insira um valor numérico válido.");
                        }
                    }
                    default -> JOptionPane.showMessageDialog(null, "Edição cancelada!");
                }
            } else {
                JOptionPane.showMessageDialog(null, "Ligação não encontrada!");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Cidade de origem não encontrada!");
        }
    }
}