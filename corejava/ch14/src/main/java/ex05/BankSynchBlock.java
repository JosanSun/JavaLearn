package ex05;

import java.util.Arrays;

/**
 * @Author : zs.sun
 * @Date : 2018/8/16 14:51
 * @Package : ex05
 * @ProjectName: corejava
 * @Description:
 */
public class BankSynchBlock {
    private final double[] accounts;
    private Object lock = new Object();

    /**
     * Constructs the bank.
     * @param n              the number of accouts
     * @param initialBalance the initial balance for each account
     */
    public BankSynchBlock(int n, double initialBalance)
    {
        accounts = new double[n];
        Arrays.fill(accounts, initialBalance);
    }

    /**
     * Transfers money from one account to another
     * @param from   the account to transfer from
     * @param to     the account to transfer to
     * @param amount the amount to transfer
     */
    public void transfer(int from, int to, double amount) throws InterruptedException
    {
        while(accounts[from] < amount)
        {
            wait();
        }

        synchronized (lock)
        {
            System.out.print(Thread.currentThread());
            accounts[from] -= amount;
            System.out.printf(" %10.2f from %d to %d", amount, from, to);
            accounts[to] += amount;
            System.out.printf(" Total Balance:%10.2f%n", getTotalBalance());
        }


        notifyAll();
    }

    /**
     * Gets the sum of all account balances.
     * @return the total balance
     */
    public double getTotalBalance()
    {
        synchronized (lock)
        {
            double sum = 0;

            for(double a : accounts)
            {
                sum += a;
            }

            return sum;
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
