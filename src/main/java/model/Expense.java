package model;

public class Expense {
    private String expenseCategory,date,expenseName,description;
    private double amount;

    public Expense(String expenseCategory, String date, String expenseName, String description, double amount) {
        super();
        this.expenseCategory = expenseCategory;
        this.date = date;
        this.expenseName = expenseName;
        this.description = description;
        this.amount = amount;
    }

    public Expense() {
        super();
    }

    public String getExpenseCategory() {
        return expenseCategory;
    }

    public void setExpenseCategory(String expenseCategory) {
        this.expenseCategory = expenseCategory;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getExpenseName() {
        return expenseName;
    }

    public void setExpenseName(String expenseName) {
        this.expenseName = expenseName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}