
class YearlyReport {
    private int month;
    private int amount;
    private boolean isExpense;

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

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        this.isExpense = expense;
    }

    @Override
    public String toString() {
        return "YearlyReport{" +
                "month=" + month +
                ", amount=" + amount +
                ", is_expense=" + isExpense +
                '}';
    }
}