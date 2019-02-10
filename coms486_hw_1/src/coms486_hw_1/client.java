
/** @author Jawad M Rahman **/

import java.io.*;  
import java.net.*;  
import java.util.Scanner;

public class Client {

	public static void main(String argv[]) throws IOException  
	{  	String serverSen;
		String hostName;
		int port = 0; 
		// check if length of args array is 
		// greater than 0 
		if (argv.length == 2) 
		{  //getting the hostname and the port number 
			hostName = argv[0];
			port = Integer.parseInt(argv[1]);
		} 
		else{
			if(argv.length == 0) {
				System.out.println("No command line arguments found, please try again."); 
			}
			else {
				System.out.println("Please enter the name of the program, hostname and port number and try again.");
			}
			return;
		}

		Socket sock = new Socket(hostName, port);
		while(true) {  
			//Attaching output stream to socket 
			DataOutputStream sendToServer = new DataOutputStream(sock.getOutputStream());
			//Attaching input stream to socket
			BufferedReader serverMessage = new BufferedReader(new InputStreamReader(sock.getInputStream()));
			//the system will now prompt the user for input and scan it
			System.out.println("Waiting for your input: \n");
			Scanner scan = new Scanner(System.in);
			String str = scan.next();
			if(str.equals("QUIT"))
			{
				System.out.println("Terminating program");
				break;
			}
			//Sending the user input to server
			sendToServer.writeBytes(str + '\n');
			System.out.println("Waiting for the Server to send the length of the user input.");
			//Receiving the message from server 
			serverSen = serverMessage.readLine();
			System.out.println("From server: the last input's length is " +serverSen);
			scan.close();
		}
		sock.close();
	}

}
