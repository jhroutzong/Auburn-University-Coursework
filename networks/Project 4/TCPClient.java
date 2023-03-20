import java.net.*;
import java.io.*;
import java.util.Scanner;
import java.util.Date;

public class TCPClient {

   public String str = "";
   public static int requestID = 1;
   public static int tml = 0;
   public static int numOfOperands;
   public static final String zero = "0";
   public static String f = "";
   public static String h = "";

    //This file was created by using TCPEchoClient.java, and returns
    // an all capitalized version of a user-inputted string.
   public static void main(String[] args) throws IOException {
   
      if ((args.length < 1) || (args.length > 2))  // Test for correct # of args
         throw new IllegalArgumentException("Parameter(s): <Server> [<Port>]");
   
      String server = args[0];       // Server name or IP address
      int servPort = (args.length == 2) ? Integer.parseInt(args[1]) : 7;
      Scanner scan = new Scanner(System.in);
      while (servPort != 10013) {
         System.out.println("You entered the incorrect port # for our team. Please enter another port #.");
         servPort = scan.nextInt();
      }
      String outString = "";
      while(true) {
      
         Socket socket = new Socket(server, servPort); // Create socket for Server to accept
         String o = "";
         System.out.println("You're connected to jzr0093's Calculating Client.");
         System.out.println("Please enter an Opcode (0 - 6): ");
         int opcode = scan.nextInt();
         System.out.println("Please enter the number of Operands: (1 if using ~)");
         numOfOperands = scan.nextInt();
         System.out.println("Please enter Operand 1: ");
         int operand1 = scan.nextInt();
         System.out.println("Please enter Operand 2: (0 if ~ is used)");
         int operand2 = scan.nextInt();
         if (numOfOperands == 2) {
            tml = 8;
         }
         else {
            tml = 7;
         }
         int zz = 00;
         int y = 0;
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         String a = Integer.toHexString(tml);
         String b = Integer.toHexString(requestID);
         String c = Integer.toHexString(opcode);
         String d = Integer.toHexString(numOfOperands);
         String z = Integer.toHexString(zz);
         
         //Accounting for correct number of 0's
         if (operand1 < 16) {
            String ff = Integer.toHexString(operand1);
            String fff = "0";
            f = String.format("%s%s", fff,ff);
         }
         else {
            f = Integer.toHexString(operand1);
         }
         if (operand2 < 16) {
            String hh = Integer.toHexString(operand2);
            String hhh = "0";
            h = String.format("%s%s", hhh,hh);
         }
         else {
            h = Integer.toHexString(operand2);
         }
         System.out.println("H is equal to " + h);
         System.out.println("Z is equal to " + z);
         
         if (operand1 < 256 && operand2 < 256 && operand1 > 16 && operand2 > 16) {
            if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + f + z + z + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + f + z + z + h;
            }
         }
         //
         else if (operand1 > 256 && operand2 < 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d +z+z+ f + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + z + f + h;
            }
         }
         //
         else if (operand1 < 16 && operand2 > 256) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + z + f + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + z + f + h;
            }
         }
         //
         else if (operand1 < 16 && operand2 < 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + z + f + z + z + z + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + z + f + z + z + z + h;
            }
         }
         //
         else if (operand1 < 16 && operand2 < 256 && operand2 > 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + z + f + z + z + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + z + f + z + z + h;
            }
         }
         //
         else if (operand1 < 256 && operand2 < 16 && operand1 > 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + f + z + z + z + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + f + z + z + z + h;
            }
         }
         //
         else if (operand1 > 256 && operand2 < 256 && operand2 > 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + f + z + z + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + f + z + z + h;
            }
         }
         //
         else if (operand1 < 256 && operand2 > 256 && operand1 > 16) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + z + z + f + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + z + z + f + h;
            }
         }
         //
         else if (operand1 > 256 && operand2 > 256) {
         if (requestID < 16) {
               o = zero + a + zero + b + zero + c + zero + d + f + h;
            }
            else if (requestID > 16) {
               o = zero + a + b + zero + c + zero + d + f + h;
            }
         }
         //
         
         // else if (operand1 < 256) {
            // if (requestID < 16) {
               // o = zero + a + zero + b + zero + c + zero + d + z + z + f + h;
            // }
            // else if (tml < 16) {
               // o = zero + a + b + zero + c + d + z + z + f + h;
            // }
         // }
         // else if (operand2 < 256) {
            // if (tml < 16 && requestID < 16) {
               // o = zero + a + zero + b + zero + c + zero + d + f + z + z + h;
            // }
            // else if (tml < 16) {
               // o = zero + a + b + zero + c + zero + d + f + z + z + h;
            // }
            // else if (requestID < 16) {
               // o = a + zero + b + zero + c + zero + d + f + z + z + h;
            // }
            // else {
               // o = a + b + zero + c + zero + d + f + z + z + h;
            // }
         // }
         // else {
            // if (tml < 16 && requestID < 16) { 
               // o = zero + a + zero + b + zero + c + zero + d + f + h;
            // }
            // else if (tml < 16) {
               // o = zero + a + b + zero + c + zero + d + f + h;
            // }
            // else if (requestID < 16) {
               // o = a + zero + b + zero + c + zero + d + f + h;
            // }
            // else {
               // o = a + b + zero + c + zero + d + f + h;
            // }
         // }
         System.out.println("The message is " + o);
         // String tmcNumber = o.substring(0, 2);
      //          String requestNum = o.substring(2, 4);
      //          String opCode = o.substring(4, 6);
      //          String numOfOperandss = o.substring(6, 8);
      //          String operand1half1 = o.substring(8, 10);
      //          String operand1half2 = o.substring(10, 12);
      //          String operand2half1 = o.substring(12, 14);
      //          String operand2half2 = o.substring(14, 16);
      
         // System.out.println("Sending message: 0x" + tmcNumber + " 0x" + requestNum + " 0x" + opCode + " 0x" + numOfOperandss
      //             + " 0x" + operand1half1 + " 0x" + operand1half2 + " 0x" + operand2half1 + " 0x" + operand2half2);
        
      
         PrintWriter pr = new PrintWriter(socket.getOutputStream()); //creates a writer to output on server
         long startTime = System.currentTimeMillis(); //creates start time
         pr.println(o);  // Sends the string to the server using PW class
         pr.flush(); //flushes printwriter
      
           //Creates two objects to determine input from server.
         InputStreamReader in = new InputStreamReader(socket.getInputStream());
         BufferedReader br = new BufferedReader(in);
         b = br.readLine();
      //receive
      
         long endTime = System.currentTimeMillis();
         long roundTripTime = endTime - startTime;
         String checkString = b.substring(12, 14);
         String tmcResult = b.substring(0, 2);
         String requestResult = b.substring(2, 4);
         String opResult = b.substring(4, 6);
         String numOfOperandResult = b.substring(6, 8);
         String emptyMessageResult = b.substring(8, 10);
         String resulthalf1 = b.substring(10, 12);
         String resulthalf2 = b.substring(12, 14);
         String result = b.substring(10, 14);
         int resultt = Integer.parseInt(result, 16);
         String resulttt =b.substring(8, 12);
         String resulttthalf1 = b.substring(8, 10);
         String resulttthalf2 = b.substring(10, 12);
         int resultttt = Integer.parseInt(resulttt, 16);
         long roundTrip = endTime - startTime;
      
      
         if (numOfOperands == 1) {
            System.out.println("Received message: 0x" + tmcResult + " 0x" + requestResult + " 0x" + opResult + " 0x"
               + numOfOperandResult + " 0x" + resulttthalf1 + " 0x" + resulttthalf2);
            System.out.println("The Request ID is: " + requestResult);
            System.out.println("The Result is: " + resultttt);
            System.out.println("The round trip time was " + roundTrip + "ms" + "\n");
         }
         else {
            System.out.println("Received message: 0x" + tmcResult + " 0x" + requestResult + " 0x" + opResult + " 0x"
               + numOfOperandResult + " 0x" + emptyMessageResult + " 0x" + resulthalf1 + " 0x" + resulthalf2);
            System.out.println("The Request ID is: " + requestResult);
            System.out.println("The Result is: " + resultt);
            System.out.println("The round trip time was " + roundTrip + "ms" + "\n");
         }
         requestID++;
      
      }
   		//socket.close();  // Close the socket
      //closes while loop
   }
}

