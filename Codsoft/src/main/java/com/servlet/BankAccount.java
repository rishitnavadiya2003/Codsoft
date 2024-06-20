package com.servlet;

public class BankAccount 
{

    private double balance;

    public BankAccount(double initialBalance) {
        if (initialBalance >= 0) {
            this.balance = initialBalance;
        } else {
            System.out.println("Initial balance cannot be negative.");
            this.balance = 0;
        }
    }

    public double getBalance() {
        return balance;
    }

    public boolean withdraw(double amount) {
        if (amount > 0 && amount <= balance) {
            balance = balance - amount;
            return true;
        }
        return false;
    }

    public boolean deposit(double amount) {
        if (amount > 0) {
            balance = balance + amount;
            return true;
        }
        return false;
    }
}
