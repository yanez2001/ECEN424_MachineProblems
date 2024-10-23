import java.io.*;
import java.net.*;

public class BufferClient {
    public static void main(String[] args) throws IOException {
        if (args.length != 2) {
            // check if the number of arguments <serverIP> and <port> is provided
            System.out.println("Please enter <serverIP> and <port>.");
            return;
        }

        // parse the server port to server IP, on the same command line
        String serverIp = args[0];
        int serverPort = Integer.parseInt(args[1]);

        // connect to the server with specific IP and port
        Socket socket = new Socket(serverIp, serverPort);
        // create buffer read
        BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()));

        // use string builder to buffer all characters of string
        StringBuilder buffer = new StringBuilder();
        int data;
        while ((data = in.read()) != -1) {
            buffer.append((char) data);
        }

        System.out.println(buffer.toString());  // Display everything after it's received

        // close the socket
        socket.close();
    }
}
