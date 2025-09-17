public class MaiorPalindromo {
    public static void main(String[] args) {
        int maiorPalindromo = 0;
        int fator1 = 0, fator2 = 0;
        
        for (int i = 999; i >= 100; i--) {
            for (int j = i; j >= 100; j--) { 
                int produto = i * j;
                if (produto > maiorPalindromo && ehPalindromo(produto)) {
                    maiorPalindromo = produto;
                    fator1 = i;
                    fator2 = j;
                }
            }
        }

        System.out.println("O maior palíndromo obtido pela multiplicação de dois números de três dígitos é: " 
                           + maiorPalindromo + " (" + fator1 + " x " + fator2 + ")");
    }


    public static boolean ehPalindromo(int numero) {
        int original = numero;
        int reverso = 0;
    
        while (numero > 0) {
            int digito = numero % 10; 
            reverso = reverso * 10 + digito; 
            numero /= 10; 
        }
    
        return original == reverso; 
    }
}