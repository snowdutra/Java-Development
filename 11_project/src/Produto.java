public class Produto {
    private String nome;
    private double valorUnitario;
    private int quantidadeEstoque;
    private Fornecedor fornecedor;

    public Produto(String nome, double valorUnitario, int quantidadeEstoque, Fornecedor fornecedor) {
        this.nome = nome;
        this.valorUnitario = valorUnitario;
        this.quantidadeEstoque = quantidadeEstoque;
        this.fornecedor = fornecedor;
    }

    public Produto(String nome) {
        this.nome = nome;
    }
    
    @Override
    public boolean equals(Object obj) {
        Produto produto = (Produto) obj;
        return produto.nome.equalsIgnoreCase(nome);
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getValorUnitario() {
        return valorUnitario;
    }

    public void setValorUnitario(double valorUnitario) {
        this.valorUnitario = valorUnitario;
    }

    public int getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(int quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    

}