public class ListaDupla<T> {
    private No<T> inicio;
    private No<T> fim;
    private int tamanho;

    public ListaDupla() {
        this.inicio = null;
        this.fim = null;
        this.tamanho = 0;
    }

    public void inserir(T dado) {
        No<T> aux = new No<>(dado);
        if (estaVazia()) {
            this.inicio = aux;
            this.fim = aux;
        } else {
            this.fim.setProximo(aux);
            aux.setAnterior(this.fim);
            this.fim = aux;
        }
        this.tamanho++;
    }

    public void imprimir() {
        No<T> aux = this.inicio;
        while (aux != null) {
            System.out.print(aux.getDado() + " ");
            aux = aux.getProximo();
        }
        System.out.println();
    }

    public No<T> pesquisar(T dado) {
        for (No<T> aux = this.inicio; aux != null; aux = aux.getProximo()) {
            if (aux.getDado().equals(dado)) {
                return aux;
            }
        }
        return null;
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public void remover(T dado) {
        No<T> aux = this.pesquisar(dado);
        if (aux != null) {
            if (aux.getAnterior() != null) {
                aux.getAnterior().setProximo(aux.getProximo());
            } else {
                this.inicio = aux.getProximo();
            }
            if (aux.getProximo() != null) {
                aux.getProximo().setAnterior(aux.getAnterior());
            } else {
                this.fim = aux.getAnterior();
            }
            aux = null;
            this.tamanho--;
        }
    }
}

