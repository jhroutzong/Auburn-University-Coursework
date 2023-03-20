import java.net.*;  
import java.io.*;   
import java.util.Scanner;
import java.util.Date;

public class myFirstTCPClient {

    //This file was created by using TCPEchoClient.java, and returns
    // an all capitalized version of a user-inputted string.
	public static void main(String[] args) throws IOException {

		if ((args.length < 1) || (args.length > 2))  // Test for correct # of args
			throw new IllegalArgumentException("Parameter(s): <Server> [<Port>]");

		String server = args[0];       // Server name or IP address
		int servPort = (args.length == 2) ? Integer.parseInt(args[1]) : 7; 
		String outString = "";
		while(true) {
			Socket socket = new Socket(server, servPort); // Create socket
			System.out.println("Please input a message");	
			Scanner scanner = new Scanner(System.in);
			String msg = scanner.nextLine(); //Takes in message
			PrintWriter pr = new PrintWriter(socket.getOutputStream()); //creates a writer for output from server
			long startTime = System.currentTimeMillis(); //initiates start time
			pr.println(msg);  // Sends the string to the server using PW class
 			pr.flush();

           //Creates two objects, from ISR & BR classes, to determine input from server.
 			InputStreamReader in = new InputStreamReader(socket.getInputStream());
 			BufferedReader br = new BufferedReader(in); 
			String rcvMsg = br.readLine();
			long endTime = System.currentTimeMillis();
			long roundTripTime = endTime - startTime;

			System.out.println("Received: " + rcvMsg);
			System.out.println("Round Trip Time: " + String.valueOf(roundTripTime) + "ms");
			socket.close();  // Close the socket 

		}
	}
}
