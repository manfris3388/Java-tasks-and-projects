package lt.codeacademy;

import java.util.ArrayList;

public class Budget {
  private Double balance = 0D;
  private final ArrayList<IncomeRecord> incomeRecords = new ArrayList<>();
  private final ArrayList<ExpensesRecord> expensesRecords = new ArrayList<>();

  public void addIncome(IncomeRecord incomeRecord) {
    incomeRecords.add(incomeRecord);
    balance += Double.parseDouble(incomeRecord.getAmount());
  }

  public void addExpenses(ExpensesRecord expensesRecord) {
    expensesRecords.add(expensesRecord);
    balance -= Double.parseDouble(expensesRecord.getAmount());
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

  public Double getBalance() {
    return balance;
  }
}
