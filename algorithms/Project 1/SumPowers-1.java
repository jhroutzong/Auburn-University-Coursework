public class SumPowers {

    public static double computeSumPowers(double x, int n) {
        double sum = 0;

        for (int i = 1; i <= n; i++) {
            double prod = 1;

            for (int j = 1; j <= i; j++) {
                prod = prod * x;
            }

            sum = sum + prod;
        }

        return sum;
    }
}
