import java.net.*;
import java.io.*;
import java.util.*;

public class TCPServer {


   public static int result = 0;
   public static int tcmNum;
   public static boolean onOff;
   public static String str = "";
   public static String b = "";
   private static final int zero = 0;

   public static void main(String[] args) throws IOException {
   
      if (args.length != 1)
         throw new IllegalArgumentException("Parameter(s): <Port>"); //sets the port #
   
      int servPort = Integer.parseInt(args[0]);
      Scanner scan = new Scanner(System.in);
      while (servPort != 10013) {
         System.out.println("You entered the incorrect port # for our team. Please enter another port #.");
         servPort = scan.nextInt();
      }
      ServerSocket servSock = new ServerSocket(servPort); //creates a socket based on port #
      System.out.println("You're connected to jzr0093's Calculating Server." +
         " Please respond via the Client program.");
   
      for (;;) { //runs forever
         Socket clntSock = servSock.accept(); //accepts socket
      //Uses readers from ISR & BR classes to output data from client
         InputStreamReader in = new InputStreamReader(clntSock.getInputStream()); //gets input from client
      ///
         BufferedReader bf = new BufferedReader(in); //reads input from client
         b = bf.readLine();
      //** inputted from UDP program
         System.out.println(b);
         String tmcNumber = b.substring(0, 2);
         String requestNum = b.substring(2, 4);
         String opCode = b.substring(4, 6);
         String numOfOperands = b.substring(6, 8);
         String operand1 = b.substring(8, 12);
         String operand2 = b.substring(12, 16);
         String operand1half1 = b.substring(8, 10);
         String operand1half2 = b.substring(10, 12);
         String operand2half1 = b.substring(12, 14);
         String operand2half2 = b.substring(14, 16);
      
         int tmcNum = Integer.parseInt(tmcNumber, 16);
         int requestNumber = Integer.parseInt(requestNum, 16);
         int operationCode = Integer.parseInt(opCode, 16);
         int numberOfOperands = Integer.parseInt(numOfOperands, 16);
         int operand11 = Integer.parseInt(operand1, 16);
         int operand22 = Integer.parseInt(operand2, 16);
      
         if (numberOfOperands == 2) {
            System.out.println("Received message: 0x" + tmcNumber + " 0x" + requestNum + " 0x" + opCode + " 0x" + numOfOperands
               + " 0x" + operand1half1 + " 0x" + operand1half2 + " 0x" + operand2half1 + " 0x" + operand2half2);
         }
         else if (numberOfOperands == 1) {
            System.out.println("Received message: 0x" + tmcNumber + " 0x" + requestNum + " 0x" + opCode + " 0x" + numOfOperands
               + " 0x" + operand1half1 + " 0x" + operand1half2);
            onOff = true;
         }
         System.out.println("The Request ID is: " + requestNumber);
         if (operationCode == 0) {
            result = operand11 + operand22;
            String f = "+";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 1) {
            result = operand11 - operand22;
            String f = "-";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 2) {
            result = operand11 | operand22;
            String f = "|";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 3) {
            result = operand11 & operand22;
            String f = "&";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 4) {
            result = operand11 >> operand22;
            String f = ">>";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 5) {
            result = operand11 << operand22;
            String f = "<<";
            System.out.println("The request is: " + operand11 + f + operand22);
         }
         else if (operationCode == 6) {
            result = ~operand11;
            String f = "~";
            System.out.println("The request is: " + f + operand11);
         }
         else if (operationCode < 0 || operationCode > 6) {
            System.out.println("You entered an invalid Op Code (1 - 6). Please try again.");
            continue;
         }
         int z = 0;
         int aa = (tmcNum - 1);
         String a = Integer.toHexString(aa);
         String b = Integer.toHexString(requestNumber);    
         String c = Integer.toHexString(z);
         String e = Integer.toHexString(result);
          
         
         
         if (onOff && result < 256 && result > 16) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c + c + c + c + c + e; //only 1 operand, returns 12
            }
            else {
               str = c + a + b + c + c + c + c + c + c + e;
            }
         }
         else if (onOff && result > 256) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c  + c + c + e;
            }
            else {
               str = c + a + b + c + c + c + c + e;
            }  
         }
         //
         else if (onOff && result < 16) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c  + c + c + c + c + c + e;
            }
            else {
               str = c + a + b + c + c + c + c + c + c + c + e;
            }  
         }
         //
         else if (result < 256 && result > 16) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c + c + c + c + c + c + c + e;
            }
            else {
               str = c + a + b + c + c + c + c + c + c + c + c + e;
            }  
         }
         //
         else if (result < 16) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c + c + c + c + c + c + c + c + e;
            }
            else {
               str = c + a + b + c + c + c + c + c + c + c + c + c + e;
            }  
         }
         //
         else if (result > 256) {
            if (requestNumber < 16) {
               str = c + a + c + b + c + c + c + c + c + c + e;
            }
            else {
               str = c + a + b + c + c + c + c + c + c + e;
            }  
         }
         //
      // else if (tmcNum == 7) {
      //          str = a + b + c + c + e;
      
      
      
      
      
         onOff = false;
         System.out.println("Sending back: " + str);
      //Uses PR class to print data to client
         PrintWriter pr = new PrintWriter(clntSock.getOutputStream());
         pr.println(str);
         pr.flush();
      //clntSock.close();
      //closes while loop
      }
   
   }
  
}

