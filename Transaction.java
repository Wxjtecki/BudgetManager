//Autor Kamil Pajączkowski
public class Transaction {
    private String type; // "income" or "expense"
    private double amount;
    private String description;

    public Transaction(String type, double amount, String description) {
        this.type = type;
        this.amount = amount;
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public double getAmount() {
        return amount;
    }

    public String getDescription() {
        return description;
    }
}
