 
import java.net.*;
import java.io.*;
public class EchoServer {
    public static void main(String[] args) {
        String helloStrClient = "Hello there! I am the client"; // Declaring the string for echoserver

        try {
            ServerSocket sock = new ServerSocket(6014); // Creating new ServerSocket object

            Socket client = sock.accept(); // Opening the socket and setting input and output stream
            InputStream inStream = client.getInputStream();
            OutputStream outStream = client.getOutputStream();

            int buffSize = 5; // Setting buffer size for one read setting array to read input
            byte wholeBytes[] = new byte[0];
            byte rcvdBytes[] = new byte[buffSize];
            int rcvdLen = 0;

            while ((rcvdLen = inStream.read(rcvdBytes)) > -1) { // While loop that generates byte array with input
                
                for (int i = rcvdLen; i < rcvdBytes.length; i++) { // For loop that cleans remaining digits
                    rcvdBytes[i] = 0;
                }
                System.out.print("received length = " + rcvdLen + ":"); // This block of code displays the length and the contents of received input
                System.out.write(rcvdBytes);
                if (rcvdBytes[rcvdLen - 1] != '\n') {
                    System.out.println();
                }
                byte tempBytes[] = new byte[wholeBytes.length + rcvdLen]; // Create a temporary byte array adding the size which is just received
                System.arraycopy(wholeBytes, 0, tempBytes, 0, wholeBytes.length); // copy whole byte into a new temporary byte array
                System.arraycopy(rcvdBytes, 0, tempBytes, wholeBytes.length, rcvdLen); // copy received byte into the temporary byte array
                wholeBytes = tempBytes; // Saves the temporary byte array to whole byte array

                if(wholeBytes[wholeBytes.length - 1] == '\n') { // Checks if the reading is done
                    System.out.print("total length = " + wholeBytes.length + ":"); // If the reading is done, displays the whole byte array
                    System.out.write(wholeBytes);

                    String rcvdStr = new String(wholeBytes); // Converts whole byte array to String
                    System.out.println("rcvdStr = " + rcvdStr); // Displays converted String
                    if (rcvdStr.startsWith(helloStrClient)) { // Checks if the String is valid (starts with "Hello there! I am the client") and replace the word "client" to "server"
                        String sndStr = rcvdStr.replaceAll("client", "server");
                        wholeBytes = sndStr.getBytes();
                    }
                    outStream.write(wholeBytes); // Sending the response to the client

                    wholeBytes = new byte[0]; // Initializing the whole byte array and received byte array
                    rcvdBytes = new byte[buffSize];
                }
            }
            System.out.println("Server was terminated by the client !!!"); // Message that tells the termination of the server when terminated   
        }
        catch (Exception ex) { // Catches and displays error when there is any
            System.out.println(ex);
        }
    }

   
            
}