package com.thoughtworks.tddintro.accountbalance;

/**
 * Created by Ella on 6/7/16.
 */
public class AccountBalance {

    private int balance;

    public AccountBalance(int initialBalance){
        balance = initialBalance;
    }

    public int deposit(int i) {
        return i + balance;
    }

    public int withdraw(int i) {
        if( i > balance)
            return balance;
        return balance - i;
    }
}
