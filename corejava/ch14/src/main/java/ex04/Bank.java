package ex04;

// 注意idea会自动导入Bank。导致程序错误。
// import ex03.Bank

import java.util.Arrays;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @Author : zs.sun
 * @Date : 2018/8/16 11:16
 * @Package : ex04
 * @ProjectName: corejava
 * @Description: A bank with a number of bank accounts that uses locks for serializing access
 */
public class Bank {
    private final double[] accounts;
    private Lock bankLock;
    private Condition sufficientFunds;

    /**
     * Constructs the bank.
     * @param n the number of accounts
     * @param initialBalance the initial balance for each account
     */
    public Bank(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
        bankLock = new ReentrantLock();
        sufficientFunds = bankLock.newCondition();
    }


    /**
     * Transfer money from one account to another
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        int j = 100;
        ++j;
        System.out.println(j);

        bankLock.lock();
        try
        {
            while(accounts[from] < amount)
            {
                sufficientFunds.await();
            }
            int i = 10;
            ++i;
            System.out.println(i);
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance: %10.2f%n", getTotalBalance());
            sufficientFunds.signal();
        }
        finally {
            bankLock.unlock();
            System.out.println("j is: " + j);
        }
    }

    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public double getTotalBalance()
    {
        bankLock.lock();
        try
        {
            double sum = 0;

            for(double a : accounts)
            {
                sum += a;
            }

            return sum;
        }
        finally {
            bankLock.unlock();
        }
    }

    /**
     * Gets the number of accounts in the bank.
     * @return the number of accounts
     */
    public int size()
    {
        return accounts.length;
    }
}


