import java.util.Scanner;
/**
* Proramming assignment 2c - CPSC 3303
* Uses logic bitwise operations to convert a number to binary.
* @author Jacob Routzong
* @version 03/15/2021
*/

public class logicBitwise {
   
   public static void main(String args[]) {
   
   Scanner scan = new Scanner(System.in);
   
   long input = 0;
   long finalresult = 0;
   String output = "";
   int count = 0;
   char z;

   System.out.print("Enter a positive integer ranging from 0 to 4294967295: ");
      input = scan.nextLong();
   
   for (int i = 0; i < 16; i++) {
   finalresult = input & 1;
   input = input >> 1;
   output = finalresult + output;
   }
   for (int j = 0; j < 16; j++) {
   z = output.charAt(j);
   if (z == '0') {
   count++; }
   else {
   break; }}
   output = output.substring(count);
   
   System.out.print(output);
}
}
   
    