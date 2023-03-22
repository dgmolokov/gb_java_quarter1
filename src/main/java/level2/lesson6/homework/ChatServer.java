package level2.lesson6.homework;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;


public class ChatServer {
  private static final Logger LOGGER = Logger.getLogger(ChatServer.class.getName());
  protected static int SERVER_PORT = 1234;

  public static void main(String[] args) {
    try (ServerSocket serverSocket = new ServerSocket(SERVER_PORT)) {
      System.out.println("Server started! Waiting for client...");
      Socket socket = serverSocket.accept();
      System.out.println("Client connected!");
      var messageHandler = new MessageHandler(socket, ChatServer.class.getSimpleName());
      messageHandler.startHandler();
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "An error occurred while starting server or accepting connection from client!", e);
    }
    System.out.println("Server has been closed!");
  }
}
