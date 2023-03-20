import java.net.*;  // for DatagramSocket, DatagramPacket, and InetAddress
import java.io.*;   // for IOException

public class myFirstUDPServer {

   private static final int ECHOMAX = 255;  // Maximum size of echo datagram

   public static void main(String[] args) throws IOException {
   
      if (args.length != 1)  // Test for correct argument list
         throw new IllegalArgumentException("Parameter(s): <Port>");
   
      int servPort = Integer.parseInt(args[0]);
   
      DatagramSocket socket = new DatagramSocket(servPort);
      DatagramPacket packet = new DatagramPacket(new byte[ECHOMAX], ECHOMAX);
   
      for (;;) {  // Run forever, receiving and echoing datagrams
         socket.receive(packet);     // Receive packet from client
         byte[] buffer = new byte[ECHOMAX];
         buffer = packet.getData();
         String message = new String(buffer);
         System.out.println("Handling client at " + packet.getAddress());
         System.out.println("Port #: " + packet.getPort());
         System.out.println("Received: " + message);
         message = message.toUpperCase();
         System.out.println("Echoing back: " + message);
         byte[] ab = message.getBytes();
         DatagramPacket sendPacket = new DatagramPacket(ab, ab.length, packet.getAddress(), packet.getPort()); //, address, servPort 
         socket.send(sendPacket);       // Send the packet back to client
         packet.setLength(ECHOMAX); // Reset length to avoid shrinking buffer
         //Clear the Strings and Arays
         message = "";
        for (int i = 0; i < ab.length; i++) {
            ab[i] = 0;
        }
        for (int i = 0; i < buffer.length; i++) {
            buffer[i] = 0;
        }
      }
      /* NOT REACHED */
   }
}
