import java.time.LocalDateTime;
import java.util.Scanner;

public class BudgetRun {
  static Scanner scanner = new Scanner(System.in);
  static Budget budget = new Budget();

  public static void run() {
    while (true) {

      System.out.println("Pasirinkite iš galimų variantų:");
      System.out.println("Jei norite įvesti pajamas spauskite 1");
      System.out.println("Jei norite įvesti išlaidas spauskite 2");
      System.out.println("Jei norite peržiūrėti pajamas, spauskite 3");
      System.out.println("Jei norite peržiūrėti išlaidas, spauskite 4");
      System.out.println("Jei norite matyti visas operacijas spauskite 5");
      System.out.println("Jei norite atsijunti spauskite q");
      String choice = scanner.nextLine();
      makechoice(choice);
    }
  }

  private static void makechoice(String choice) {
    switch (choice) {
      case "1":
        String input = enterData(1);
        System.out.println(input);
        break;
      default:
        System.out.println("Neteisinga įvestis");
        break;
    }
  }

  private static String enterData(int choice) {
    System.out.println("Įveskite sumą");
    String amount = scanner.nextLine();
    String data = String.valueOf(LocalDateTime.now());
    String categoryInd = "nežinomas";
    System.out.println(
        "Pasirinkite ar operacija įvykdyta per banko sąskaitą. Jei taip spauskite 1");
    String transfer;
    String bankTransaction = scanner.nextLine();
    if (bankTransaction.equals("1")) {
      transfer = "Pervedimas į banko sąskaitą";
    } else {
      transfer = "Atsiskaitymas grynaisiais";
    }
    System.out.println("Įveskite papildomą informaciją");
    String additionalInfo = scanner.nextLine();
    if (choice == 1){
      budget.addIncome(new IncomeRecord(amount, data, categoryInd, transfer, additionalInfo));
    }
    String input = amount + " " + data + " " + categoryInd + " " + transfer + " " + additionalInfo;
    return input;
  }
}
