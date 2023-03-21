import java.util.Scanner;
/**
* Programming assignment 2a - CPSC 3303
* @author Jacob Routzong
* @version 03/15/2021
*/
public class binaryString {

   public static void main(String args[]) {
   
   String userbit = "";
   
   Scanner scan = new Scanner(System.in);
   
   System.out.print("Enter a 16-character string that represents binary bit: ");
   userbit = scan.nextLine(); 
   
   int integer1 = Character.getNumericValue(userbit.charAt(0));
   int integer2 = Character.getNumericValue(userbit.charAt(1));
   int integer3 = Character.getNumericValue(userbit.charAt(2));
   int integer4 = Character.getNumericValue(userbit.charAt(3));
   int integer5 = Character.getNumericValue(userbit.charAt(4));
   int integer6 = Character.getNumericValue(userbit.charAt(5));
   int integer7 = Character.getNumericValue(userbit.charAt(6));
   int integer8 = Character.getNumericValue(userbit.charAt(7));
   int integer9 = Character.getNumericValue(userbit.charAt(8));
   int integer10 = Character.getNumericValue(userbit.charAt(9));
   int integer11 = Character.getNumericValue(userbit.charAt(10));
   int integer12 = Character.getNumericValue(userbit.charAt(11));
   int integer13 = Character.getNumericValue(userbit.charAt(12));
   int integer14 = Character.getNumericValue(userbit.charAt(13));
   int integer15 = Character.getNumericValue(userbit.charAt(14));
   int integer16 = Character.getNumericValue(userbit.charAt(15));
   
   
   long finalvalue = integer16 * 1 + integer15 * 2 + integer14 * 4 + integer13 * 8 + integer12 * 16 + integer11 * 32
      + integer10 * 64 + integer9 * 128 + integer8 * 256 + integer7 * 512 + integer6 * 1024 + integer5 * 2048 
      + integer4 * 4096 + integer3 * 8192 + integer2 * 16384 + integer1 * 32768;
   
   
   
   System.out.print("The decimal value of the 16-bit string you entered is: " + finalvalue
      + "!");
      
}
}   
   
   
   //if char ! 0 or 1, print error
   
   //if string ! 16 char, print error