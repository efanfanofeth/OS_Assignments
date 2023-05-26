import java.net.*;
import java.io.*;
public class EchoClient {
    public static void main(String[] args) {

        Socket sock = null; // Setting the socket to null
        String promptStr = "Input a text to the server: "; // String that prompts the user to enter a text to the server
        
        try {
            sock = new Socket("localhost", 6014); // Declaring the socket with the port number
            PrintWriter sndToServer = new PrintWriter(sock.getOutputStream(), true); // Output that will be sended to the server
            BufferedReader readerFromServer = new BufferedReader(new InputStreamReader(sock.getInputStream())); // Reads from input stream from the server
            BufferedReader stdInput = new BufferedReader(new InputStreamReader(System.in)); // Reads from standard input stream

            String sndStr;
            System.out.println(promptStr);
            while ((sndStr = stdInput.readLine()) != null) { // Check if the standard input is null and if not, this code sends input to the server and displays the echo
                sndToServer.println(sndStr);
                String rcvdStr = readerFromServer.readLine();
                System.out.println(">>> Received from the server: " + rcvdStr);
                System.out.print(promptStr);
            }
        } catch (Exception e) { // Catches and displays error when there is any
            System.err.println(e);
            System.exit(1);
        }
    }
    
}