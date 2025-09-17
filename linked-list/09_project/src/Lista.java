public class Lista {
    No inicio;
    No fim;

    public void inserir(String dado) {
        No aux = new No(dado);
        if (inicio == null) {
            inicio = fim = aux;
        } else {
            fim.prox = aux;
            fim = aux;
        }
    }

    public void imprimir() {
        No aux = inicio;
        while (aux != null) {
            System.out.println(aux.dado);
            aux = aux.prox;
        }
    }
}