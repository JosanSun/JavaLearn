package ex03;

import sun.security.provider.PolicySpiFile;

/**
 * @Author : zs.sun
 * @Date : 2018/8/16 10:53
 * @Package : ex03
 * @ProjectName: corejava
 * @Description: This program shows data corruption when multiple threads access a data structure.
 */
public class UnsynchBankTest {
    public static final int NACCOUNTS = 10;
    public static final double INITIAL_BALANCE = 100;
    public static final double MAX_AMOUNT = 100;
    public static final int DELAY = 10;

    public static void main(String[] args) {
        Bank bank = new Bank(NACCOUNTS, INITIAL_BALANCE);
        System.out.println(bank.getTotalBalance());
        for (int i = 0; i < NACCOUNTS; i++) {
            int fromAccount = i;
            Runnable r = () ->{
                try
                {
                    while(true)
                    {
                        int toAccount = (int)(bank.size() * Math.random());
                        double amount = MAX_AMOUNT * Math.random();
                        bank.transfer(fromAccount, toAccount, amount);
                        Thread.sleep((int)(DELAY * Math.random()));
                    }
                }
                catch (InterruptedException e)
                {

                }
            };
            Thread t = new Thread(r);
            t.start();
        }
    }
}
