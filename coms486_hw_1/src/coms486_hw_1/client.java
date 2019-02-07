package coms486_hw_1;
import java.io.*;  
import java.net.*;  

public class client {

		  public static void main(String argv[]) throws Exception  
		    {  
		      String clientSentence;  
		      String capitalizedSentence;  
		      String hostName;
		      int port = 0; 
		   // check if length of args array is 
		        // greater than 0 
		        if (argv.length > 0) 
		        {  //gettign the hostname and the port number 
		           hostName = argv[1];
		           port = Integer.parseInt(argv[2]);
//		            for (String val:argv) 
//		                System.out.println(val); 
		        } 
		        else{
		            System.out.println("No command line "+ 
		                               "arguments found, please try again."); 
		            return;
		        }
		        
		      ServerSocket welcomeSocket = new ServerSocket(port);  
		      while(true) {  
		            Socket connectionSocket = welcomeSocket.accept();  
		           BufferedReader inFromClient =  
		              new BufferedReader(new 
		              InputStreamReader(connectionSocket.getInputStream()));  
		           
		           DataOutputStream  outToClient =  
		                   new DataOutputStream(connectionSocket.getOutputStream());
		                 clientSentence = inFromClient.readLine();  
		                 capitalizedSentence = clientSentence.toUpperCase() + '\n';  
		                 outToClient.writeBytes(capitalizedSentence);
		      }
		      
		    }
		  	
}
