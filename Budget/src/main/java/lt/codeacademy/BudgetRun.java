package lt.codeacademy;

import lt.codeacademy.Budget;

import java.time.LocalDateTime;
import java.util.Scanner;

public class BudgetRun {
  static Scanner scanner = new Scanner(System.in);
  static Budget budget = new Budget();
  static boolean runApp = true;

  public static void run() {
    while (runApp) {

      System.out.println("Pasirinkite iš galimų variantų:");
      System.out.println("Jei norite įvesti pajamas spauskite 1");
      System.out.println("Jei norite įvesti išlaidas spauskite 2");
      System.out.println("Jei norite peržiūrėti pajamas, spauskite 3");
      System.out.println("Jei norite peržiūrėti išlaidas, spauskite 4");
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
