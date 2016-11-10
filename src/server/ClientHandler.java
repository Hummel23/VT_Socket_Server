package server;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class ClientHandler implements Runnable {
	BufferedReader in;
	PrintWriter out;
	Socket client;
	Protocol protocol;

	ClientHandler(Socket client, Protocol protocol) throws IOException{
		this.client=client;
		this.protocol=protocol;
		this.in = new BufferedReader(new InputStreamReader(client.getInputStream()));
		this.out = new PrintWriter(client.getOutputStream(), true);
	}

	@Override
	public void run() {
		System.out.println("Connected to Client.");

		//as long as client is connected
		while(client.isConnected()){
			try{
				//receive data from Client
				String msg = in.readLine();

				// process Client input
				String result = protocol.process(msg);

				//send processed data back to Client
				out.println(result);

			}catch (IOException e) {
				System.out.println(e);
				System.out.println("ERROR: incoming message could not be read.");
				out.println("Incoming message could not be read. Please try again.");
				e.printStackTrace();

			}
		}
		//TODO find out why this line is not printed. 
		System.out.println("Connection to client was terminated.");
	}

}
