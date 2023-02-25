
class MonthlyReport {
    private String itemName;
    private boolean isExpense;
    private int quantity;
    private int sumOfOne;

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public boolean isExpense() {
        return isExpense;
    }

    public void setExpense(boolean expense) {
        this.isExpense = expense;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public int getSumOfOne() {
        return sumOfOne;
    }

    public void setSumOfOne(int sumOfOne) {
        this.sumOfOne = sumOfOne;
    }

    @Override
    public String toString() {
        return "MonthlyReport{" +
                "item_name='" + itemName + '\'' +
                ", is_expense=" + isExpense +
                ", quantity=" + quantity +
                ", sum_of_one=" + sumOfOne +
                '}';
    }
}