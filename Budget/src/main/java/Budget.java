public class Budget {
    IncomeRecord[] income = new IncomeRecord[100];
    ExpensesRecord[] expenses = new ExpensesRecord[100];

    public IncomeRecord[] addIncome(IncomeRecord incomeRecord){
        IncomeRecord[] newArr = new IncomeRecord[income.length + 1];
        int i;
        for (i = 0; i < income.length; i++) {
            newArr[i] = income[i];
        }
        newArr[i] = incomeRecord;
    System.out.println("pridejau turbut");
        return newArr;
    }
    public ExpensesRecord[] addExpenses(ExpensesRecord expensesRecord){
        ExpensesRecord[] newArr = new ExpensesRecord[expenses.length + 1];
        int i;
        for (i = 0; i < expenses.length; i++) {
            newArr[i] = expensesRecord;
        }
        newArr[expenses.length + 1] = expensesRecord;
        return newArr;
    }
}
