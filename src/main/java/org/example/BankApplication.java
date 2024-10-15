package org.example;

import java.util.Scanner;

public class BankApplication {
    public static void run() {
        Scanner scanner = new Scanner(System.in);

        // Создаем аккаунт с ID 1155, балансом 300 000 руб., и годовой процентной ставкой 6.5%
        Account account = new Account("Semen", 1155, 300000, 6.5);

        while (true) {
            System.out.print("Please enter your account ID: ");
            int enteredId = scanner.nextInt();

            // Проверка ID
            if (enteredId != account.getId()) {
                System.out.println("Incorrect ID. Please try again.");
                continue;  // Снова запросить ID
            }

            boolean exit = false;
            while (!exit) {
                // Главное меню
                System.out.println("\nMain Menu:");
                System.out.println("1. View current balance");
                System.out.println("2. Withdraw money");
                System.out.println("3. Deposit money");
                System.out.println("4. Add monthly interest");
                System.out.println("5. View account creation date");
                System.out.println("6. View transaction history");
                System.out.println("7. Exit");

                System.out.print("Enter your choice: ");
                int choice = scanner.nextInt();

                switch (choice) {
                    case 1:
                        // Показать текущий баланс
                        System.out.println("Current balance: " + account.getBalance() + " rub.");
                        break;
                    case 2:
                        // Снять деньги
                        System.out.print("Enter amount to withdraw: ");
                        double withdrawAmount = scanner.nextDouble();
                        account.withdraw(withdrawAmount);
                        break;
                    case 3:
                        // Внести деньги
                        System.out.print("Enter amount to deposit: ");
                        double depositAmount = scanner.nextDouble();
                        account.deposit(depositAmount);
                        break;
                    case 4:
                        // Начислить ежемесячный процент
                        account.addMonthlyInterest();
                        break;
                    case 5:
                        // Показать дату создания счета
                        System.out.println("Account creation date: " + account.getDateCreated());
                        break;
                    case 6:
                        // Показать историю транзакций
                        account.displayTransactions();
                        break;
                    case 7:
                        // Выйти из системы
                        exit = true;
                        break;
                    default:
                        System.out.println("Invalid choice. Please try again.");
                }
            }
        }
    }
}
