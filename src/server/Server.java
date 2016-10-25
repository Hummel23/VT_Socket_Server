package server;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
public class Server {
	
	private static int SERVER_SOCKET = 7890;
	
	public static void main(String[] args) {
		BufferedReader in;
		PrintWriter out;
		boolean isOnline = true;
		Protocol protocol = Protocol.getInstance();
		
		try{
			//start server
			ServerSocket serverSocket = new ServerSocket(SERVER_SOCKET);
			System.out.println("Server up and running... ");
			
			while(isOnline){
			//connection to Client
			Socket client = serverSocket.accept();
			System.out.println("Connected to Client.");
			
			//receive data from Client
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			String msg = in.readLine();
			
			// process Client input
			String result = protocol.process(msg);
			
			//send processed data to Client
			out = new PrintWriter(client.getOutputStream(), true);
			out.println(result);
			}
			
			serverSocket.close();
			
			
		}catch (IOException e) {
			e.printStackTrace();
			System.out.println("Server is down.");
		}

	}

}
