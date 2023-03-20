import java.io.*;
import java.util.*;
import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ActivitySelector {


public static void main(String[] args)throws IOException {
 Scanner scan = new Scanner(System.in);
 System.out.println("Please enter your value for Number of Points!");
 int x = scan.nextInt();
 System.out.println("Please enter your value for Number of Runs!");
 int y = scan.nextInt();
 studyOverhead(x, y);
 System.out.println("Your data has been outputted to outputdiv.txt! \n**Values are outputted for i=1 until i=NumberofPoints**");
}

public static int[] recursiveActivitySelector(int[] array_S, int[] array_F, int k, int n, int[] set_A) {  
   int m = k + 1;
   while (m <= n && array_S[m] < array_F[k]) {
      m = m + 1;
   }
   if (m <= n) {
   set_A[m] = 1;
   recursiveActivitySelector(array_S, array_F, m, n, set_A);
   return set_A;
   }
   else {
   return null;
   }
   }
   
public static int[] iterativeActivitySelector(int[] array_S, int[] array_F, int n, int[] set_A) {
 //n = array_S.length;
 set_A[0] = 1;
 int k = 1; 
 
 for (int m = 2; m < n; m++) {
   if (array_S[m] >= array_F[k]) {
   set_A[m] = 1;
   k = m;
   }
 }
 return set_A;
}

public static void studyOverhead(int numberPoints, int numberRuns)throws IOException {
File f2 = new File("outputdiv.txt");
f2.createNewFile();

FileWriter fw2 = new FileWriter(f2);
   
int[] array_S = new int[numberPoints];
int[] array_F = new int[numberPoints];
double[] m = new double[numberPoints + 1];
  
   for (int i = 1; i < numberPoints; i++) {
      long timeRecursive = 0;
      long timeIterative = 0;
      
      for (int j = 1; j < numberRuns; j++) {
         int[] set_A = new int[i];
         long timeRecursiveStart;
         long timeRecursiveEnd;
         timeRecursiveStart = System.nanoTime();
         recursiveActivitySelector(array_S, array_F, 0, i-1, set_A);
         timeRecursiveEnd = System.nanoTime();
         timeRecursive += timeRecursiveEnd - timeRecursiveStart;
         //fw.write("Recursive time is " + timeRecursive);
         
         long timeIterativeStart;
         long timeIterativeEnd;
         timeIterativeStart = System.nanoTime();
         iterativeActivitySelector(array_S, array_F, i-1, set_A);
         timeIterativeEnd = System.nanoTime();
         timeIterative += timeIterativeEnd - timeIterativeStart;
         //fw.write(" Iterative time is " + timeIterative);
         }
      
      double result = (float)timeRecursive/ (float)timeIterative;
      m[i] = result;
      fw2.write(m[i] + "\n");
      System.out.println(m[i]);
      }
      fw2.close();
      } 
    



public static void initializeArrays(int n, int[] array_S, int[] array_F) {
array_F[0] = 0;
array_S[0] = 0;
for (int i = 0; i < n; i++) {
   if (i % 2 == 0) {
      array_S[i] = array_F[i-2];
      array_F[i] = array_S[i] + 2;
   }
   else {
      array_S[i] = array_F[i-1] - 1;
      array_F[i] = array_F[i-1] + 1;
   }
}
}
}