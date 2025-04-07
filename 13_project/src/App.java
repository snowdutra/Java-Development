import java.util.Scanner;
import java.util.Stack;


public class App {
    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        String expressao,polonesa;

        System.out.println("Digite a expressão (notação infixa): ");
        expressao = sc.nextLine().toUpperCase();


        polonesa = converter(expressao);

        System.out.println(polonesa);
    }

    private static String converter(String expressao) {
        Stack<Character> pilha = new Stack<>();
        String polonesa = "";
        char ch;

        for(int i = 0; i < expressao.length(); i++){
            ch = expressao.charAt(i);
        }

        return polonesa;
    }
}
