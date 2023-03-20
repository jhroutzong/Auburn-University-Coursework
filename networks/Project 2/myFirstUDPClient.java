import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException
import java.util.*; //for Scanner

public class myFirstUDPClient {

   private static final int TIMEOUT = 3000;   // Resend timeout (milliseconds)
   private static final int MAXTRIES = 5;     // Maximum retransmissions
   private static final int ECHOMAX = 255; 

   public static void main(String[] args) throws IOException {
   
      if ((args.length < 1) || (args.length > 2))  // Test for correct # of args
         throw new IllegalArgumentException("Parameter(s): <Server> <Word> [<Port>]");
   
      InetAddress serverAddress = InetAddress.getByName(args[0]);  // Server address
      int servPort = (args.length == 2) ? Integer.parseInt(args[1]) : 7; //socket #   
      DatagramPacket receivePacket = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
      for (;;) {
      DatagramSocket socket = new DatagramSocket();  
      System.out.println("Please input a message");	
         Scanner scanner = new Scanner(System.in);
         String msg = scanner.nextLine(); //Takes in message
         byte[] b = msg.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(b,  // Sending packet
            b.length, serverAddress, servPort);
         long startTime = System.currentTimeMillis(); //initiates start time
         socket.send(sendPacket); 
         socket.receive(receivePacket); 
         byte[] buffer = new byte[ECHOMAX];
               buffer = receivePacket.getData();
               String message = new String(buffer);
         long endTime = System.currentTimeMillis();
         long roundTrip = endTime - startTime;
         System.out.println("Received: " + message + "\nThe round trip time was " + roundTrip + " ms");
         receivePacket.setLength(ECHOMAX);
         //Clear the Strings and Arays
         msg = "";
         message = "";
         for (int i = 0; i < b.length; i++) {
            b[i] = 0;
        }
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }
         socket.close();
      }
   }
}
