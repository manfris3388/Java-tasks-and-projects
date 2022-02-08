import java.time.LocalDate;
import java.time.LocalDateTime;

public class Record {
    private final String amount;
    private final String date;
    private final String categoryIndex;
    private final String transferToBankAccount;
    private final String additionalInfo;

    public Record(String amount, String date, String categoryIndex, String transferToBankAccount, String additionalInfo) {
        this.amount = amount;
        this.date = date;
        this.categoryIndex = categoryIndex;
        this.transferToBankAccount = transferToBankAccount;
        this.additionalInfo = additionalInfo;
    }
    @Override
    public String toString() {
        return "Record{" +
                "amount=" + amount +
                ", date=" + date +
                ", categoryIndex=" + categoryIndex +
                ", transferToBankAccount=" + transferToBankAccount +
                ", additionalInfo='" + additionalInfo + '\'' +
                '}';
    }
}
