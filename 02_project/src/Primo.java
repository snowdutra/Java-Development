/*
 *  Ler um valor inteiro e imprimir todos os primos no intervalo
 */

 import java.util.Scanner;

 public class Primo {
 
     public static void main(String[] args) {
 
         Scanner sc = new Scanner(System.in);
         int valor;
         boolean primo;
 
         // entrada de dados
         System.out.print("Informe um valor inteiro: ");
         valor = sc.nextInt();
 
         for(int cont = 2; cont <= valor; cont++ ){
             if (cont == 2){
                 System.out.print(cont + " ");
             }
             if (cont % 2 != 0 ){
                 primo = true;
                 for(int i = 2; i < cont; i++){
                     if(cont % i == 0){
                         primo = false;
                         break;
                     }
                 }
                 if(primo){
                     System.out.print(cont + " ");
                 }
 
             }
         }
 
         sc.close();
     }
 
 }