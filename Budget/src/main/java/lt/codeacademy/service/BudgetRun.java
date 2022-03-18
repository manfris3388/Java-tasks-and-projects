package lt.codeacademy.service;

import lt.codeacademy.model.Record;
import lt.codeacademy.model.RecordType;
import java.time.LocalDateTime;

import static lt.codeacademy.Menu.scanner;

public class BudgetRun {
  public static void enterData(int menuChoice) {
    System.out.println("Įveskite sumą");
    String amount = scanner.nextLine();
    String data = String.valueOf(LocalDateTime.now());
    String categoryId = "vieta categoryID";
    System.out.println(
        "Kaip įvykdyta operacija? Jei per banką spauskite 1, jei ne, spauskite bet kurį klavišą");
    String transactionMethod = Integer.parseInt(scanner.nextLine()) == 1 ? "Pervedimas į banko sąskaitą" : "Atsiskaitymas grynaisiais";
    System.out.println("Įveskite papildomą informaciją");
    String additionalInfo = scanner.nextLine();
    RecordType recordType = menuChoice == 1 ? RecordType.INCOME : RecordType.EXPENSES;
    BudgetService.addRecord(new Record(amount, data, categoryId, transactionMethod, additionalInfo, recordType));
  }
}
