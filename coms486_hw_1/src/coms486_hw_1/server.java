/** @author Jawad M Rahman **/

import java.io.*;  
import java.net.*;  
public class Server {

	public static void main(String argv[]) throws IOException  
	{  
		String sentence;
		int port = 0;
		String len;
		if (argv.length == 1) 
		{  //getting the port number 
			port = Integer.parseInt(argv[0]);
		} 

		else{
			if(argv.length == 0) {
				System.out.println("No command line arguments found, please try again."); 
			}
			else {
				System.out.println("Please enter the name of the program and port number and try again. ");

			}
			return;
		}
		//making the socket 
		ServerSocket socketSvr = new ServerSocket(port);


		while(true) {
			
			//Creating the socket which will manage the contact with client
			Socket connectionSocket = socketSvr.accept();
			//Attaching the input stream to the socket
			BufferedReader inFromClient =new BufferedReader(new InputStreamReader(connectionSocket.getInputStream()));
			//Attaching the output stream from client
			DataOutputStream outToClient =new DataOutputStream (connectionSocket.getOutputStream());
			//get the length of the sentence from client and send the length
			len = Integer.toString((inFromClient.readLine().length()));
			System.out.println("Got the input and now sending the length");
			outToClient.writeBytes(len);

		}

	}
}
