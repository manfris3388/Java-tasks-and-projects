package lt.codeacademy.model;

public class IncomeRecord extends Record {

  public IncomeRecord(
      Double amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo,
      RecordType recordType) {
    super(amount, date, categoryIndex, transactionMethod, additionalInfo, recordType);
  }
}
