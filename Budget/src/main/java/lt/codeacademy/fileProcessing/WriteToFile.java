package lt.codeacademy.fileProcessing;

import lt.codeacademy.model.Record;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class WriteToFile {

  public static void writeToFile(Record record) {
    try {
      FileOutputStream fileOutputStream = new FileOutputStream("Records.bin");
      ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
      objectOutputStream.writeObject(record);
      System.out.println("Išsaugota į failą");
      objectOutputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
  }
}
