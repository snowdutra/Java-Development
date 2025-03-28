import static javax.swing.JOptionPane.*;
import static java.lang.Integer.parseInt;
import static java.lang.Double.parseDouble;
public class App {
    
    static ListaDupla<Produto> listaProduto = new ListaDupla<>();
    static ListaDupla<Fornecedor> listaFornecedor = new ListaDupla<>();

    public static void main(String[] args) throws Exception {
        
        menuPrincipal();

    }

    public static void menuPrincipal() {
        String menu = "1. Cadastrar produto\n2. Pesquisar produto\n3. Pesquisar fornecedor\n4. Finalizar";
        int opcao;
        int resposta;

        while(true) {
            opcao = parseInt(showInputDialog(menu));
            if(opcao == 4) {
                resposta = showConfirmDialog(null, "Tem certeza que deseja sair?");
                if(resposta == YES_OPTION) {
                    break;
                }
            }
            if(opcao < 1 || opcao > 4) {
                showMessageDialog(null, "Opção inválida");
            }
            else {
                switch(opcao) {
                    case 1:
                        cadastrarProduto();
                        break;
                }
            }
        }
    }

    public static void cadastrarProduto() {
        No<Fornecedor> aux = pesquisar();
        String nome;
        double valorUnitario;
        int qtdEstoque;
        
        if(aux == null) {
            cadastrarFornecedor();
        }

        // cadastro do produto
        nome = showInputDialog("Nome do produto");
        valorUnitario = parseDouble(showInputDialog("Valor unitário do produto"));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        listaProduto.inserir(new Produto(nome, valorUnitario, qtdEstoque, aux.getDado()));
    }

    private static void cadastrarFornecedor() {
        String nome;
        int cnpj;
        nome = showInputDialog("nome do fornecedor");
        cnpj = parseInt(showInputDialog("cnpj"));
        listaFornecedor.inserir(new Fornecedor(nome, cnpj));
    }

    public static No<Fornecedor> pesquisar() {
        int cnpj = parseInt(showInputDialog("CNPJ para pesquisa"));
        return listaFornecedor.pesquisar(new Fornecedor(cnpj));
    }


}