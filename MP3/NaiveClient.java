import java.io.*;
import java.net.*;

public class NaiveClient {
    public static void main(String[] args) throws IOException {
        // check if the number of arguments <serverIP> and <port> is provided
        if (args.length != 2) {
            System.out.println("Please enter <serverIP> and <port>.");
            return;
        }

        // parse the server port to server ip command line
        String serverIp = args[0];
        int serverPort = Integer.parseInt(args[1]);

        // connect to the server with the server IP and port
        Socket socket = new Socket(serverIp, serverPort);
        // create the buffer read
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        int data;
        // read the data from the server
        while ((data = in.read()) != -1) {
            System.out.print((char) data);  // Display each character immediately
        }

        // close the socket
        socket.close();
    }
}
