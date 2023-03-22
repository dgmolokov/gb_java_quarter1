package level2.lesson6.homework;

import java.io.IOException;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

import static level2.lesson6.homework.ChatServer.SERVER_PORT;

public class ChatClient {
  private static final Logger LOGGER = Logger.getLogger(ChatClient.class.getName());
  private static final String SERVER_ADDRESS = "localhost";

  public static void main(String[] args) {
    try {
      System.out.printf("Connecting to server %s:%d...\n", SERVER_ADDRESS, SERVER_PORT);
      var socket = new Socket(SERVER_ADDRESS, SERVER_PORT);
      System.out.printf("Connected to %s:%d!\n", SERVER_ADDRESS, SERVER_PORT);
      var messageHandler = new MessageHandler(socket, ChatClient.class.getSimpleName());
      messageHandler.startHandler();
      System.out.println("Server has been closed! Disconnecting...");
      socket.close();
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "An error occurred while trying connecting to server!", e);
    }
    System.out.println("Successfully disconnected!");
  }
}
