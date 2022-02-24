package lt.codeacademy;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BudgetRun {
  static Scanner scanner = new Scanner(System.in);
  static BudgetService budget = new BudgetService();
  static boolean runApp = true;

  public static void run() {
    while (runApp) {

      System.out.println("Pasirinkite iš galimų variantų:");
      System.out.println("Jei norite įvesti pajamas spauskite 1");
      System.out.println("Jei norite įvesti išlaidas spauskite 2");
      System.out.println("Jei norite peržiūrėti pajamas, spauskite 3");
      System.out.println("Jei norite peržiūrėti išlaidas, spauskite 4");
      System.out.println("Jei norite gauti balansą, spauskite 5");
      System.out.println("Jei norite ištrinti įrašą, spauskite 6, po to suveskite pasirinktos transakcijos indeksą");
      System.out.println("Jei norite atsijunti spauskite q");
      String choice = scanner.nextLine();
      makechoice(choice);
    }
  }

  private static void makechoice(String choice) {
    switch (choice) {
      case "1" -> enterData(1);
      case "2" -> enterData(2);
      case "3" -> budget.printData(1);
      case "4" -> budget.printData(2);
      case "5" -> System.out.println("Jūsų sąskaitos balansas yra " + budget.getBalance());
      case "6" -> budget.deleteRecord(scanner.nextInt());
      case "q" -> runApp = false;
      default -> System.out.println("Neteisinga įvestis");
    }
  }


  private static void enterData(int choice) {
    System.out.println("Įveskite sumą");
    String amount = scanner.nextLine();
    String data = String.valueOf(LocalDateTime.now());
    String categoryInd = "vieta categoryID";
    System.out.println(
        "Pasirinkite ar operacija įvykdyta per banko sąskaitą. Jei taip spauskite 1, jei operacija grynais pinigais, spauskit bet korį klavišą");
    String transactionMethod;
    String bankTransaction = scanner.nextLine();
    if (bankTransaction.equals("1")) {
      transactionMethod = "Pervedimas į banko sąskaitą";
    } else {
      transactionMethod = "Atsiskaitymas grynaisiais";
    }
    System.out.println("Įveskite papildomą informaciją");
    String additionalInfo = scanner.nextLine();
    if (choice == 1) {
      budget.addIncome(new IncomeRecord(amount, data, categoryInd, transactionMethod, additionalInfo));
    } else {
      budget.addExpenses(new ExpensesRecord(amount, data, categoryInd, transactionMethod, additionalInfo));
    }
    String input = amount + " " + data + " " + categoryInd + " " + transactionMethod + " " + additionalInfo;
  }
}
