package level2.lesson6.homework;

import lombok.AllArgsConstructor;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

@AllArgsConstructor
public class MessageHandler {
  private final Logger LOGGER = Logger.getLogger(MessageHandler.class.getName());
  Socket socket;
  String sender;

  public void startHandler() {
    try {
      var in = new DataInputStream(socket.getInputStream());
      var out = new DataOutputStream(socket.getOutputStream());
      var messageSender = new Thread(() -> {
        Scanner scanner = new Scanner(System.in);
        while (true) {
          String message = scanner.nextLine();
          sendMessage(message, out);
        }
      });
      messageSender.setDaemon(true);
      messageSender.start();
      try {
        while (true) {
          String message = in.readUTF();
          System.out.println(message);
          if (message.equals("/end")) {
            sendMessage("/end", out);
            break;
          }
        }
      } catch (IOException e) {
        LOGGER.log(Level.WARNING, "Error while reading incoming message!", e);
      }
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "An error occurred while creating input or output stream, or socket has been closed!", e);
    }
  }

  private void sendMessage(String message, DataOutputStream out) {
    try {
      if (message.equals("/end")) {
        out.writeUTF(message);
      }
      var formattedMessage = String.format("%s: %s", sender, message);
      out.writeUTF(formattedMessage);
      System.out.println(formattedMessage);
    } catch (IOException e) {
      LOGGER.log(Level.WARNING, "Error while sending message!", e);
    }
  }
}
