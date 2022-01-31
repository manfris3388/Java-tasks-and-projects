import java.time.LocalDate;

public class ExpensesRecord extends Record{
    public ExpensesRecord(float amount, LocalDate date, int categoryIndex, boolean transferToBankAccount, String additionalInfo) {
        super(amount, date, categoryIndex, transferToBankAccount, additionalInfo);
    }
}
