import java.io.*;
import java.net.*;
import java.util.Random;

public class Listener {
    public static void main(String[] args) throws IOException {
        // check if user put in the correct number of arguments
        if (args.length != 3) {
            System.out.println("Usage: java Listener <listener port> <talker address> <ack probability>");
            return;
        }

        // parse the command line arguments from user
        // listener port
        int listenerPort = Integer.parseInt(args[0]);
        //talker ip address (use local)
        InetAddress talkerAddress = InetAddress.getByName(args[1]);
        // ack probability (0.0 for all acks sent, 0.5 for half acks sent)
        double ackProbability = Double.parseDouble(args[2]);

        //create a socket to listen on the specified port
        DatagramSocket socket = new DatagramSocket(listenerPort);

        // buffer to receive the messages
        byte[] buffer = new byte[1024];
        // packet to recieve the message
        DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

        // Receive the number of messages 
        String data = receiveMessage(socket, packet);
        int numMessages = Integer.parseInt(data.substring(1));
        System.out.println("Received message 0: " + numMessages);

        // store received messages
        String[] receivedMessages = new String[numMessages];

        // receive each message based on the expected number of messages
        for (int i = 0; i < numMessages; i++) {
            // receive the message
            data = receiveMessage(socket, packet);
            // extract the sequence number from the message
            int seqNum = Character.getNumericValue(data.charAt(0));
            // extract the actuall message
            String message = data.substring(1);
            // store the message in appropriate sequence
            receivedMessages[seqNum - 1] = message;
            System.out.println("Received message " + seqNum + ": " + message);

            // Randomly drop ACKs for testing
            if (new Random().nextFloat() < ackProbability) {
                System.out.println("ACK " + seqNum + " dropped for testing");
                continue;
            }

            // Send ACK
            sendMessage(socket, packet, "ACK " + (seqNum + 1), talkerAddress, packet.getPort());
        }

        // Concatenate received messages
        StringBuilder concatenatedMessage = new StringBuilder();
        // make sure we dont keep going after 5 expected messages
        for (String msg : receivedMessages) {
            concatenatedMessage.append(msg);
        }
        System.out.println("Concatenated message: " + concatenatedMessage.toString());

        // close the socket
        socket.close();
    }

    // method to send the message
    private static void sendMessage(DatagramSocket socket, DatagramPacket packet, String msg, InetAddress address, int port) throws IOException {
        byte[] buffer = msg.getBytes();
        packet = new DatagramPacket(buffer, buffer.length, address, port);
        socket.send(packet);
        System.out.println("Sent message: " + msg);
    }

    // method to receive the message
    private static String receiveMessage(DatagramSocket socket, DatagramPacket packet) throws IOException {
        socket.receive(packet);
        String receivedMsg = new String(packet.getData(), 0, packet.getLength());
        //System.out.println("Received message: " + receivedMsg);
        return receivedMsg;
    }
}


