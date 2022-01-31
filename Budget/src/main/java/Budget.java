public class Budget {
    IncomeRecord[] income = new IncomeRecord[0];
    ExpensesRecord[] expenses = new ExpensesRecord[0];

    public IncomeRecord[] addIncome(IncomeRecord incomeRecord){
        int length = income.length;
        IncomeRecord[] newArr = new IncomeRecord[length + 1];
        for (int i = 0; i < length; i++) {
            newArr[i] = income[i];
        }
        newArr[length+1] = incomeRecord;
        return newArr;
    }
    public ExpensesRecord[] addExpenses(ExpensesRecord expensesRecord){
        int length = expenses.length;
        ExpensesRecord[] newArr = new ExpensesRecord[length + 1];
        for (int i = 0; i < length; i++) {
            newArr[i] = expenses[i];
        }
        newArr[length+1] = expensesRecord;
        return newArr;
    }
}
