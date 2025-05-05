public class App {
    public static void main(String[] args) {
        Arvore<Integer> arvore = new Arvore<>();
        
        arvore.inserir(10);
        arvore.inserir(5);
        arvore.inserir(25);
        arvore.inserir(18);

        System.out.println("Pre-ordem: ");
        arvore.preOrdem();
        System.out.println("\nEm-ordem: ");
        arvore.emOrdem();
        System.out.println("\nPos-ordem: ");
        arvore.posOrdem();

        System.out.println(arvore.pesquisar(180));
    }
}
