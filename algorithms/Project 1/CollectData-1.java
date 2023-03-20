import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class CollectData {

    public static void collectData() throws IOException {
        // declare start and end time variables here so that they
        // don't keep getting re-declared in the "for" loop below
        long startTime;
        long endTime;

        // same here for the time calculation variables
        long runningTime;
        double dividedByN;
        double dividedByNSquared;
        double dividedByLnOfN;

        String output;

        // set up the output file
        FileWriter fileWriter = new FileWriter("sumPowersRunningTime.csv");

        // set up the printWriter object so that we can
        // print output to the output file
        PrintWriter printWriter = new PrintWriter(fileWriter);

        // write first row of csv file (so that Excel knows what's going on)
        printWriter.println("n,T(n)/n,T(n)/(n^2),T(n)/ln(n)");

        for (int n = 100; n <= 1000000; n += 100) {
            // determine running time
            startTime = System.nanoTime();
            SumPowers.computeSumPowers(0.5, n);
            endTime = System.nanoTime();

            // calculate T(n)
            runningTime = endTime - startTime;

            // calculate T(n)/n, casting runningTime to double to enable
            // floating-point division
            dividedByN = (double) runningTime / n;

            // calculate T(n) / Math.pow(n, 2)
            dividedByNSquared = (double) runningTime / Math.pow(n, 2);

            // calculate T(n) / ln(n)
            dividedByLnOfN = (double) runningTime / Math.log(n);

            // set up output
            output = n + ","
                    + dividedByN + ","
                    + dividedByNSquared + ","
                    + dividedByLnOfN;

            // output to file
            printWriter.println(output);

            // ensure output is written to file in case we need to
            // suspend execution before reaching the maximum value of n
            printWriter.flush();

            // print something to console so that we know the current value
            // of n
            System.out.println(n);
        }
    }
}
