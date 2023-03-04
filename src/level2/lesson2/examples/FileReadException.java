package level2.lesson2.examples;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class FileReadException {
  public static void main(String[] args) {
    FileInputStream fis = null;
    try {
      fis = new FileInputStream("test1.txt");
      byte [] bytes = fis.readAllBytes();
      System.out.println(new String(bytes));
      fis.close();
    } catch (FileNotFoundException e) {
      e.printStackTrace();
      System.out.println("Файл не был найден!");
    } catch (IOException e) {
      System.out.println("Файл поврежден!");
    } finally { // блок finally выполняется вне зависимости от того - было ли проброшено исключение или нет
      if (fis != null) {
        try {
          fis.close();
        } catch (IOException e) {
          e.printStackTrace();
        }
      }
    }
  }
}
