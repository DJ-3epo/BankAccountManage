package org.example;

import java.util.ArrayList;
import java.util.Date;

public class Account {
    private String name;
    private int id;
    private double balance;
    private double annualInterestRate;
    private Date dateCreated;
    private ArrayList<Transaction> transactions;

    public Account(String name, int id, double balance, double annualInterestRate) {
        this.name = name;
        this.id = id;
        this.balance = balance;
        this.annualInterestRate = annualInterestRate;
        this.dateCreated = new Date();  // Текущая дата создания счета
        this.transactions = new ArrayList<>();
    }

    // Возвращает текущий баланс
    public double getBalance() {
        return balance;
    }

    // Возвращает годовую процентную ставку
    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    // Возвращает дату создания счета
    public Date getDateCreated() {
        return dateCreated;
    }

    // Возвращает ID счета
    public int getId() {
        return id;
    }

    // Возвращает список транзакций
    public ArrayList<Transaction> getTransactions() {
        return transactions;
    }

    // Метод для снятия денег со счета
    public void withdraw(double amount) {
        if (balance >= amount) {
            balance -= amount;
            transactions.add(new Transaction('-', amount, balance, "Withdrawal of " + amount));
            System.out.println("Successfully withdrew: " + amount + " rub.");
        } else {
            System.out.println("Insufficient balance. Withdrawal failed.");
        }
    }

    // Метод для пополнения счета
    public void deposit(double amount) {
        balance += amount;
        transactions.add(new Transaction('+', amount, balance, "Deposit of " + amount));
        System.out.println("Successfully deposited: " + amount + " rub.");
    }

    // Метод для расчета ежемесячных процентов
    public double getMonthlyInterest() {
        return (annualInterestRate / 100) / 12 * balance;
    }

    // Начисление ежемесячного процента
    public void addMonthlyInterest() {
        double interest = getMonthlyInterest();
        balance += interest;
        transactions.add(new Transaction('+', interest, balance, "Monthly interest"));
        System.out.println("Monthly interest added: " + interest + " rub.");
    }

    // Показать все транзакции
    public void displayTransactions() {
        System.out.println("Transaction history:");
        for (Transaction transaction : transactions) {
            System.out.println(transaction);
        }
    }
}
