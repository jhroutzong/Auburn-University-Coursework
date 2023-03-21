import java.util.Scanner;
/**
* Programming assignment 2b - CPSC 3303
* @author Jacob Routzong
* @version 03/15/2021
*/

public class hexadecimalString { 

   public static void main(String args []) {
   
   Scanner scan = new Scanner(System.in);
   
   String hexinput = "";
   int number1 = 0;
   int number2 = 0;
   int number3 = 0;
   int number4 = 0;
   
   System.out.print("Please enter a 4-character string that represents a hexadecimal value: ");
   hexinput = scan.nextLine();
   
   switch (hexinput.charAt(0)) {
   case '0':
      number1 = 0;
      break;
   case '1':
      number1 = 1;
      break;
   case '2':
      number1 = 2;
      break;
   case '3':
      number1 = 3;
      break;
   case '4':
      number1 = 4;
      break;
   case '5':
      number1 = 5;
      break;
   case '6':
      number1 = 6;
      break;
   case '7':
      number1 = 7;
      break;
   case '8':
      number1 = 8;
      break;
   case '9':
      number1 = 9;
      break;
   case 'A':
      number1 = 10;
      break;
   case 'B':
      number1 = 11;
      break;
   case 'C':
      number1 = 12;
      break;
   case 'D':
      number1 = 13;
      break;
   case 'E':
      number1 = 14;
      break;
   case 'F':
      number1 = 15;
   }
   switch (hexinput.charAt(1)) {
   case '0':
      number2 = 0;
      break;
   case '1':
      number2 = 1;
      break;
   case '2':
      number2 = 2;
      break;
   case '3':
      number2 = 3;
      break;
   case '4':
      number2 = 4;
      break;
   case '5':
      number2 = 5;
      break;
   case '6':
      number2 = 6;
      break;
   case '7':
      number2 = 7;
      break;
   case '8':
      number2 = 8;
      break;
   case '9':
      number2 = 9;
      break;
   case 'A':
      number2 = 10;
      break;
   case 'B':
      number2 = 11;
      break;
   case 'C':
      number2 = 12;
      break;
   case 'D':
      number2 = 13;
      break;
   case 'E':
      number2 = 14;
      break;
   case 'F':
      number2 = 15;
   }
   switch (hexinput.charAt(2)) {
   case '0':
      number3 = 0;
      break;
   case '1':
      number3 = 1;
      break;
   case '2':
      number3 = 2;
      break;
   case '3':
      number3 = 3;
      break;
   case '4':
      number3 = 4;
      break;
   case '5':
      number3 = 5;
      break;
   case '6':
      number3 = 6;
      break;
   case '7':
      number3 = 7;
      break;
   case '8':
      number3 = 8;
      break;
   case '9':
      number3 = 9;
      break;
   case 'A':
      number3 = 10;
      break;
   case 'B':
      number3 = 11;
      break;
   case 'C':
      number3 = 12;
      break;
   case 'D':
      number3 = 13;
      break;
   case 'E':
      number3 = 14;
      break;
   case 'F':
      number3 = 15;
   }
   switch (hexinput.charAt(3)) {
   case '0':
      number4 = 0;
      break;
   case '1':
      number4 = 1;
      break;
   case '2':
      number4 = 2;
      break;
   case '3':
      number4 = 3;
      break;
   case '4':
      number4 = 4;
      break;
   case '5':
      number4 = 5;
      break;
   case '6':
      number4 = 6;
      break;
   case '7':
      number4 = 7;
      break;
   case '8':
      number4 = 8;
      break;
   case '9':
      number4 = 9;
      break;
   case 'A':
      number4 = 10;
      break;
   case 'B':
      number4 = 11;
      break;
   case 'C':
      number4 = 12;
      break;
   case 'D':
      number4 = 13;
      break;
   case 'E':
      number4 = 14;
      break;
   case 'F':
      number4 = 15;
   }
   
   int finalvalue = number1 + number2 + number3 + number4;
   
   System.out.print("Your hexadecimals value in decimal is: " + finalvalue + "!");
   
   
   }
} 
      //if string ! 4 char, print error
   //if string has g, h, i, j, k, l, m, n, o, p, q, r, s, t, u, v, w, x, y, z print error