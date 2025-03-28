import static java.lang.Integer.parseInt;
import static javax.swing.JOptionPane.*;

public class App {

    private ListaDupla<Produto> listaProduto = new ListaDupla<>();
    private ListaDupla<Fornecedor> listaFornecedor = new ListaDupla<>();

    public static void main(String[] args) throws Exception {
        menuPrincipal();
    }

    private static void menuPrincipal() {
        String menu = "1. Cadastrar produto\n 2. Pesquisar produto \n3. Pesquisar fornecedor\n 4. Finalizar";
        int opcao;
        int resposta;

        while (true) {
            opcao = parseInt(showInputDialog(menu));
            if (opcao == 4) {
                resposta = showConfirmDialog(null, "Tem certeza que deseja sair?");
                if (resposta == YES_OPTION) {
                    break;
                }
            } else if (opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida!");
            } else {
                switch (opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                    case 2:
                        pesquisarProduto();
                        break;
                    case 3:
                        pesquisarFornecedor();
                        break;
                    default:
                        break;
                }
            }
        }
    }

    private static void cadastrarProduto() {
        No<Fornecedor> aux = pesquisar();
        String nome;
        double preco;
        int qtdEstoque;

        if (aux != null) {
            cadastrarFornecedor();
        }

        nome = showInputDialog("Nome do produto");
        preco = parseDouble(showInputDialog("Valor unitario do produto"));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque do produto"));
        listaProduto.inserir(new Produto(nome, preco, qtdEstoque, aux.getDado()));
    }

    private static void cadastrarFornecedor() {
        String nome;
        int cnpj;
        nome = showInputDialog("Nome do fornecedor");
        cnpj = parseInt(showInputDialog("CNPJ do fornecedor"));
        listaFornecedor.inserir(new Fornecedor(cnpj, nome));
    }

    private static No<Fornecedor> pesquisar() {
        int cnpj = parseInt(showInputDialog("Digite o CNPJ do fornecedor"));
        return listaFornecedor.pesquisar(new Fornecedor(cnpj));
    }
}
