public class Budget {
  private IncomeRecord[] income = new IncomeRecord[0];
  private ExpensesRecord[] expenses = new ExpensesRecord[0];

  public void addIncome(IncomeRecord incomeRecord) {
    IncomeRecord[] newArr = new IncomeRecord[income.length + 1];
    int i;
    for (i = 0; i < income.length; i++) {
      newArr[i] = income[i];
    }
    newArr[i] = incomeRecord;
    income = newArr;
  }

  public void addExpenses(ExpensesRecord expensesRecord) {
    ExpensesRecord[] newArr = new ExpensesRecord[expenses.length + 1];
    int i;
    for (i = 0; i < expenses.length; i++) {
      newArr[i] = expenses[i];
    }
    newArr[i] = expensesRecord;
    expenses = newArr;
  }

  public void printData(int choice) {
    if (choice == 1) {
      System.out.println("Pajamų išrašas");
      for (IncomeRecord line : income) {
        System.out.println(line);
      }
    } else {
      System.out.println("Išlaidų išrašas");
      for (ExpensesRecord line : expenses) {
        System.out.println(line);
      }
    }
  }
}
