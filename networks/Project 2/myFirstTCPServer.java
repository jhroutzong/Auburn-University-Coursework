import java.net.*; 
import java.io.*;   

public class myFirstTCPServer {

  private static final int BUFSIZE = 32;   

  public static void main(String[] args) throws IOException {

    if (args.length != 1)  
      throw new IllegalArgumentException("Parameter(s): <Port>"); //sets the port # 

    int servPort = Integer.parseInt(args[0]);
    ServerSocket servSock = new ServerSocket(servPort); //creates a socket based on port #
     

    for (;;) { //runs forever
      Socket clntSock = servSock.accept(); //accepts socket 
      //Uses readers from ISR & BR classes to output data from client     
      InputStreamReader in = new InputStreamReader(clntSock.getInputStream());
      BufferedReader bf = new BufferedReader(in); 
      String str = bf.readLine(); 
       System.out.println("Handling client at " +
        clntSock.getInetAddress().getHostAddress() + " on port " +
             clntSock.getPort()); //prints server message from socket following acception
      System.out.println("Recieved message: " + str);
     str = str.toUpperCase();
     System.out.println("Echoing back: " + str);  
     //Uses PR class to print data to client
     PrintWriter pr = new PrintWriter(clntSock.getOutputStream());
     pr.println(str); 
     pr.flush();
     clntSock.close();  
    }
    
  }
}

//int recvMsgSize;   
//byte[] byteBuffer = new byte[BUFSIZE];  