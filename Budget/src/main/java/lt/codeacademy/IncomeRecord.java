package lt.codeacademy;

import java.time.LocalDateTime;

public class IncomeRecord extends Record {

  public IncomeRecord(
      String amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo) {
    super(amount, date, categoryIndex, transactionMethod, additionalInfo);
  }
}
