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

  @Override
  public String toString() {
    return "Record{"
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
