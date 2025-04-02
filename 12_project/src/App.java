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
                    case 2:
                        pesquisarProduto();
                        break;
                }
            }
        }
    }

    public static void pesquisarProduto() {
        String nome = showInputDialog("Nome do produto");
        No<Produto> aux = listaProduto.pesquisar(new Produto(nome));
        if(aux == null) {
            showMessageDialog(null, nome + " não encontrado");
        }
        else {
            Produto produto = aux.getDado();
            String mensagem = "";
            mensagem += "Nome do produto: " + nome + "\n";
            mensagem += "Quantidade em estoque: " + produto.getQuantidadeEstoque() + "\n";
            mensagem += "Valor unitário R$ " + produto.getValorUnitario() + "\n";
            mensagem += "Fornecedor: " + produto.getFornecedor().getNome();
            showMessageDialog(null, mensagem);
        }
    }

    public static void cadastrarProduto() {
        Fornecedor fornecedor = pesquisar();
        String nome;
        double valorUnitario;
        int qtdEstoque;
        
        if(fornecedor == null) {
            fornecedor = cadastrarFornecedor();
        }

        // cadastro do produto
        nome = showInputDialog("Nome do produto");
        valorUnitario = parseDouble(showInputDialog("Valor unitário do produto"));
        qtdEstoque = parseInt(showInputDialog("Quantidade em estoque"));
        listaProduto.inserir(new Produto(nome, valorUnitario, qtdEstoque, fornecedor));
    }

    private static Fornecedor cadastrarFornecedor() {
        String nome;
        int cnpj;
        Fornecedor fornecedor;

        nome = showInputDialog("nome do fornecedor");
        cnpj = parseInt(showInputDialog("cnpj"));
        fornecedor = new Fornecedor(nome, cnpj);
        listaFornecedor.inserir(fornecedor);
        return fornecedor;
    }

    public static Fornecedor pesquisar() {
        Fornecedor fornecedor = null;
        No<Fornecedor> aux;

        int cnpj = parseInt(showInputDialog("CNPJ para pesquisa"));
        aux = listaFornecedor.pesquisar(new Fornecedor(cnpj));
        if(aux != null) {
            fornecedor = aux.getDado();
            showMessageDialog(null, fornecedor.getNome() + " cadastrado");
        }
        else {
            showMessageDialog(null, cnpj + " não encontrado");
        }

        return fornecedor; 
    }


}