public class Arvore<T extends Comparable<T>> {
    private No<T> raiz;


    public void inserir(T dado){
        raiz = inserir(raiz, dado);
    }

    private No<T> inserir(No<T> ref, T dado) {
        if (ref == null) {
            return new No<>(dado);
        }

        if (ref.getDado().compareTo(dado) > 0) {
            ref.setDireita(inserir(ref.getDireita(), dado));
        } 
        
        
        else if (ref.getDado().compareTo(dado) < 0) {
            ref.setEsquerda(inserir(ref.getEsquerda(), dado));
        }

        return ref;
    }

    public void preOrdem() {
        preOrdem(raiz);
    }

    private void preOrdem(No<T> ref) {
        
    }

}