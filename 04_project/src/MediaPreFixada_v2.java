/*
 * nesta primeira versão, o cálculo da média é realizado em O(n). 
 * Esse método é bem melhor em relação a versão 1
 */

 import java.util.Scanner;

 public class MediaPreFixada_v2{
     public static void main(String[] args) {
         
         Scanner sc = new Scanner(System.in);
         int[] x = {2, 7, 10, 9, 5, 4, 1, 3, 9, 15};
         double[] media = new double[x.length];
         int soma = 0;
 
         // cálculo da média pré fixada
         for(int i = 0; i < x.length; i++) {
             soma += x[i];            
             media[i] = soma / (i + 1);
         }
 
         
         // impressão do vetor de médias
         for(int i = 0; i < media.length; i++) {
             System.out.println(media[i] + " ");
         }
         sc.close();
     }
 }