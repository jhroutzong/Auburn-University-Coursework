import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import java.io.File;
import java.lang.Math;
import java.io.FileWriter;

public class equationFinder {

   public static void main(String[] args) throws FileNotFoundException, IOException {
      //fileReader
      String filePath = "/Users/jacobroutzong/Desktop/Comp Sci/m2 pa/Writer/data.txt";
      File file = new File(filePath);
      //fileWriter
      File filename = new File("data1.txt");
                FileWriter fw = new FileWriter(filename);
      
      
      try { 
      Scanner sc = new Scanner(file);
      
      while (sc.hasNext())  {
         String line = sc.next();
         String line2 = sc.next();
           int a = Integer.parseInt(line);
           int b = Integer.parseInt(line2);
           fw.write("n = " + line + " height = " + line2);
           fw.write("\n\n");
           fw.write("h (n) / lg (n) = " + (b / (Math.log(a) / Math.log(2))));
           fw.write("\n\n");
           double f = (double) b / (double) a;
           fw.write("h (n) / n = "+ f);
           fw.write("\n\n");
           fw.write("h (n) / n^2 = " + (b / (Math.pow(a, 2))));
           fw.write("\n\n");
           
           
           // System.out.println(a);
      //      System.out.println(b);
      }
      sc.close();
      fw.close();
     } 
      catch (FileNotFoundException e) {
        e.printStackTrace();
   }
}

}
  
   //FileReader fr = new FileReader("data.txt");
