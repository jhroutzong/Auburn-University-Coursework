import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.ThreadLocalRandom;

public class CollectData {

    public static void main(String[] args) throws IOException {
        CollectData.collectData();
    }

    public static void collectData() throws IOException {
        // set up variables
        System.out.println("Setting up variables and generating random data");
        int L = Integer.MAX_VALUE / 9;
        int[] G = generateRandoms(L);
        int[] A = new int[L];

        long startTime;
        long endTime;
        long runningTime;

        double divBySqrtN;
        double divByNLog2N;
        double divByNSquared;

        // set up file output
        FileWriter fileWriter = new FileWriter("runningTime.csv");

        // set up the printWriter object so that we can
        // print output to the output file
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // write first row of csv file (so that Excel knows what's going on)
        printWriter.println("n,T(n),T(n)/sqrt(n),T(n)/(n * log2(n)),T(n)/(n^2)");

        for (int n = 1000; n <= L; n+= 1000) {

            // print n to console
            System.out.print(n + "...");

            // copy array data
            for (int i = 0; i <= n; i++) {
                A[i + 1] = G[i];
            }

            // take start time
            startTime = System.nanoTime();

            // perform merge sort
            mergeSort(A, 0, n-1);

            // take end time
            endTime = System.nanoTime();

            // calculate T(n)
            runningTime = endTime - startTime;

            // calculate T(n) / sqrt(n)
            divBySqrtN = (runningTime / Math.sqrt(n));

            // calculate T(n) / (n * log2(n)), casting to
            // double to ensure floating-point division
            divByNLog2N = (double) runningTime / (n *log2(n));

            // calculate T(n) / (n^2)
            divByNSquared = runningTime / Math.pow(n, 2);

            // set up output
            String output = n + ","
                    + runningTime + ","
                    + divBySqrtN + ","
                    + divByNLog2N + ","
                    + divByNSquared;

            // output to file
            printWriter.println(output);

            // flush buffer to ensure output is written to
            // file immediately
            printWriter.flush();

            // print to console
            System.out.println("Done!");
        }
    }

    private static int log2(int x) {
        return (int) (Math.log(x) / Math.log(2));
    }

    private static int[] generateRandoms(int arraySize) {
        int[] A = new int[arraySize];

        for (int i = 0; i < arraySize; i++) {
            A[i] = ThreadLocalRandom.current().nextInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        }

        return A;
    }

    public static void mergeSort(int[] A, int p, int r) {
        // A is the array to be sorted
        // p is the starting index to sort
        // r is the end index to sort

        if (p < r) {
            int q = (int) Math.floor(((float)p + r) / 2);
            // System.out.println("q: " + q);
            mergeSort(A, p, q);
            mergeSort(A, q + 1, r);
            merge(A, p, q, r);
        }
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n1 = q - p + 1;
        int n2 = r - q;

        int[] L = new int[n1 + 2];
        int[] R = new int[n2 + 2];

        for (int i = 1; i <= n1; i++) {
            L[i] = A[p + i - 1];
        }

        for (int j = 1; j <= n2; j++) {
            R[j] = A[q + j];
        }

        L[n1 + 1] = Integer.MAX_VALUE;
        R[n2 + 1] = Integer.MAX_VALUE;

        int i = 1;
        int j = 1;

        for (int k = p; k <= r; k++) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
        }
    }
}
