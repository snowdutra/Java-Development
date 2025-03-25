public class Ordenacao {
    public static void main(String[] args) {
        int[] x = { 1, 2, 3, 5, 6, 7, 8, 9, 10 };
        int total = 0;
        
        for (int j = 0; j < x.length; j++) {
            for (int i = 0; i < x.length - 1; i++) {
                if (x[i] > x[i + 1]) {
                    int aux = x[i];
                    x[i] = x[i + 1];
                    x[i + 1] = aux;
                    total++;
                }
            }
        }
        System.out.println(total);
    }
}
