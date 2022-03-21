package lt.codeacademy.service;

import lt.codeacademy.model.Record;
import lt.codeacademy.model.RecordType;
import lt.codeacademy.utils.ValidateEntry;

import java.util.ArrayList;

import static lt.codeacademy.Menu.scanner;

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
      balance += record.getAmount();
    } else {
      balance -= record.getAmount();
    }
  }

  public Double getBalance() {
    return balance;
  }

  public static void modifyRecord(Integer id){
    Record record = getRecord(id);
    System.out.println("Pasirinkite kokį parametrą norit modifikuoti");
    System.out.println("Jei tai norimas parametras spauskite 1, eiti į sekantį parametrą spauskite 2");
    System.out.println(record.getAmount());
    int choice1 = Integer.parseInt(scanner.nextLine());
    if (choice1 == 1){
      System.out.println("Įveskite naują sumą");
      record.setAmount(ValidateEntry.validateEntry(scanner.nextLine()));
    }
    System.out.println(record.getTransactionMethod());
    int choice2 = Integer.parseInt(scanner.nextLine());
    if (choice2 == 1){
      record.setTransactionMethod(BudgetRun.getTransactionMethod());
    }
    System.out.println(record.getAdditionalInfo());
    int choice3 = Integer.parseInt(scanner.nextLine());
    if (choice3 == 1){
      record.setAdditionalInfo(scanner.nextLine());
    }
  }

  private static Record getRecord(Integer id) {
    for (Record record : records) {
      if (record.getId().equals(id)) {
        return record;
      }
    } return null;
  }
}
