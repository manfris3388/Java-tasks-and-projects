package lt.codeacademy.model;

public class Record {
  private Double amount;
  private final String date;
  private final String categoryIndex;
  private String transactionMethod;
  private String additionalInfo;
  private static Integer recordIndex = 1;
  private final Integer id;
  private final RecordType recordType;

  public Record(
      Double amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo,
      RecordType recordType) {
    this.amount = amount;
    this.date = date;
    this.categoryIndex = categoryIndex;
    this.transactionMethod = transactionMethod;
    this.additionalInfo = additionalInfo;
    this.recordType = recordType;
    id = recordIndex;
    recordIndex++;
  }

  public Double getAmount() {
    return amount;
  }

  public Integer getId() {
    return id;
  }

  public RecordType getRecordType() {
    return recordType;
  }

  public String getTransactionMethod() {
    return transactionMethod;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  public void setTransactionMethod(String transactionMethod) {
    this.transactionMethod = transactionMethod;
  }

  public void setAdditionalInfo(String additionalInfo) {
    this.additionalInfo = additionalInfo;
  }

  public void setAmount(Double amount) {
    this.amount = amount;
  }

  @Override
  public String toString() {
    return "lt.codeacademy.model.Record{"
        + "record type = "
        + recordType.getType()
        + "amount="
        + amount
        + ", date="
        + date
        + ", categoryIndex="
        + categoryIndex
        + ", transferToBankAccount="
        + transactionMethod
        + ", additionalInfo='"
        + additionalInfo
        + ", transaction id = "
        + id
        + '\''
        + '}';
  }
}
