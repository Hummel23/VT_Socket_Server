import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
	
	private static int SERVER_SOCKET = 8080;
	
	public static void main(String[] args) {
		BufferedReader in;
		PrintWriter out;
		
		try{
			//start server
			ServerSocket serverSocket = new ServerSocket(SERVER_SOCKET);
			System.out.println("Server up and running... ");
			
			//connection to Client
			Socket client = serverSocket.accept();
			System.out.println("Connected to Client.");
			
			//receive data from Client
			in = new BufferedReader(new InputStreamReader(client.getInputStream()));
			System.out.println("Client sends: " + in.readLine());
			String msg = in.readLine();
			
			
			
			//send data to Client
			out = new PrintWriter(client.getOutputStream(), true);
			out.println("world");			
			
		}catch (Exception e) {
			System.out.println("Server is down.");
		}

	}

}
