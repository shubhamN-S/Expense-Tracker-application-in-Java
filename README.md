# Expense-Tracker-application-in-Java  
Creating a full-fledged Expense Tracker application in Java involves several components such as managing users, expenses, user interface, file handling, and more. Below is a simplified version that covers the basic functionalities of an Expense Tracker. This example uses console-based interaction and focuses on core Java concepts like classes, data structures, and file I/O.

### ExpenseTracker.java (Main Class)

```java
import java.util.Scanner;

public class ExpenseTracker {
    private static UserManager userManager = new UserManager();
    private static ExpenseManager expenseManager = new ExpenseManager();
    private static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        System.out.println("Welcome to Expense Tracker!");

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Register");
            System.out.println("2. Log In");
            System.out.println("3. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    registerUser();
                    break;
                case 2:
                    loginUser();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void registerUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManager.registerUser(username, password)) {
            System.out.println("User registered successfully!");
        } else {
            System.out.println("Username already exists. Please choose a different username.");
        }
    }

    private static void loginUser() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        if (userManager.login(username, password)) {
            System.out.println("Login successful!");
            showExpenseMenu();
        } else {
            System.out.println("Invalid username or password. Please try again.");
        }
    }

    private static void showExpenseMenu() {
        while (true) {
            System.out.println("\nExpense Menu:");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Log Out");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    addExpense();
                    break;
                case 2:
                    viewExpenses();
                    break;
                case 3:
                    System.out.println("Logging out...");
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
                    break;
            }
        }
    }

    private static void addExpense() {
        System.out.print("Enter expense category: ");
        String category = scanner.nextLine();
        System.out.print("Enter expense amount: ");
        double amount = scanner.nextDouble();
        scanner.nextLine(); // Consume newline character

        expenseManager.addExpense(category, amount);
        System.out.println("Expense added successfully!");
    }

    private static void viewExpenses() {
        System.out.println("\nYour Expenses:");
        expenseManager.displayAllExpenses();
    }
}
```

### UserManager.java

```java
import java.util.HashMap;
import java.util.Map;

public class UserManager {
    private Map<String, String> users; // username -> password

    public UserManager() {
        this.users = new HashMap<>();
    }

    public boolean registerUser(String username, String password) {
        if (users.containsKey(username)) {
            return false; // Username already exists
        }
        users.put(username, password);
        return true;
    }

    public boolean login(String username, String password) {
        if (users.containsKey(username) && users.get(username).equals(password)) {
            return true; // Login successful
        }
        return false; // Invalid username or password
    }
}
```

### ExpenseManager.java

```java
import java.util.ArrayList;
import java.util.List;

public class ExpenseManager {
    private List<Expense> expenses;

    public ExpenseManager() {
        this.expenses = new ArrayList<>();
    }

    public void addExpense(String category, double amount) {
        Expense expense = new Expense(category, amount);
        expenses.add(expense);
    }

    public void displayAllExpenses() {
        for (Expense expense : expenses) {
            System.out.println(expense);
        }
    }
}

class Expense {
    private String category;
    private double amount;

    public Expense(String category, double amount) {
        this.category = category;
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Category: " + category + ", Amount: $" + amount;
    }
}
```

### Running the Application

1. **Compile the Code**:
   - Save each of the above classes into separate `.java` files.
   - Open a terminal or command prompt.
   - Navigate to the directory containing your `.java` files.
   - Compile them using the command:
     ```bash
     javac ExpenseTracker.java UserManager.java ExpenseManager.java
     ```

2. **Run the Application**:
   - After successful compilation, run the `ExpenseTracker` class using the command:
     ```bash
     java ExpenseTracker
     ```

3. **Using the Expense Tracker**:
   - Follow the prompts to register a user, log in, add expenses, view expenses, and log out.

This example provides a basic structure for an Expense Tracker application in Java, focusing on core functionalities like user management, expense entry, and viewing. For a complete application, you may consider adding features such as file I/O for persistence, more sophisticated user interfaces, and advanced error handling.
