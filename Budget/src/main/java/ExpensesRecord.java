import java.time.LocalDateTime;

public class ExpensesRecord extends Record{
    public ExpensesRecord(String amount, String date, String categoryIndex, String transferToBankAccount, String additionalInfo) {
        super(amount, date, categoryIndex, transferToBankAccount, additionalInfo);
    }
}
