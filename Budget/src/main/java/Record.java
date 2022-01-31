import java.time.LocalDate;

public class Record {
    private float amount;
    private LocalDate date;
    private int categoryIndex;
    private boolean transferToBankAccount;
    private String additionalInfo;

    public Record(float amount, LocalDate date, int categoryIndex, boolean transferToBankAccount, String additionalInfo) {
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
