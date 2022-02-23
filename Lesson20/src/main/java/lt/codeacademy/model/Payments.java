package lt.codeacademy.model;

public class Payments {
    private final int PAYMENT_ID;
    private final int AMOUNT;
    private final int RECEIVERS_ID;
    private final int SENDERS_ID;

    public Payments(int PAYMENT_ID, int AMOUNT, int RECEIVERS_ID, int SENDERS_ID) {
        this.PAYMENT_ID = PAYMENT_ID;
        this.AMOUNT = AMOUNT;
        this.RECEIVERS_ID = RECEIVERS_ID;
        this.SENDERS_ID = SENDERS_ID;
    }

    public int getPAYMENT_ID() {
        return PAYMENT_ID;
    }

    public int getAMOUNT() {
        return AMOUNT;
    }

    public int getRECEIVERS_ID() {
        return RECEIVERS_ID;
    }

    public int getSENDERS_ID() {
        return SENDERS_ID;
    }

    @Override
    public String toString() {
        return "Payments{" +
                "PAYMENT_ID=" + PAYMENT_ID +
                ", AMOUNT=" + AMOUNT +
                ", RECEIVERS_ID=" + RECEIVERS_ID +
                ", SENDERS_ID=" + SENDERS_ID +
                '}';
    }
}
