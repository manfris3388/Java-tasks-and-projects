package lt.codeacademy.service;

import lt.codeacademy.model.Record;
import lt.codeacademy.model.RecordType;

import java.util.ArrayList;

public class BudgetService {
  private static Double balance = 0D;
  private static final ArrayList<Record> records = new ArrayList<>();

  public static void addRecord(Record record) {
    records.add(record);
    calculateBalance(record);
  }

  public void printRecords(int menuChoice) {
    if (menuChoice == 3) {
      System.out.println("Pajamų išrašas");
      for (Record line : records) {
        if (line.getRecordType().equals(RecordType.INCOME)) {
          System.out.println(line);
        }
      }
    } else if (menuChoice == 4) {
      System.out.println("Išlaidų išrašas");
      for (Record line : records) {
        if (line.getRecordType().equals(RecordType.EXPENSES)) {
          System.out.println(line);
        }
      }
    }
  }

  public void deleteRecord(Integer id) {
    for (Record record : records) {
      if (record.getId().equals(id)) {
        records.remove(record);
        break;
      }
    }
  }

  private static void calculateBalance(Record record) {
    if (record.getRecordType().equals(RecordType.INCOME)) {
      balance += Double.parseDouble(record.getAmount());
    } else {
      balance -= Double.parseDouble(record.getAmount());
    }
  }

  public Double getBalance() {
    return balance;
  }
}
