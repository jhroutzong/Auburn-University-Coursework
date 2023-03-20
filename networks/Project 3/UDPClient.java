import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException
import java.util.*;

public class UDPClient {

   private static final int ECHOMAX = 8;
   public static int requestID = 1;
   private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
   public static int numOfOperands;

   public static String bytesToHex(byte[] bytes) {
      char[] hexChars = new char[bytes.length * 2];
      for (int j = 0; j < bytes.length; j++) {
         int v = bytes[j] & 0xFF;
         hexChars[j * 2] = HEX_ARRAY[v >>> 4];
         hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
      }
      return new String(hexChars);
   }


   public static void main(String args[]) throws Exception {
      Scanner scan = new Scanner(System.in);
      if ((args.length < 1) || (args.length > 2))  // Test for correct # of args
         throw new IllegalArgumentException("Parameter(s): <Destination>" +
            	     " <Port> [<encoding]");
   
   
      InetAddress destAddr = InetAddress.getByName(args[0]);  // Destination address
      int destPort = Integer.parseInt(args[1]);
      while (destPort != 10013) {
         System.out.println("You entered the incorrect port # for our team. Please enter another port #.");
        
         destPort = scan.nextInt();
      }             // Destination port
   
      // Friend friend = new Friend(1234567890987654L, "Alice Adams",
   		// 	 (short) 777, 90007, true, true, false);
   
      DatagramSocket sock = new DatagramSocket(); // UDP socket for sending
      boolean run = true;
      int tml;
      while (run) {
      //Scanner scan = new Scanner();
         String f = "";
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
         int z = 0;
         int y = 0;
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         if (operand1 < 256 && operand2 < 256) {
            int[] intArray = {tml, requestID, opcode, numOfOperands, z, operand1, y, operand2};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else if (operand1 < 256) {
            int[] intArray = {tml, requestID, opcode, numOfOperands, z, operand1, operand2};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else if (operand2 < 256) {
            int[] intArray = {tml, requestID, opcode, numOfOperands, operand1, y, operand2};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else {
            int[] intArray = {tml, requestID, opcode, numOfOperands, operand1, operand2};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         byte[] c = outputStream.toByteArray();
         
         String o = bytesToHex(c);
         String tmcNumber = o.substring(0, 2);
         String requestNum = o.substring(2, 4);
         String opCode = o.substring(4, 6);
         String numOfOperandss = o.substring(6, 8);
         String operand1half1 = o.substring(8, 10);
         String operand1half2 = o.substring(10, 12);
         String operand2half1 = o.substring(12, 14);
         String operand2half2 = o.substring(14, 16);
         
         System.out.println("Sending message: 0x" + tmcNumber + " 0x" + requestNum + " 0x" + opCode + " 0x" + numOfOperandss
            + " 0x" + operand1half1 + " 0x" + operand1half2 + " 0x" + operand2half1 + " 0x" + operand2half2);
      
         DatagramPacket message = new DatagramPacket(c, c.length,
            		  destAddr, destPort);
         long startTime = System.currentTimeMillis();
         sock.send(message);
         DatagramPacket receivePacket = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
         sock.receive(receivePacket); 
         byte[] buffer = new byte[8];
         buffer = receivePacket.getData();
         long endTime = System.currentTimeMillis();
           
         String b = bytesToHex(buffer);
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
         receivePacket.setLength(ECHOMAX);
      }
   
      sock.close();
   }
}
