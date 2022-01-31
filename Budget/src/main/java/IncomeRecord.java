import java.time.LocalDate;

public class IncomeRecord extends Record {

    public IncomeRecord(float amount, LocalDate date, int categoryIndex, boolean transferToBankAccount, String additionalInfo) {
        super(amount, date, categoryIndex, transferToBankAccount, additionalInfo);
    }
}
