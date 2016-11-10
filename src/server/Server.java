package server;
import java.io.IOException;
import java.net.ServerSocket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;
public class Server {

	private static int SERVER_SOCKET = 7890;

	public static void main(String[] args) {

		boolean isOnline = true;
		Protocol protocol = Protocol.getInstance();
		
		//thread pool created handling a maximum of 5 threads/clients at a time
		int maxNumClients = 5;
		ExecutorService pool = Executors.newFixedThreadPool(maxNumClients);

		try{
			//start server
			ServerSocket serverSocket = new ServerSocket(SERVER_SOCKET);
			System.out.println("Server up and running... ");

			while(isOnline){

				//creates a thread/client connection and adds it to the Thread pool at the same time,
				//as long as the server is running
				pool.submit(new ClientHandler(serverSocket.accept(), protocol));
			}
			
			//when server is offline shutdown the pool 	
			pool.shutdown();
			try {
				while (!pool.isShutdown()) {
					
					//pool is waiting 500 milliseconds before terminating 
					pool.awaitTermination(500, TimeUnit.MILLISECONDS);
				}
			} catch (InterruptedException e) {
				System.out.println("Pool could not be shut down properly.");
			}
			
			//then close socket
			serverSocket.close();


		}catch (IOException e) {
			isOnline = false;
			System.out.println("Server is down.");
		}

	}

}
