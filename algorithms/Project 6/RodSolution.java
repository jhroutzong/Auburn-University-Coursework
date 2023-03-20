public class RodSolution {

   public static void main(String[] args) {
      RodSolution rc = new RodSolution();
      int[] prices = { 1, 5, 8, 9, 10, 17, 17, 20, 24, 30 };
   
      for (int i = 0; i < prices.length + 1; i++) {
         int max1 = rc.memoizedCutRod(prices, i);
         System.out.printf("memoized max: %d%n", max1);
         rc.printCutRodSolution(prices, i);
         System.out.println("----------------");
      }
   
   }

       //Memoization

   public int memoizedCutRod(int[] prices, int n) {
      int[] revs = new int[n + 1];
      for (int i = 0; i < revs.length; i++) {
         revs[i] = -1;
      }
      return memoizedCutRodAux(prices, n, revs);
   }

   private int memoizedCutRodAux(int[] prices, int n, int[] revs) {
      if (revs[n] >= 0) {
         return revs[n];
      }
      int max = Integer.MIN_VALUE;
      if (n == 0) {
         max = 0;
      } else {
         for (int i = 0; i < n; i++) {
            max = Math.max(max, prices[i] + memoizedCutRodAux(prices, n - i - 1, revs));
         }
      }
      revs[n] = max;
      return max;
   }
   
   
   public int[][] extendedBottomUpCutRod(int[] prices, int n) {
      int[] revs = new int[n + 1];
      int[] size = new int[n + 1];
      
      revs[0] = 0;
      int max = Integer.MIN_VALUE;
      for (int j = 1; j <= n; j++) {
         max = Integer.MIN_VALUE;
         for (int i = 0; i < j; i++) {
            if (max < prices[i] + revs[j - i - 1]) {
               max = prices[i] + revs[j - i - 1];
               size[j] = i + 1;
            }
         }
         revs[j] = max;
      }
      
      int[][] rs = new int[2][n + 1];
      for (int i = 0; i < n + 1; i++) {
         rs[0][i] = revs[i];
         rs[1][i] = size[i];
      }
      return rs;
   }

   public void printCutRodSolution(int[] prices, int n) {
      int[][] revsAndSize = extendedBottomUpCutRod(prices, n);
      int maxRevenue = revsAndSize[0][n];
      int[] size = revsAndSize[1];
      while (n > 0) {
         System.out.println(size[n]);
         n -= size[n];
      }
      System.out.printf("max revenue: %d%n", maxRevenue);
   }
}