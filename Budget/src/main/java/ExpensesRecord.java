import java.time.LocalDateTime;

public class ExpensesRecord extends Record {
  public ExpensesRecord(
      String amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo) {
    super(amount, date, categoryIndex, transactionMethod, additionalInfo);
  }
}
