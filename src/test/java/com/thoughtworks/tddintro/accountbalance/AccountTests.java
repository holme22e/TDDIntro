package com.thoughtworks.tddintro.accountbalance;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;


public class AccountTests {

    @Test
    public void shouldIncreaseMyBalanceWhenIDepositMoney(){
            assertThat( new AccountBalance(100).deposit(50), is(150));
    }

    @Test
    public void shouldDecreaseMyBalanceWhenIWithdrawMoney(){
        assertThat( new AccountBalance(100).withdraw(50), is(50));
    }

    @Test
    public void shouldNotDecreaseMyBalanceWhenIWithdrawMoneyAndDoNotHaveEnoughToCoverTheWithdrawal(){
        assertThat( new AccountBalance(50).withdraw(100), is(50));

    }
}
