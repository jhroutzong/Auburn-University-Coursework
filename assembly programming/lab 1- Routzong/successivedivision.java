import java.util.Scanner;
import java.text.DecimalFormat;
/**
* Programming Exercise 3
* @author Jacob Routzong
* @version 03/10/2021
* Prompts a user for a positive 32 bit integer and prints in binary.
*/

public class successivedivision {

   public static void main(String args[]) {
   
   Scanner scan = new Scanner(System.in);
   
   DecimalFormat df = new DecimalFormat("###############################0");
   
   long uservalue = 0;
   long bitvalue32 = 0;
   long uservalue1 = 0;
   long bitvalue31 = 0;
   long uservalue2 = 0;
   long bitvalue30 = 0;
   long uservalue3 = 0;
   long bitvalue29 = 0;
   long uservalue4 = 0;
   long bitvalue28 = 0;
   long uservalue5 = 0;
   long bitvalue27 = 0;
   long uservalue6 = 0;
   long bitvalue26 = 0;
   long uservalue7 = 0;
   long bitvalue25 = 0;
   long uservalue8 = 0;
   long bitvalue24 = 0;
   long uservalue9 = 0;
   long bitvalue23 = 0;
   long uservalue10 = 0;
   long bitvalue22 = 0;
   long uservalue11 = 0;
   long bitvalue21 = 0;
   long uservalue12 = 0;
   long bitvalue20 = 0;
   long uservalue13 = 0;
   long bitvalue19 = 0;
   long uservalue14 = 0;
   long bitvalue18 = 0;
   long uservalue15 = 0;
   long bitvalue17 = 0;
   long uservalue16 = 0;
   long bitvalue16 = 0;
   long uservalue17 = 0;
   long bitvalue15 = 0;
   long uservalue18 = 0;
   long bitvalue14 = 0;
   long uservalue19 = 0;
   long bitvalue13 = 0;
   long uservalue20 = 0;
   long bitvalue12 = 0;
   long uservalue21 = 0;
   long bitvalue11 = 0;
   long uservalue22 = 0;
   long bitvalue10 = 0;
   long uservalue23 = 0;
   long bitvalue9 = 0;
   long uservalue24 = 0;
   long bitvalue8 = 0;
   long uservalue25 = 0;
   long bitvalue7 = 0;
   long uservalue26 = 0;
   long bitvalue6 = 0;
   long uservalue27 = 0;
   long bitvalue5 = 0;
   long uservalue28 = 0;
   long bitvalue4 = 0;
   long uservalue29 = 0;
   long bitvalue3 = 0;
   long uservalue30 = 0;
   long bitvalue2 = 0;
   long uservalue31 = 0;
   long bitvalue1 = 0;
   long uservalue32 = 0;
   long bitvalue = 0;
   long uservalue0 = 0;
   
   System.out.print("Please enter a positive integer from 0 to 4294967295: ");
   uservalue = scan.nextLong();
   
   if (uservalue >= 0) {
   bitvalue32 = uservalue % 2;
   uservalue1 = uservalue / 2; }
   else {
   System.out.print("Invalid: Your entered input is not a positive integer."); }
   if (uservalue1 >= 0) {
   bitvalue31 = uservalue1 % 2;
   uservalue2 = uservalue1 / 2; }
   else { 
   System.out.print("The binary value of the decimal integer you entered is: " + bitvalue32); }
   if (uservalue2 >= 0) {
   bitvalue30 = uservalue2 % 2;
   uservalue3 = uservalue2 / 2; }
   else {
   System.out.print("The binary value of the decimal integer you entered is: " + bitvalue31
      + bitvalue32);   }
   if (uservalue3 >= 0) {
   bitvalue29 = uservalue3 % 2;
   uservalue4 = uservalue3 / 2; }
   else { 
   System.out.print("The binary value of the decimal integer you entered is: " + bitvalue30
      + bitvalue31 + bitvalue32);   }
   if (uservalue4 >= 0) {
   bitvalue28 = uservalue4 % 2;
   uservalue5 = uservalue4 / 2; }
   else {
   System.out.print("The binary value of the decimal integer you entered is: " + bitvalue29 
      + bitvalue30 + bitvalue31 + bitvalue32);    }
   if (uservalue5 >= 0) {
   bitvalue27 = uservalue5 % 2;
   uservalue6 = uservalue5 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue28
      + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);   }
   if (uservalue6 >= 0) {
   bitvalue26 = uservalue6 % 2;
   uservalue7 = uservalue6 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue27
      + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);   }
   if (uservalue7 >= 0) {
   bitvalue25 = uservalue7 % 2;
   uservalue8 = uservalue7 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue26
      + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);  }
   if (uservalue8 >= 0) {
   bitvalue24 = uservalue8 % 2;
   uservalue9 = uservalue8 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue25
      + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue9 >= 0) {
   bitvalue23 = uservalue9 % 2;
   uservalue10 = uservalue9 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue24
      + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31
      + bitvalue32);  }
   if (uservalue10 >= 0) {
   bitvalue22 = uservalue10 % 2;
   uservalue11 = uservalue10 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue23
      + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30
      + bitvalue31 + bitvalue32); }
   if (uservalue11 >= 0) {
   bitvalue21 = uservalue11 % 2;
   uservalue12 = uservalue11 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue22
      + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29
      + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue12 >= 0) {
   bitvalue20 = uservalue12 % 2;
   uservalue13 = uservalue12 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue21
      + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28
      + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue13 >= 0) {
   bitvalue19 = uservalue13 % 2;
   uservalue14 = uservalue13 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue20
      + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27
      + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);  }
   if (uservalue14 >= 0) {
   bitvalue18 = uservalue14 % 2;
   uservalue15 = uservalue14 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue19
      + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26
      + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);  }
   if (uservalue15 >= 0) {
   bitvalue17 = uservalue15 % 2;
   uservalue16 = uservalue15 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue18
      + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25
      + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue16 >= 0) {
   bitvalue16 = uservalue16 % 2;
   uservalue17 = uservalue16 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue17
      + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24
      + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31
      + bitvalue32); }
   if (uservalue17 >= 0) {
   bitvalue15 = uservalue17 % 2;
   uservalue18 = uservalue17 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue16
      + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23
      + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30
      + bitvalue31 + bitvalue32);  }
   if (uservalue18 >= 0) {
   bitvalue14 = uservalue18 % 2;
   uservalue19 = uservalue18 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue15
      + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22
      + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29
      + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue19 >= 0) {
   bitvalue13 = uservalue19 % 2;
   uservalue20 = uservalue19 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue14
      + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21
      + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28
      + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue20 >= 0) {
   bitvalue12 = uservalue20 % 2;
   uservalue21 = uservalue20 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue13
      + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20
      + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27
      + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue21 >= 0) {
   bitvalue11 = uservalue21 % 2;
   uservalue22 = uservalue21 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue12
      + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19
      + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26
      + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue22 >= 0) {
   bitvalue10 = uservalue22 % 2;
   uservalue23 = uservalue22 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue11
      + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18
      + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25
      + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue23 >= 0) {
   bitvalue9 = uservalue23 % 2;
   uservalue24 = uservalue23 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue10
      + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17
      + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24
      + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31
      + bitvalue32); }
   if (uservalue24 >= 0) {
   bitvalue8 = uservalue24 % 2;
   uservalue25 = uservalue24 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue9
      + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16
      + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23
      + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30
      + bitvalue31 + bitvalue32); }
   if (uservalue25 >= 0) {
   bitvalue7 = uservalue25 % 2;
   uservalue26 = uservalue25 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue8
      + bitvalue9 + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15
      + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22
      + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29
      + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue26 >= 0) {
   bitvalue6 = uservalue26 % 2;
   uservalue27 = uservalue26 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue7
      + bitvalue8 + bitvalue9 + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14
      + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21
      + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28
      + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue27 >= 0) {
   bitvalue5 = uservalue27 % 2;
   uservalue28 = uservalue27 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue6
      + bitvalue7 + bitvalue8 + bitvalue9 + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13
      + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20
      + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27
      + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue28 >= 0) {
   bitvalue4 = uservalue28 % 2;
   uservalue29 = uservalue28 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue5
      + bitvalue6 + bitvalue7 + bitvalue8 + bitvalue9 + bitvalue10 + bitvalue11 + bitvalue12
      + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18 + bitvalue19
      + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26
      + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue29 >= 0) {
   bitvalue3 = uservalue29 % 2;
   uservalue30 = uservalue29 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue4
      + bitvalue5 + bitvalue6 + bitvalue7 + bitvalue8 + bitvalue9 + bitvalue10 + bitvalue11
      + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18
      + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25
      + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   if (uservalue30 >= 0) {
   bitvalue2 = uservalue30 % 2;
   uservalue31 = uservalue30 / 2; }
   else {System.out.print("The binary value of the decimal integer you entered is: " + bitvalue3
      + bitvalue4 + bitvalue5 + bitvalue6 + bitvalue7 + bitvalue8 + bitvalue9 + bitvalue10
      + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17
      + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24
      + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31
      + bitvalue32); }
   if (uservalue31 >= 0) {
   bitvalue1 = uservalue31 % 2;
   uservalue32 = uservalue31 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue2
      + bitvalue3 + bitvalue4 + bitvalue5 + bitvalue26 + bitvalue7 + bitvalue8 + bitvalue9
      + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16
      + bitvalue17 + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23
      + bitvalue24 + bitvalue25 + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30
      + bitvalue31 + bitvalue32); }
   if (uservalue32 >= 0) {
   bitvalue = uservalue32 % 2;
   uservalue0 = uservalue32 / 2; }
   else { System.out.print("The binary value of the decimal integer you entered is: " + bitvalue1 + bitvalue2 
      + bitvalue3 + bitvalue4 + bitvalue5 + bitvalue6 + bitvalue7 + bitvalue8 + bitvalue9 + bitvalue10
      + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17 + bitvalue18
      + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25 + bitvalue26
      + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32);   }
   if (uservalue32 == 0) {
   System.out.print("The binary value of the decimal integer you entered is: " + bitvalue1 
      + bitvalue2 + bitvalue3 + bitvalue4 + bitvalue5 + bitvalue6 + bitvalue7 + bitvalue8 + bitvalue9
      + bitvalue10 + bitvalue11 + bitvalue12 + bitvalue13 + bitvalue14 + bitvalue15 + bitvalue16 + bitvalue17
      + bitvalue18 + bitvalue19 + bitvalue20 + bitvalue21 + bitvalue22 + bitvalue23 + bitvalue24 + bitvalue25
      + bitvalue26 + bitvalue27 + bitvalue28 + bitvalue29 + bitvalue30 + bitvalue31 + bitvalue32); }
   else {
   }
   }
}

   
   
   
   
   