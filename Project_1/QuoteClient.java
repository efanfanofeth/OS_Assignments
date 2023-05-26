import java.net.*;
import java.io.*;


public class QuoteClient
{
    public static void main(String[] args) {
        try{
            //searches socket with localhost and port 6017
            Socket sock = new Socket("localhost", 6017);

            //takes the input from QuoteServer by reading the line
            InputStreamReader input = new InputStreamReader(sock.getInputStream());
            BufferedReader buffer = new BufferedReader(input);
           
            //Places string into variable quote, prints the quote
            String quote = buffer.readLine();
            System.out.println("Quote: " + quote);
            //Closes connection
            sock.close();
        }
        //Catches any errors that may occur
        catch (IOException ioe) {
            System.err.println(ioe);
          }
    }
}
