public class Main {

    public static void main(String[] args) {
        ListaDupla<Produto> lista = new ListaDupla<>();
        
        lista.inserir(new Produto("batata", 15));
        lista.inserir(new Produto("café", 70));
        lista.inserir(new Produto("arroz", 32));
        lista.inserir(new Produto("pimenta", 12));
        
        System.out.println("Lista original:");
        lista.imprimir();
        
        remover(lista, new Produto("arroz"));
        
        System.out.println("Após remover arroz:");
        lista.imprimir();
        
        remover(lista, new Produto("batata"));
        
        System.out.println("Após remover batata:");
        lista.imprimir();
        
        remover(lista, new Produto("pimenta"));
        
        System.out.println("Após remover pimenta:");
        lista.imprimir();
        
        remover(lista, new Produto("café"));
        
    }
    
    public static void remover(ListaDupla<Produto> lista, Produto produto) {
        if (lista.pesquisar(produto) != null) {
            lista.remover(produto);
        }
    }
}

