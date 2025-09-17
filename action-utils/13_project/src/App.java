import java.util.LinkedList;
import java.util.Queue;
import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;

public class App {
    static Queue<Acao> carteira = new LinkedList<>();
    static double lucro = 0.0; // Variável lucro declarada como variável de instância

    public static void main(String[] args) throws Exception {        
        String menu = "1. Comprar\n2. Vender\n3. Finalizar";
        int opcao;

        while (true) {
            try {
                opcao = parseInt(showInputDialog(menu));
                switch (opcao) {
                    case 1:
                        comprar();
                        break;
                    case 2:
                        vender();
                        break;
                    case 3:
                        showMessageDialog(null, "Finalizando o programa...");
                        return; // Encerra o loop e o programa
                    default:
                        showMessageDialog(null, "Opção inválida");
                }
            } catch (NumberFormatException e) {
                showMessageDialog(null, "Entrada inválida. Por favor, insira um número.");
            }
        }
    }

    private static void vender() {
        try {
            int quantidade_Vendida = parseInt(showInputDialog("Quantidade vendida"));
            double valor = parseDouble(showInputDialog("Valor da ação"));
            int qtd;
            Acao acao;

            while (quantidade_Vendida > 0 && !carteira.isEmpty()) {
                acao = carteira.peek();
                qtd = Math.min(quantidade_Vendida, acao.getQuantidade());
                lucro += qtd * (valor - acao.getValor());
                quantidade_Vendida -= qtd;
                acao.setQuantidade(acao.getQuantidade() - qtd);
                if (acao.getQuantidade() == 0) {
                    carteira.poll(); // Remove a ação da fila
                }
            }
            showMessageDialog(null, "Lucro R$: " + lucro);
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Entrada inválida. Por favor, insira valores numéricos.");
        }
    }

    private static void comprar() {
        try {
            String nome = showInputDialog("Nome da ação");
            int quantidade = parseInt(showInputDialog("Quantidade comprada"));
            double valor = parseDouble(showInputDialog("Valor da ação"));
            carteira.add(new Acao(nome, quantidade, valor));
        } catch (NumberFormatException e) {
            showMessageDialog(null, "Entrada inválida. Por favor, insira valores numéricos.");
        }
    }
}