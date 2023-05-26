/**
 * Modified DateServer so that it requests a quote
 * from the quote server.
 */
 
 import java.net.*;
 import java.io.*;
 
 public class QuoteServer
 {
   public static void main(String[] args) {
     try {
      //Starts server socket with port 6017
       ServerSocket sock = new ServerSocket(6017);


        // Looking for connections
       while (true) {
         Socket client = sock.accept();
        
         PrintWriter pout = new
         PrintWriter(client.getOutputStream(), true);

        //Quote of the day
         pout.println("An apple a day keeps the doctor away");
        // Closes the client after the quote has been printed
         client.close();
       }
     }
     catch (IOException ioe) {
       System.err.println(ioe);
     }
  }
}
