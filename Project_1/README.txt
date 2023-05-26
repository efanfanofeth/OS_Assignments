For Question 1: Quote of the Day

1. Open both QuoteServer.java and QuoteClient.java

2. Run QuoteServer.java first. This will establish the server to listen to port 6017.

3. After QuoteServer.java is running, run QuoteClient.java, which should connect to port 6017.

4. After QuoteClient.java is done running, a quote of the day should be printed in the users terminal and connection to the server will automatically close.

For Question 2: Echo
To use the program, first open two terminal or console windows.

Second, you need to compile the server first because if you compile the client first, it will be terminated because there is no server connected to it. To compile, you have to move to the directory where the code file is and just type "javac EchoServer.java" and "java EchoServer".

And you also have to compile the client. You should type "javac EchoClient.java" and "java EchoClient" in a new terminal or console window. 
And then, you will see the prompt saying: "Input a text to the server:". You just simply test with the sentence "Hello there! I am the client". The server will answer you back with the sentence 
"Hello there! I am the server". If you type any other things, the server will answer you back exactly the same thing what you have typed in because it's an echo server.