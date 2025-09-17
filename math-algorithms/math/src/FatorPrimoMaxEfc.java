public class FatorPrimoMaxEfc {
    public static void main(String[] args) {
        long numero = 600851475143L;
        long maiorPrimo = 2;


        while (numero % 2 == 0) {
            numero /= 2;
        }

  
        for (long i = 3; i * i <= numero; i += 2) {
            while (numero % i == 0) {
                maiorPrimo = i;
                numero /= i;
            }
        }


        if (numero > 2) {
            maiorPrimo = numero;
        }

        System.out.println("O maior divisor primo de 600851475143 é: " + maiorPrimo);
    }
}
