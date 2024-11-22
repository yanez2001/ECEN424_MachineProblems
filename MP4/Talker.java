import java.io.*;
import java.net.*;

public class Talker {
    public static void main(String[] args) throws IOException {
        // check if user input correct number of  arguments
        if (args.length != 4) {
            System.out.println("Usage: java Talker <listener address> <listener port> <talker port> <message>");
            return;
        }

        // parse users input in command line
        // address of the listener
        InetAddress listenerAddress = InetAddress.getByName(args[0]);
        // port on which the listener is listening
        int listenerPort = Integer.parseInt(args[1]);
        // port on which the talker is talking
        int talkerPort = Integer.parseInt(args[2]);
        // the message that user input to be sent
        String message = args[3];

        // create a socket
        DatagramSocket socket = new DatagramSocket(talkerPort);
        // set a timeout for socket
        socket.setSoTimeout(2000);

        // Split the message into 10 character chunks
        // array to store the message
        String[] messages = new String[5];
        for (int i = 0; i < 5; i++) {
            int start = i * 10;
            int end = Math.min(start + 10, message.length());
            messages[i] = message.substring(start, end);
        }

        // Send number of messages to be sent
        sendMessage(socket, listenerAddress, listenerPort, "0" + messages.length);

        // Send each message and wait for acknowledgment
        for (int i = 0; i < messages.length; i++) {
            // ack not recevied yet
            boolean acknowledged = false;
            while (!acknowledged) {
                String msg = (i + 1) + messages[i];
                sendMessage(socket, listenerAddress, listenerPort, msg);

                try {
                    // wait for the ACK
                    String response = receiveMessage(socket);
                    if (response.equals("ACK " + (i + 2))) {
                        // we recevied the ACK
                        acknowledged = true;
                    }
                } catch (SocketTimeoutException e) {
                    System.out.println("Timeout, resending message " + (i + 1));
                }
            }
        }
        // close the socket
        socket.close();
    }

    // send a message
    private static void sendMessage(DatagramSocket socket, InetAddress address, int port, String msg) throws IOException {
        byte[] buffer = msg.getBytes();
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
        System.out.println("Sent message: " + msg);
    }
    // receive a message
    private static String receiveMessage(DatagramSocket socket) throws IOException {
        byte[] buffer = new byte[1024];
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);
        socket.receive(packet);
        String receivedMsg = new String(packet.getData(), 0, packet.getLength());
        System.out.println("Received message: " + receivedMsg);
        return receivedMsg;
    }
}


