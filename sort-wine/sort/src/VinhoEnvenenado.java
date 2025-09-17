import java.util.Random;
import java.util.Scanner;

public class VinhoEnvenenado {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n, garrafaEnvenenada, testadores;
        int aux;

        System.out.print("Número de garrafas --> ");
        n = sc.nextInt();
        
        // gera um valor aleatório entre 0 e n representando a garrafa envenenada
        garrafaEnvenenada = new Random().nextInt(n); 
        
        // determina a quantidade de testadores --> O(log n)
        // Math.log() está na base, portanto uma mudança de base deve ser realizada
        testadores = (int) Math.ceil(Math.log(n) / Math.log(2)); 

        // array de testadores --> array boolean
        boolean[] cemiterio = new boolean[testadores];

        // simulação
        for (int i = 0; i < testadores; i++) {
            aux = 1 << i;
            if ((garrafaEnvenenada & (aux)) != 0) { 
                cemiterio[i] = true; 
            }
        }

        // qual a garrfa envenenada?
        int garrafa = 0;
        for (int i = 0; i < testadores; i++) {
            if (cemiterio[i]) {
                garrafa |= (1 << i);
            }
        }

        System.out.println("Garrafa envenenada: " + garrafaEnvenenada);
        System.out.println("Garrafa detectada: " + garrafa);
        System.out.println(garrafaEnvenenada == garrafa ? "Sucesso!" : "Falha!");

        sc.close();
    }
}
