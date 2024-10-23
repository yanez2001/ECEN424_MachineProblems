import java.io.*;
import java.net.*;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Server {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            // check that the correct number of arguments are provided
            System.out.println("Please enter <port> and <maxClients>.");
            return;
        }

        // parse the port number and max number of clients on command line java Server <port> <maxClients>
        int port = Integer.parseInt(args[0]);
        int maxClients = Integer.parseInt(args[1]);

        // create a server socket to listen to specific port
        ServerSocket serverSocket = new ServerSocket(port);
        ExecutorService threadPool = Executors.newFixedThreadPool(maxClients);

        // creating a thread to assist multiple clients
        // for our Buffer client
        BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
        // read the string provided from user
        System.out.println("Enter the string to send:");
        String str = consoleInput.readLine();
        // enter the number of times (N) to send the provided string
        System.out.println("Enter the number of times to send the string:");
        int N = Integer.parseInt(consoleInput.readLine());

        // print out that the server is currently running and on which port
        System.out.println("Server is running on port " + port + " and waiting for clients...");

        // NEED TO FIX HERE, maybe to stop the server after max clients reached
        while (true) {
            Socket clientSocket = serverSocket.accept();
            threadPool.execute(new ClientHandler(clientSocket, str, N));
        }
    }
}

// class to put everything together
class ClientHandler implements Runnable {
    private Socket clientSocket;
    private String str; // the string to send to client
    private int N;      // the number of times to send the string to client

    // initialize the client socket, the string and the number of times to send string
    public ClientHandler(Socket clientSocket, String str, int N) {
        this.clientSocket = clientSocket;
        this.str = str; // the string to send to client
        this.N = N;     // the number of times to send the string to client
    }

    @Override
    public void run() {
        try (PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true)) {
            // sending the string N times with a 2 second delay.
            for (int i = 0; i < N - 1; i++) {
                out.print(str);
                out.flush(); // no newline until last N
                Thread.sleep(2000); // 2 second delay
            }
            out.println(str); // Last one ends with a newline
            out.flush();
            // close connection with client
            clientSocket.close();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
