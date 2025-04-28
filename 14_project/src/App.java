public class App {
    public static void main(String[] args) throws Exception {
        
        Arvore<Integer> arvore = new Arvore<>();
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(25);
        arvore.inserir(18);


        arvore.preOrdem();
    }
}
