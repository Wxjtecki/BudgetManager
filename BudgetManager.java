//Autor Kamil Pajączkowski
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BudgetManager {
    private List<Transaction> transactions;

    public BudgetManager() {
        this.transactions = new ArrayList<>();
    }

    // Add income or expense
    public void addTransaction(String type, double amount, String description) {
        Transaction transaction = new Transaction(type, amount, description);
        transactions.add(transaction);
    }

    // Display summary for all transactions
    public void displaySummary() {
        double totalIncome = 0;
        double totalExpenses = 0;

        for (Transaction t : transactions) {
            if (t.getType().equals("income")) {
                totalIncome += t.getAmount();
            } else if (t.getType().equals("expense")) {
                totalExpenses += t.getAmount();
            }
        }

        double balance = totalIncome - totalExpenses;
        System.out.println("Total Income: " + totalIncome);
        System.out.println("Total Expenses: " + totalExpenses);
        System.out.println("Balance: " + balance);
    }

    public static void main(String[] args) {
        BudgetManager manager = new BudgetManager();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- Budget Manager ---");
            System.out.println("1. Add Income");
            System.out.println("2. Add Expense");
            System.out.println("3. View Summary");
            System.out.println("4. Exit");
            System.out.print("Select an option: ");
            int choice = scanner.nextInt();

            if (choice == 1 || choice == 2) {
                System.out.print("Enter amount: ");
                double amount = scanner.nextDouble();
                scanner.nextLine(); // Consume newline
                System.out.print("Enter description: ");
                String description = scanner.nextLine();

                if (choice == 1) {
                    manager.addTransaction("income", amount, description);
                } else {
                    manager.addTransaction("expense", amount, description);
                }
            } else if (choice == 3) {
                manager.displaySummary();
            } else if (choice == 4) {
                break;
            }
        }

        scanner.close();
    }
}
