import java.net.*;  // for DatagramSocket and DatagramPacket
import java.io.*;   // for IOException
import java.util.*;

public class UDPServer {
   
   private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
   private static final int ECHOMAX = 8;
   public static int result = 0;
   public static int tcmNum;
   public static boolean onOff;
  
   public static String bytesToHex(byte[] bytes) {
      char[] hexChars = new char[bytes.length * 2];
      for (int j = 0; j < bytes.length; j++) {
         int v = bytes[j] & 0xFF;
         hexChars[j * 2] = HEX_ARRAY[v >>> 4];
         hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
      }
      return new String(hexChars);
   }
  
   public static void main(String[] args) throws Exception {
      Scanner scan = new Scanner(System.in);
      if (args.length != 1 && args.length != 2)  // Test for correct # of args
         throw new IllegalArgumentException("Parameter(s): <Port> [<encoding>]");
      int port = Integer.parseInt(args[0]);   // Receiving Port
      while (port != 10013) {
         System.out.println("You entered the incorrect port # for our team. Please enter another port #.");
        
         port = scan.nextInt();
      }
   
      DatagramSocket sock = new DatagramSocket(port);  // UDP socket for receiving
      System.out.println("You're connected to jzr0093's Calculating Server." +
          " Please respond via the Client program.");
      boolean m = true;
      while (m) {
         onOff = false;
         DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
         sock.receive(packet);
         byte[] buffer = new byte[9];
         buffer = packet.getData();
         String b = bytesToHex(buffer);
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
         ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
         if (onOff & result < 256) {
            int[] intArray = {tmcNum - 1, requestNumber, 0, 0, z, result};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else if (onOff) {
            int[] intArray = {tmcNum - 1, requestNumber, 0, 0, result};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         
         else if (result < 256) {
            int[] intArray = {tmcNum - 1, requestNumber, 0, 0, 0, z, result};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else if (result > 256) {
            int[] intArray = {tmcNum - 1, requestNumber, 0, 0, 0, result};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         else if (tmcNum == 7) {
            int[] intArray = {tmcNum - 1, requestNumber, 0, 0, result};
            for (int a : intArray) {
               outputStream.write(a);
            }
         }
         // else if (operand22 < 256) {
            // int[] intArray = {tcmNum - 1, requestNumber, 0, 0, operand11, y, operand22};
            // for (int a : intArray) {
               // outputStream.write(a);
            // }
         // }
         // else {
            // int[] intArray = {tcmNum - 1, requestNumber, 0, 0, operand11, operand22};
            // for (int a : intArray) {
               // outputStream.write(a);
            // }
         // }
         
         byte[] c = outputStream.toByteArray();
         DatagramPacket sendPacket = new DatagramPacket(c, c.length, packet.getAddress(), packet.getPort());
         sock.send(sendPacket);
      }
      sock.close();
   }


}
