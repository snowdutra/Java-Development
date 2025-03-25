public class Fornecedor  {
    private String nome;
    private int cnpj;

    public Fornecedor(String nome, int cnpj) {
        this.nome = nome;
        this.cnpj = cnpj;
    }

    public Fornecedor(int cnpj) {        
        this.cnpj = cnpj;
    }

    // método equals para comparar dois objetos
    @Override
    public boolean equals(Object obj) {
        Fornecedor f = (Fornecedor) obj;
        return f.cnpj == cnpj;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getCnpj() {
        return cnpj;
    }

    public void setCnpj(int cnpj) {
        this.cnpj = cnpj;
    }

    

}