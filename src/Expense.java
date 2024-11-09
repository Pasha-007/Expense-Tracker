public class Expense {
    private double amount;
    private String description;
    private String date;

    public Expense(double amount, String description, String date) {
        this.amount = amount;
        this.description = description;
        this.date = date;
    }
    public double getAmount() {
        return amount;
    }
    public String getDescription() {
        return description;
    }
    public String getDate() {
        return date;
    }

    @Override
    public String toString() {
        return "Expense{" +
                "amount=" + amount +
                ", description=" + description +
                ", date=" + date + '\'' +
                '}';
    }
}
