import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Task_1 {
    private double balance;
    private List<Transaction> transactions;

    public Task_1() {
        this.balance = 0;
        this.transactions = new ArrayList<>();
    }

    public void deposit(double amount) {
        balance += amount;
        Transaction transaction = new Transaction("Deposit", amount, new Date());
        transactions.add(transaction);
    }

    public void withdraw(double amount) {
        if (amount > balance) {
            System.out.println("Insufficient funds");
        } else {
            balance -= amount;
            Transaction transaction = new Transaction("Withdrawal", amount, new Date());
            transactions.add(transaction);
        }
    }

    public void displayTransactions() {
        System.out.println("Transaction history:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }

    private class Transaction {
        private String type;
        private double amount;
        private Date timestamp;

        public Transaction(String type, double amount, Date timestamp) {
            this.type = type;
            this.amount = amount;
            this.timestamp = timestamp;
        }

        @Override
        public String toString() {
            return "Type: " + type + ", Amount: " + amount + ", Date: " + timestamp;
        }
    }

    public static void main(String[] args) {
        Task_1 account = new Task_1();
        account.deposit(1000);
        account.withdraw(500);
        account.deposit(200);
        account.displayTransactions();
    }
}