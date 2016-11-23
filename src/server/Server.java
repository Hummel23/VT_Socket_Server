package server;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Server {

	private static int SERVER_SOCKET = 7890;

	public static void main(String[] args) {

		ServerSocket serverSocket;
		Socket client;

		try{
			//start server
			serverSocket = new ServerSocket(SERVER_SOCKET);
			System.out.println("Server up and running... ");
			client = serverSocket.accept();
			boolean isOnline = true;
			Protocol protocol = Protocol.getInstance();
			//thread pool created handling a maximum of 5 threads/clients at a time
			int maxNumClients = 5;
			ExecutorService pool = Executors.newFixedThreadPool(maxNumClients);
			ClientHandler clientHandler = new ClientHandler(client, protocol);
			
			while(isOnline){

				//creates a thread/client connection and adds it to the Thread pool at the same time,
				//as long as the server is running
				pool.submit(clientHandler);
			}

			//when server is offline shutdown the pool 	
			pool.shutdown();

			while (!pool.isShutdown()) {

				//pool is waiting 500 milliseconds before terminating 
				pool.awaitTermination(500, TimeUnit.MILLISECONDS);
			}

			//then close socket
			serverSocket.close();


		}catch (Exception e) {
			e.printStackTrace();
		}

	}

}
