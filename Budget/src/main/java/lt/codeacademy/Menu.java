package lt.codeacademy;

import lt.codeacademy.service.BudgetRun;
import lt.codeacademy.service.BudgetService;

import java.util.Scanner;

public class Menu {
    public static Scanner scanner = new Scanner(System.in);
    static BudgetService budgetService = new BudgetService();
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
            String menuChoice = scanner.nextLine();
            makechoice(menuChoice);
        }
        scanner.close();
    }

    private static void makechoice(String menuChoice) {
        switch (menuChoice) {
            case "1" -> BudgetRun.enterData(1);
            case "2" -> BudgetRun.enterData(2);
            case "3" -> budgetService.printRecords(3);
            case "4" -> budgetService.printRecords(4);
            case "5" -> System.out.println("Jūsų sąskaitos balansas yra " + budgetService.getBalance());
            case "6" -> budgetService.deleteRecord(scanner.nextInt());
            case "q" -> runApp = false;
            default -> System.out.println("Neteisinga įvestis");
        }
    }
}
