package lt.codeacademy;

public class Record {
  private final String amount;
  private final String date;
  private final String categoryIndex;
  private final String transactionMethod;
  private final String additionalInfo;

  public Record(
      String amount,
      String date,
      String categoryIndex,
      String transactionMethod,
      String additionalInfo) {
    this.amount = amount;
    this.date = date;
    this.categoryIndex = categoryIndex;
    this.transactionMethod = transactionMethod;
    this.additionalInfo = additionalInfo;
  }

  public String getAmount() {
    return amount;
  }

  public String getDate() {
    return date;
  }

  public String getCategoryIndex() {
    return categoryIndex;
  }

  public String getTransactionMethod() {
    return transactionMethod;
  }

  public String getAdditionalInfo() {
    return additionalInfo;
  }

  @Override
  public String toString() {
    return "lt.codeacademy.Record{"
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
        + '\''
        + '}';
  }
}
