public class Arvore<T extends Comparable<T>> {
    private No<T> raiz;

    private static class No<T> {
        private final T dado;
        private No<T> esquerda;
        private No<T> direita;

        public No(T dado) {
            this.dado = dado;
        }

        public T getDado() {
            return dado;
        }

        public No<T> getEsquerda() {
            return esquerda;
        }

        public void setEsquerda(No<T> esquerda) {
            this.esquerda = esquerda;
        }

        public No<T> getDireita() {
            return direita;
        }

        public void setDireita(No<T> direita) {
            this.direita = direita;
        }
    }

    public void inserir(T dado) {
        raiz = inserir(raiz, dado);
    }

    private No<T> inserir(No<T> ref, T dado) {
        if (ref == null) {
            return new No<>(dado);
        }

        if (ref.getDado().compareTo(dado) > 0) {
            ref.setEsquerda(inserir(ref.getEsquerda(), dado));
        } else if (ref.getDado().compareTo(dado) < 0) {
            ref.setDireita(inserir(ref.getDireita(), dado));
        }

        return ref;
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No<T> ref) {
        if (ref != null) {
            System.out.print(ref.getDado() + " ");
            preOrdem(ref.getEsquerda());
            preOrdem(ref.getDireita());
        }
    }
}