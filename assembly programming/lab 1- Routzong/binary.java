import java.util.Scanner;
/**
* Programming Exercise 1
* @author Jacob Routzong
* @version 03/09/2021
* Prompts the user to enter a 0 or a 1 and prints.
*/

public class binary {

   public static void main(String args[]) {
   
   char code = 0;
   
   Scanner scan = new Scanner(System.in);
   
   System.out.print("Enter a character c that represents a binary bit: ");
   code = scan.next().charAt(0); 
   
   if (code == '0') {
   System.out.print("Your character's value in decimal is " + code + "!");
   }
   else {
   if (code == '1') {
   System.out.print("Your character's value in decimal is " + code + "!");
   }
   else {
   System.out.print("The character " + code + " is invalid: " + code
      + " is not a bit.");
   }}
}
}
   