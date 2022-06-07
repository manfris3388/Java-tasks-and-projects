package lt.codeacademy.fileProcessing;

import lt.codeacademy.model.Record;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;

public class ReadFromFile {

  public static void readFromFile() {
    try {
      FileInputStream fileInputStream = new FileInputStream("Records.bin");
      ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
      while (objectInputStream.readObject() != null) {
        Record record = (Record) objectInputStream.readObject();
        System.out.println(record.toString());
      }
      objectInputStream.close();
      } catch (IOException | ClassNotFoundException e) {
      e.printStackTrace();
    }
  }
}
