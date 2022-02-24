package lt.codeacademy;

public class Record {
  private final String amount;
  private final String date;
  private final String categoryIndex;
  private final String transactionMethod;
  private final String additionalInfo;
  private static Integer recordIndex = 1;
  private final Integer id;

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
    id = recordIndex;
    recordIndex++;
  }

  public String getAmount() {
    return amount;
  }

  public Integer getId() {
    return id;
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
            + ", transaction id = "
            + id
        + '\''
        + '}';
  }
}
