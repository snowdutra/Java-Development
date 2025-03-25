public class MediaPreFixada   {

    public static void main(String[] args) {
        int[] x = {10, 5, 12, 3, 2};
        double[] media = new double[x.length];

        for(int i = 0; i < x.length; i++) {
            int soma = 0;
            for(int j = 0; j <= i; j++) {
                soma += x[j];
            }
            media[i] = soma / (i+1);
        }

        for(int i = 0; i < media.length; i++) {
            System.out.println(media[i] + " ");
        }
    }
}