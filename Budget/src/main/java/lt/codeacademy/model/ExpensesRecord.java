package lt.codeacademy.model;

public class ExpensesRecord extends Record {

  public ExpensesRecord(
      String amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo,
      RecordType recordType) {
    super(amount, date, categoryIndex, transactionMethod, additionalInfo, recordType);
  }
}
