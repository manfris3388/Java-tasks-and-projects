package lt.codeacademy;

import java.util.ArrayList;

public class Budget {
  private final ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();
  private final ArrayList<ExpensesRecord> expensesRecords = new ArrayList<>();

  public void addIncome(IncomeRecord incomeRecord) {
    incomeRecords.add(incomeRecord);
  }

  public void addExpenses(ExpensesRecord expensesRecord) {
    expensesRecords.add(expensesRecord);
  }

  public void printData(int menuChoice) {
    if (menuChoice == 1) {
      System.out.println("Pajamų išrašas");
      for (IncomeRecord line : incomeRecords) {
        System.out.println(line);
      }
    } else {
      System.out.println("Išlaidų išrašas");
      for (ExpensesRecord line : expensesRecords) {
        System.out.println(line);
      }
    }
  }
}
