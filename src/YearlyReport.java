
class YearlyReport {
    private int month;
    private int amount;
    private boolean is_expense;

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public boolean isIs_expense() {
        return is_expense;
    }

    public void setIs_expense(boolean is_expense) {
        this.is_expense = is_expense;
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "month=" + month +
                ", amount=" + amount +
                ", is_expense=" + is_expense +
                '}';
    }
}