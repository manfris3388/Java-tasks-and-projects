package lt.codeacademy.model;

public enum RecordType {
    INCOME("Income"),
    EXPENSES("Expenses");

    private final String type;

    RecordType(String type){
        this.type = type;
    }

    public String getType() {
        return type;
    }
}
